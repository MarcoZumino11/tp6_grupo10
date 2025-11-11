package ar.edu.unju.escmi.tp6.collections;

import ar.edu.unju.escmi.tp6.dominio.Libro;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * Clase que simula el repositorio de libros en memoria.
 * - Métodos: registrarLibro, mostrarLibros, buscarPorId, eliminarLibro.
 *
 * Estas clases Collections están separadas para respetar SRP (Single Responsibility).
 * Permiten centralizar operaciones sobre las listas.
 */
public class CollectionLibro {
    // lista privada estática: se simula un almacenamiento global en memoria
    private static final List<Libro> libros = new ArrayList<>();

    public static void registrarLibro(Libro libro) {
        libros.add(libro);
    }

    public static List<Libro> obtenerLibros() {
        return new ArrayList<>(libros); // devolvemos copia para no exponer la lista interna
    }

    public static void mostrarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }
        for (Libro l : libros) l.mostrarDatos();
    }

    public static Libro buscarPorId(int id) {
        for (Libro l : libros) if (l.getId() == id) return l;
        return null;
    }

    public static boolean eliminarLibro(int id) {
        Iterator<Libro> it = libros.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.remove();
                return true;
            }
        }
        return false;
    }
}
