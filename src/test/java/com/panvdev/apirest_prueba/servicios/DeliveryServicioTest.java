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

import com.panvdev.apirest_prueba.modelos.Delivery;
import com.panvdev.apirest_prueba.repositorios.DeliveryRepositorio;

@SpringBootTest
public class DeliveryServicioTest {

    @InjectMocks
    private DeliveryServicioImpl deliveryServicio;

    @Mock
    private DeliveryRepositorio deliveryRepositorio;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGuardarDelivery() {
        Delivery delivery = new Delivery();
        delivery.setDireccion("123 Calle Falsa");
        delivery.setComuna("Comuna Ejemplo");
        delivery.setRegion("Región Ejemplo");

        when(deliveryRepositorio.save(delivery)).thenReturn(delivery);
        assertEquals(delivery, deliveryServicio.guardar(delivery));
    }

    @Test
    public void testObtenerDeliverys() {
        List<Delivery> deliverys = Arrays.asList(new Delivery());
        when(deliveryRepositorio.findAll()).thenReturn(deliverys);
        assertEquals(deliverys, deliveryServicio.obtenerTodo());
    }

    @Test
    public void testObtenerDeliveryPorId() {
        Delivery delivery = new Delivery();
        delivery.setDireccion("123 Calle Falsa");
        delivery.setComuna("Comuna Ejemplo");
        delivery.setRegion("Región Ejemplo");

        when(deliveryRepositorio.findById(1L)).thenReturn(java.util.Optional.of(delivery));
        assertEquals(delivery, deliveryServicio.obtenerPorId(1L));
    }

    @Test
    public void testEliminarDelivery() {
        Delivery delivery = new Delivery();
        delivery.setId(1L);
        deliveryServicio.eliminar(delivery.getId());
        when(deliveryRepositorio.findById(delivery.getId())).thenReturn(java.util.Optional.empty());
        assertEquals(null, deliveryServicio.obtenerPorId(delivery.getId()));
    }
}
