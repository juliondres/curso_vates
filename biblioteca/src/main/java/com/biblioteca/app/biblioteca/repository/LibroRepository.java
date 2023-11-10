package com.biblioteca.app.biblioteca.repository;

import com.biblioteca.app.biblioteca.model.Autor;
import com.biblioteca.app.biblioteca.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

    List<Libro> findByTitulo(String titulo);

    List<Libro> findByAutor(String nombre, String apellido);

    List<Libro> findByCategoria(String categoria);
}
