package com.MapacheBD.Barberia.controller;


import com.MapacheBD.Barberia.model.Servicio;
import com.MapacheBD.Barberia.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/servicio")

public class ServicioController {

    @Autowired
   private ServicioRepository servicioRepository;

    @GetMapping()
    public ResponseEntity<Iterable<Servicio>> findAll(){
        return ResponseEntity.ok(servicioRepository.findAll());
    }

    @GetMapping("/{idServicio}")
    public ResponseEntity<Servicio> findById(@PathVariable Long idServicio){
        Optional<Servicio> servicioOptional = servicioRepository.findById(idServicio);
        if (servicioOptional.isPresent()){
            return ResponseEntity.ok(servicioOptional.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Servicio newServicio, UriComponentsBuilder ucb){
        Servicio savedServicio = servicioRepository.save(newServicio);
        URI uri = ucb
                .path("servicio/{idServicio}")
                .buildAndExpand(savedServicio.getIdServicio())
                .toUri();
        return ResponseEntity.created(uri).build();

    }
    @PutMapping("/{idServicio}")
    public ResponseEntity<Void> update(@PathVariable Long idServicio, @RequestBody Servicio servicioAct){
        Servicio servicioAnt = servicioRepository.findById(idServicio).get();
        if (servicioAnt != null){
            servicioAct.setIdServicio(servicioAnt.getIdServicio());
            servicioRepository.save(servicioAct);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idServicio}")
    public ResponseEntity<Void> delete(@PathVariable Long idServicio){
        if (servicioRepository.findById(idServicio).get() != null){
            servicioRepository.deleteById(idServicio);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}