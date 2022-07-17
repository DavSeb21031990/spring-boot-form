package springbootapp.spring.boot.form.services;

import springbootapp.spring.boot.form.models.domain.Pais;

import java.util.List;

public interface PaisService {

    List<Pais> listar();

    Pais obtenerPorId(Integer id);

}
