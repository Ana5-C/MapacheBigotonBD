package com.MapacheBD.Barberia.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cita")
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCita;
    private String nombre;
    private Long telefono;
    private String fecha;
    private String hora;
    private String descripcion;
    private double costo;
    private String nombreBar;

    public Cita() {
    }

    public Cita(String nombre, String fecha, String hora, String descripcion, String nombreBar) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.descripcion = descripcion;
        this.nombreBar = nombreBar;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getNombreBar() {
        return nombreBar;
    }

    public void setNombreBar(String nombreBar) {
        this.nombreBar = nombreBar;
    }


    @Override
    public String toString() {
        return "Cita [idCita=" + idCita + ", nombre=" + nombre + ", telefono=" + telefono + ", fecha=" + fecha
                + ", hora=" + hora + ", descripcion=" + descripcion + ", costo=" + costo + ", nombreBar=" + nombreBar
                +  "]";
    }

}
