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
    @GetMapping("/juguetes")
    public String juguetes() {
        return "juguetes";
    }

    @GetMapping("/snacks")
    public String snacks() {
        return "snacks";
    }

    @GetMapping("/ropa")
    public String ropa() {
        return "ropa";
    }

    @GetMapping("/alimentos")
    public String alimentos() {
        return "alimentos";
    }

    @GetMapping("/contactanos")
    public String contactanos() {
        return "contactanos";
    }

    @PostMapping({"/guardar", "/categoria/guardar"})
    public String guardar(Categoria categoria,
            @RequestParam(value = "imageFile", required = false) MultipartFile imagenFile) {

        categoriaService.save(categoria);

        return "redirect:/principal";

    }

}
