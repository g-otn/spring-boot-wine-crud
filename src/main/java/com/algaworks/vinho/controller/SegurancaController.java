package com.algaworks.vinho.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SegurancaController {

    @RequestMapping("/login")
    public String login() {
        return "Login.html";
    }

}
