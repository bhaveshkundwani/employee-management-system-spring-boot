# Employee Management System

A server-rendered web application for managing employee records, built with **Spring Boot**, **Thymeleaf**, and **PostgreSQL**. It provides a clean, responsive interface for creating, viewing, updating, and deleting employees.

## Features

- Add new employees with auto-generated unique IDs (e.g., `EMP4821`)
- View all employees in a responsive table
- Edit employee details through a modal form
- Delete a single employee with a confirmation prompt
- Delete all employees, protected by a typed confirmation
- Responsive UI built with Bootstrap 5 and Bootstrap Icons

## Tech Stack

| Layer       | Technology                     |
|-------------|--------------------------------|
| Language    | Java 17                        |
| Framework   | Spring Boot 4.1.1 (Web MVC)    |
| Persistence | Spring Data JPA, Hibernate     |
| Database    | PostgreSQL                     |
| View        | Thymeleaf, Bootstrap 5         |
| Build Tool  | Maven                          |
| Other       | Lombok, Bean Validation        |

## Project Structure

```
src/main/java/com/employee/
├── controller/    # MVC controller handling web requests
├── service/       # Business logic (CRUD, ID generation)
├── repository/    # Spring Data JPA repository
├── entity/        # Employee JPA entity
└── dto/           # Form objects (delete-all confirmation)

src/main/resources/
├── templates/     # Thymeleaf template (index.html)
├── static/css/    # Custom styles
└── application.yaml
```

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven (or use the included Maven wrapper)
- PostgreSQL

### Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/bhaveshkundwani/employee-management-system-spring-boot.git
   cd employee-management-system-spring-boot
   ```

2. **Create the database**
   ```sql
   CREATE DATABASE employee_management;
   ```

3. **Configure database credentials** in `src/main/resources/application.yaml`:
   ```yaml
   spring:
     datasource:
       url: jdbc:postgresql://localhost:5432/employee_management
       username: ${DB_USERNAME}
       password: ${DB_PASSWORD}
   ```
   Set `DB_USERNAME` and `DB_PASSWORD` as environment variables so credentials are never committed.

4. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```

5. **Open in your browser**
   ```
   http://localhost:8080
   ```

Tables are created automatically on startup (`ddl-auto: update`).

## Application Routes

| Method | Route         | Description                                  |
|--------|---------------|----------------------------------------------|
| GET    | `/`           | Home page with employee list and forms       |
| POST   | `/create`     | Create a new employee                        |
| POST   | `/update`     | Update an existing employee                  |
| POST   | `/remove`     | Delete an employee by ID                     |
| POST   | `/remove/all` | Delete all employees (requires confirmation) |

## Employee Data Model

| Field            | Type                                      |
|------------------|-------------------------------------------|
| `id`             | String (auto-generated, `EMP` + 4 digits) |
| `employeeName`   | String                                    |
| `employeeEmail`  | String                                    |
| `employeePhone`  | Long                                      |
| `employeeGender` | String                                    |
| `employeeSalary` | String                                    |
| `employeeRole`   | String                                    |

## Author

**Bhavesh Kundwani**
