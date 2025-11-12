package ar.edu.unju.escmi.tp6.principal;

import ar.edu.unju.escmi.tp6.collections.CollectionLibro;
import ar.edu.unju.escmi.tp6.collections.CollectionPrestamo;
import ar.edu.unju.escmi.tp6.collections.CollectionUsuario;
import ar.edu.unju.escmi.tp6.dominio.*;
import ar.edu.unju.escmi.tp6.exceptions.*;
import ar.edu.unju.escmi.tp6.utils.FechaUtil;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * Clase Principal con menú por consola corregida.
 * - Maneja excepciones personalizadas y usa los métodos mostrarError() si existen.
 * - Usa nombres claros: isDisponible() en Libro, methods registrarX en Collections.
 */
public class Principal {
    private static final Scanner sc = new Scanner(System.in);
    private static int contadorLibros = 1;
    private static int contadorUsuarios = 1;
    private static int contadorPrestamos = 1;

    public static void main(String[] args) {
        cargarDatosDemo();
        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            String opcion = sc.nextLine();
            try {
                switch (opcion) {
                    case "1": altaLibro(); break;
                    case "2": altaUsuario(); break;
                    case "3": prestarLibro(); break;
                    case "4": devolverLibro(); break;
                    case "5": CollectionLibro.mostrarLibros(); break;
                    case "6": CollectionUsuario.mostrarUsuarios(); break;
                    case "7": CollectionPrestamo.mostrarPrestamos(); break;
                    case "8": System.out.println("Saliendo..."); salir = true; break;
                    default: System.out.println("Opción inválida.");
                }
            } catch (LibroNoEncontradoException e) {
                // Excepción personalizada: mostrar detalle con método propio si existe
                e.mostrarError();
            } catch (LibroNoDisponibleException e) {
                e.mostrarError();
            } catch (UsuarioNoRegistradoException e) {
                e.mostrarError();
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha inválido. Use dd/MM/yyyy.");
            } catch (NumberFormatException e) {
                System.out.println("ID inválido (debe ser número).");
            } catch (Exception e) {
                // Catch genérico por si surge otro error inesperado
                System.out.println("Ocurrió un error: " + e.getMessage());
            } finally {
                System.out.println();
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("---- Biblioteca (TP6) ----");
        System.out.println("1 - Alta Libro");
        System.out.println("2 - Alta Usuario");
        System.out.println("3 - Prestar Libro");
        System.out.println("4 - Devolver Libro");
        System.out.println("5 - Mostrar Libros");
        System.out.println("6 - Mostrar Usuarios");
        System.out.println("7 - Mostrar Prestamos");
        System.out.println("8 - Salir");
        System.out.print("Opción: ");
    }

    private static void altaLibro() {
        System.out.print("Autor: "); String autor = sc.nextLine();
        System.out.print("Titulo: "); String titulo = sc.nextLine();
        System.out.print("ISBN: "); String isbn = sc.nextLine();
        Libro l = new Libro(contadorLibros++, autor, titulo, isbn, true);
        CollectionLibro.registrarLibro(l);
        System.out.println("Libro registrado ID: " + l.getId());
    }

    private static void altaUsuario() {
        System.out.print("¿Alumno (A) o Bibliotecario (B)? "); String tipo = sc.nextLine();
        System.out.print("Nombre: "); String nombre = sc.nextLine();
        System.out.print("Apellido: "); String apellido = sc.nextLine();
        System.out.print("Email: "); String email = sc.nextLine();

        if (tipo.equalsIgnoreCase("A")) {
            System.out.print("Nro Libreta (num): "); int nro = Integer.parseInt(sc.nextLine());
            System.out.print("Curso: "); String curso = sc.nextLine();
            Alumno a = new Alumno(contadorUsuarios++, nombre, apellido, email, nro, curso);
            CollectionUsuario.registrarUsuario(a);
            System.out.println("Alumno registrado ID: " + a.getId());
        } else {
            System.out.print("Legajo (num): "); int legajo = Integer.parseInt(sc.nextLine());
            Bibliotecario b = new Bibliotecario(contadorUsuarios++, nombre, apellido, email, legajo);
            CollectionUsuario.registrarUsuario(b);
            System.out.println("Bibliotecario registrado ID: " + b.getId());
        }
    }

    private static void prestarLibro() throws LibroNoEncontradoException, UsuarioNoRegistradoException, LibroNoDisponibleException {
        System.out.print("ID Libro a prestar: "); int idLibro = Integer.parseInt(sc.nextLine());
        Libro libro = CollectionLibro.buscarPorId(idLibro);
        if (libro == null) throw new LibroNoEncontradoException("Libro no encontrado ID " + idLibro);
        if (!libro.isDisponible()) throw new LibroNoDisponibleException("Libro no disponible (ya prestado).");

        System.out.print("ID Usuario: "); int idUsuario = Integer.parseInt(sc.nextLine());
        Usuario usuario = CollectionUsuario.buscarPorId(idUsuario);
        if (usuario == null) throw new UsuarioNoRegistradoException("Usuario no registrado ID " + idUsuario);

        System.out.print("Fecha prestamo (dd/MM/yyyy): "); String fP = sc.nextLine();
        LocalDate fechaPrestamo = FechaUtil.convertirStringLocalDate(fP);

        System.out.print("Fecha devolucion prevista (dd/MM/yyyy): "); String fD = sc.nextLine();
        LocalDate fechaDevolucion = FechaUtil.convertirStringLocalDate(fD);

        libro.setDisponible(false); // marcar como prestado
        Prestamo p = new Prestamo(contadorPrestamos++, fechaPrestamo, fechaDevolucion, libro, usuario);
        CollectionPrestamo.registrarPrestamo(p);
        System.out.println("Prestamo registrado ID: " + p.getId());
    }

    private static void devolverLibro() {
        System.out.print("ID Prestamo a devolver: "); int idPrest = Integer.parseInt(sc.nextLine());
        Prestamo p = CollectionPrestamo.buscarPorId(idPrest);
        if (p == null) {
            System.out.println("No existe préstamo con ID " + idPrest);
            return;
        }
        System.out.print("Fecha real de devolución (dd/MM/yyyy): "); String fReal = sc.nextLine();
        LocalDate fechaReal = FechaUtil.convertirStringLocalDate(fReal);
        p.registrarDevolucion(fechaReal);
        System.out.println("Devolución registrada. Libro ID " + p.getLibro().getId() + " disponible.");
    }

    private static void cargarDatosDemo() {
        CollectionLibro.registrarLibro(new Libro(contadorLibros++, "Autor A", "Programacion Java", "111-AAA", true));
        CollectionLibro.registrarLibro(new Libro(contadorLibros++, "Autor B", "Estructuras Datos", "222-BBB", true));
        CollectionUsuario.registrarUsuario(new Alumno(contadorUsuarios++, "Juan", "Perez", "juan@ejemplo.com", 100, "5to"));
        CollectionUsuario.registrarUsuario(new Bibliotecario(contadorUsuarios++, "Ana", "Gomez", "ana@ejemplo.com", 123));
    }
}
