package ar.edu.unju.escmi.tp6.collections;

import ar.edu.unju.escmi.tp6.dominio.Prestamo;
import java.util.ArrayList;
import java.util.List;

public class CollectionPrestamo {
    public static List<Prestamo> prestamos = new ArrayList<>();

    public static void agregarPrestamo(Prestamo p) { prestamos.add(p); }

    public static Prestamo buscarPorId(int id) {
        for (Prestamo p : prestamos) if (p.getId() == id) return p;
        return null;
    }
}
