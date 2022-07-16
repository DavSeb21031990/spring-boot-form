package springbootapp.spring.boot.form.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import springbootapp.spring.boot.form.models.domain.Usuario;

@Component
public class UsuarioValidador implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Usuario.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Usuario usuario = (Usuario) target;
        //ValidationUtils.rejectIfEmpty(errors, "nombre", "NotEmpty.usuario.nombre");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "NotEmpty.usuario.nombre");
        if(!usuario.getIdentificador().matches("[0-9]{2}[.][0-9]{3}[.][0-9]{3}[.][A-Z]")){
            errors.rejectValue("identificador", "pattern.usuario.identificador");
        }
    }

}
