# Spring Data JPA Concepts - Basic Persistence Example

This project is a minimal Spring Boot application demonstrating the fundamental setup for **Object-Relational Mapping (ORM)** using **Spring Data JPA** and **Hibernate**.

It focuses on defining a basic **Student Entity** and using a standard **JPA Repository** for data persistence.

## 🚀 Key Implementations

* **Student Entity:** A Java class mapped to a PostgreSQL table using JPA annotations.
* **Student Repository:** An interface extending `JpaRepository` for basic CRUD operations.
* **Data Initialization:** Uses a **`CommandLineRunner`** to automatically create and persist a `Student` object when the application starts.

## 🛠️ Code Details & Concepts

### 1. Student Entity (`Student.java`)

This entity defines the structure of the `student` table in the database.

| Annotation | Purpose |
| :--- | :--- |
| `@Entity` | Marks the class as a JPA entity. |
| `@Table` | Specifies the table name (`student`) and defines a **unique constraint** on the `email` column (`student_email_unique`). |
| `@Id` / `@GeneratedValue` | Defines the `id` field as the primary key, utilizing a **sequence generator** for automatic value generation. |
| `@Column(nullable = false)` | Ensures that `first_name`, `last_namr`, `email`, and `age` columns cannot be null. |
| `@Column(updatable = false)` | Prevents the `id` from being modified after creation. |

### 2. Student Repository (`StudentRepository.java`)

This simple interface automatically provides standard **CRUD (Create, Read, Update, Delete)** methods (e.g., `save()`, `findById()`, `findAll()`) by extending `JpaRepository<Student, Long>`.

* `Student`: The entity type managed by this repository.
* `Long`: The data type of the entity's primary key (`id`).

### 3. Application Initialization (`SpringDataJpaConceptApplication.java`)

The `@Bean` annotated `CommandLineRunner` is crucial for demonstration:

```java
@Bean
CommandLineRunner commandLineRunner (StudentRepository studentRepository){
   return args -> {
      Student maria = new Student("Satya", "Vadapalli","satyavadapalli@gmail.com",24);
      studentRepository.save(maria); // Persists the Student object to the database
   };
}
