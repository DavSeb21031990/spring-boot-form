package springbootapp.spring.boot.form.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.SecureRandom;
import java.util.Random;

@Component("tiempoTranscurridoInterceptor")
public class TiempoTranscurridoInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(TiempoTranscurridoInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(request.getMethod().equalsIgnoreCase("post")){
            return true;
        }

        LOGGER.info("TiempoTranscurridoInterceptor: preHandler() entrando ...");

        long tiempoInicio = System.currentTimeMillis();
        request.setAttribute("tiempoInicio", tiempoInicio);

        Random random = SecureRandom.getInstanceStrong();
        int demora = random.nextInt(500);

        Thread.sleep(demora);

        //response.sendRedirect(request.getContextPath().concat("/login"));
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        long tiempoFin = System.currentTimeMillis();
        long tiempoInicio = (long) request.getAttribute("tiempoInicio");
        long tiempoTranscurrido = tiempoFin - tiempoInicio;

        if(modelAndView != null){
            modelAndView.addObject("tiempoTranscurrido", tiempoTranscurrido);
        }

        LOGGER.info("Tiempo Transcurrido {} milisegundos.", tiempoTranscurrido);
        LOGGER.info("TiempoTranscurridoInterceptor: postHandler() salidendo ...");

    }

}
