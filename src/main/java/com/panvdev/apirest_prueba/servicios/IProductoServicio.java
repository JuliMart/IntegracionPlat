package com.panvdev.apirest_prueba.servicios;

import java.util.List;

import com.panvdev.apirest_prueba.modelos.Producto;

public interface IProductoServicio{

    public List<Producto> obtenerTodo();

    public Producto guardar(Producto producto);

    public Producto obtenerPorId(long id);

    public void eliminar(long id);
}
