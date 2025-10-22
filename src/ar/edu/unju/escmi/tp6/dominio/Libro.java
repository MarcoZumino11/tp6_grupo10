package ar.edu.unju.escmi.tp6.dominio;

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
        System.out.println("Libro -> ID: " + id + " | Titulo: " + titulo + " | Autor: " + autor +
                           " | ISBN: " + isbn + " | Estado: " + (estado ? "Disponible" : "No disponible"));
    }

    // Método indicado en el diagrama: registrarDevolucion (simple: marca disponible)
    public void registrarDevolucion() {
        this.estado = true;
    }

    @Override
    public String toString() {
        return "Libro{id=" + id + ", autor='" + autor + "', titulo='" + titulo + "', isbn='" + isbn +
               "', estado=" + (estado ? "Disponible" : "No disponible") + "}";
    }
}
