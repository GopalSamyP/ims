package com.ivm.inventorymanagement.specification;

import com.ivm.inventorymanagement.dto.InventoryFilter;
import com.ivm.inventorymanagement.entity.Inventory;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class InventorySpecification {

    public static Specification<Inventory> filter(InventoryFilter f) {

        return (root, query, cb) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (f.getName() != null) {
                predicates.add(cb.like(
                        cb.lower(root.get("name")),
                        "%" + f.getName().toLowerCase() + "%"
                ));
            }

            if (f.getCategory() != null) {
                predicates.add(cb.equal(root.get("category"), f.getCategory()));
            }

            if (f.getSubcategory() != null) {
                predicates.add(cb.equal(root.get("subcategory"), f.getSubcategory()));
            }

            if (f.getModel() != null) {
                predicates.add(cb.equal(root.get("model"), f.getModel()));
            }

            if (f.getSeller() != null) {
                predicates.add(cb.equal(root.get("seller"), f.getSeller()));
            }

            if (f.getLocation() != null) {
                predicates.add(cb.equal(root.get("location"), f.getLocation()));
            }

            if (f.getSku() != null) {
                predicates.add(cb.equal(root.get("sku"), f.getSku()));
            }

            if (f.getBarcode() != null) {
                predicates.add(cb.equal(root.get("barcode"), f.getBarcode()));
            }

            if (f.getStatus() != null) {
                predicates.add(cb.equal(root.get("status"), f.getStatus()));
            }

            // 🔥 Price Range
            if (f.getMinPrice() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("price"), f.getMinPrice()));
            }

            if (f.getMaxPrice() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("price"), f.getMaxPrice()));
            }

            // 🔥 Stock Range
            if (f.getMinStock() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("stock"), f.getMinStock()));
            }

            if (f.getMaxStock() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("stock"), f.getMaxStock()));
            }

            // 🔥 Supplier
            if (f.getSupplierId() != null) {
                predicates.add(cb.equal(root.get("supplierId"), f.getSupplierId()));
            }

            // 🔥 Date ranges
            if (f.getManufacturingDateFrom() != null) {
                predicates.add(cb.greaterThanOrEqualTo(
                        root.get("manufacturingDate"),
                        f.getManufacturingDateFrom()
                ));
            }

            if (f.getManufacturingDateTo() != null) {
                predicates.add(cb.lessThanOrEqualTo(
                        root.get("manufacturingDate"),
                        f.getManufacturingDateTo()
                ));
            }

            if (f.getExpiryDateFrom() != null) {
                predicates.add(cb.greaterThanOrEqualTo(
                        root.get("expiryDate"),
                        f.getExpiryDateFrom()
                ));
            }

            if (f.getExpiryDateTo() != null) {
                predicates.add(cb.lessThanOrEqualTo(
                        root.get("expiryDate"),
                        f.getExpiryDateTo()
                ));
            }

            return cb.and(predicates.toArray(new Predicate[0])); // 🔥 AND condition
        };
    }
}
