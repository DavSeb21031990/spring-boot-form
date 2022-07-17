package springbootapp.spring.boot.form.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pais {

    private String codigo;
    private String nombre;

    public Pais (String json){
        String[] camposPaisString = StringUtils.split(json, ":");
        this.codigo = camposPaisString != null && camposPaisString.length > 0 ? camposPaisString[0] : "";
        this.nombre = camposPaisString != null && camposPaisString.length > 1 ? camposPaisString[1] : "";
    }

}
