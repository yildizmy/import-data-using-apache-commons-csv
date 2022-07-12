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

* Database connection url for DBeaver, etc.

```
jdbc:mysql://localhost:3306/employee-db
```

<br/>

### Executing program

* Postman requests:

```
http://localhost:8080/api/v1/employees/upload
// in Postman select form-data in the Body section and use "file" as key parameter
```

```
http://localhost:8080/api/v1/employees
```

```
http://localhost:8080/api/v1/employees/:email
```

## Help



[Apache Commons CSV User Guide](https://commons.apache.org/proper/commons-csv/user-guide.html#Using_an_enum_to_define_a_header)


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