package ar.edu.unju.escmi.tp6.dominio;

/**
 * Bibliotecario extiende Usuario.
 * - El atributo legajo es privado (integer).
 * - No mantenemos referencia directa a Libro: la gestión se hace a través de las Collections.
 *
 * Esto responde al feedback del profesor: el bibliotecario no debe llevar
 * referencias permanentes a objetos Libro; su rol es gestionar mediante operaciones.
 */
public class Bibliotecario extends Usuario {
    private int legajo;

    public Bibliotecario(int id, String nombre, String apellido, String email, int legajo) {
        super(id, nombre, apellido, email);
        this.legajo = legajo;
    }

    public int getLegajo() { return legajo; }

    @Override
    public void mostrarDatos() {
        System.out.println("Bibliotecario -> ID: " + getId()
                + " | " + getNombre() + " " + getApellido()
                + " | Email: " + getEmail()
                + " | Legajo: " + legajo);
    }
}
