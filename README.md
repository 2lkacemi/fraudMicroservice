This application is designed to improve efficiency and scalability using a microservice architecture built with Spring Boot. It consists of three microservices: fraud detection, customer management, and notification. Each microservice has its own dedicated database powered by PostgreSQL, allowing for independent management and data handling.
To facilitate communication between the microservices, we have implemented Spring Cloud Eureka and Spring Sleuth, which provide service discovery and distributed tracing capabilities. Additionally, we have integrated Zipkin to enable us to visualize and debug any issues that may arise.
To further enhance the functionality of our application, we have implemented message queuing between the notification microservice and the other microservices using AMQP. This allows us to efficiently handle large volumes of notifications and ensures that they are delivered in a timely manner.
In this repository, you will find the following:

- **amqp:** the AMQP-based message queuing implementation.
- **apigw:** the API gateway.
- **customer:** the customer management microservice.
- **fraud:** the fraud detection microservice.
- **notification:** the notification microservice.
- **eureka-server:** the Eureka server for service discovery.

To run the system, you will need to have the following installed on your computer:

- Java 11+
- PostgreSQL
- To set up and run the microservices, follow these steps:
- Set up PostgreSQL databases for each microservice.
- Open each microservice directory in your preferred Java IDE.
- Update the database configuration in the application.properties file for each microservice to match your database setup.
- Run the EurekaServerApplication class to start the Eureka server.
- Run the Application class for each microservice to start them.
- Run the ApiGatewayApplication class to start the API gateway.
