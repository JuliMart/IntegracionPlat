package com.panvdev.apirest_prueba.servicios;

import java.util.List;
import com.panvdev.apirest_prueba.modelos.Delivery;
import com.panvdev.apirest_prueba.repositorios.DeliveryRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryServicioImpl implements IDeliveryServicio{

    @Autowired
    DeliveryRepositorio deliveryrepositorio;

    @Override
    public List<Delivery> obtenerTodo() {
        return deliveryrepositorio.findAll();
    }

    @Override
    public Delivery guardar(Delivery delivery) {
        return deliveryrepositorio.save(delivery);
    }

    @Override
    public Delivery obtenerPorId(long id) {
        return deliveryrepositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminar(long id) {
        deliveryrepositorio.deleteById(id);

    }

}
