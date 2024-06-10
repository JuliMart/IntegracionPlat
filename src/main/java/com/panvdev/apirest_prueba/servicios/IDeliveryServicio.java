package com.panvdev.apirest_prueba.servicios;

import java.util.List;

import com.panvdev.apirest_prueba.modelos.Delivery;

public interface IDeliveryServicio{

    public List<Delivery> obtenerTodo();

    public Delivery guardar(Delivery delivery);

    public Delivery obtenerPorId(long id);

    public void eliminar(long id);
}
