package com.upbiker.crm.service;

import com.upbiker.crm.model.Producto;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Inventario {
    private Map<String, List<Producto>> productosPorCategoria;

    public Inventario() {
        productosPorCategoria = new HashMap<>();
    }

    // Método para agregar un producto al inventario
    public void agregarProducto(String nombre, double precio, String categoria) {
        Producto producto = new Producto(nombre, precio, categoria);
        productosPorCategoria.computeIfAbsent(categoria, k -> new ArrayList<>()).add(producto);
    }

    // Método para eliminar un producto del inventario
    public void eliminarProducto(String nombre, String categoria) {
        List<Producto> productos = productosPorCategoria.get(categoria);
        if (productos != null) {
            productos.removeIf(p -> p.getNombre().equalsIgnoreCase(nombre));
        }
    }

    // Listar productos por categoría
    public List<Producto> listarProductosPorCategoria(String categoria) {
        return productosPorCategoria.getOrDefault(categoria, Collections.emptyList());
    }
}
