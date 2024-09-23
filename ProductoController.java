package com.tu_paquete.controlador;

import com.tu_paquete.modelo.Producto;
import com.tu_paquete.servicio.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Permite el acceso desde React
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/productos")
    public List<Producto> obtenerProductosAleatorios() {
        List<Producto> productos = productoService.obtenerTodosLosProductos();
        Collections.shuffle(productos); // Mezclar la lista
        return productos.stream().limit(10).collect(Collectors.toList()); // Limitar a 10 productos
    }
}
