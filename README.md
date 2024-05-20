# Items - Hexagonal Architectury
This project is an example of a Java application using MongoDB and Hexagonal Architecture to manage items. It demonstrates how to structure an application to maximize decoupling between layers and improve testability and maintainability.

# Prerequisites
Before getting started, make sure you have the following installed in your development environment:

* Java JDK 17
* Maven
* Docker
  
# Installation and Execution
1. Clone the repository:
```bash
git clone https://github.com/your-user/items-hexagonal-arch.git
```
Or download and extract the project manually.

2. Navigate to the project directory:
```bash
cd items-hexagonal-arch
```
3. Run the project using Maven:
```bash
mvn spring-boot:run
```
The application will start and be accessible at http://localhost:8080.

# Endpoints
The application exposes the following endpoints:

* POST /api/items: Creates a new item.
    * Request body:
      ```json
        {
          "name": "Item Name",
          "description": "Item Description"
        }
      ```
* GET /api/items: Returns all items.
* GET GET /api/items/{id}: Returns a specific item by ID.
* PUT PUT /api/items/{id}: Updates an existing item.
    * Request body:
      ```json
        {
          "name": "Updated Item Name",
          "description": "Updated Item Description"
        }
      ```
* DELETE /api/items/{id}: Deletes an item by ID.

# Configuration
The application's settings can be found in the application.properties file. Make sure to configure the properties related to Redis and the database according to your environment.
```yml
spring:
  application:
    name: items-hexagonal-arch
  data:
    mongodb:
      username: root
      password: secret
      database: items-db
      port: 27017
      host: mongodb
```

# Contributing
If you wish to contribute to this project, follow these steps:

1. Fork the project.
2. Create a branch for your feature:
```bash
git checkout -b feature-new-feature
```
3. Make your changes and commit them:
```bash
git commit -m 'Add a new feature
```
4. Push to the branch:
```bash
git push origin feature-new-feature
```
5. Submit a pull request.
