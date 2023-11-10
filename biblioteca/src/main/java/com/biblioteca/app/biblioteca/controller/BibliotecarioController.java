package com.biblioteca.app.biblioteca.controller;

import com.biblioteca.app.biblioteca.model.Libro;
import com.biblioteca.app.biblioteca.service.BibliotecarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bibliotecario")
public class BibliotecarioController {

    @Autowired
    private BibliotecarioService bibliotecarioService;

    @PostMapping("/libro")
    public Libro agregarLibro(@RequestBody Libro libro){
        return bibliotecarioService.agregarLibro(libro);
    }

    @PutMapping("/libro")
    public Libro modificarLibro(@RequestBody Libro libro){
        return bibliotecarioService.modificarLibro(libro);
    }

    @DeleteMapping("/libro/{id}")
    public void eliminarLibro(@PathVariable Long id){
        bibliotecarioService.eliminarLibro(id);
    }

/*
    @GetMapping("/reporte/{cantidadDeDias}")
    public String obtenerReporte(@PathVariable Integer cantidadDeDias){
        return bibliotecarioService.obtenerReporte(cantidadDeDias);
    }
*/
}
