package com.MapacheBD.Barberia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicio")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idServicio;
    private String tiposervico;
    private double precio;

    public Servicio(String tiposervico) {
        this.tiposervico = tiposervico;
    }

    public Servicio() {
    }

    public Long getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Long idServicio) {
        this.idServicio = idServicio;
    }

    public String getTiposervico() {
        return tiposervico;
    }

    public void setTiposervico(String tiposervico) {
        this.tiposervico = tiposervico;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Servicio [idServicio=" + idServicio + ", tiposervico=" + tiposervico + ", precio=" + precio + "]";
    }

}