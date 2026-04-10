package com.ivm.inventorymanagement.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record InventoryDto(

        Long id,

        String name,
        String category,
        String subcategory,

        LocalDate manufacturingDate,
        LocalDate expiryDate,

        String specification,

        BigDecimal price,
        Integer stock,

        String model,
        String seller,

        String location,

        String sku,
        String barcode,

        Status status,

        Integer reorderLevel,
        Long supplierId,

        BigDecimal discount,
        BigDecimal weight,

        LocalDateTime createdAt,
        LocalDateTime updatedAt

) {}
