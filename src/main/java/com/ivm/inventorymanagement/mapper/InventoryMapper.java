package com.ivm.inventorymanagement.mapper;

import com.ivm.inventorymanagement.dto.InventoryDto;
import com.ivm.inventorymanagement.dto.InventoryResponseDto;
import com.ivm.inventorymanagement.entity.Inventory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InventoryMapper {

    public InventoryResponseDto applyPagination(Page<Inventory> page) {

        InventoryResponseDto responseDTO = InventoryResponseDto.builder().build();
        responseDTO.setInventories(page.getContent().stream().map(InventoryMapper::toDto).toList());
        responseDTO.setPageNumber(page.getNumber());
        responseDTO.setPageSize(page.getSize());
        responseDTO.setTotalElements(page.getTotalElements());
        responseDTO.setTotalPages(page.getTotalPages());

        return responseDTO;
    }

    public InventoryResponseDto convertToInventoryResponseDto(List<Inventory> inventories) {
        InventoryResponseDto responseDTO = InventoryResponseDto.builder().build();
        responseDTO.setInventories(inventories.stream().map(InventoryMapper::toDto).toList());
        responseDTO.setTotalElements(Long.valueOf(inventories.size()));
        return responseDTO;
    }

    public static InventoryDto toDto(Inventory entity) {

        return new InventoryDto(
                entity.getId(),
                entity.getName(),
                entity.getCategory(),
                entity.getSubcategory(),
                entity.getManufacturingDate(),
                entity.getExpiryDate(),
                entity.getSpecification(),
                entity.getPrice(),
                entity.getStock(),
                entity.getModel(),
                entity.getSeller(),
                entity.getLocation(),
                entity.getSku(),
                entity.getBarcode(),
                entity.getStatus(),
                entity.getReorderLevel(),
                entity.getSupplierId(),
                entity.getDiscount(),
                entity.getWeight(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
