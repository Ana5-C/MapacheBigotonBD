package com.MapacheBD.Barberia.repository;

import com.MapacheBD.Barberia.model.Servicio;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ServicioRepository extends CrudRepository<Servicio, Long> {
}
