package ru.geekmarket.controller.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailNotRegisteredValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailNotRegistered {
    String message() default "User with this email already registered";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
