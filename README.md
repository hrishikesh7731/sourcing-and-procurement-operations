# Sourcing and Procurement Operations (SPO)

A procurement management backend that automates the procure-to-pay cycle: purchase requisitions, supplier sourcing and quotations, purchase order fulfillment, goods receipts and invoice verification.

## Tech Stack

Java, Spring Boot, Spring Data JPA, Hibernate, PostgreSQL, Spring Security, JWT, Maven

## Features

- RESTful APIs for procurement company onboarding, purchase requisitions, supplier quotations, purchase orders, goods receipts and invoice management
- Configurable approval workflows, role-based authorization (Spring Security and JWT) and budget controls that enforce procurement business rules
- Supplier quotation comparison and purchase order generation
- Delivery tracking and three-way invoice matching (purchase order, goods receipt, invoice)
- Relational data model and transactional service operations using Spring Data JPA, Hibernate and PostgreSQL
- Reusable notification service for approval requests, supplier communications and procurement status updates
- Centralized exception handling, request validation, automated tests and API documentation

## Getting Started

### Prerequisites

- Java [version, e.g. 17]
- PostgreSQL
- Maven (or use the included Maven wrapper)

### Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/hrishikesh7731/sourcing-and-procurement-operations.git
   cd sourcing-and-procurement-operations
   ```
2. Create a PostgreSQL database named `[supply-chain-easy-db]`.
3. Set the database URL, username and password in `src/main/resources/application.properties`.
4. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```
5. The API starts at `http://localhost:[port, default 8080]`.

### Run the tests

```bash
./mvnw test
```

## Author

Gaddamedi Hrishikesh | [LinkedIn](https://www.linkedin.com/in/hrishikesh-gaddamedi-6b0a513b0/) | [GitHub](https://github.com/hrishikesh7731)
