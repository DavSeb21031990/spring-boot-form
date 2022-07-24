package springbootapp.spring.boot.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//Se crea esta clase para registrar el interceptor
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    @Qualifier("tiempoTranscurridoInterceptor")
    private HandlerInterceptor tiempoTranscurridoInterceptor;

    //Se sobreescribe el metodo para registrar el interceptor
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //Si no se define las rutas se aplica a toddas las rutas
        registry.addInterceptor(tiempoTranscurridoInterceptor);
    }

}
