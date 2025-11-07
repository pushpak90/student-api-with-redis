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
