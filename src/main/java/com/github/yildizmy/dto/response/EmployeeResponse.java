package com.github.yildizmy.dto.response;

import com.github.yildizmy.domain.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class EmployeeResponse {
    private Long id;
    private String name;
    private String email;
    private String country;
    private LocalDate birthDate;

    public EmployeeResponse(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.email = employee.getEmail();
        this.country = employee.getCountry();
        this.birthDate = employee.getBirthDate();
    }
}
