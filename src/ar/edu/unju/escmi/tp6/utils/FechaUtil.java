package ar.edu.unju.escmi.tp6.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Utilitario para parseo de fechas con formato dd/MM/yyyy.
 * Centralizar el parseo permite control y manejo de errores consistente.
 */
public class FechaUtil {
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static LocalDate convertirStringLocalDate(String fechaStr) throws DateTimeParseException {
        return LocalDate.parse(fechaStr, FORMATO);
    }
}
