package com.ivm.inventorymanagement.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class InventoryFilter {

    private String name;
    private String category;
    private String subcategory;
    private String model;
    private String seller;
    private String location;
    private String sku;
    private String barcode;
    private Status status;
    private Double minPrice;
    private Double maxPrice;
    private Integer minStock;
    private Integer maxStock;
    private Long supplierId;
    private LocalDate manufacturingDateFrom;
    private LocalDate manufacturingDateTo;
    private LocalDate expiryDateFrom;
    private LocalDate expiryDateTo;

    public boolean isEmpty() {
        return isBlank(name) &&
                isBlank(category) &&
                isBlank(subcategory) &&
                isBlank(model) &&
                isBlank(seller) &&
                isBlank(location) &&
                isBlank(sku) &&
                isBlank(barcode) &&
                status == null &&
                minPrice == null &&
                maxPrice == null &&
                minStock == null &&
                maxStock == null &&
                supplierId == null &&
                manufacturingDateFrom == null &&
                manufacturingDateTo == null &&
                expiryDateFrom == null &&
                expiryDateTo == null;
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}
