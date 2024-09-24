package com.MapacheBD.Barberia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "cita")
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCita;
    private String nombre;
    private Long telefono;
    private String descripcion;
    private String fecha;
    private Long Hora;
    private Double costo;

    public Cita(String nombre, String descripcion, String fecha) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public Cita(){
    }

    public Long getIdCita() {
        return idCita;
    }

    public void setIdCita(Long idCita) {
        this.idCita = idCita;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Long getHora() {
        return Hora;
    }

    public void setHora(Long hora) {
        Hora = hora;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Cita [idCita=" + idCita + ", nombre=" + nombre + ", telefono=" + telefono + ", descripcion="
                + descripcion + ", fecha=" + fecha + ", Hora=" + Hora + ", costo=" + costo + "]";
    }

    
    

    

}
