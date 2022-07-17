package springbootapp.spring.boot.form.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootapp.spring.boot.form.api.CountriesStateCityAPI;
import springbootapp.spring.boot.form.dto.PaisDTO;
import springbootapp.spring.boot.form.models.domain.Pais;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class PaisServiceImpl implements PaisService{

    @Autowired
    private CountriesStateCityAPI countriesStateCityAPI;

    private List<Pais> paisList;

    @PostConstruct
    public void getPaises(){
        try{
            AtomicInteger id = new AtomicInteger(1);
            this.paisList =  countriesStateCityAPI.getTerritory().getPaisDTOList()
                    .stream()
                    .map(paisDTO -> new Pais(id.getAndIncrement(), paisDTO.getCodigo(), paisDTO.getNombre()))
                    .collect(Collectors.toList());
        }catch (NullPointerException e){
            this.paisList = new ArrayList<>();
        }
    }

    @Override
    public List<Pais> listar() {
        return paisList;
    }

    @Override
    public Pais obtenerPorId(Integer id) {
        return paisList
                .stream()
                .filter(pais -> pais.getId().compareTo(id) == 0)
                .findFirst()
                .orElse(null);
    }

}
