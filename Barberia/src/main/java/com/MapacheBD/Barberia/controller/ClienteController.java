package com.MapacheBD.Barberia.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.MapacheBD.Barberia.model.Cliente;
import com.MapacheBD.Barberia.repository.ClienteRepository;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    // findAll ---->READ
    @GetMapping()
    public ResponseEntity<Iterable<Cliente>> findAll() {
        return ResponseEntity.ok(clienteRepository.findAll());
    }

    // findById ----> READ
    @GetMapping("/{idCliente}")
    public ResponseEntity<Cliente> findById(@PathVariable Long idCliente) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(idCliente);
        if (clienteOptional.isPresent()) {
            return ResponseEntity.ok(clienteOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Cliente newCliente, UriComponentsBuilder ucb) {
        Cliente savedCliente = clienteRepository.save(newCliente);
        URI uri = ucb
                .path("cliente/{idCliente}")
                .buildAndExpand(savedCliente.getIdCliente())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    // UPDATE
    @PutMapping("/{idCliente}")
    public ResponseEntity<Void> update(@PathVariable Long idCliente, @RequestBody Cliente clienteAct) {
        Cliente clienteAnt = clienteRepository.findById(idCliente).get();
        if (clienteAnt != null) {
            clienteAct.setIdCliente(clienteAnt.getIdCliente());
            clienteRepository.save(clienteAct);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // DELETE
    @DeleteMapping("/{idCliente}")
    public ResponseEntity<Void> delete(@PathVariable Long idCliente) {
        if (clienteRepository.findById(idCliente).get() != null) {
            clienteRepository.deleteById(idCliente);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/login")
public ResponseEntity<Cliente> login(@RequestBody Cliente cliente) {
    Optional<Cliente> clienteOptional = clienteRepository.findByNombreUsuarioAndContrasena(cliente.getNombreUsuario(), cliente.getContrasena());
    if (clienteOptional.isPresent()) {
        return ResponseEntity.ok(clienteOptional.get());
    } else {
        return ResponseEntity.badRequest().build();
    }
}
}
