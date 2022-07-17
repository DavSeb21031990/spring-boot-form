package springbootapp.spring.boot.form.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import springbootapp.spring.boot.form.dto.TerritorioDTO;

@Component
public class CountriesStateCityAPI {

    @Autowired
    private RestTemplate restTemplate;

    public TerritorioDTO getTerritory() {

        final String URL = "http://country.io/names.json";

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                URL, HttpMethod.GET, null, String.class);

        String territorioJson = responseEntity.getBody() != null ? responseEntity.getBody() : "";

        territorioJson = territorioJson.replace('{', ' ')
                .replace('}', ' ')
                .replace('"', ' ');

        return new TerritorioDTO(territorioJson);

    }

}
