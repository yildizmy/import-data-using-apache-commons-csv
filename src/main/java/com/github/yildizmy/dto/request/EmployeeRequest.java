package com.github.yildizmy.dto.request;

import lombok.Value;

import java.time.LocalDate;

@Value
public class EmployeeRequest {
    Long id;
    String name;
    String email;
    String country;
    LocalDate birthDate;
}
