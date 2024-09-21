package com.MapacheBD.Barberia.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "cita")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCita;
    private String descripcion;
    private String nombreCliente;
    private Long telefono;
    private Date fechaHora; // Usamos Date en lugar de LocalDateTime
    private Double costo;

    @ManyToOne(fetch = FetchType.LAZY, Opcional = false)
    @JoinColumn(name = "idCita")
    @JsonProperty(access = JsonProperty.access.WRITE_ONLY)
    private Cita cita;

    @OneToMany(mappedBy = "cita")
    private List<CitaServicios> citaServicios;

    // Constructor
    public Cita(String descripcion, String nombreCliente, Long telefono, Date fechaHora, Double costo) {
        this.descripcion = descripcion;
        this.nombreCliente = nombreCliente;
        this.telefono = telefono;
        this.fechaHora = fechaHora;
        this.costo = costo;
    }

    // Constructor vacío
    public Cita() {
    }

    // Getters y Setters
    public Long getIdCita() {
        return idCita;
    }

    public void setIdCita(Long idCita) {
        this.idCita = idCita;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Cita [idCita=" + idCita + ", descripcion=" + descripcion + ", nombreCliente=" + nombreCliente
                + ", telefono=" + telefono + ", fechaHora=" + fechaHora + ", costo=" + costo + "]";
    }
}
