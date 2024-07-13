package com.panvdev.apirest_prueba.servicios;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.panvdev.apirest_prueba.modelos.Producto;
import com.panvdev.apirest_prueba.repositorios.ProductoRepositorio;

@SpringBootTest
public class ProductoServicioTest {

    @InjectMocks
    private ProductoServicioImpl productoServicio;

    @Mock
    private ProductoRepositorio productoRepositorio;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGuardarProducto() {
        Producto producto = new Producto();
        producto.setArticulo("Sierra");
        producto.setMarca("Dewalt");
        producto.setDescripcion("Sierra de banco");
        producto.setPrecio(39.990);

        when(productoRepositorio.save(producto)).thenReturn(producto);
        assertEquals(producto, productoServicio.guardar(producto));
    }

    @Test
    public void testObtenerProductos() {
        List<Producto> productos = Arrays.asList(new Producto());
        when(productoRepositorio.findAll()).thenReturn(productos);
        assertEquals(productos, productoServicio.obtenerTodo());
    }

    @Test
    public void testObtenerProductoPorId() {
        Producto producto = new Producto();
        producto.setArticulo("Sierra");
        producto.setMarca("Dewalt");
        producto.setDescripcion("Sierra de banco");

        when(productoRepositorio.findById(1L)).thenReturn(java.util.Optional.of(producto));
        assertEquals(producto, productoServicio.obtenerPorId(1L));
    }

    @Test
    public void testEliminarProducto() {
        Producto producto = new Producto();
        producto.setId(1L);
        productoServicio.eliminar(producto.getId());
        when(productoRepositorio.findById(producto.getId())).thenReturn(java.util.Optional.empty());
        assertEquals(null, productoServicio.obtenerPorId(producto.getId()));
    }
}
