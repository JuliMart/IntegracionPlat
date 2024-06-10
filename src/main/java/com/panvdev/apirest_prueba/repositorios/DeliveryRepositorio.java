package com.panvdev.apirest_prueba.repositorios;

import com.panvdev.apirest_prueba.modelos.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DeliveryRepositorio extends JpaRepository<Delivery, Long> {
}
