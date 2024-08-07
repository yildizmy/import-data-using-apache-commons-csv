package com.github.yildizmy.common;

import java.time.format.DateTimeFormatter;

public final class Constants {

    private Constants() {
        throw new UnsupportedOperationException(CLASS_CANNOT_BE_INSTANTIATED);
    }

    public static final String TRACE = "trace";
    public static final String[] SUPPORTED_CONTENT_TYPES =  {"text/csv", "application/vnd.ms-excel"};
    // set format for reading/writing from/to CSV (same date format as in the file)
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("M/d/yyyy");

    public static final String SUCCESS = "Success";
    public static final String CLASS_CANNOT_BE_INSTANTIATED = "This is a utility class and cannot be instantiated";
    public static final String SUCCESSFULLY_IMPORTED="File imported successfully: ";
    public static final String SUCCESSFULLY_DELETED="Successfully deleted";
    public static final String VALIDATION_ERROR="Validation error. Check 'errors' field for details";
    public static final String ENTITY_NOT_FOUND="Item not found";
    public static final String INVALID_FILE_TYPE="Invalid file type";
    public static final String UNKNOWN_ERROR="Unknown error occurred";
    public static final String NO_RECORD="File does not contain any record";
    public static final String FAILED_TO_PARSE="Failed to parse csv file: ";
    public static final String MAX_UPLOAD_SIZE_EXCEEDED="Maximum upload size exceeded";
}
