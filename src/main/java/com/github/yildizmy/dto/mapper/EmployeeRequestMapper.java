package com.github.yildizmy.dto.mapper;

import com.github.yildizmy.dto.request.EmployeeRequest;
import com.github.yildizmy.domain.Employee;

public class EmployeeRequestMapper {

    // TODO: JMapper or MapStruct library might be used for mapping

    public static Employee mapToEntity(EmployeeRequest request) {
        return new Employee(
                request.getId(),
                request.getName(),
                request.getEmail(),
                request.getCountry(),
                request.getBirthDate()
        );
    }
}
