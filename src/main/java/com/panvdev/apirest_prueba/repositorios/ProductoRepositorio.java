package com.panvdev.apirest_prueba.repositorios;

import com.panvdev.apirest_prueba.modelos.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.panvdev.apirest_prueba.modelos.Cliente;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long> {

}
