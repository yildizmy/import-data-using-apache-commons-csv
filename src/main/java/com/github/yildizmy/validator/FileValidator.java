package com.github.yildizmy.validator;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

import static com.github.yildizmy.common.Constants.SUPPORTED_CONTENT_TYPES;

public class FileValidator implements ConstraintValidator<ValidFile, MultipartFile> {

    @Override
    public void initialize(ValidFile constraintAnnotation) { }

    @Override
    public boolean isValid(MultipartFile multipartFile, ConstraintValidatorContext context) {
        String contentType = multipartFile.getContentType();
        return isSupportedContentType(contentType);
    }

    private boolean isSupportedContentType(String contentType) {
        return Arrays.stream(SUPPORTED_CONTENT_TYPES).anyMatch(contentType::equals);
    }
}
