# Library Management System

A Spring Boot-based RESTful API for managing a library's book collection. It supports full CRUD operations with validation, global exception handling, security,
and MySql database integration.

## Features
- CRUD operations on books (Create, Read, Update, Delete)
- Input validation and Global exception handling
- Basic authentication using Spring Security
- MySql database for data storage

## Getting Started

### Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- Maven

### Run the Project
1. Clone the repository:
```bash
git clone https://github.com/Mahesh0206/Library_Management.git
cd library-management-system
```
2. Build and run the project:
```bash
mvn clean install
mvn spring-boot:run
```

### API Endpoints
| Method | Endpoint           | Description         |
|--------|--------------------|---------------------|
| GET    | /api/books/getAll  | List all books      |
| GET    | /api/books/{id}    | Get book by ID      |
| POST   | /api/books/save    | Create new book     |
| PUT    | /api/books/update  | Update existing book|
| DELETE | /api/books/delete  | Delete book         |

### Default Credentials
- Username: `dev`
- Password: `123`

### Run Tests
```bash
mvn test
```
