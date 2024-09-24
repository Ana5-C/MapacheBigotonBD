package com.MapacheBD.Barberia.model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

@Entity
@Table (name="servicio")
public class Servicio {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idServicio;
    private String tiposervico;
    private Integer precio;

    public Servicio(String tiposervico, Integer precio){
        this.tiposervico = tiposervico;
        this.precio = precio;
    }

    public Servicio(){

    }

    public Long getIdServicio() { return idServicio;}

    public void setIdServicio(Long idServicio) { this.idServicio = idServicio; }

    public String getTiposervico() { return tiposervico;}

    public void setTiposervico(String tiposervico) { this.tiposervico = tiposervico;}

    public Integer getPrecio() { return precio; }

    public void setPrecio(Integer precio) { this.precio = precio;}

    @Override
    public String toString() {
        return "Servicio{" +
                "idServicio=" + idServicio +
                ", tiposervico='" + tiposervico + '\'' +
                ", precio=" + precio +
                '}';
    }
}
