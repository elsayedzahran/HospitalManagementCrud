# HospitalManagementCrud
repo to try crud operations on hospital management system.
# Spring Boot Application Readme

This readme provides an overview of a Spring Boot application that includes four entities: Hospital, Doctor, Drug, and Patient. The application provides RESTful APIs to manage these entities through corresponding controllers. The application is built using JDK 17 and can be deployed in a Docker container.

## Entity Relationship Diagram(ERD)
![mermaid-diagram-2023-09-25-122902](https://github.com/elsayedzahran/HospitalManagementCrud/assets/68614758/7f01ef9b-d16f-49a0-944f-f61c6532ce2c)




## Entities

### Hospital
- Represents a hospital entity.
- Contains properties such as id, name, address, etc.

### Doctor
- Represents a doctor entity.
- Contains properties such as id, name, specialization, etc.

### Drug
- Represents a drug entity.
- Contains properties such as id, name, dosage, etc.

### Patient
- Represents a patient entity.
- Contains properties such as id, name, age, etc.

## Controllers

### HospitalController
- REST controller for managing hospitals.
- Base URL: /hospitals

#### Endpoints:
- GET /list: Retrieves a list of all hospitals.
- GET /{id}: Retrieves a specific hospital by ID.
- POST /add: Adds a new hospital.
- POST /delete/{id}: Deletes a hospital with the specified ID.
- POST /update/{id}: Updates a hospital with the specified ID.
- GET /search?name={name}: Searches for hospitals by name.

### DoctorController
- REST controller for managing doctors.
- Base URL: /doctors

#### Endpoints:
- GET /list: Retrieves a list of all doctors.
- GET /{id}: Retrieves a specific doctor by ID.
- POST /add: Adds a new doctor.
- POST /delete/{id}: Deletes a doctor with the specified ID.
- POST /update/{id}: Updates a doctor with the specified ID.

### PatientController
- REST controller for managing patients.
- Base URL: /patients

#### Endpoints:
- GET /list: Retrieves a list of all patients.
- GET /{id}: Retrieves a specific patient by ID.
- POST /add: Adds a new patient.
- POST /delete/{id}: Deletes a patient with the specified ID.
- POST /update/{id}: Updates a patient with the specified ID.

### DrugController
- REST controller for managing drugs.
- Base URL: /drugs

#### Endpoints:
- GET /list: Retrieves a list of all drugs.
- GET /{id}: Retrieves a specific drug by ID.
- POST /add: Adds a new drug.
- POST /delete/{id}: Deletes a drug with the specified ID.
- POST /update/{id}: Updates a drug with the specified ID.
- GET /search?name={name}: Searches for drugs by name.

## Dependencies

The application depends on the following:
- Spring Boot framework
- mySQL database 
- Docker

Ensure that you have these dependencies installed and configured correctly.
