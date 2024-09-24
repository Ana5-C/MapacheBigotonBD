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
import com.MapacheBD.Barberia.model.CitaServicio;
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
    public ResponseEntity<Void> create(@RequestBody Cita cita, UriComponentsBuilder ucb){
       Opcional<Cita> citaOptional = citaRepository.findById(cita.getCita().getIdCita);
       if (!citaOptional.isPresent()){
        retuResponseEntity.notFound().build();
       }
        cita.setCita(citaOptional.get();
        cita savedCita =citaRepository.save(cita);
        URI uri = ucb
                .path("cliente/{idCliente}")
                .buildAndExpand(savedCita.getIdCita())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{idCita}")
    public ResponseEntity<Void> update(@PathVariable Long idCita, @RequestBody Cita cita){
        Opcional<Cita> citaOptional = citaRepository.findById(cita.getCita().getIdCita);
        if (!citaOptional.isPresent()){
            retuResponseEntity.notFound().build();
        }

        Opcional<Cita> citaOptional = citaRepository.findById(idCita);
        if (! citaOptional.isPresent()){
            retuResponseEntity.notFound().build();
        }

        cita.setCita(citaOptional.get());
        cita.setCita(citaOptional.get().getIdCita());
        citaRepository.save(cita);
        return ResponseEntity.noContent().build();
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
