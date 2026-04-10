package com.ivm.inventorymanagement.service;

import com.ivm.inventorymanagement.dto.InventoryFilter;
import com.ivm.inventorymanagement.dto.InventoryResponseDto;
import com.ivm.inventorymanagement.entity.Inventory;
import com.ivm.inventorymanagement.mapper.InventoryMapper;
import com.ivm.inventorymanagement.repository.InventoryRepository;
import com.ivm.inventorymanagement.specification.InventorySpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private final InventoryRepository repository;
    private final InventoryMapper mapper;

    public InventoryService(InventoryRepository repository, InventoryMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public InventoryResponseDto search(InventoryFilter filter, Pageable pageable, Boolean pagination) {
        try {
            if (pagination) {
                Page<Inventory> inventoryPage = repository.findAll(InventorySpecification.filter(filter), pageable);
                return mapper.applyPagination(inventoryPage);
            }
            List<Inventory> inventories = repository.findAll(InventorySpecification.filter(filter));
            return mapper.convertToInventoryResponseDto(inventories);
        } catch (Exception e) {
            return InventoryResponseDto.builder()
                    .message("Error occurred while searching inventory: " + e.getMessage())
                    .status(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
}
