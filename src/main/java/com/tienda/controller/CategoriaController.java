package com.tienda.controller;

import com.tienda.domain.Categoria;
import com.tienda.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;


    // -------------------------
    //        CATEGORÍAS
    // -------------------------
    @GetMapping("/celulares")
    public String celulares() {
        return "celulares";
    }

    @GetMapping("/computadoras")
    public String computadoras() {
        return "computadoras";
    }

    @GetMapping("/hogar")
    public String hogar() {
        return "Hogar";
    }

    @GetMapping("/componentes")
    public String componentes() {
        return "componentes";
    }

    @GetMapping("/monitores")
    public String monitores() {
        return "monitores";
    }

    @PostMapping({"/guardar", "/categoria/guardar"})
    public String guardar(Categoria categoria,
            @RequestParam(value = "imageFile", required = false) MultipartFile imagenFile) {

        categoriaService.save(categoria);

        return "redirect:/principal";

    }

}
