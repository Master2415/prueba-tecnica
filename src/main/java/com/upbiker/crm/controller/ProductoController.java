package com.upbiker.crm.controller;

import com.upbiker.crm.service.Inventario;
import com.upbiker.crm.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private Inventario inventario;

    // Endpoint para agregar productos (POST)
    @PostMapping
    public ResponseEntity<String> agregarProducto(@RequestBody Producto producto) {
        inventario.agregarProducto(producto.getNombre(), producto.getPrecio(), producto.getCategoria());
        return ResponseEntity.ok("Producto agregado correctamente");
    }

    // Endpoint para eliminar productos (DELETE)
    @DeleteMapping("/{categoria}/{nombre}")
    public ResponseEntity<String> eliminarProducto(@PathVariable String categoria, @PathVariable String nombre) {
        inventario.eliminarProducto(nombre, categoria);
        return ResponseEntity.ok("Producto eliminado correctamente");
    }

    // Endpoint para listar productos por categoría (GET)
    @GetMapping("/{categoria}")
    public ResponseEntity<List<Producto>> listarProductos(@PathVariable String categoria) {
        List<Producto> productos = inventario.listarProductosPorCategoria(categoria);
        return ResponseEntity.ok(productos);
    }
}
