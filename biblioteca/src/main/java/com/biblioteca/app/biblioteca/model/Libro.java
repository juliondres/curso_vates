package com.biblioteca.app.biblioteca.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@NamedNativeQuery(name = "Libro.findByTitulo", query = "SELECT * FROM libro WHERE titulo = ?", resultClass = Libro.class)
@NamedNativeQuery(name = "Libro.findByAutor", query = "SELECT l.* FROM libro l, autor a, persona p WHERE l.autor_id = a.id and a.id = p.id and lower(p.nombre) = lower(:nombre) and lower(p.apellido) = lower(:apellido)", resultClass = Libro.class)
@NamedNativeQuery(name = "Libro.findByCategoria", query = "SELECT a.* FROM libro a, libro_categoria b, categoria c  WHERE a.id = b.libro_id and b.categoria_id = c.id and c.nombre = ?", resultClass = Libro.class)
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @OneToOne(cascade = CascadeType.ALL)
    private Autor autor;
    @Temporal(TemporalType.DATE)
    private Date fechaPublicacion;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "libro_categoria",
            joinColumns = @JoinColumn(name = "libro_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name="categoria_id", nullable = false)
    )
    private List<Categoria> categorias;
    @OneToOne(cascade = CascadeType.ALL)
    private Editorial editorial;

    private Integer cantidad;

    public Libro(){
    }

    public Libro(Long id) {
        this.id = id;
    }
    public Libro(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Libro(Long id, String titulo, Autor autor, Date fechaPublicacion, List<Categoria> categorias, Editorial editorial, Integer cantidad) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.categorias = categorias;
        this.editorial = editorial;
        this.cantidad = cantidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

}
