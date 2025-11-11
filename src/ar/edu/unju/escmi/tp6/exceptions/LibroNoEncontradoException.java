package ar.edu.unju.escmi.tp6.exceptions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Excepción lanzada cuando el sistema no encuentra un libro según el ID.
 * 
 * 
 * git Incluye atributos y métodos propios para brindar contexto adicional.
 */
public class LibroNoEncontradoException extends Exception {
    private LocalDateTime fechaError;

    public LibroNoEncontradoException(String mensaje) {
        super(mensaje);
        this.fechaError = LocalDateTime.now();
    }

    public void mostrarError() {
        String hora = fechaError.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        System.out.println("[LibroNoEncontradoException] " + getMessage() + " | Hora: " + hora);
    }

    public LocalDateTime getFechaError() {
        return fechaError;
    }
}
