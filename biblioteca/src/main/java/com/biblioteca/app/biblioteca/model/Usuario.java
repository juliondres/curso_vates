package com.biblioteca.app.biblioteca.model;

import jakarta.persistence.*;

@Entity
public class Usuario extends Persona{

    private Long dni;

    private String direccion;

    public Usuario() {
        super();
    }

    public Usuario(String nombre, String apellido, Long dni, String direccion) {
        super(nombre, apellido);
        this.dni = dni;
        this.direccion = direccion;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
