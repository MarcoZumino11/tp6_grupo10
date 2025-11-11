package ar.edu.unju.escmi.tp6.dominio;

import java.time.LocalDate;

/**
 * Libro:
 * - Atributos privados: id, autor, titulo, isbn, estado (boolean).
 * - registrarDevolucion(LocalDate fecha): según el diagrama recibe la fecha.
 *
 * El estado booleano modela disponibilidad y registrarDevolucion
 * actualiza ese estado; si se quisiera almacenar fecha, se puede añadir un atributo fechaUltimaDevolucion.
 */
public class Libro {
    private int id;
    private String autor;
    private String titulo;
    private String isbn;
    private boolean estado; // true = disponible, false = prestado

    public Libro(int id, String autor, String titulo, String isbn, boolean estado) {
        this.id = id;
        this.autor = autor;
        this.titulo = titulo;
        this.isbn = isbn;
        this.estado = estado;
    }

    public int getId() { return id; }
    public String getAutor() { return autor; }
    public String getTitulo() { return titulo; }
    public String getIsbn() { return isbn; }
    public boolean isEstado() { return estado; }

    public void setEstado(boolean estado) { this.estado = estado; }

    public void mostrarDatos() {
        System.out.println("Libro -> ID: " + id
                + " | Titulo: " + titulo
                + " | Autor: " + autor
                + " | ISBN: " + isbn
                + " | Estado: " + (estado ? "Disponible" : "Prestado"));
    }

    /**
     * registrarDevolucion(in fecha: date) -> actualiza estado a disponible.
     * Si necesitás registrar la fecha, añadí un atributo LocalDate fechaUltimaDevolucion.
     */
    public void registrarDevolucion(LocalDate fecha) {
        this.estado = true;
        // Si se desea: guardar la fecha en un atributo (no especificado en el diagrama)
        // this.fechaUltimaDevolucion = fecha;
    }

    @Override
    public String toString() {
        return "Libro{id=" + id + ", titulo='" + titulo + "', autor='" + autor + "', isbn='" + isbn
                + "', estado=" + (estado ? "Disponible" : "Prestado") + "}";
    }
}
