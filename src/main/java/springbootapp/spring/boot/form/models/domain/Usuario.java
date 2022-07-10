package springbootapp.spring.boot.form.models.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Usuario {

    private String username;
    private String password;
    private String email;

}
