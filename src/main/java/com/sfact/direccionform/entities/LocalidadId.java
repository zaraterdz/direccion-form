package com.sfact.direccionform.entities;

import java.io.Serializable;
import java.util.Objects;

public class LocalidadId implements Serializable {
    private String clave;
    private String estado;

    public LocalidadId() {}

    public LocalidadId(String clave, String estado) {
        this.clave = clave;
        this.estado = estado;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocalidadId that = (LocalidadId) o;
        return Objects.equals(clave, that.clave) &&
                Objects.equals(estado, that.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clave, estado);
    }
}