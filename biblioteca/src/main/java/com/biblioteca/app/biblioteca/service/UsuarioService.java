package com.biblioteca.app.biblioteca.service;

import com.biblioteca.app.biblioteca.model.Libro;

import java.util.List;

public interface UsuarioService {

    List<Libro> buscarLibroPorTitulo(String titulo);

    List<Libro> buscarLibroPorAutor(String nombre, String apellido);

    List<Libro> buscarLibroPorCategoria(String categoria);

}
