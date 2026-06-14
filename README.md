# ✈️ Airline Reservation System

A full-stack backend Airline Reservation System developed using Spring Boot, Spring Security, JWT Authentication, Hibernate, and MySQL. The application provides secure user authentication, role-based authorization, flight management, booking management, and booking cancellation functionality through REST APIs.

---

## 🚀 Features

### User Management

* User Registration
* Secure Login using JWT Authentication
* Password Encryption using BCrypt
* Role-Based Access Control (ADMIN / USER)

### Flight Management

* Add New Flights (Admin Only)
* Search Flights by Source and Destination
* Manage Flight Details

### Booking Management

* Book Flights
* View User Bookings
* Cancel Bookings
* Automatic Seat Availability Update

### Security

* Spring Security Integration
* JWT Token Authentication
* Stateless Session Management
* Protected APIs
* Role-Based Authorization

### Exception Handling

* Global Exception Handling
* Custom Error Responses

---

## 🛠️ Tech Stack

### Backend

* Java
* Spring Boot
* Spring Security
* Spring Data JPA
* Hibernate

### Database

* MySQL

### Authentication

* JWT (JSON Web Token)
* BCrypt Password Encoder

### Build Tool

* Maven

### API Testing

* Postman
* Swagger UI

---

## 📂 Project Architecture

```text
Controller Layer
       ↓
Service Layer
       ↓
Repository Layer
       ↓
MySQL Database
```

### Project Structure

```text
src/main/java
│
├── controller
├── service
├── repository
├── entity
├── dto
├── security
├── exception
└── config
```

---

## 🔑 API Endpoints

### Authentication APIs

| Method | Endpoint    |
| ------ | ----------- |
| POST   | /auth/login |

### User APIs

| Method | Endpoint        |
| ------ | --------------- |
| POST   | /users/register |

### Flight APIs

| Method | Endpoint        |
| ------ | --------------- |
| POST   | /flights        |
| GET    | /flights/search |

### Booking APIs

| Method | Endpoint                     |
| ------ | ---------------------------- |
| POST   | /bookings                    |
| GET    | /bookings/user/{userId}      |
| PUT    | /bookings/cancel/{bookingId} |

---

## 🔒 Security Flow

1. User registers an account.
2. User logs in using email and password.
3. JWT token is generated.
4. Client sends JWT token in Authorization header.
5. JWT filter validates token.
6. Spring Security authorizes the request.
7. Protected APIs become accessible based on role.

---

## 📈 Future Improvements

* Flight Seat Selection
* Online Payment Integration
* Email Notifications
* Refresh Token Support
* Admin Dashboard
* Flight Scheduling Module

---

## 👨‍💻 Author

**Ajay Dangi**

Java Backend Developer | Spring Boot Enthusiast | Problem Solver

GitHub: https://github.com/AjayDangi62
