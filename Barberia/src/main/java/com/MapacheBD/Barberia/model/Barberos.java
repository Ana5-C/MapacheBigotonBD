package com.MapacheBD.Barberia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "barberos")
public class Barberos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBarbero;
    private String nombre;

    public Barberos(String nombre) {
        this.nombre = nombre;
    }

    public Barberos(){}

    public Long getIdBarbero() {
        return idBarbero;
    }

    public void setIdBarbero(Long idBarbero) {
        this.idBarbero = idBarbero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Barberos [idBarbero=" + idBarbero + ", nombre=" + nombre + "]";
    }

    
    
}