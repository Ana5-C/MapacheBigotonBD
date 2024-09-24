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

import com.MapacheBD.Barberia.model.Cita;
import com.MapacheBD.Barberia.model.Cliente;
import com.MapacheBD.Barberia.repository.CitaRepository;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/cita")
public class CitaController {
    @Autowired
    CitaRepository citaRepository;

    @GetMapping()
    public ResponseEntity<Iterable<Cita>> findAll(){
        return ResponseEntity.ok(citaRepository.findAll());
    }

    @GetMapping("/{idCita}")
    public ResponseEntity<Cita> findById(@PathVariable Long idCita){
        Optional<Cita> citaOptional = citaRepository.findById(idCita);
        if(citaOptional.isPresent()){
            return ResponseEntity.ok(citaOptional.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Cita newCita, UriComponentsBuilder ucb){
       Cita savedCita = citaRepository.save(newCita);
        URI uri = ucb
                .path("cita/{idCita}")
                .buildAndExpand(savedCita.getIdCita())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{idCita}")
    public ResponseEntity<Void> update(@PathVariable Long idCita, @RequestBody Cita citaAct){
        Cita citaAnt = citaRepository.findById(idCita).get();
        if(citaAnt != null){
            citaAct.setIdCita(citaAnt.getIdCita());
            citaRepository.save(citaAct);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idCita}")
    public ResponseEntity<Void> delete(@PathVariable Long idCita){
        if(citaRepository.findById(idCita).get() != null){
            citaRepository.deleteById(idCita);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
