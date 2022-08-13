# Import data into MySQL using Apache Commons CSV
Project used for importing csv file into MySQL database using Apache Commons CSV.


## Description

Spring Boot provides some properties with which we can add the exception message, exception class, or even a stack trace as part of the response payload:

```
server.error.include-message=always
server.error.include-binding-errors=always
server.error.include-stacktrace=on_param
server.error.include-exception=true
```

Using these Spring Boot server properties in our `application.properties` we can alter the error response to some extent.

Note that we’ve set the property `include-stacktracee` to `on_trace_param` which means that only if we include the trace param in the URL (`?trace=true`), we’ll get a stack trace in the response payload:

We might want to keep the value of `include-stacktrace` flag to `never`, at least in production, as it might reveal the internal workings of our application.


## Getting Started

### Dependencies

* Spring Web
* Spring Boot
* Spring Data JPA
* Apache Commons CSV
* MySQL Database

### Installing

* Run the following command in the project root for creating MySQL database in Docker

```
docker-compose up -d
```
<br/>

To set container name as mysql instead of the folder name where `docker-compose.yml` file is located, use the following command:

```
docker-compose -f docker-compose.yml -p "mysql" up
```
<br/>

* Database connection url:

```
jdbc:mysql://localhost:3306/employee-db
```

### API Endpoints

All URIs are relative to *http://localhost:8080/api/v1*

Class | Method                                                    | HTTP request         | Description
------------ |-----------------------------------------------------------|----------------------| -------------
*EmployeeController* | [**importFile**](http://localhost:8080/api/v1/employees/import) | **POST** /employees/import | Import list of employees file
*EmployeeController* | [**findByEmail**](http://localhost:8080/api/v1/employees/{email})       | **GET** /employees/{email}    | Get employee by email
*EmployeeController* | [**findAll**](http://localhost:8080/api/v1/employees)                   | **GET** /employees            | Get all employees
*EmployeeController* | [**deleteAll**](http://localhost:8080/api/v1/employees)                 | **DELETE** /employees   | Delete all employees


## Documentation
[Apache Commons CSV User Guide](https://commons.apache.org/proper/commons-csv/user-guide.html#Using_an_enum_to_define_a_header)<br/>
[Hibernate ORM 5.6.10.Final User Guide](https://docs.jboss.org/hibernate/orm/5.6/userguide/html_single/Hibernate_User_Guide.html#naturalid)<br/>
[Hibernate Natural Ids with @NaturalId](https://howtodoinjava.com/hibernate/hibernate-naturalid-example-tutorial/)<br/>
[The best way to map a @NaturalId business key with JPA and Hibernate](https://vladmihalcea.com/the-best-way-to-map-a-naturalid-business-key-with-jpa-and-hibernate/)<br/>
[How to Use Hibernate Natural IDs in Spring Boot](https://dzone.com/articles/how-to-use-hibernate-natural-ids-in-spring-boot)


## Authors
Murat Yıldız


## Version History

* 0.2
    * Various bug fixes and optimizations
    * See [commit change]() or See [release history]()
* 0.1
    * Initial Release


## License

...


## Acknowledgements
...