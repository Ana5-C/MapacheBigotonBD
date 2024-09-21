package com.MapacheBD.Barberia.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("/cita")
public class CitaController {
    @Autowired 
    private CitaRepository citaRepository ;

    @Autowired
    private ServicioRepository ServicioRepository;

    @GetMapping()
    public ResponseEntity<Iterable<cita>> findAll(){
        return ResponseEntity.ok(CitaRepository.findAll());
    }
    
    @GetMapping("/{idCita}")
    public ResponseEntity<Cita> findById (@PathVariable integer idCita){
        Optional<Cita> citaOptional = citaRepository.findById(idCita);
        if (!citaOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(citaOptional.get());
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Cita newCliente, UriComponentsBuilder ucb){
        Cita savedCliente = citaRepository.save(newCliente);
        URI uri = ucb
                .path("cita/{idCita}")
                .buildAndExpand(savedCliente.getIdCita())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

}

