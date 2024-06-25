package com.panvdev.apirest_prueba.servicios;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.panvdev.apirest_prueba.modelos.Cliente;
import com.panvdev.apirest_prueba.repositorios.ClienteRepositorio;

@SpringBootTest
public class ClienteServicioTest {

    @Mock
    private ClienteRepositorio clienteRepositorio;

    @InjectMocks
    private ClienteServicioImpl clienteServicio;

    public ClienteServicioTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGuardarCliente() {
        Cliente cliente = new Cliente("Juan", "Perez", "juan.perez@mail.com");
        when(clienteRepositorio.save(cliente)).thenReturn(cliente);
        assertEquals(cliente, clienteServicio.guardar(cliente));
    }

    @Test
    public void testObtenerClientes() {
        List<Cliente> clientes = Arrays.asList(new Cliente("Juan", "Perez", "juan.perez@mail.com"));
        when(clienteRepositorio.findAll()).thenReturn(clientes);
        assertEquals(clientes, clienteServicio.obtenerTodo());
    }
}
