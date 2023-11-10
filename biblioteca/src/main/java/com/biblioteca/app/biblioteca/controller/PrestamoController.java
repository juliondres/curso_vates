package com.biblioteca.app.biblioteca.controller;

import com.biblioteca.app.biblioteca.model.Prestamo;
import com.biblioteca.app.biblioteca.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/prestamo")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @PostMapping("/")
    public Prestamo crearPrestamo(@RequestBody Prestamo prestamo){
      return prestamoService.crearPrestamo(prestamo);
    };

    @GetMapping("/devolver/{numeroPrestamo}")
    public Prestamo devolverPrestamo(@PathVariable Long numeroPrestamo){
        return prestamoService.devolverPrestamo(numeroPrestamo);
    }

}
