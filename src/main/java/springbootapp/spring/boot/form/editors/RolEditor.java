package springbootapp.spring.boot.form.editors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.stereotype.Component;
import springbootapp.spring.boot.form.services.RolService;

@Component
public class RolEditor extends PropertiesEditor {

    @Autowired
    private RolService rolService;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            Integer id = Integer.parseInt(text);
            setValue(rolService.obtenerPorId(id));
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
    }

}
