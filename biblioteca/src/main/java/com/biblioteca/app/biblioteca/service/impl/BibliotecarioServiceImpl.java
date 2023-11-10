package com.biblioteca.app.biblioteca.service.impl;

import com.biblioteca.app.biblioteca.model.Libro;
import com.biblioteca.app.biblioteca.repository.LibroRepository;
import com.biblioteca.app.biblioteca.service.BibliotecarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BibliotecarioServiceImpl implements BibliotecarioService {

    @Autowired
    private LibroRepository libroRepository;

    @Override
    public Libro agregarLibro(Libro libro){
        return libroRepository.save(libro);
    }
    @Override
    public Libro modificarLibro(Libro libro){
        return libroRepository.save(libro);
    }
    @Override
    public void eliminarLibro(Long id){
        Libro libro = new Libro(id);
        libroRepository.delete(libro);
    }

}
