package ar.edu.unju.escmi.tp6.dominio;

/**
 * Alumno extiende Usuario.
 * - Atributos privados: nroLibreta (int) y curso (String)
 *
 * Alumno extiende Usuario porque comparte los mismos atributos
 * base (id, nombre, apellido, email) y añade información específica del alumno.
 */
public class Alumno extends Usuario {
    private int nroLibreta;   // según el diagrama: nroLibreta : integer
    private String curso;     // curso : string

    public Alumno(int id, String nombre, String apellido, String email, int nroLibreta, String curso) {
        super(id, nombre, apellido, email);
        this.nroLibreta = nroLibreta;
        this.curso = curso;
    }

    public int getNroLibreta() { return nroLibreta; }
    public String getCurso() { return curso; }

    @Override
    public void mostrarDatos() {
        System.out.println("Alumno -> ID: " + getId()
                + " | " + getNombre() + " " + getApellido()
                + " | Email: " + getEmail()
                + " | NroLibreta: " + nroLibreta
                + " | Curso: " + curso);
    }
}
