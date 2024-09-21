package com.MapacheBD.Barberia.repository;

import com.MapacheBD.Barberia.model.Cita;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepository extends CrudRepository<Cita, Long>{

}