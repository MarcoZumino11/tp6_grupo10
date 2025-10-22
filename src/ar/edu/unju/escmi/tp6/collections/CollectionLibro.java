package ar.edu.unju.escmi.tp6.collections;

import ar.edu.unju.escmi.tp6.dominio.Libro;
import java.util.ArrayList;
import java.util.List;

public class CollectionLibro {
    public static List<Libro> libros = new ArrayList<>();

    public static void agregarLibro(Libro l) { libros.add(l); }

    public static Libro buscarPorId(int id) {
        for (Libro l : libros) if (l.getId() == id) return l;
        return null;
    }
}
