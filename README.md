# 🎓 Student Management System — Spring Boot + MySQL + Redis

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-6DB33F?logo=springboot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-Database-4479A1?logo=mysql&logoColor=white)
![Redis](https://img.shields.io/badge/Redis-Cache-DC382D?logo=redis&logoColor=white)
![Java](https://img.shields.io/badge/Java-17+-007396?logo=java&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-Build%20Tool-02303A?logo=gradle&logoColor=white)

---

A **RESTful web application** built using **Spring Boot**, **MySQL**, and **Redis** to manage student data efficiently.  
This project demonstrates CRUD operations with MySQL as the main database and Redis for caching to improve performance.

---

## 🏷️ Project Overview

The **Student Management System** provides a simple API to manage students' information — allowing you to create, read, update, and delete records.  
To enhance speed and reduce database load, the project uses **Redis caching** with **Spring Cache abstraction**.

---

## 🚀 Features

✅ Create, Read, Update, and Delete (CRUD) student records  
✅ MySQL database integration using **Spring Data JPA**  
✅ **Redis caching** to boost performance and reduce database hits  
✅ Uses **ModelMapper** for clean DTO–Entity mapping  
✅ JSON-based caching using **GenericJackson2JsonRedisSerializer**  
✅ Follows a clean, modular structure (Controller → Service → Repository)

---

## 🧠 Tech Stack

| Layer | Technology |
|--------|-------------|
| **Backend Framework** | Spring Boot 3.x |
| **Database** | MySQL |
| **Cache** | Redis |
| **ORM** | Spring Data JPA |
| **DTO Mapping** | ModelMapper |
| **Build Tool** | Gradle |
| **Language** | Java 17+ |

---

## 🏗️ Project Structure
```bash
Student-Management-System/
│
├── src/main/java/com/dev/Student/Managment/System/
│   ├── Config/
│   │   └── RedisConfig.java
│   │
│   ├── Controller/
│   │   └── StudentController.java
│   │
│   ├── DTOs/
│   │   └── StudentDto.java
│   │
│   ├── Entity/
│   │   └── Student.java
│   │
│   ├── Repository/
│   │   └── StudentRepo.java
│   │
│   ├── Service/
│   │   ├── StudentService.java
│   │   └── ServiceImpl/
│   │       └── StudentImpl.java
│   │
│   └── SpringbootMysqlDemoApplication.java
│
└── build.gradle

```

## ⚙️ Setup & Installation

### 1️⃣ Clone the repository  
Clone the project from GitHub and navigate to the folder.

### 2️⃣ Create MySQL Database  
Create a database named `studentdb` in MySQL.

### 3️⃣ Configure `application.properties`  
Add your MySQL username, password, and Redis configuration (host and port).

### 4️⃣ Start Redis Server  
Run Redis locally and ensure it’s accessible (check with `redis-cli ping`).

### 5️⃣ Build and Run the Application  
Use Gradle to build and run the project with `./gradlew bootRun`.

---

## 🌐 API Endpoints

| Method | Endpoint | Description |
|---------|-----------|-------------|
| **POST** | `/api/students` | Add a new student |
| **GET** | `/api/students` | Get all students (cached) |
| **GET** | `/api/students/{id}` | Get student by ID (cached) |
| **PUT** | `/api/students/{id}` | Update student details |
| **DELETE** | `/api/students/{id}` | Delete student |

---

## 🧩 Caching Behavior (Redis)

| Operation | Cache Key | Effect |
|------------|------------|--------|
| `getStudentList()` | `"students"` | Caches full list |
| `getStudentById(id)` | `"student::<id>"` | Caches individual student |
| `addStudent()` | Evicts `"students"` | Clears list cache |
| `updateStudent()` | Updates `"student::<id>"` and clears `"students"` | Refresh cache |
| `deleteStudent()` | Evicts `"student"` and `"students"` | Clears both caches |

---

## 🧠 Redis Integration Summary

- Uses **Spring Cache abstraction** to manage caching automatically.  
- Configured using **GenericJackson2JsonRedisSerializer** for human-readable JSON storage.  
- Automatically handles cache invalidation on create, update, and delete operations.  
- TTL (time-to-live) for cache entries set to **10 minutes** for freshness.

---

## 🧾 Application Flow

1. **Client sends a request** (e.g., GET /api/students).  
2. **Spring checks Redis cache**:  
   - If data exists → returns cached data instantly.  
   - If not → fetches from MySQL, caches it, and returns the result.  
3. **Any write operation (POST, PUT, DELETE)** → automatically clears or refreshes the related caches.  

---

## 📊 View Redis Data

You can inspect Redis cache data using:
- **Redis CLI**: Run `redis-cli`, then `keys *` to list cached keys.  
- **RedisInsight (GUI)**: [Download here](https://redis.io/insight) to visualize keys, TTL, and values in a clean interface.

---


