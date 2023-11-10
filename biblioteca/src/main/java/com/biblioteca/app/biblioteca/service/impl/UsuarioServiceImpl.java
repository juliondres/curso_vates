package com.biblioteca.app.biblioteca.service.impl;

import com.biblioteca.app.biblioteca.model.Libro;
import com.biblioteca.app.biblioteca.repository.LibroRepository;
import com.biblioteca.app.biblioteca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    LibroRepository libroRepository;

    @Override
    public List<Libro> buscarLibroPorTitulo(String titulo){
        return libroRepository.findByTitulo(titulo);
    }
    @Override
    public List<Libro> buscarLibroPorAutor(String nombre, String apellido){
        return libroRepository.findByAutor(nombre, apellido);
    }
    @Override
    public List<Libro> buscarLibroPorCategoria(String categoria){
        return libroRepository.findByCategoria(categoria);
    }
}
