package com.ivm.inventorymanagement.entity;

import com.ivm.inventorymanagement.dto.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "inventory", indexes = {
        @Index(name = "idx_name", columnList = "name"),
        @Index(name = "idx_category", columnList = "category"),
        @Index(name = "idx_subcategory", columnList = "subcategory"),
        @Index(name = "idx_sku", columnList = "sku"),
        @Index(name = "idx_supplier", columnList = "supplier_id")
})
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;

    private String subcategory;

    private LocalDate manufacturingDate;
    private LocalDate expiryDate;

    @Column(columnDefinition = "TEXT")
    private String specification;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer stock = 0;

    private String model;
    private String seller;

    private String location;

    @Column(nullable = false, unique = true)
    private String sku;

    @Column(unique = true)
    private String barcode;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

    private Integer reorderLevel = 0;

    @Column(name = "supplier_id")
    private Long supplierId;

    private BigDecimal discount = BigDecimal.ZERO;

    private BigDecimal weight = BigDecimal.ZERO;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Auto set timestamps
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // Getters and Setters
    // (Generate using Lombok or IDE)
}
