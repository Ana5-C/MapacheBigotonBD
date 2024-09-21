package com.MapacheBD.Barberia.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cita_servicio")
public class CitaServicio {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer folio;

    private String nota;

    @ManyToOne
    @JoinColumn(name = "idCita")
    private Cita cita;

    @ManyToOne
    @JoinColumn(name = "idServicio")
    private Servicio servicio;

    // Constructor vacío
    public CitaServicio() {
    }

    // Constructor completo
    public CitaServicio(String nota) {
        this.nota = nota;
    }

    // Getters y Setters
    public Integer getFolio() {
        return folio;
    }

    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "CitaServicio [folio=" + folio + ", nota=" + nota + "]";
    }
}
