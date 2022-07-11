package com.github.yildizmy.service;

import com.github.yildizmy.dto.mapper.EmployeeRequestMapper;
import com.github.yildizmy.dto.response.EmployeeDto;
import com.github.yildizmy.exception.EntityNotFoundException;
import com.github.yildizmy.model.Employee;
import com.github.yildizmy.repository.EmployeeRepository;
import com.github.yildizmy.util.CsvHelper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public void create(MultipartFile file) throws Exception {
        try {
            List<Employee> employees = CsvHelper.csvToEmployees(file.getInputStream()).stream()
                    .map(EmployeeRequestMapper::mapToEntity)
                    .collect(Collectors.toList());
            employeeRepository.saveAll(employees);
        } catch (Exception e) {
            throw new Exception("Could not upload file: " + file.getOriginalFilename());
        }
    }

    public List<EmployeeDto> findAll() {
        return employeeRepository.findAll()
                .stream().map(EmployeeDto::new)
                .collect(Collectors.toList());
    }

    public EmployeeDto findByEmail(String email) {
        return employeeRepository.findByEmail(email)
                .map(EmployeeDto::new)
                .orElseThrow(() -> new EntityNotFoundException("Employee is not found"));
    }

    public void deleteAll() {
        employeeRepository.deleteAll();
    }
}
