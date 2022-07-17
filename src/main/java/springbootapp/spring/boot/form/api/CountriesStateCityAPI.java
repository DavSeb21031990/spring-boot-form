package springbootapp.spring.boot.form.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import springbootapp.spring.boot.form.dto.Pais;
import springbootapp.spring.boot.form.dto.Territorio;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class CountriesStateCityAPI {

    @Autowired
    private RestTemplate restTemplate;

    public Territorio getTerritory() {

        final String URL = "http://country.io/names.json";

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                URL, HttpMethod.GET, null, String.class);

        String territorioJson = responseEntity.getBody() != null ? responseEntity.getBody() : "";

        territorioJson = territorioJson.replace('{', ' ')
                .replace('}', ' ')
                .replace('"', ' ');

        return new Territorio(territorioJson);

    }

}
