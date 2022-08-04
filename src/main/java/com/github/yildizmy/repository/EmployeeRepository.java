package com.github.yildizmy.repository;

import com.github.yildizmy.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends NaturalRepository<Employee, String> {

    Optional<Employee> findByEmail(String email);
}
