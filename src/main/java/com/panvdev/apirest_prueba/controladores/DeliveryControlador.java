package com.panvdev.apirest_prueba.controladores;

import java.util.HashMap;
import java.util.List;

import com.panvdev.apirest_prueba.modelos.Delivery;
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

import com.panvdev.apirest_prueba.servicios.DeliveryServicioImpl;

@RestController
@RequestMapping("/delivery/")
public class DeliveryControlador {

    @Autowired
    DeliveryServicioImpl deliveryservicio;


    @GetMapping("/deliverys")
    public List<Delivery> obtenerDelivery(){
        return deliveryservicio.obtenerTodo();
    }


    @PostMapping("/guardar")
    public ResponseEntity<Delivery> guardarDelivery(@RequestBody Delivery delivery){
        Delivery nuevo_delivery = deliveryservicio.guardar(delivery);
        return new ResponseEntity<>(nuevo_delivery, HttpStatus.CREATED);
    }

    @GetMapping("/delivery/{id}")
    public ResponseEntity<Delivery> obtenerDeliveryId(@PathVariable long id){
        Delivery deliveryPorId = deliveryservicio.obtenerPorId(id);
        return ResponseEntity.ok(deliveryPorId);
    }

    @PutMapping("/delivery/{id}")
    public ResponseEntity<Delivery> actualizarDelivery(@PathVariable long id, @RequestBody Delivery delivery){
        Delivery deliveryPorId = deliveryservicio.obtenerPorId(id);
        deliveryPorId.setDireccion(delivery.getDireccion());
        deliveryPorId.setComuna(delivery.getComuna());
        deliveryPorId.setRegion(delivery.getRegion());

        Delivery delivery_actualizado = deliveryservicio.guardar(deliveryPorId);
        return new ResponseEntity<>(delivery_actualizado, HttpStatus.CREATED);
    }

    @DeleteMapping("/delivery/{id}")
    public ResponseEntity<HashMap<String,Boolean>> eliminarDelivery(@PathVariable long id){
        this.deliveryservicio.eliminar(id);

        HashMap<String, Boolean> estadoDeliveryEliminado = new HashMap<>();
        estadoDeliveryEliminado.put("eliminado", true);
        return ResponseEntity.ok(estadoDeliveryEliminado);
    }
















}
