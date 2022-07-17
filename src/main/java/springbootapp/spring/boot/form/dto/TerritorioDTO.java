package springbootapp.spring.boot.form.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TerritorioDTO {

    private List<PaisDTO> paisDTOList;

    public TerritorioDTO(String json) {
        String[] territorioJson = json.split(",", -1);
        this.paisDTOList = Arrays.stream(territorioJson)
                .map(PaisDTO::new)
                .collect(Collectors.toList());
    }

}
