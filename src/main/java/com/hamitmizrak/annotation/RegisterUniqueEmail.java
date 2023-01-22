package com.hamitmizrak.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
        validatedBy = {RegisterUniqueEmailValidation.class}
)
public @interface RegisterUniqueEmail {

    String message() default "{register.email.validation.constraints.unique.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
