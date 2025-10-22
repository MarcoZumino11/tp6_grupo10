package ar.edu.unju.escmi.tp6.dominio;

public abstract class Usuario {
    protected int id;
    protected String nombre;
    protected String apellido;
    protected String email;

    public Usuario(int id, String nombre, String apellido, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getEmail() { return email; }

    public abstract void mostrarDatos();

    @Override
    public String toString() {
        return "Usuario{id=" + id + ", nombre='" + nombre + "', apellido='" + apellido + "', email='" + email + "'}";
    }
}
