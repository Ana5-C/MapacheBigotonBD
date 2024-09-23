package com.MapacheBD.Barberia.repository;

import com.MapacheBD.Barberia.model.Cliente;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>{
    Optional<Cliente> findByNombreUsuarioAndContrasena(String nombreUsuario, String contrasena);
}
