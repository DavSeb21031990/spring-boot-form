package springbootapp.spring.boot.form.services;

import springbootapp.spring.boot.form.models.domain.Rol;

import java.util.List;

public interface RolService {

    List<Rol> listar();
    Rol obtenerPorId(Integer id);

}
