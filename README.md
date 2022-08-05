# Upload CSV into MySQL using Apache Commons CSV
Project used for uploading and reading csv file into MySQL database using Apache Commons CSV.

## Description

...

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

<br/>

### Executing program

* Postman requests:

For file upload request, select form-data in the Body section and use "file" as key parameter.
```
http://localhost:8080/api/v1/employees/upload
```

```
http://localhost:8080/api/v1/employees
```

```
http://localhost:8080/api/v1/employees/:email
```

## Documentation
[Apache Commons CSV User Guide](https://commons.apache.org/proper/commons-csv/user-guide.html#Using_an_enum_to_define_a_header)<br/>
[Hibernate ORM 5.6.10.Final User Guide](https://docs.jboss.org/hibernate/orm/5.6/userguide/html_single/Hibernate_User_Guide.html#naturalid)<br/>
[Hibernate Natural Ids with @NaturalId](https://howtodoinjava.com/hibernate/hibernate-naturalid-example-tutorial/)<br/>
[The best way to map a @NaturalId business key with JPA and Hibernate](https://vladmihalcea.com/the-best-way-to-map-a-naturalid-business-key-with-jpa-and-hibernate/)
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

## Acknowledgments
...