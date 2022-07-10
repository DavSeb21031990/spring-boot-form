package springbootapp.spring.boot.form.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springbootapp.spring.boot.form.models.domain.Usuario;

@Controller
public class FormController {

    @GetMapping("/form")
    public String formModel(Model model){
        model.addAttribute("titulo", "Formulario Usuarios");
        return "form";
    }

    @PostMapping("/form")
    public String procesar(Usuario usuario, Model model){

        model.addAttribute("titulo", "Resultado form");
        model.addAttribute("usuario", usuario);

        return "resultado";

    }

}
