package ar.edu.unju.escmi.tp6.dominio;

/**
 * Clase abstracta Usuario.
 * - Es abstracta porque no tiene sentido instanciar un "Usuario" genérico.
 * - Las subclases (Alumno, Bibliotecario) implementan mostrarDatos().
 *
 * Principio de abstracción y reutilización.
 */
public abstract class Usuario {
    // ATRIBUTOS privados por encapsulamiento (requisito del TP/rúbrica)
    private int id;
    private String nombre;
    private String apellido;
    private String email;

    public Usuario(int id, String nombre, String apellido, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    // Getters (acceso controlado)
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getEmail() { return email; }

    // Setters si algún flujo necesita actualizar (ej.: corregir email)
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public void setEmail(String email) { this.email = email; }

    // Método abstracto: obliga a las subclases a implementar mostrarDatos()
    public abstract void mostrarDatos();

    @Override
    public String toString() {
        return "Usuario{id=" + id + ", nombre='" + nombre + "', apellido='" + apellido + "', email='" + email + "'}";
    }
}
