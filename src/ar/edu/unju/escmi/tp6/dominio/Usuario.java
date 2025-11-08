package ar.edu.unju.escmi.tp6.dominio;

public abstract class Usuario {
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

    // getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getEmail() { return email; }

    // setters (si necesitás modificar alguno)
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public void setEmail(String email) { this.email = email; }

    public abstract void mostrarDatos();

    @Override
    public String toString() {
        return "Usuario{id=" + id + ", nombre='" + nombre + "', apellido='" + apellido + "', email='" + email + "'}";
    }
}
