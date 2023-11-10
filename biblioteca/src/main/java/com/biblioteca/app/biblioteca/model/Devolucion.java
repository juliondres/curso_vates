package com.biblioteca.app.biblioteca.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Devolucion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date fechaDevolucion;

    @OneToOne(cascade = CascadeType.ALL)
    private Multa multa;

    public Devolucion(){
    }
    public Devolucion(Long id, Date fechaDevolucion, Multa multa) {
        this.id = id;
        this.fechaDevolucion = fechaDevolucion;
        this.multa = multa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Multa getMulta() {
        return multa;
    }

    public void setMulta(Multa multa) {
        this.multa = multa;
    }
}
