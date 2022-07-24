package springbootapp.spring.boot.form.models.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pais {

    private Integer id;
    private String codigo;
    private String nombre;

    @Override
    public String toString() {
        return this.id.toString();
    }
}
