package com.sfact.direccionform.entities;

import java.io.Serializable;

public class ColoniaId implements Serializable {
    private String clave;
    private String cp;

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
