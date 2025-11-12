package ar.edu.unju.escmi.tp6.dominio;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Libro:
 * - Atributos privados: id, autor, titulo, isbn, disponible (boolean).
 * - registrarDevolucion(LocalDate fecha): según el diagrama recibe la fecha y actualiza estado y fechaUltimaDevolucion.
 */
public class Libro {
    private final int id;
    private String autor;
    private String titulo;
    private String isbn;
    private boolean disponible; // true = disponible, false = prestado
    private LocalDate fechaUltimaDevolucion; // opcional, para trazabilidad

    public Libro(int id, String autor, String titulo, String isbn, boolean disponible) {
        if (titulo == null || titulo.isBlank()) throw new IllegalArgumentException("Título no puede ser vacío");
        if (autor == null || autor.isBlank()) throw new IllegalArgumentException("Autor no puede ser vacío");
        this.id = id;
        this.autor = autor;
        this.titulo = titulo;
        this.isbn = isbn;
        this.disponible = disponible;
    }

    // Getters
    public int getId() { return id; }
    public String getAutor() { return autor; }
    public String getTitulo() { return titulo; }
    public String getIsbn() { return isbn; }
    public boolean isDisponible() { return disponible; }
    public LocalDate getFechaUltimaDevolucion() { return fechaUltimaDevolucion; }

    // Setters para campos editables si se necesitan (ej.: corregir datos)
    public void setAutor(String autor) {
        if (autor == null || autor.isBlank()) throw new IllegalArgumentException("Autor no puede ser vacío");
        this.autor = autor;
    }
    public void setTitulo(String titulo) {
        if (titulo == null || titulo.isBlank()) throw new IllegalArgumentException("Título no puede ser vacío");
        this.titulo = titulo;
    }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    public void mostrarDatos() {
        System.out.println("Libro -> ID: " + id
                + " | Titulo: " + titulo
                + " | Autor: " + autor
                + " | ISBN: " + isbn
                + " | Estado: " + (disponible ? "Disponible" : "Prestado")
                + (fechaUltimaDevolucion != null ? " | Últ. devolución: " + fechaUltimaDevolucion : ""));
    }

    /**
     * registrarDevolucion(in fecha: date) -> actualiza estado a disponible y guarda la fecha.
     */
    public void registrarDevolucion(LocalDate fecha) {
        this.disponible = true;
        this.fechaUltimaDevolucion = fecha;
    }

    @Override
    public String toString() {
        return String.format("Libro{id=%d, titulo='%s', autor='%s', isbn='%s', estado=%s}",
                id, titulo, autor, isbn, (disponible ? "Disponible" : "Prestado"));
    }

    // equals y hashCode basados en id o isbn (según criterio)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Libro)) return false;
        Libro libro = (Libro) o;
        return id == libro.id; // o Objects.equals(isbn, libro.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
