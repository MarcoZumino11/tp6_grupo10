package ar.edu.unju.escmi.tp6.dominio;

public class Bibliotecario extends Usuario {
    private int legajo;

    public Bibliotecario(int id, String nombre, String apellido, String email, int legajo) {
        super(id, nombre, apellido, email);
        this.legajo = legajo;
    }

    public int getLegajo() { return legajo; }

    @Override
    public void mostrarDatos() {
        System.out.println("Bibliotecario -> ID: " + getId() + " | " + getNombre() + " " + getApellido() +
                           " | Email: " + getEmail() + " | Legajo: " + legajo);
    }
}
