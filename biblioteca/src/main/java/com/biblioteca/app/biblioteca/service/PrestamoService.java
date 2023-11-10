package com.biblioteca.app.biblioteca.service;

import com.biblioteca.app.biblioteca.model.Prestamo;

public interface PrestamoService {

    Prestamo crearPrestamo(Prestamo prestamo);
    Prestamo devolverPrestamo(Long id);
}
