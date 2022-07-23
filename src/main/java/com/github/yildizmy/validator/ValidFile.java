package com.github.yildizmy.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static com.github.yildizmy.common.Constants.INVALID_FILE_TYPE;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Constraint(validatedBy = {FileValidator.class})
public @interface ValidFile {

    String message() default INVALID_FILE_TYPE;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
