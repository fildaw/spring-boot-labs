## Spring Boot RESTful API application

### Description

A simple CRUD application in Java using Spring Boot, developed for my university's Internet Services Architecture course. 
The task involved building a RESTful CRUD API with endpoints for managing entities and their categories. 
JPA handles object-relational mapping, while Lombok provides useful annotations. 
Spring MVC, structured with repositories, services, controllers, and appropriate DTOs, 
implements the RESTful services. 
The application is divided into three microservices: entity manager, 
entity categories manager, and Spring Gateway. 
The communication between entity manager and category manager is realized
as an event-based communication using RestTemplate.
The app is containerized using Docker Compose.

### How to run?
Simply type
```bash 
$ docker compose up 
```
in the root directory of the project.
This would start a composition of three microservices (film, film-repository and gateway)
and two MariaDB databases, one for film (entity manager) and one for film-repository (category manager).
The API gateway will be exposed on `http://localhost:8083`.

### Using the API
Endpoints specification alongside with examples are in [requests.http](gateway/requests.http) file. 
You can run them using IntelliJ IDEA Ultimate or transform them to `curl` commands.
