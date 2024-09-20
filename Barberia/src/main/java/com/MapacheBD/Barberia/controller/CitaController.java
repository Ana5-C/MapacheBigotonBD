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
    private ClienteRepository ClienteRepository;

    

}

