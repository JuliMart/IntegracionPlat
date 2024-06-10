package com.panvdev.apirest_prueba.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panvdev.apirest_prueba.modelos.Producto;
import com.panvdev.apirest_prueba.repositorios.ProductoRepositorio;

@Service
public class ProductoServicioImpl implements IProductoServicio{

    @Autowired
    ProductoRepositorio productorepositorio;

    @Override
    public List<Producto> obtenerTodo() {
        return productorepositorio.findAll();
    }

    @Override
    public Producto guardar(Producto producto) {
        return productorepositorio.save(producto);
    }

    @Override
    public Producto obtenerPorId(long id) {
        return productorepositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminar(long id) {
        productorepositorio.deleteById(id);

    }

}
