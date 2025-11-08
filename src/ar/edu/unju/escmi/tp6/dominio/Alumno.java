package ar.edu.unju.escmi.tp6.dominio;

public class Alumno extends Usuario {
    private int nroLibreta;
    private String curso;

    public Alumno(int id, String nombre, String apellido, String email, int nroLibreta, String curso) {
        super(id, nombre, apellido, email);
        this.nroLibreta = nroLibreta;
        this.curso = curso;
    }

    public int getNroLibreta() { return nroLibreta; }
    public String getCurso() { return curso; }

    @Override
    public void mostrarDatos() {
        System.out.println("Alumno -> ID: " + getId() + " | " + getNombre() + " " + getApellido() +
                           " | Email: " + getEmail() + " | NroLibreta: " + nroLibreta + " | Curso: " + curso);
    }
}
