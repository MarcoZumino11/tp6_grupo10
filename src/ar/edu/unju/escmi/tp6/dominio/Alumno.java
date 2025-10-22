package ar.edu.unju.escmi.tp6.dominio;

public class Alumno extends Usuario {
    private String nroLibreta;
    private String curso;

    public Alumno(int id, String nombre, String apellido, String email, String nroLibreta, String curso) {
        super(id, nombre, apellido, email);
        this.nroLibreta = nroLibreta;
        this.curso = curso;
    }

    public String getNroLibreta() { return nroLibreta; }
    public String getCurso() { return curso; }

    @Override
    public void mostrarDatos() {
        System.out.println("Alumno -> ID: " + id + " | " + nombre + " " + apellido + " | Email: " + email +
                           " | NroLibreta: " + nroLibreta + " | Curso: " + curso);
    }
}
