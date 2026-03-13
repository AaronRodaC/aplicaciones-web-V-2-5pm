package com.tienda.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CarritoService {

    // Simula carrito en memoria (productoId → cantidad)
    private Map<Long, Integer> carrito = new HashMap<>();

    // 👉 AGREGA PRODUCTO
    public void agregarProducto(Long productoId, int cantidad) {
        carrito.merge(productoId, cantidad, Integer::sum);
    }

    // 👉 LISTA DE ITEMS PARA LA VISTA
    public List<ItemCarrito> obtenerItems() {

        List<ItemCarrito> items = new ArrayList<>();

        for (Map.Entry<Long, Integer> entry : carrito.entrySet()) {

            Long productoId = entry.getKey();
            int cantidad = entry.getValue();

            // 🔹 Simulación de productos (luego BD)
            String nombre = "Producto #" + productoId;
            double precio = obtenerPrecio(productoId);

             ItemCarrito item = new ItemCarrito(
                    productoId,
                    nombre,
                    precio,
                    cantidad
            );

            items.add(item);
        }

        return items;
    }

    // 👉 TOTAL DEL CARRITO
    public double obtenerTotal() {
        return obtenerItems().stream()
                .mapToDouble(i -> i.getPrecio() * i.getCantidad())
                .sum();
    }

    // 👉 SIMULA PRECIOS
    private double obtenerPrecio(Long productoId) {
        return switch (productoId.intValue()) {
            case 101 -> 315000;
            case 102 -> 420000;
            case 103 -> 1250000;
            case 104 -> 720000;
            case 105 -> 530000;
            case 106 -> 595000;
            default -> 100000;
        };
    }

    // 👉 LIMPIAR CARRITO (checkout)
    public void limpiar() {
        carrito.clear();
    }

    public Object getCarrito() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
