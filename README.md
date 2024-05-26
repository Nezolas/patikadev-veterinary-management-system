# Veterinary Management System
We have developed an API that allows a veterinary clinic to manage its operations with a veterinary management system project.

The application is designed to be used by veterinary staff. With this application, the staff can:
Register veterinarians, record the working days (available days) of the doctors as dates without time, register customers, register animals belonging to the customers, record vaccinations applied to the animals along with the dates, create appointments for animals with the veterinarians, enter the date and time when creating an appointment, check the availability of the doctor for the given date without time, and check the existing appointment records for date and time to avoid conflicts. If there are no conflicts in the records, the appointment is created.

 ## UML Diagram
![diagram-export-5-26-2024-7_16_24-PM](https://github.com/Nezolas/patikadev-veterinary-management-system/assets/25018831/798b5bd6-4274-4a9a-9788-d169b4c808ed)

## Technologies
- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Maven
- PostgreSQL
- Lombok
- Mapstruct
- Swagger
- Postman

The application will run by default at http://localhost:8080.

## Project Structure

The project includes the following components:

- **CONTROLLER**
- **CORE**
- **DTO**
- **ENTITIES**
- **MAPPER**
- **REPOSITORY**
- **SERVICE**

## Endpoints
Below is a list of basic endpoints provided by the API:

| Endpoint                                      | HTTP Method | Description                                                                         |
|-----------------------------------------------|:------------|-------------------------------------------------------------------------------------|
|  **Animals**                                  |             |                                                                                     |
| /api/v1/animals                               | GET         | List of all animals                                                                 |
| /api/v1/animals/{id}                          | GET         | Animal by id number                                                                 |
| /api/v1/animals/customer/{id}                 | GET         | All animals belonging to a customer are listed.                                     |    
| /api/v1/animals/name/{name}                   | GET         | Animals are listed by name.                                                         |
| /api/v1/animals                               | POST        | Add new animal.                                                                     |
| /api/v1/animals/{id}                          | PUT         | The animal of a specific id is updated.                                             | 
| /api/v1/animals/{id}                          | DELETE      | The animal of a specific id is deleted.                                             |
|**Appointments**                               |             |                                                                                     |
| /api/v1/appointments                          | GET         | List of all appointments.                                                           |
| /api/v1/appointments/{id}                     | GET         | Appointment by id number.                                                           |
| /api/v1/appointments/animal/date-range        | GET         | The appointments for a specified animal within a designated date range are listed.  |
| /api/v1/appointments/doctor/date-range        | GET         | The appointments for a specified doctor within a designated date range are listed.  |
| /api/v1/appointments                          | POST        | Add new appointment.                                                                |
| /api/v1/appointments/{id}                     | PUT         | The appointment of a specific id is updated.                                        |
| /api/v1/appointments/{id}                     | DELETE      | The appointment of a specific id is deleted.                                        |
|**AvailableDates**                             |             |                                                                                     |
| /api/v1/available-date                        | GET         | List of all available dates.                                                        |
| /api/v1/available-date/{id}                   | GET         | Available date by id number.                                                        |
| /api/v1/available-date/date-range             | GET         | The available dates of a specific doctor on a requested date are listed.            |
| /api/v1/available-date                        | POST        | Add new AvailableDate.                                                              |
| /api/v1/available-date/{id}                   | PUT         | The available date of a specific id is updated.                                     |
| /api/v1/available-date/{id}                   | DELETE      | The available date of a specific id is deleted.                                     |
|**Customers**                                  |             |                                                                                     |
| /api/v1/customers                             | GET         | List of all customers.                                                              |
| /api/v1/customers/{id}                        | GET         | Customer by id number.                                                              |
| /api/v1/customers/name/{name}                 | GET         | List of customers with a specific name.                                             |
| /api/v1/customers                             | POST        | Add new Customer.                                                                   |
| /api/v1/customers/{id}                        | PUT         | The customer of a specific id is updated.                                           |
| /api/v1/customers/{id}                        | DELETE      | The customer of a specific id is deleted.                                           |
|**Doctors**                                    |             |                                                                                     |
| /api/v1/doctors                               | GET         | List of all doctors.                                                                |
| /api/v1/doctors/{id}                          | GET         | Doctor by id number.                                                                |   
| /api/v1/doctors                               | POST        | Add new Doctor.                                                                     |
| /api/v1/doctors/{id}                          | PUT         | The doctor of a specific id is updated.                                             |
| /api/v1/doctors/{id}                          | DELETE      | The doctor of a specific id is deleted.                                             |
|**Vaccines**                                   |             |                                                                                     |
| /api/v1/vaccines                              | GET         | List of all vaccines.                                                               |
| /api/v1/vaccines/{id}                         | GET         | Vaccine by id number.                                                               |
| /api/v1/vaccines/animal/{id}                  | GET         | The list of vaccines for a specific animal.                                         |
| /api/v1/vaccines/date-range                   | GET         | The list of vaccines expiring within a specific time range.                         |
| /api/v1/vaccines                              | POST        | Add new Vaccine.                                                                    |
| /api/v1/vaccines                              | PUT         | The vaccine of a specific id is updated.                                            |
| /api/v1/vaccines                              | DELETE      | The vaccine of a specific id is deleted.                                            |
