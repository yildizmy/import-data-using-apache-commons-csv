package com.github.yildizmy.controller;

import com.github.yildizmy.dto.response.EmployeeDto;
import com.github.yildizmy.dto.response.ResponseMessage;
import com.github.yildizmy.service.EmployeeService;
import com.github.yildizmy.validator.ValidFile;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.github.yildizmy.common.Constants.SUCCESSFULLY_DELETED;
import static com.github.yildizmy.common.Constants.SUCCESSFULLY_UPLOADED;

@Validated
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/employees/upload")
    public ResponseEntity<ResponseMessage> uploadFile(
            @ValidFile @RequestParam("file") MultipartFile file) {
        employeeService.create(file);
        return ResponseEntity.ok(new ResponseMessage(SUCCESSFULLY_UPLOADED + file.getOriginalFilename()));
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDto>> findAll() {
        final List<EmployeeDto> employees = employeeService.findAll();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/employees/{email}")
    public ResponseEntity<EmployeeDto> findByEmail(@PathVariable String email) {
        final EmployeeDto employee = employeeService.findByEmail(email);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/employees")
    public ResponseEntity deleteAll() {
        employeeService.deleteAll();
        return ResponseEntity.ok(SUCCESSFULLY_DELETED);
    }
}
