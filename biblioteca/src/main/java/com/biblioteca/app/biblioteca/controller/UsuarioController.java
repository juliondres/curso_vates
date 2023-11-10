package com.biblioteca.app.biblioteca.controller;

import com.biblioteca.app.biblioteca.model.Autor;
import com.biblioteca.app.biblioteca.model.Libro;
import com.biblioteca.app.biblioteca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/libro/titulo/{titulo}")
    public List<Libro> buscarLibroPorTitulo(@PathVariable String titulo){
        return usuarioService.buscarLibroPorTitulo(titulo);
    }

    @GetMapping("/libro/autor/{nombre}/{apellido}")
    public List<Libro> buscarLibroPorAutor(@PathVariable String nombre, @PathVariable String apellido){
        return usuarioService.buscarLibroPorAutor(nombre, apellido);
    }

    @GetMapping("/libro/categoria/{categoria}")
    public List<Libro> buscarLibroPorCategoria(@PathVariable String categoria){
        return usuarioService.buscarLibroPorCategoria(categoria);
    }

}
