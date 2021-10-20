package ru.lanit.ServletSpring.validatior;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class UniqueIdValidator implements ConstraintValidator<AgeAllows, LocalDate>{
    LocalDate currentDate = LocalDate.now();

    @Override
    public boolean isValid(LocalDate birthdate, ConstraintValidatorContext constraintValidatorContext) {
        return ChronoUnit.YEARS.between(birthdate,currentDate) >= 18;
    }
}
