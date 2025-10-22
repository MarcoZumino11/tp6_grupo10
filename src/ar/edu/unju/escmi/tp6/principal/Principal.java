package ar.edu.unju.escmi.tp6.principal;

import ar.edu.unju.escmi.tp6.collections.*;
import ar.edu.unju.escmi.tp6.dominio.*;
import ar.edu.unju.escmi.tp6.exceptions.*;
import ar.edu.unju.escmi.tp6.utils.FechaUtil;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Principal {
    private static Scanner sc = new Scanner(System.in);
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
                    case "1": registrarLibro(); break;
                    case "2": registrarUsuario(); break;
                    case "3": prestarLibro(); break;
                    case "4": devolverLibro(); break;
                    case "5": listarLibros(); break;
                    case "6": listarUsuarios(); break;
                    case "7": listarPrestamos(); break;
                    case "8": System.out.println("Saliendo..."); salir = true; break;
                    default: System.out.println("Opción inválida.");
                }
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            } finally {
                System.out.println();
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("---- Biblioteca (TP6) ----");
        System.out.println("1 - Registrar libro");
        System.out.println("2 - Registrar usuario");
        System.out.println("3 - Prestar libro");
        System.out.println("4 - Devolver libro");
        System.out.println("5 - Listar libros");
        System.out.println("6 - Listar usuarios");
        System.out.println("7 - Listar préstamos");
        System.out.println("8 - Salir");
        System.out.print("Elija opción: ");
    }

    private static void registrarLibro() {
        try {
            System.out.print("Autor: ");
            String autor = sc.nextLine();
            System.out.print("Título: ");
            String titulo = sc.nextLine();
            System.out.print("ISBN: ");
            String isbn = sc.nextLine();
            Libro l = new Libro(contadorLibros++, autor, titulo, isbn, true);
            CollectionLibro.agregarLibro(l);
            System.out.println("Libro registrado correctamente. ID: " + l.getId());
        } catch (Exception e) {
            System.out.println("Error registrando libro: " + e.getMessage());
        }
    }

    private static void registrarUsuario() {
        try {
            System.out.print("¿Alumno (A) o Bibliotecario (B)? ");
            String tipo = sc.nextLine();
            System.out.print("Nombre: "); String nombre = sc.nextLine();
            System.out.print("Apellido: "); String apellido = sc.nextLine();
            System.out.print("Email: "); String email = sc.nextLine();
            if (tipo.equalsIgnoreCase("A")) {
                System.out.print("Nro libreta: "); String nro = sc.nextLine();
                System.out.print("Curso: "); String curso = sc.nextLine();
                Alumno a = new Alumno(contadorUsuarios++, nombre, apellido, email, nro, curso);
                CollectionUsuario.agregarUsuario(a);
                System.out.println("Alumno registrado. ID: " + a.getId());
            } else {
                System.out.print("Legajo (número): ");
                int legajo = Integer.parseInt(sc.nextLine());
                Bibliotecario b = new Bibliotecario(contadorUsuarios++, nombre, apellido, email, legajo);
                CollectionUsuario.agregarUsuario(b);
                System.out.println("Bibliotecario registrado. ID: " + b.getId());
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Formato inválido para legajo.");
        } catch (Exception e) {
            System.out.println("Error registrando usuario: " + e.getMessage());
        }
    }

    private static void prestarLibro() throws LibroNoEncontradoException, UsuarioNoRegistradoException, LibroNoDisponibleException {
        try {
            System.out.print("ID Libro a prestar: ");
            int idLibro = Integer.parseInt(sc.nextLine());
            Libro libro = CollectionLibro.buscarPorId(idLibro);
            if (libro == null) throw new LibroNoEncontradoException("No existe libro con ID " + idLibro);
            if (!libro.isEstado()) throw new LibroNoDisponibleException("El libro no está disponible.");

            System.out.print("ID Usuario: ");
            int idUsuario = Integer.parseInt(sc.nextLine());
            Usuario usuario = CollectionUsuario.buscarPorId(idUsuario);
            if (usuario == null) throw new UsuarioNoRegistradoException("Usuario con ID " + idUsuario + " no registrado.");

            System.out.print("Fecha préstamo (dd/MM/yyyy): ");
            String fechaP = sc.nextLine();
            LocalDate fechaPrestamo = FechaUtil.convertirStringLocalDate(fechaP);

            System.out.print("Fecha devolución prevista (dd/MM/yyyy): ");
            String fechaD = sc.nextLine();
            LocalDate fechaDevolucion = FechaUtil.convertirStringLocalDate(fechaD);

            // marcar libro como prestado y crear préstamo
            libro.setEstado(false);
            Prestamo p = new Prestamo(contadorPrestamos++, fechaPrestamo, fechaDevolucion, libro, usuario);
            CollectionPrestamo.agregarPrestamo(p);
            System.out.println("Préstamo registrado. ID préstamo: " + p.getId());
        } catch (NumberFormatException nfe) {
            System.out.println("ID inválido.");
        } catch (DateTimeParseException dtpe) {
            System.out.println("Formato de fecha inválido. Use dd/MM/yyyy.");
        }
    }

    private static void devolverLibro() {
        try {
            System.out.print("ID Préstamo a devolver: ");
            int idPrest = Integer.parseInt(sc.nextLine());
            Prestamo p = CollectionPrestamo.buscarPorId(idPrest);
            if (p == null) {
                System.out.println("No se encontró préstamo con ID " + idPrest);
                return;
            }
            System.out.print("Fecha real de devolución (dd/MM/yyyy): ");
            String fechaStr = sc.nextLine();
            LocalDate fechaReal = FechaUtil.convertirStringLocalDate(fechaStr);
            p.registrarDevolucion(fechaReal);
            System.out.println("Devolución registrada. Libro ID " + p.getLibro().getId() + " ahora disponible.");
        } catch (NumberFormatException nfe) {
            System.out.println("ID inválido.");
        } catch (DateTimeParseException dtpe) {
            System.out.println("Formato de fecha inválido.");
        } catch (Exception e) {
            System.out.println("Error en devolución: " + e.getMessage());
        }
    }

    private static void listarLibros() {
        if (CollectionLibro.libros.isEmpty()) {
            System.out.println("No hay libros.");
            return;
        }
        System.out.println("---- Libros ----");
        for (Libro l : CollectionLibro.libros) l.mostrarDatos();
    }

    private static void listarUsuarios() {
        if (CollectionUsuario.usuarios.isEmpty()) {
            System.out.println("No hay usuarios.");
            return;
        }
        System.out.println("---- Usuarios ----");
        for (Usuario u : CollectionUsuario.usuarios) u.mostrarDatos();
    }

    private static void listarPrestamos() {
        if (CollectionPrestamo.prestamos.isEmpty()) {
            System.out.println("No hay préstamos.");
            return;
        }
        System.out.println("---- Préstamos ----");
        for (Prestamo p : CollectionPrestamo.prestamos) p.mostrarDatos();
    }

    private static void cargarDatosDemo() {
        CollectionLibro.agregarLibro(new Libro(contadorLibros++, "Autor A", "Programación en Java", "111-AAA", true));
        CollectionLibro.agregarLibro(new Libro(contadorLibros++, "Autor B", "Algoritmos y Estructuras", "222-BBB", true));
        CollectionUsuario.agregarUsuario(new Alumno(contadorUsuarios++, "Juan", "Pérez", "juan@ejemplo.com", "L-100", "5to"));
        CollectionUsuario.agregarUsuario(new Bibliotecario(contadorUsuarios++, "Ana", "Gómez", "ana@ejemplo.com", 1234));
    }
}
