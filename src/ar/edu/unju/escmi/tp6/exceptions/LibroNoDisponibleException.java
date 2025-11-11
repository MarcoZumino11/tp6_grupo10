package ar.edu.unju.escmi.tp6.exceptions;

/**
 * Excepción lanzada cuando se intenta prestar un libro que no está disponible.
 * Usar excepciones personalizadas mejora claridad y permite manejo específico.
 */
public class LibroNoDisponibleException extends Exception {
    public LibroNoDisponibleException(String mensaje) { super(mensaje); }
}
