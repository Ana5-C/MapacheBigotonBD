package com.MapacheBD.Barberia.repository;

import com.MapacheBD.Barberia.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>{

}
