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

import com.MapacheBD.Barberia.model.Barberos;
import com.MapacheBD.Barberia.repository.BarberosRepository;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/barbero")
public class BarberosController {
    @Autowired
    BarberosRepository barberosRepository;
    
    @GetMapping()
    public ResponseEntity<Iterable<Barberos>> findAll(){
        return ResponseEntity.ok(barberosRepository.findAll());
    }

    @GetMapping("/{idBarbero}")
    public ResponseEntity<Barberos> findById(@PathVariable Long idBarbero){
        Optional<Barberos> barberoOptional = barberosRepository.findById(idBarbero);
        if(barberoOptional.isPresent()){
            return ResponseEntity.ok(barberoOptional.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Barberos newBarberos, UriComponentsBuilder ucb){
        Barberos savedBarberos = barberosRepository.save(newBarberos);
        URI uri = ucb.path("barbero/{idBarbero}").buildAndExpand(savedBarberos.getIdBarbero()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{idBarbero}")
    public ResponseEntity<Void> update(@PathVariable Long idBarbero, @RequestBody Barberos barberoAct){
        Barberos barberoAnt =barberosRepository.findById(idBarbero).get();
        if(barberoAnt != null){
            barberoAct.setIdBarbero(barberoAnt.getIdBarbero());
            barberosRepository.save(barberoAct);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idBarbero}")
    public ResponseEntity<Void> delete(@PathVariable Long idBarbero){
        if(barberosRepository.findById(idBarbero).get() != null){
            barberosRepository.deleteById(idBarbero);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
