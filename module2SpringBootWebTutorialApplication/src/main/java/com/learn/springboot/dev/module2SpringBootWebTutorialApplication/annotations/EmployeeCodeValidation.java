package com.learn.springboot.dev.module2SpringBootWebTutorialApplication.annotations;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EmployeeCodeValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EmployeeCodeValidation {
    String message() default "Invalid Employee Code";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
