package springbootapp.spring.boot.form.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import springbootapp.spring.boot.form.models.domain.Usuario;

import javax.validation.Valid;

@Controller
@SessionAttributes("usuario")
public class FormController {

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

        if(result.hasErrors()){
            return "form";
        }

        model.addAttribute("titulo", "Resultado form");
        model.addAttribute("usuario", usuario);

        sessionStatus.setComplete();

        return "resultado";

    }

}
