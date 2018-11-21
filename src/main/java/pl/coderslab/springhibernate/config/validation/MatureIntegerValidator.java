package pl.coderslab.springhibernate.config.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class MatureIntegerValidator implements ConstraintValidator<Mature, Integer> {

    public void initialize(Mature constraint) {
    }

    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) return true;
        int year = LocalDate.now().getYear();
        return (year - value) >= 18;
    }
}
