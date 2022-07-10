package springbootapp.spring.boot.form.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import springbootapp.spring.boot.form.models.domain.Usuario;

import javax.validation.Valid;

@Controller
public class FormController {

    @GetMapping("/form")
    public String formModel(Model model){
        Usuario usuario = new Usuario();
        model.addAttribute("titulo", "Formulario Usuarios");
        model.addAttribute("usuario", usuario);
        return "form";
    }

    @PostMapping("/form")
    public String procesar(@Valid Usuario usuario, BindingResult result, Model model){

        if(result.hasErrors()){
            return "form";
        }

        model.addAttribute("titulo", "Resultado form");
        model.addAttribute("usuario", usuario);

        return "resultado";

    }

}
