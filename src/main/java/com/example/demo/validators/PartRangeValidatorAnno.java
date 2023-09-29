package com.example.demo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.Integer;


@Constraint(validatedBy = {PartRangeValidator.class})
@Target ({ElementType.TYPE})
        //({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)

public @interface PartRangeValidatorAnno {
    String message() default "Inventory is out of range of maximum or minimum allowed";
    Class<?> [] groups() default{};
    Class<? extends Payload> [] payload() default{};
}
