package ru.lanit.ServletSpring.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = ModelVendorValidator.class)
public @interface ModelVendorFormat {
    String message() default "Format should be Model-Vendor";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
