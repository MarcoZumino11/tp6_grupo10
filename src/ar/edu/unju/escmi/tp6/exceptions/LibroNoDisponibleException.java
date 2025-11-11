package ar.edu.unju.escmi.tp6.exceptions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Excepción lanzada cuando un libro se intenta prestar pero no está disponible.
 * 
 * 
 * Hereda de Exception, pero además guarda la fecha y hora del error.
 * Tiene un método mostrarError() que imprime un mensaje más informativo.
 */
public class LibroNoDisponibleException extends Exception {
    private LocalDateTime fechaError; // Guarda cuándo ocurrió el error

    public LibroNoDisponibleException(String mensaje) {
        super(mensaje);
        this.fechaError = LocalDateTime.now();
    }

    public void mostrarError() {
        String hora = fechaError.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        System.out.println("[LibroNoDisponibleException] " + getMessage() + " | Hora: " + hora);
    }

    public LocalDateTime getFechaError() {
        return fechaError;
    }
}
