package com.github.yildizmy.service;

import com.github.yildizmy.dto.mapper.EmployeeRequestMapper;
import com.github.yildizmy.dto.response.EmployeeDto;
import com.github.yildizmy.exception.NoSuchElementFoundException;
import com.github.yildizmy.model.Employee;
import com.github.yildizmy.repository.EmployeeRepository;
import com.github.yildizmy.util.CsvHelper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.github.yildizmy.common.Constants.NO_ITEM_FOUND;
import static com.github.yildizmy.common.Constants.NO_RECORD;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<EmployeeDto> findAll() {
        return employeeRepository.findAll()
                .stream().map(EmployeeDto::new)
                .toList();
    }

    public EmployeeDto findByEmail(String email) {
        return employeeRepository.findByEmail(email)
                .map(EmployeeDto::new)
                .orElseThrow(() -> new NoSuchElementFoundException(NO_ITEM_FOUND));
    }

    @SneakyThrows
    public void create(MultipartFile file) throws NoSuchElementFoundException {
        List<Employee> employees = CsvHelper.csvToEmployees(file.getInputStream()).stream()
                .map(EmployeeRequestMapper::mapToEntity)
                .toList();
        if (employees.isEmpty()) { throw new NoSuchElementFoundException(NO_RECORD); }
        employeeRepository.saveAll(employees);
    }

    public void deleteAll() {
        employeeRepository.deleteAll();
    }
}
