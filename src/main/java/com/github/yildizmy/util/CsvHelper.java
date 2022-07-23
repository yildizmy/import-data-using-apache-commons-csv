package com.github.yildizmy.util;

import com.github.yildizmy.dto.request.EmployeeRequest;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.github.yildizmy.common.Constants.FAILED_TO_PARSE;
import static com.github.yildizmy.common.Constants.FORMATTER;

public class CsvHelper {

    private enum Headers {
        ID,
        NAME,
        EMAIL,
        COUNTRY,
        BIRTHDATE
    }

    public static List<EmployeeRequest> csvToEmployees(InputStream is) throws IllegalAccessException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
             CSVParser parser = new CSVParser(reader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {

            List<EmployeeRequest> employees = new ArrayList<>();
            Iterable<CSVRecord> records = parser.getRecords();

            for (CSVRecord rec : records) {
                EmployeeRequest employee = new EmployeeRequest(
                        Long.parseLong(rec.get(Headers.ID)),
                        rec.get(Headers.NAME),
                        rec.get(Headers.EMAIL),
                        rec.get(Headers.COUNTRY),
                        rec.get(Headers.BIRTHDATE).isEmpty() ? null : LocalDate.parse(rec.get(Headers.BIRTHDATE), FORMATTER)
                );
                employees.add(employee);
            }
            return employees;
        } catch (IOException e) {
            throw new IllegalAccessException(FAILED_TO_PARSE + e.getMessage());
        }
    }
}
