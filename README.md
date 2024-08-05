# virtual-power-plant-system

## Problem
You are working on a virtual power plant system for aggregating distributed power sources into a single cloud-based energy provider.
Please implement a REST API in spring boot that encompasses the following functionality:
The API should have an endpoint that accepts
- in the HTTP request body
- a list of batteries, each containing: name, postcode, and watt capacity.
- This data should be persisted in a database (In-memory is acceptable).
- The API should have an endpoint that receives a postcode range.
- The response body will contain a list of names of batteries that fall within the range, sorted alphabetically.
- Additionally, there should be some statistics included for the returned batteries, such as total and average watt capacity.
- The implementation should use Java streams in some way.

We will be specifically looking for clean, tested, and well-structured code. If you have a way to deploy the application in a cloud
environment it would be a plus, but this is not mandatory and won't impact the final outcome of the assessment.

## Solution

### Functional Requirements

1. Battery Registration Endpoint:
    - Accept a list of batteries in the HTTP request body
    - Persist battery data (name, postcode, watt capacity) in a database

2. Battery Query Endpoint:
    - Accept a postcode range as input
    - Return alphabetically sorted list of battery names within the range
    - Provide statistics: total and average watt capacity

3. Data Processing:
    - Utilize Java streams

4. Database Integration:
    - Store and retrieve battery data (in-memory database is acceptable)

### Non-Functional Requirements

1. Technology Stack:
    - Spring Boot framework
    - REST API architecture

2. Code Quality:
    - Clean, well-structured code
    - Comprehensive test coverage
    - Best practices and design patterns

3. Performance:
    - Efficient data processing for large datasets
    - Optimized database queries

4. Scalability:
    - Design for potential growth in batteries and requests

5. Security:
    - Appropriate measures to protect API and data

6. Documentation:
    - Clear API documentation (endpoints, request/response formats)

7. Error Handling:
    - Robust error handling with meaningful messages

8. Maintainability:
    - Modular and easily maintainable code
    - Appropriate comments and documentation

9. Compatibility:
    - Works with standard HTTP clients and tools

10. Cloud Deployment (Optional):
    - Ability to deploy in a cloud environment

11. Compliance:
    - Adherence to relevant data protection and energy sector regulations

12. Logging:
    - Appropriate logging for monitoring and debugging

13. Versioning:
    - Consider API versioning for future updates

## Getting Started



## API Documentation



## Testing



## Deployment

