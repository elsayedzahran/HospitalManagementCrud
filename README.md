# HospitalManagementCrud
This readme provides an overview of a Spring Boot application that includes four entities: Hospital, Doctor, Drug, and Patient. The application provides RESTful APIs to manage these entities through corresponding controllers. The application is built using JDK 17 and can be deployed in a Docker container.

## Entity Relationship Diagram(ERD)
![mermaid-diagram-2023-09-25-122902](https://github.com/elsayedzahran/HospitalManagementCrud/assets/68614758/7f01ef9b-d16f-49a0-944f-f61c6532ce2c)

## Controllers

### HospitalController
- REST controller for managing hospitals.
- Base URL: /hospitals

#### Endpoints:
- GET /: Retrieves a list of all hospitals.
- GET /{id}: Retrieves a specific hospital by ID.
- POST /add: Adds a new hospital.
- DELETE /{id}: Deletes a hospital with the specified ID.
- PUT /{id}: Updates a hospital with the specified ID.

### DoctorController
- REST controller for managing doctors.
- Base URL: /doctors

#### Endpoints:
- GET /: Retrieves a list of all doctors.
- GET /{id}: Retrieves a specific doctor by ID.
- POST /: Adds a new doctor.
- DELETE /{id}: Deletes a doctor with the specified ID.
- PUT /{id}: Updates a doctor with the specified ID.

### PatientController
- REST controller for managing patients.
- Base URL: /patients

#### Endpoints:
- GET /: Retrieves a list of all patients.
- GET /{id}: Retrieves a specific patient by ID.
- POST /: Adds a new patient.
- DELETE /{id}: Deletes a patient with the specified ID.
- PUT /{id}: Updates a patient with the specified ID.

### DrugController
- REST controller for managing drugs.
- Base URL: /drugs

#### Endpoints:
- GET /: Retrieves a list of all drugs.
- GET /{id}: Retrieves a specific drug by ID.
- POST /: Adds a new drug.
- DELETE /{id}: Deletes a drug with the specified ID.
- PUT /{id}: Updates a drug with the specified ID.

## Dependencies

The application depends on the following:
- Spring Boot framework
- mySQL database 
- Docker

Ensure that you have these dependencies installed and configured correctly.
