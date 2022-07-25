package com.github.yildizmy.validator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Violation {

    private final String fieldName;
    private final String message;
}
