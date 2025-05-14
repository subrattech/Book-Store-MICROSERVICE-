# Bookstore Microservices

This repository contains the core microservices of the Bookstore Application, built using Spring Boot and managed via Spring Cloud (Eureka, Gateway). It includes:

- `user-service`: Manages user registration and profile details.
- `book-service`: Manages the book catalog.
- `order-service`: Handles book orders and interactions between users and books.

---

## 🧱 Architecture Overview

               +------------------------+
               |   API Gateway (4848)   |
               +------------------------+
                /          |           \
               /           |             \
              /            |               \
    _____________    _______________    _______________             
  | user-service |  | book-service  |  | order-service |
  |    (8081)    |  |     (8082)    |  |     (8083)    |
  | ____________ |  | _____________ |  | _____________ |
Each service registers with the Eureka Discovery Server and communicates through the API Gateway using load-balanced routes.

### Prerequisites

- Java 17
- Maven 3.6+
- Eureka Server (running separately)
- API Gateway (running separately)

### Running the Services Individually

1. cd eureka Server
mvn spring-boot:run

2. cd API Gateway
mvn spring-boot:run

3. cd user-service
mvn spring-boot:run

4. cd book-service
mvn spring-boot:run

5. cd order-service
mvn spring-boot:run

🔧 API Endpoints (via API Gateway)

Service	Route Prefix	Example Endpoint
User Service	/api/users/**	GET /api/users/1
Book Service	/api/books/**	GET /api/books/1
Order Service	/api/orders/**	POST /api/orders


