package ar.edu.unju.escmi.tp6.dominio;

import java.time.LocalDate;

public class Prestamo {
    private int id;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion; // prevista o real (puede ser null si no devuelto aún)
    private Libro libro;   // dirección: Prestamo=libro (1)
    private Usuario usuario; // dirección: Prestamousuario (1)

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

    // registra la devolución real y actualiza el libro
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
