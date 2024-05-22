# bookStorage
Book Storage System
The Book Storage System is a web application designed to manage information about books and their authors. It provides functionalities to add, update, delete, and retrieve books and authors from a database.

Features
Add Book: Allows users to add new books to the system, including details such as title, author, genre, and price.
Update Book: Enables users to update existing book information, including title, author, genre, and price.
Delete Book: Allows users to delete books from the system.
Retrieve Book: Provides endpoints to retrieve information about books, including individual books and all books in the system.

Error Handling: Implements error handling to handle scenarios such as book not found, invalid input, etc.

Technologies Used
Spring Boot: A powerful framework for building Java-based applications.
Spring Data JPA: Simplifies data access layer implementation by providing easy-to-use APIs for working with databases.
Hibernate: An object-relational mapping (ORM) framework for Java applications.
H2 Database: A lightweight, in-memory database used for development and testing.
Maven: A build automation tool used for managing dependencies and building the project.

Setup

Clone the Repository:

git clone https://github.com/your-username/book-storage.git

Build the Project:

cd book-storage

mvn clean install


Run the Application:

mvn spring-boot:run

Access the Application:

Open a web browser and go to http://localhost:8080 to access the application

Usage
Add Book:
Send a POST request to /api/books with JSON payload containing book details.

Update Book:
Send a PUT request to /api/books/{id} with JSON payload containing updated book details.

Delete Book:
Send a DELETE request to /api/books/{id} to delete a book with the specified ID.

Retrieve Book:
Send a GET request to /api/books/{id} to retrieve details of a book with the specified ID.
Send a GET request to /api/books to retrieve details of all books in the system.

