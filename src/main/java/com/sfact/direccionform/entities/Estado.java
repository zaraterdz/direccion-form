package com.sfact.direccionform.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estado")
public class Estado {
    @Id
    private String clave;
    private String pais;
    private String nombre_Estado;

    // Getters y Setters
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getNombreEstado() {
        return nombre_Estado;
    }

    public void setNombreEstado(String nombre_Estado) {
        this.nombre_Estado = nombre_Estado;
    }
}