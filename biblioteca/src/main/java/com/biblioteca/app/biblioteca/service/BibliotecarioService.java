package com.biblioteca.app.biblioteca.service;

import com.biblioteca.app.biblioteca.model.Libro;

public interface BibliotecarioService {

    Libro agregarLibro(Libro libro);

    Libro modificarLibro(Libro libro);

    void eliminarLibro(Long id);

}
