package com.ecoenvio;

public class Cliente {
    private String nombre;
    private String tipoMembresia;

    public Cliente(String nombre, String tipoMembresia) {
        this.nombre = nombre;
        this.tipoMembresia = tipoMembresia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoMembresia() {
        return tipoMembresia;
    }
}