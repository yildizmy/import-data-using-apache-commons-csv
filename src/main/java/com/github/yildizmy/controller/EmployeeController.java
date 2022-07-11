package com.github.yildizmy.controller;

import com.github.yildizmy.dto.response.EmployeeDto;
import com.github.yildizmy.dto.response.ResponseMessage;
import com.github.yildizmy.service.EmployeeService;
import com.github.yildizmy.util.CsvHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/employees/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        if (CsvHelper.hasCsvFormat(file)) {
            employeeService.create(file);
            return ResponseEntity.ok(new ResponseMessage("File uploaded successfully: " + file.getOriginalFilename()));
        }
        return ResponseEntity.ok(new ResponseMessage("Please upload a csv file!"));
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
        return ResponseEntity.ok("Successfully deleted");
    }
}
