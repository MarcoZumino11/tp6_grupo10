package ar.edu.unju.escmi.tp6.collections;

import ar.edu.unju.escmi.tp6.dominio.Usuario;
import java.util.ArrayList;
import java.util.List;

public class CollectionUsuario {
    public static List<Usuario> usuarios = new ArrayList<>();

    public static void agregarUsuario(Usuario u) { usuarios.add(u); }

    public static Usuario buscarPorId(int id) {
        for (Usuario u : usuarios) if (u.getId() == id) return u;
        return null;
    }
}
