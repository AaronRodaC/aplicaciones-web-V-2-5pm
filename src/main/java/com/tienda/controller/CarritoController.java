package com.tienda.controller;

import com.tienda.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    // ✅ MOSTRAR CARRITO
    @GetMapping("/carrito")
    public String verCarrito(Model model) {
        model.addAttribute("carrito", carritoService.getCarrito());
        return "carrito"; // 👉 busca carrito.html
    }

    // ✅ AGREGAR PRODUCTO
    @PostMapping("/carrito/agregar")
    public String agregarProducto(
            @RequestParam("productoId") Long productoId,
            @RequestParam("cantidad") int cantidad) {

        carritoService.agregarProducto(productoId, cantidad);
        return "redirect:/";
    }
}
