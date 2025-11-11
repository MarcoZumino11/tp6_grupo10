package ar.edu.unju.escmi.tp6.dominio;

import java.time.LocalDate;

/**
 * Prestamo:
 * - Dirección clara: Prestamo -> Libro y Prestamo -> Usuario (cada prestamo referencia uno de cada).
 * - fechaDevolucion puede ser null hasta que se devuelva.
 *
 * Enfatizá la dirección (no hay colección de préstamos dentro de Usuario),
 * esto cumple el feedback del profe sobre la dirección de las relaciones.
 */
public class Prestamo {
    private int id;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion; // prevista o real; puede ser null
    private Libro libro;    // relación: Prestamo -> Libro (1)
    private Usuario usuario; // relación: Prestamo -> Usuario (1)

    public Prestamo(int id, LocalDate fechaPrestamo, LocalDate fechaDevolucion, Libro libro, Usuario usuario) {
        this.id = id;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.libro = libro;
        this.usuario = usuario;
    }

    public int getId() { return id; }
    public LocalDate getFechaPrestamo() { return fechaPrestamo; }
    public LocalDate getFechaDevolucion() { return fechaDevolucion; }
    public Libro getLibro() { return libro; }
    public Usuario getUsuario() { return usuario; }

    /**
     * Registra la devolución real y delega la actualización del estado del libro.
     * Defensa: muestra separación de responsabilidades: Prestamo registra la devolución,
     * y Libro se ocupa de su propio estado.
     */
    public void registrarDevolucion(LocalDate fechaReal) {
        this.fechaDevolucion = fechaReal;
        if (libro != null) {
            libro.registrarDevolucion(fechaReal);
        }
    }

    public void mostrarDatos() {
        System.out.println("Prestamo -> ID: " + id);
        System.out.println("  FechaPrestamo: " + fechaPrestamo);
        System.out.println("  FechaDevolucion: " + (fechaDevolucion == null ? "No devuelto" : fechaDevolucion));
        System.out.println("  Libro: " + (libro != null ? libro.getTitulo() + " (ID " + libro.getId() + ")" : "N/A"));
        System.out.println("  Usuario: " + usuario.getNombre() + " " + usuario.getApellido() + " (ID " + usuario.getId() + ")");
    }
}
