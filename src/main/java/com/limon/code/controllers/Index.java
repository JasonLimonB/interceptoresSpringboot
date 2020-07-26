package com.limon.code.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Index {

    String txt = "Si puedes leer este texto es que se cumplio la candición";

    @RequestMapping( value = "/", method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("texto", txt);
        return "index";
    }

}
