package com.biblioteca.app.biblioteca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
public class Autor extends Persona{

    private String pseudonimo;

    public Autor() {
        super();
    }

    public Autor(String nombre, String apellido, String pseudonimo) {
        super(nombre, apellido);
        this.pseudonimo = pseudonimo;
    }

    public String getPseudonimo() {
        return pseudonimo;
    }

    public void setPseudonimo(String pseudonimo) {
        this.pseudonimo = pseudonimo;
    }
}
