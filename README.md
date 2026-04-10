# 📦 Inventory Management System

A Spring Boot-based **Inventory Management API** that supports dynamic search, filtering, and pagination using **Spring Data JPA Specifications**.

---

## 🚀 Features

- 🔍 Dynamic Search (all filters optional)
- 📦 Inventory management
- 📊 Pagination & Sorting
- 🧠 JPA Specification (Criteria API)
- 🗃️ MySQL database integration
- ✅ Input validation support

---

## 🛠️ Tech Stack

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- MySQL
- Lombok
- OpenAPI (Swagger)

---

## 📁 Project Structure

src/main/java/com/ivm/inventorymanagement

- controller       - REST Controllers
- service          - Business Logic
- repository       - JPA Repositories
- entity           - JPA Entities
- dto              - Request/Response DTOs
- specification    - Dynamic query logic
- config           - Configuration classes

---

## ⚙️ Setup & Run

### 1. Configure Database

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/ims_db
    username: root
    password: your_password

---

### 2. Run Application

mvn clean install
mvn spring-boot:run

---

## 🌐 API

GET /api/inventory/search

---

## 🔎 Query Parameters

name, category, subcategory, model, seller, location, sku, barcode,
status, minPrice, maxPrice, minStock, maxStock,
supplierId, manufacturingDateFrom, manufacturingDateTo,
expiryDateFrom, expiryDateTo

---

## 📊 Pagination

?page=0&size=10&sort=price,asc,pagination=true

---

## 📦 Sample Response

{
  "content": [
    {
      "id": 1,
      "name": "iPhone 15 Pro",
      "category": "Electronics",
      "price": 129999.99
    }
  ]
}

---

## 🧠 Concepts

- JPA Specification
- CriteriaBuilder
- Pagination
- DTO Mapping
- REST API

---

## 🔥 Future Enhancements

- JWT Authentication
- Full CRUD APIs
- Docker support
- Kubernetes deployment

---

