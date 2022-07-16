package springbootapp.spring.boot.form.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import springbootapp.spring.boot.form.models.domain.Usuario;
import springbootapp.spring.boot.form.validation.UsuarioValidador;

import javax.validation.Valid;

@Controller
@SessionAttributes("usuario")
public class FormController {

    @Autowired
    private UsuarioValidador usuarioValidador;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.addValidators(usuarioValidador);
    }

    @GetMapping("/form")
    public String formModel(Model model){

        Usuario usuario = Usuario.builder()
                .nombre("Johon")
                .apellido("Doe")
                .identificador("123.456.789-K")
                .build();

        model.addAttribute("titulo", "Formulario Usuarios");
        model.addAttribute("usuario", usuario);

        return "form";

    }

    @PostMapping("/form")
    public String procesar(@Valid Usuario usuario, BindingResult result,
                           Model model,
                           SessionStatus sessionStatus){

        //usuarioValidador.validate(usuario, result);

        if(result.hasErrors()){
            return "form";
        }

        model.addAttribute("titulo", "Resultado form");
        model.addAttribute("usuario", usuario);

        sessionStatus.setComplete();

        return "resultado";

    }

}
