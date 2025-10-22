package ar.edu.unju.escmi.tp6.dominio;

import java.time.LocalDate;

public class Prestamo {
    private int id;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion; // puede ser null hasta la devolución
    private Libro libro;
    private Usuario usuario;

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

    public void registrarDevolucion(LocalDate fechaReal) {
        this.fechaDevolucion = fechaReal;
        if (libro != null) libro.registrarDevolucion(); // actualiza estado del libro
    }

    public void mostrarDatos() {
        System.out.println("Prestamo -> ID: " + id);
        System.out.println("  FechaPrestamo: " + fechaPrestamo);
        System.out.println("  FechaDevolucion: " + (fechaDevolucion == null ? "No devuelto" : fechaDevolucion));
        System.out.println("  Libro: " + libro.getTitulo() + " (ID " + libro.getId() + ")");
        System.out.println("  Usuario: " + usuario.getNombre() + " " + usuario.getApellido() + " (ID " + usuario.getId() + ")");
    }
}
