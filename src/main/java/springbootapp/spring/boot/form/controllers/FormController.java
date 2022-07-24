package springbootapp.spring.boot.form.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import springbootapp.spring.boot.form.api.CountriesStateCityAPI;
import springbootapp.spring.boot.form.editors.NombreMayusculaEditor;
import springbootapp.spring.boot.form.editors.PaisPropertyEditor;
import springbootapp.spring.boot.form.editors.RolEditor;
import springbootapp.spring.boot.form.models.domain.Pais;
import springbootapp.spring.boot.form.models.domain.Rol;
import springbootapp.spring.boot.form.models.domain.Usuario;
import springbootapp.spring.boot.form.services.RolServiceImpl;
import springbootapp.spring.boot.form.validation.UsuarioValidador;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Controller
@SessionAttributes("usuario")
public class FormController {

    @Autowired
    private CountriesStateCityAPI countriesStateCityAPI;
    @Autowired
    private UsuarioValidador usuarioValidador;
    @Autowired
    private PaisPropertyEditor paisPropertyEditor;
    @Autowired
    private RolEditor rolEditor;

    @Autowired
    private RolServiceImpl rolService;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {

        webDataBinder.addValidators(usuarioValidador);

        //Siempre usar con guiones cuando se usa en formulario html5
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
        //Se aplica a un campo especifico
        //webDataBinder.registerCustomEditor(Date.class, "fechaNacimiento" , new CustomDateEditor(dateFormat, false));
        //webDataBinder.registerCustomEditor(String.class, new NombreMayusculaEditor());
        webDataBinder.registerCustomEditor(String.class, "Nombre", new NombreMayusculaEditor());
        webDataBinder.registerCustomEditor(String.class, "Apellido", new NombreMayusculaEditor());
        webDataBinder.registerCustomEditor(Pais.class, "pais", paisPropertyEditor);
        webDataBinder.registerCustomEditor(Rol.class, "roles", rolEditor);
    }

    @GetMapping("/form")
    public String formModel(Model model) {

        Usuario usuario = Usuario.builder()
                .nombre("Johon")
                .apellido("Doe")
                .identificador("123.456.789-K")
                .habilitar(true)
                .valorSecreto("Algún valor secreto ****")
                .build();

        model.addAttribute("titulo", "Formulario Usuarios");
        model.addAttribute("usuario", usuario);

        return "form";

    }

    @ModelAttribute("paises")
    public List<Pais> getPaisList() {
        try{
            AtomicInteger id = new AtomicInteger(1);
            return countriesStateCityAPI.getTerritory().getPaisDTOList()
                    .stream()
                    .map(paisDTO -> new Pais(id.getAndIncrement(), paisDTO.getCodigo(), paisDTO.getNombre()))
                    .collect(Collectors.toList());
        }catch (NullPointerException e){
            return new ArrayList<>();
        }
    }

    @ModelAttribute("generos")
    public List<String> getGeneroList(){
        return Arrays.asList("Hombre, Mujer");
    }

    @ModelAttribute("listaRolesString")
    public List<String> getRolesSring(){
        return Arrays.asList(
                "ROLE_ADMIN",
                "ROLE_USER",
                "ROLE_MODERATOR"
                );
    }

    @ModelAttribute("listaRoles")
    public List<Rol> getRoles(){
        return rolService.listar();
    }

    @PostMapping("/form")
    public String procesar(@Valid Usuario usuario, BindingResult result,
                           Model model,
                           SessionStatus sessionStatus) {

        //usuarioValidador.validate(usuario, result);

        if (result.hasErrors()) {
            return "form";
        }

        model.addAttribute("titulo", "Resultado form");
        model.addAttribute("usuario", usuario);

        sessionStatus.setComplete();

        return "resultado";

    }

}
