package com.panvdev.apirest_prueba.controladores;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panvdev.apirest_prueba.modelos.Producto;
import com.panvdev.apirest_prueba.servicios.ProductoServicioImpl;

@RestController
@RequestMapping("/producto")
public class ProductoControlador {

    @Autowired
    ProductoServicioImpl productoservicio;


    @GetMapping("/productos")
    public List<Producto> obtenerProductos(){
        return productoservicio.obtenerTodo();
    }


    @PostMapping("/guardar")
    public ResponseEntity<Producto> guardarProducto(@RequestBody Producto producto){
        Producto nuevo_producto = productoservicio.guardar(producto);
        return new ResponseEntity<>(nuevo_producto, HttpStatus.CREATED);
    }

    @GetMapping("/producto/{id}")
    public ResponseEntity<Producto> obtenerProductoId(@PathVariable long id){
        Producto productoPorId = productoservicio.obtenerPorId(id);
        return ResponseEntity.ok(productoPorId);
    }

    @PutMapping("/producto/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable long id, @RequestBody Producto producto){
        Producto productoPorId = productoservicio.obtenerPorId(id);
        productoPorId.setArticulo(producto.getArticulo());
        productoPorId.setMarca(producto.getMarca());
        productoPorId.setDescripcion(producto.getDescripcion());

        Producto producto_actualizado = productoservicio.guardar(productoPorId);
        return new ResponseEntity<>(producto_actualizado, HttpStatus.CREATED);
    }

    @DeleteMapping("/producto/{id}")
    public ResponseEntity<HashMap<String,Boolean>> eliminarProducto(@PathVariable long id){
        this.productoservicio.eliminar(id);

        HashMap<String, Boolean> estadoProductoEliminado = new HashMap<>();
        estadoProductoEliminado.put("eliminado", true);
        return ResponseEntity.ok(estadoProductoEliminado);
    }
















}
