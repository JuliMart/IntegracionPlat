package com.panvdev.apirest_prueba.servicios;

import java.util.List;

import com.panvdev.apirest_prueba.modelos.Cliente;

public interface IClienteServicio{

	public List<Cliente> obtenerTodo();
	
	public Cliente guardar(Cliente cliente);
	
	public Cliente obtenerPorId(long id);
	
	public void eliminar(long id);
}
