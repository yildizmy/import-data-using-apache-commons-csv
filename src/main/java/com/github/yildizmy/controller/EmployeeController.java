package com.github.yildizmy.controller;

import com.github.yildizmy.dto.response.ApiResponse;
import com.github.yildizmy.dto.response.CommandDto;
import com.github.yildizmy.dto.response.EmployeeDto;
import com.github.yildizmy.service.EmployeeService;
import com.github.yildizmy.validator.ValidFile;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.Clock;
import java.time.Instant;
import java.util.List;

import static com.github.yildizmy.common.Constants.*;

@Validated
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class EmployeeController {

    private final Clock clock;
    private final EmployeeService employeeService;

    @PostMapping("/employees/upload")
    public ResponseEntity<ApiResponse<CommandDto>> uploadFile(
            @ValidFile @RequestParam("file") MultipartFile file) {
        employeeService.create(file);
        return ResponseEntity
                .ok(new ApiResponse<>(Instant.now(clock).toEpochMilli(), SUCCESSFULLY_UPLOADED));
    }

    @GetMapping("/employees/{email}")
    public ResponseEntity<ApiResponse<EmployeeDto>> findByEmail(@PathVariable String email) {
        final EmployeeDto employee = employeeService.findByEmail(email);
        return ResponseEntity
                .ok(new ApiResponse<>(Instant.now(clock).toEpochMilli(), SUCCESS, employee));
    }

    @GetMapping("/employees")
    public ResponseEntity<ApiResponse<List<EmployeeDto>>> findAll() {
        final List<EmployeeDto> employees = employeeService.findAll();
        return ResponseEntity
                .ok(new ApiResponse<>(Instant.now(clock).toEpochMilli(), SUCCESS, employees));
    }

    @DeleteMapping("/employees")
    public ResponseEntity<ApiResponse<CommandDto>> deleteAll() {
        employeeService.deleteAll();
        return ResponseEntity
                .ok(new ApiResponse<>(Instant.now(clock).toEpochMilli(), SUCCESSFULLY_DELETED));
    }
}
