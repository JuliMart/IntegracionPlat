package com.panvdev.apirest_prueba.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panvdev.apirest_prueba.modelos.Cliente;
import com.panvdev.apirest_prueba.repositorios.ClienteRepositorio;

@Service
public class ClienteServicioImpl implements IClienteServicio{
	
	@Autowired
	ClienteRepositorio clienterepositorio;

	@Override
	public List<Cliente> obtenerTodo() {
		return clienterepositorio.findAll();
	}

	@Override
	public Cliente guardar(Cliente cliente) {
		return clienterepositorio.save(cliente);
	}

	@Override
	public Cliente obtenerPorId(long id) {
		return clienterepositorio.findById(id).orElse(null);
	}

	@Override
	public void eliminar(long id) {
		clienterepositorio.deleteById(id);
		
	}

}
