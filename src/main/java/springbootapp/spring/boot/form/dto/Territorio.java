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
public class Territorio {

    private List<Pais> paisList;

    public Territorio(String json) {
        String[] territorioJson = StringUtils.split(json, ",");
        if(territorioJson != null){
            this.paisList = Arrays.stream(territorioJson)
                    .map(Pais::new)
                    .collect(Collectors.toList());
        }else{
            this.paisList = new ArrayList<>();
        }
    }

}
