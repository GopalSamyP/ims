package com.ivm.inventorymanagement.controller;

import com.ivm.inventorymanagement.dto.InventoryResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivm.inventorymanagement.dto.InventoryFilter;
import com.ivm.inventorymanagement.service.InventoryService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService service;

    public InventoryController(InventoryService service) {
        this.service = service;
    }

    // 🔥 Dynamic Search API
    @GetMapping("/search")
    public InventoryResponseDto search(InventoryFilter filter,   // auto binds query params
            Pageable pageable, @RequestParam(name = "pagination", required = false, defaultValue = "false") Boolean pagination) {


        if(filter == null || filter.isEmpty()) {
            return InventoryResponseDto.builder()
                    .message("At least one search filter is required")
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }

        return service.search(filter, pageable, pagination);
    }
}
