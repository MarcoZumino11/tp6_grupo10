package ar.edu.unju.escmi.tp6.collections;

import ar.edu.unju.escmi.tp6.dominio.Prestamo;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class CollectionPrestamo {
    private static final List<Prestamo> prestamos = new ArrayList<>();

    public static void registrarPrestamo(Prestamo p) {
        prestamos.add(p);
    }

    public static List<Prestamo> obtenerPrestamos() {
        return new ArrayList<>(prestamos);
    }

    public static void mostrarPrestamos() {
        if (prestamos.isEmpty()) {
            System.out.println("No hay préstamos registrados.");
            return;
        }
        for (Prestamo p : prestamos) p.mostrarDatos();
    }

    public static Prestamo buscarPorId(int id) {
        for (Prestamo p : prestamos) if (p.getId() == id) return p;
        return null;
    }

    public static boolean eliminarPrestamo(int id) {
        Iterator<Prestamo> it = prestamos.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.remove();
                return true;
            }
        }
        return false;
    }
}
