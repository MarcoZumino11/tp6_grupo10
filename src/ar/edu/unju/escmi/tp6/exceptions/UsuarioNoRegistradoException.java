package ar.edu.unju.escmi.tp6.exceptions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Excepción lanzada cuando un usuario no está registrado en el sistema.
 * 
 * 
 *  Implementa lógica propia para identificar el momento del error.
 *  Mejora el manejo de errores mostrando mensajes más claros.
 */
public class UsuarioNoRegistradoException extends Exception {
    private LocalDateTime fechaError;

    public UsuarioNoRegistradoException(String mensaje) {
        super(mensaje);
        this.fechaError = LocalDateTime.now();
    }

    public void mostrarError() {
        String hora = fechaError.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        System.out.println("[UsuarioNoRegistradoException] " + getMessage() + " | Hora: " + hora);
    }

    public LocalDateTime getFechaError() {
        return fechaError;
    }
}
