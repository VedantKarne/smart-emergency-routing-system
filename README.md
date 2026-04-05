# 🚑 Smart Emergency Routing System (Spring Boot Backend)

## 📌 Overview

The Smart Emergency Routing System is a backend application designed to assign patients to hospitals based on medical severity and real-time resource availability.

The system prioritizes efficient allocation of critical resources such as ICU and general beds, ensuring that patients are routed to the most suitable hospital under constrained conditions.

This project demonstrates structured backend development using Spring Boot, with a focus on business logic, data modeling, and system design.

---

## 🎯 Objectives

- Implement a constraint-based hospital assignment system  
- Simulate real-world emergency triage decision-making  
- Apply layered backend architecture principles  
- Build a scalable foundation for future enhancements  

---

## 🏗️ Technology Stack

- **Language:** Java (JDK 25)  
- **Framework:** Spring Boot 3.2.5  
- **ORM:** Spring Data JPA (Hibernate)  
- **Database:** MySQL  
- **Build Tool:** Maven  
- **Connection Pooling:** HikariCP  

---

## 📁 Project Structure

```

smart-emergency-routing-system/
│
├── .gitignore
├── pom.xml
│
├── images/
│   ├── Image1.png
│   ├── Image2.png
│   └── ...
│
├── src/
│   ├── main/
│   │   ├── java/com/pict/emergency/
│   │   │
│   │   │   ├── EmergencyApplication.java
│   │   │
│   │   │   ├── controller/
│   │   │   │   ├── HomeController.java
│   │   │   │   ├── PatientController.java
│   │   │   │   ├── HospitalController.java
│   │   │   │   └── AssignmentController.java
│   │   │
│   │   │   ├── service/
│   │   │   │   ├── PatientService.java
│   │   │   │   ├── HospitalService.java
│   │   │   │   └── AssignmentService.java
│   │   │
│   │   │   ├── repository/
│   │   │   │   ├── PatientRepository.java
│   │   │   │   ├── HospitalRepository.java
│   │   │   │   └── AssignmentRepository.java
│   │   │
│   │   │   ├── entity/
│   │   │   │   ├── Patient.java
│   │   │   │   ├── Hospital.java
│   │   │   │   └── Assignment.java
│   │   │
│   │   │   ├── exception/
│   │   │   │   ├── ResourceNotFoundException.java
│   │   │   │   ├── NoHospitalAvailableException.java
│   │   │   │   └── GlobalExceptionHandler.java
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│
└── target/

```

---

## 🧠 System Architecture

The application follows a layered architecture:

- **Controller Layer**: Handles HTTP requests and responses  
- **Service Layer**: Contains business logic and decision-making  
- **Repository Layer**: Manages database operations via JPA  
- **Database Layer**: Stores persistent data  

---

## 🗃️ Data Model

### Patient
- `id` (Primary Key)  
- `name`  
- `severity` (1–10)  
- `requiredFacility` (ICU / GENERAL)  

### Hospital
- `id` (Primary Key)  
- `name`  
- `icuBeds`  
- `generalBeds`  

### Assignment
- `id` (Primary Key)  
- `patient` (One-to-One)  
- `hospital` (Many-to-One)  

---

## ⚙️ Core Functionality

The system assigns patients based on:

- Severity level  
- Required facility  
- Availability of hospital resources  

### Decision Rules

- Severity ≥ 8 → ICU required  
- Severity 5–7 → General or ICU acceptable  
- Severity ≤ 4 → Any available hospital  

If no suitable hospital is available, the system raises a custom exception.

---

## 🔄 API Endpoints

### Patient APIs
- `POST /patients` → Add patient  
- `GET /patients` → Retrieve all patients  
- `PUT /patients/{id}` → Update patient  
- `DELETE /patients/{id}` → Delete patient  

### Hospital APIs
- `POST /hospitals` → Add hospital  
- `GET /hospitals` → Retrieve all hospitals  
- `PUT /hospitals/{id}` → Update hospital  
- `DELETE /hospitals/{id}` → Delete hospital  

### Assignment APIs
- `POST /assign/{patientId}` → Assign hospital to patient  
- `GET /assign` → Retrieve all assignments  
- `GET /assign/{id}` → Retrieve assignment by ID  

---

## 🧪 API Testing Workflow

1. Add hospitals  
2. Add patients  
3. Trigger assignment  
4. Verify assignment and resource updates  

Refer to the `/images` directory for API testing screenshots.

---

## ⚠️ Exception Handling

- `ResourceNotFoundException` → Entity not found  
- `NoHospitalAvailableException` → No suitable hospital available  

Handled centrally using a global exception handler.

---

## 🔍 Validation

- Severity must be within the range 1–10  
- Required fields are validated using annotations  
- Invalid inputs return appropriate HTTP responses  

---

## ▶️ Running the Application

### 1. Create Database

```sql
CREATE DATABASE emergency_db;
````

### 2. Configure Database

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/emergency_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Run the Application

Run:

```
EmergencyApplication.java
```

### 4. Access Application

```
http://localhost:8080
```

---

## 📈 Future Enhancements

* Distance-based hospital selection
* Machine learning-based severity prediction
* Concurrency control for resource allocation
* Monitoring dashboard

---

## 📄 License

This project is developed for academic and learning purposes.

