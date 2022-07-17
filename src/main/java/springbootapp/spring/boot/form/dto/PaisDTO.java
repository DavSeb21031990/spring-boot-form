package springbootapp.spring.boot.form.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaisDTO {

    private String codigo;
    private String nombre;

    public PaisDTO(String json){
        String[] camposPaisString = StringUtils.split(json, ":");
        this.codigo = camposPaisString != null && camposPaisString.length > 0 ? camposPaisString[0] : "";
        this.nombre = camposPaisString != null && camposPaisString.length > 1 ? camposPaisString[1] : "";
    }

}
