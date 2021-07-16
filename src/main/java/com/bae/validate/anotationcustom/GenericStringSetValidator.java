package com.bae.validate.anotationcustom;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

/**
 * date 2021-03-19 09:14
 *
 * @author Phạm Ngọc Thắng
 */
public class GenericStringSetValidator implements ConstraintValidator<StringInList, String> {
    private Set<String> validValues;

    public void initialize(StringInList constraint) {
        validValues = Arrays.stream(constraint.values())
                .collect(toSet());
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value==null || value=="") return true;
        return validValues.contains(value);
    }
}
