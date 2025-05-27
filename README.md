
# Uber Web Application 

This project is a backend service for a ride-booking app inspired by Uber. It is built using Spring Boot and implements core functionalities including user authentication, ride management, driver matching, payment processing, and ride fare calculation. The system leverages design patterns and geospatial technologies to optimize user experience and operational efficiency.


## Tech Stack
- Java 17 – Main programming language
- Spring Boot – Framework for building RESTful APIs
- Spring Security – For authentication and authorization
- Spring Data JPA – For ORM (Object Relational Mapping)
- Hibernate – JPA implementation
- PostgreSQL – Relational database
- PostGIS – For geospatial queries (finding nearest drivers)
## Modules
- Auth Module  
- Driver Module  
- Rider Module  
- Ride Module  
- Ride Request Module  
- Payment Module  
- Rating Module  
- Wallet Module  
- Wallet Transaction Module  
- Distance Module  
## Features

- **Payment Strategy:**  
  Supports multiple payment methods including **Cash** and **Wallet** payments with a flexible payment strategy manager.

- **Driver Matching Strategy:**  
  Matches riders with drivers based on either **nearest driver proximity** (using PostGIS geospatial queries) or **highest driver rating** to ensure quality service.

- **Ride Fare Calculation Strategy:**  
  Calculates fare using default pricing or surge pricing mechanisms. Distance calculations utilize the **OSRM API** for accurate route distances.

- **Strategy Managers:**  
  Separate managers like `RideStrategyManager` and `PaymentStrategyManager` coordinate different strategies dynamically for modular and scalable design.

- **Geospatial Queries:**  
  Efficiently finds nearest drivers using PostgreSQL PostGIS functions such as `ST_Distance()` and `ST_DWithin()`.

## API Root Endpoint
- https://localhost:8080
- http://localhost:8080/swagger-ui.html

## Installation & Run

```bash
git clone https://github.com/your-username/your-uber-project.git
cd uberApplication

// create the database named UberDB and create a postgis extension by running following command

CREATE EXTENSION postgis;

# Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/UberDB?useSSL=false
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

# Mail Configuration
spring.mail.username=${MAIL}
spring.mail.password=${MAIL_PASSWORD}

Then Run your Application
