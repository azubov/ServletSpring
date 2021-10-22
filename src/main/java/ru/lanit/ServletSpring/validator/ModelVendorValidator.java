package ru.lanit.ServletSpring.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class ModelVendorValidator implements ConstraintValidator<ModelVendorFormat, String> {

    @Override
    public boolean isValid(String model, ConstraintValidatorContext constraintValidatorContext) {
        String vendorPattern = "^([A-Za-z])[A-Za-z]*";
        String separator = "-";
        String modelPattern = "[A-Za-z0-9-]*";
        return Pattern.matches(vendorPattern + separator + modelPattern, model) || model.equals("");
    }
}
