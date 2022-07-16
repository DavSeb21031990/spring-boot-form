package springbootapp.spring.boot.form.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdentificadorRegexValidador implements ConstraintValidator<IdentificadorRegex, String> {

    @Override
    public boolean isValid(String s,
                           ConstraintValidatorContext constraintValidatorContext) {
        return s.matches("[0-9]{2}[.][0-9]{3}[.][0-9]{3}[.][A-Z]");
    }

}
