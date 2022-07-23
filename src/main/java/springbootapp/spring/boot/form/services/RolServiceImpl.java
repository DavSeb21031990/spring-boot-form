package springbootapp.spring.boot.form.services;

import org.springframework.stereotype.Service;
import springbootapp.spring.boot.form.models.domain.Rol;

import java.util.ArrayList;
import java.util.List;

@Service
public class RolServiceImpl implements RolService {

    private final List<Rol> rolList;

    public RolServiceImpl() {
        this.rolList = new ArrayList<>();
        this.rolList.add(new Rol(1, "Administrador", "ROLE_ADMIN"));
        this.rolList.add(new Rol(1, "Usuario", "ROLE_USER"));
        this.rolList.add(new Rol(1, "Moderador", "ROLE_MODERATOR"));
    }

    @Override
    public List<Rol> listar() {
        return rolList;
    }

    @Override
    public Rol obtenerPorId(Integer id) {
        return rolList
                .stream()
                .filter(rol -> rol.getId().compareTo(id) == 0)
                .findFirst()
                .orElse(null);
    }

}
