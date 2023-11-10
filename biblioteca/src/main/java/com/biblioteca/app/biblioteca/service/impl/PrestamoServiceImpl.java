package com.biblioteca.app.biblioteca.service.impl;

import com.biblioteca.app.biblioteca.model.Devolucion;
import com.biblioteca.app.biblioteca.model.Libro;
import com.biblioteca.app.biblioteca.model.Multa;
import com.biblioteca.app.biblioteca.model.Prestamo;
import com.biblioteca.app.biblioteca.repository.LibroRepository;
import com.biblioteca.app.biblioteca.repository.PrestamoRepository;
import com.biblioteca.app.biblioteca.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
@Service
public class PrestamoServiceImpl implements PrestamoService {
    @Autowired
    PrestamoRepository prestamoRepository;

    @Autowired
    LibroRepository libroRepository;

    private void modificarCantidad(List<Libro> libros, Integer cantidad){
        libros.forEach(libroPrestamo -> {
            Libro libro = libroRepository.findById(libroPrestamo.getId()).orElse(new Libro(0));
            Integer cantidadLibro = libro.getCantidad() + cantidad;
            if(cantidad > 0){
                libro.setCantidad(cantidadLibro);
                libroRepository.save(libro);
            } else {
                if(cantidadLibro >= 0) {
                    libro.setCantidad(cantidadLibro);
                    libroRepository.save(libro);
                }
            }
        });
    }
    @Override
    public Prestamo crearPrestamo(Prestamo prestamo){

        modificarCantidad(prestamo.getLibros(),-1);
        Prestamo prestamoResponse =  prestamoRepository.save(prestamo);
        return prestamoRepository.findById(prestamoResponse.getId()).orElse(null);
    }
    @Override
    public Prestamo devolverPrestamo(Long id){

        Prestamo prestamo = prestamoRepository.findById(id).orElse(new Prestamo());

        if(prestamo.getDevolucion() == null){
            Devolucion devolucion = new Devolucion();
            devolucion.setFechaDevolucion(new Date());
            modificarCantidad(prestamo.getLibros(),1);
            long diferenciaDeDiasEnMilis = devolucion.getFechaDevolucion().getTime()-prestamo.getFechaDevolucion().getTime();
            long cantidadDeDias = TimeUnit.DAYS.convert(diferenciaDeDiasEnMilis, TimeUnit.MILLISECONDS);
            if(cantidadDeDias>0){
                Multa multa = new Multa();
                multa.setUsuario(prestamo.getUsuario());
                Double monto = Double.valueOf(2*cantidadDeDias);
                multa.setMonto(monto);
                multa.setFechaInfraccion(new Date());
                multa.setMotivo("Excede la fecha de devolucion en: ".concat(String.valueOf(cantidadDeDias)).concat(" Dias"));
                devolucion.setMulta(multa);
            }
            prestamo.setDevolucion(devolucion);

            prestamo = prestamoRepository.save(prestamo);
        }
        return prestamo;
    }
}
