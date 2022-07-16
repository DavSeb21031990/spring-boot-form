package springbootapp.spring.boot.form.models.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    //@Pattern(regexp = "[0-9]{2}[.][0-9]{3}[.][0-9]{3}[.][A-Z]")
    private String identificador;

    //@NotEmpty(message = "El nombre no puede ser vacio")
    private String nombre;

    @NotEmpty
    private String apellido;

    @NotEmpty
    @Size(min = 3, max = 8)
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty
    @Email(message = "Correo con formato incorrecto")
    private String email;

}
