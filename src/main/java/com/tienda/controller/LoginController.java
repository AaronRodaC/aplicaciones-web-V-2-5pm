package com.tienda.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login"; 
    }

    @PostMapping("/login")
    public String procesarLogin(
            @RequestParam("correo") String correo,
            @RequestParam("password") String password,
            HttpSession session,
            Model model
    ) {

        if (correo.equals("aaron") && password.equals("123")) {
            session.setAttribute("usuarioLogueado", "aaron");
            session.setAttribute("rol", "ADMIN");
            return "redirect:/index";
        }

        if (correo.equals("alejandro") && password.equals("456")) {
            session.setAttribute("usuarioLogueado", "alejandro");
            session.setAttribute("rol", "CLIENTE");
            return "redirect:/principal";
        }

        model.addAttribute("error", "Usuario o contraseña incorrectos");
        return "index"; 
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
