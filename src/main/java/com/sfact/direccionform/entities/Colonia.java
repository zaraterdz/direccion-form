package com.sfact.direccionform.entities;

import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "colonia")
@IdClass(ColoniaId.class)
public class Colonia {
    @Id
    private String clave;
    @Id
    private String cp;
    private String descripcion;

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
