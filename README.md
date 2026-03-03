# Library Management System

A RESTful Library Management System built with Spring Boot, JPA, and H2 in-memory database.

## Tech Stack

| Technology       | Description                            |
|------------------|----------------------------------------|
| Java 17          | Programming language                   |
| Spring Boot 3.x  | Application framework                  |
| Spring Data JPA  | Database access layer                  |
| H2 Database      | In-memory relational database          |
| Lombok           | Boilerplate code reduction             |
| Springdoc OpenAPI| API documentation (Swagger UI)         |
| Maven            | Build tool                             |

## Project Structure

```
src/
└── main/
    ├── java/com/ace/library/
    │   ├── LibraryManagementApplication.java
    │   ├── entity/
    │   │   ├── Author.java
    │   │   ├── Book.java
    │   │   ├── Category.java
    │   │   ├── Member.java
    │   │   ├── Loan.java
    │   │   └── LoanStatus.java
    │   ├── repository/
    │   │   ├── AuthorRepository.java
    │   │   ├── BookRepository.java
    │   │   ├── CategoryRepository.java
    │   │   ├── MemberRepository.java
    │   │   └── LoanRepository.java
    │   ├── service/
    │   │   ├── AuthorService.java
    │   │   ├── BookService.java
    │   │   ├── CategoryService.java
    │   │   ├── MemberService.java
    │   │   └── LoanService.java
    │   ├── controller/
    │   │   ├── AuthorController.java
    │   │   ├── BookController.java
    │   │   ├── CategoryController.java
    │   │   ├── MemberController.java
    │   │   └── LoanController.java
    │   ├── dto/
    │   │   ├── AuthorDto.java
    │   │   ├── BookDto.java
    │   │   ├── CategoryDto.java
    │   │   ├── MemberDto.java
    │   │   └── LoanDto.java
    │   └── exception/
    │       ├── GlobalExceptionHandler.java
    │       └── ResourceNotFoundException.java
    └── resources/
        ├── application.yaml
        └── data.sql
```

## How to Run

```bash
mvn spring-boot:run
```

The application will start on port `8080` by default.

## H2 Console

Access the H2 in-memory database console at:

- **URL:** [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- **JDBC URL:** `jdbc:h2:mem:librarydb`
- **Username:** `sa`
- **Password:** *(leave blank)*

## Swagger UI

API documentation is available at:

- **URL:** [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- **OpenAPI JSON:** [http://localhost:8080/api-docs](http://localhost:8080/api-docs)

## REST API Endpoints

### Authors

| Method | Path                   | Description           |
|--------|------------------------|-----------------------|
| GET    | /api/v1/authors        | Get all authors       |
| GET    | /api/v1/authors/{id}   | Get author by ID      |
| POST   | /api/v1/authors        | Create new author     |
| PUT    | /api/v1/authors/{id}   | Update author         |
| DELETE | /api/v1/authors/{id}   | Delete author         |

### Categories

| Method | Path                      | Description             |
|--------|---------------------------|-------------------------|
| GET    | /api/v1/categories        | Get all categories      |
| GET    | /api/v1/categories/{id}   | Get category by ID      |
| POST   | /api/v1/categories        | Create new category     |
| PUT    | /api/v1/categories/{id}   | Update category         |
| DELETE | /api/v1/categories/{id}   | Delete category         |

### Books

| Method | Path                              | Description                    |
|--------|-----------------------------------|--------------------------------|
| GET    | /api/v1/books                     | Get all books                  |
| GET    | /api/v1/books/{id}                | Get book by ID                 |
| POST   | /api/v1/books                     | Create new book                |
| PUT    | /api/v1/books/{id}                | Update book                    |
| DELETE | /api/v1/books/{id}                | Delete book                    |
| GET    | /api/v1/books/search?title=       | Search books by title          |
| GET    | /api/v1/books/category/{categoryId} | Get books by category        |

### Members

| Method | Path                    | Description            |
|--------|-------------------------|------------------------|
| GET    | /api/v1/members         | Get all members        |
| GET    | /api/v1/members/{id}    | Get member by ID       |
| POST   | /api/v1/members         | Create new member      |
| PUT    | /api/v1/members/{id}    | Update member          |
| DELETE | /api/v1/members/{id}    | Delete member          |

### Loans

| Method | Path                        | Description                   |
|--------|-----------------------------|-------------------------------|
| GET    | /api/v1/loans               | Get all loans                 |
| GET    | /api/v1/loans/{id}          | Get loan by ID                |
| POST   | /api/v1/loans               | Issue a new loan              |
| PUT    | /api/v1/loans/{id}/return   | Return a book                 |
| GET    | /api/v1/loans/overdue       | Get all overdue loans         |
| GET    | /api/v1/loans/member/{memberId} | Get loans by member       |

## Entity Relationship Summary

```
Category (1) ──── (N) Book (N) ──── (M) Author
                    │
                    │ (1)
                    │
                   (N)
                  Loan (N) ──── (1) Member
```

- A **Category** has many **Books**
- A **Book** belongs to one **Category**
- A **Book** has many **Authors** (and an **Author** can have many **Books**)
- A **Member** can have many **Loans**
- A **Loan** is associated with one **Book** and one **Member**
