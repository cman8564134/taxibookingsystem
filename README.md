# Taxi Booking System

Taxi Booking system is a backend API application that simulates a simple taxi booking system according to the [requirements](Requirements.md) from Motional. The application was built using Spring Boot with Java 11 and Maven 3.6. 
## Prerequisite
- Java 11
- Maven 3.6

## Instructions to build and run the application

###Method 1: Clone project and run using IntelliJ Idea (or any preferred IDE)

1) Clone git repository into a directory
2) Use your preferred IDE to open the Spring Boot project located in the directory.
3) Maven auto downloads all project dependencies located in pom.xml
4) Run the application using your IDE's "Run Application" or Go to TaxibookingsystemApplication Java main class, Right-Click and Run. 

###Method 2: Running Application using WAR file

*Please ensure you have Java installed*
1) save the ```taxibookingsystem.war``` file into a specific directory
2) Run the following command in the command prompt:
```windows
java -jar ./taxibookingsystem.war
```

##Unit test

*Need IDE to run test*
1) Import project into IntelliJ Idea (or your selected IDE).
2) Go into ```src/test/java/com.motional.cthye.taxibookingsystem```
3) Right click ```TaxiBookingApplicationUnitTest```
4) Click Run Test.
5) All tests related to the suite will run accordingly. Ensure all test pass before you commit your changes.
   
   [UnitTest](UnitTest.png)
   
##API Documentation

The Documentation for API was done using Swagger. Kindly access the application's API documentation at ```~/swagger-ui/``` at ```http://localhost:8080/swagger-ui/```.

[API Documentation](APIDocumentation.png)


## License

[Apache2.0](https://www.apache.org/licenses/LICENSE-2.0)
