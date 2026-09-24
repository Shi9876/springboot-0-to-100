package com.learn.springboot.dev.module2SpringBootWebTutorialApplication.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmployeeCodeValidator implements ConstraintValidator<EmployeeCodeValidation, String>{

    @Override
    public boolean isValid(String code, ConstraintValidatorContext context){
        if(code == null)
            return false;

        return code.matches("EMP-\\d+");
    }
}

//Regex - "EMP-\\d+"
//-> EMP- (Must start with EMP-)
//-> \d+ - (one or more digits)
