package com.biblioteca.app.biblioteca.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Multa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fechaInfraccion;
    private Double monto;

    private String motivo;
    @OneToOne
    private Usuario usuario;

    public Multa(){
    }
    public Multa(Long id, Date fechaInfraccion, Double monto, String motivo, Usuario usuario) {
        this.id = id;
        this.fechaInfraccion = fechaInfraccion;
        this.monto = monto;
        this.motivo = motivo;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaInfraccion() {
        return fechaInfraccion;
    }

    public void setFechaInfraccion(Date fechaInfraccion) {
        this.fechaInfraccion = fechaInfraccion;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
