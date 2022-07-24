package springbootapp.spring.boot.form.editors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import springbootapp.spring.boot.form.services.PaisService;

import java.beans.PropertyEditorSupport;

@Component
public class PaisPropertyEditor extends PropertyEditorSupport {

    @Autowired
    private PaisService paisService;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if(text != null && !text.equals(" ")){
            try {
                Integer id = Integer.parseInt(text);
                this.setValue(paisService.obtenerPorId(id));
            }catch (NumberFormatException e){
                setValue(null);
            }
        }
    }

}
