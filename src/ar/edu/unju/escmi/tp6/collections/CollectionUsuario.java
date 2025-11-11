package ar.edu.unju.escmi.tp6.collections;

import ar.edu.unju.escmi.tp6.dominio.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 * Repositorio en memoria para usuarios.
 * - registrarUsuario, mostrarUsuarios, buscarPorId, eliminarUsuario.
 *
 * Separa la gestión de usuarios de la lógica de negocio (Principal).
 */
public class CollectionUsuario {
    private static final List<Usuario> usuarios = new ArrayList<>();

    public static void registrarUsuario(Usuario u) {
        usuarios.add(u);
    }

    public static List<Usuario> obtenerUsuarios() {
        return new ArrayList<>(usuarios);
    }

    public static void mostrarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }
        for (Usuario u : usuarios) u.mostrarDatos();
    }

    public static Usuario buscarPorId(int id) {
        for (Usuario u : usuarios) if (u.getId() == id) return u;
        return null;
    }

    public static boolean eliminarUsuario(int id) {
        return usuarios.removeIf(u -> u.getId() == id);
    }
}
