package com.limon.code.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@Component("horarioInterceptor")
public class HorarioInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(HorarioInterceptor.class);

    @Value("${config.horario.apertura}")
    private Integer apertura;
    @Value("${config.horario.cierre}")
    private Integer cierre;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        LocalDateTime today = LocalDateTime.now();
        int currentHour = today.getHour();

        if ( currentHour >= apertura && currentHour < cierre) {
            StringBuilder mensaje = new StringBuilder("Bienvenido a nuestro local ")
                    .append("Por favor visita nuestra pagina y recuerda el horario de atencion es de ")
                    .append(apertura).append(" hrs").append(" a ").append(cierre).append(" hrs");

            request.setAttribute("mensaje", mensaje.toString());
            return true;
        }

        response.sendRedirect(request.getContextPath().concat("/horario"));

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        String mensaje = request.getAttribute("mensaje").toString();

        modelAndView.addObject("mensaje", mensaje);

    }
}
