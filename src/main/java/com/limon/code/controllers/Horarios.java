package com.limon.code.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Horarios {

    @GetMapping("/horario")
    public String horarioAtencion(){
        return "horario";
    }

}
