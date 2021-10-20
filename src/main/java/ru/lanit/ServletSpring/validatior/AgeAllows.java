package ru.lanit.ServletSpring.validatior;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = UniqueIdValidator.class)
@Target({FIELD, METHOD})
@Retention(RUNTIME)
public @interface AgeAllows {

    String message() default "Must be over 18";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
