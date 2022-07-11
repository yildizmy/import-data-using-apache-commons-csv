package com.github.yildizmy.util;

import com.github.yildizmy.dto.request.EmployeeRequest;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvHelper {
    private enum Headers {
        Id,
        Name,
        Email,
        Country,
        BirthDate
    }

    // set as the same format of date field in csv file
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
    private static String[] TYPES =  {"text/csv", "application/vnd.ms-excel"};

    public static boolean hasCsvFormat(MultipartFile file) {
        return Arrays.stream(TYPES).anyMatch(file.getContentType()::equals);
    }

    public static List<EmployeeRequest> csvToEmployees(InputStream is) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser parser = new CSVParser(reader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {

            List<EmployeeRequest> employees = new ArrayList<>();
            Iterable<CSVRecord> records = parser.getRecords();

            for (CSVRecord record : records) {
                EmployeeRequest employee = new EmployeeRequest(
                        Long.parseLong(record.get(Headers.Id)),
                        record.get(Headers.Name),
                        record.get(Headers.Email),
                        record.get(Headers.Country),
                        record.get(Headers.BirthDate).isEmpty() ? null : LocalDate.parse(record.get(Headers.BirthDate), formatter)
                );
                employees.add(employee);
            }
            return employees;
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse csv file: " + e.getMessage());
        }
    }
}
