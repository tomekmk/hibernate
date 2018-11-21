package pl.coderslab.springhibernate.config.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = MatureIntegerValidator.class)
@Target(ElementType.FIELD)       //java.lang.adnotations
@Retention(RetentionPolicy.RUNTIME)
public @interface Mature {

    String message() default "{pl.coderslab.springhibernate.config.validation.Mature.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
