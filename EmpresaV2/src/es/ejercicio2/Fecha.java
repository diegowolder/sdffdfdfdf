package es.ejercicio2;

/**
 * Clase Fecha inmutable (solo lectura).
 * Representa una fecha simple con día, mes y año.
 * Una vez creada, sus valores no pueden modificarse.
 * 
 * @author diegowolder
 * @version 1.0
 */
public final class Fecha {

    /** Día del mes (1-31) */
    private final int dia;
    
    /** Mes del año (1-12) */
    private final int mes;
    
    /** Año */
    private final int año;

    /**
     * Constructor que crea una fecha con validaciones básicas.
     * 
     * @param dia Día del mes (debe estar entre 1 y 31)
     * @param mes Mes del año (debe estar entre 1 y 12)
     * @param año Año (debe ser mayor a 0)
     * @throws IllegalArgumentException si el mes, día o año están fuera de los rangos válidos
     */
    public Fecha(int dia, int mes, int año) {
        // Validación de año
        if (año <= 0) {
            throw new IllegalArgumentException("Año inválido: " + año + ". Debe ser mayor a 0.");
        }
        // Validación de mes
        if (mes < 1 || mes > 12) {
            throw new IllegalArgumentException("Mes inválido: " + mes + ". Debe estar entre 1 y 12.");
        }
        // Validación de día
        if (dia < 1 || dia > 31) {
            throw new IllegalArgumentException("Día inválido: " + dia + ". Debe estar entre 1 y 31.");
        }
        
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    /**
     * Obtiene el día de la fecha.
     * 
     * @return Día del mes
     */
    public int getDia() { return dia; }
    
    /**
     * Obtiene el mes de la fecha.
     * 
     * @return Mes del año
     */
    public int getMes() { return mes; }
    
    /**
     * Obtiene el año de la fecha.
     * 
     * @return Año
     */
    public int getAño() { return año; }

    /**
     * Devuelve una representación de la fecha en formato ISO 8601 (yyyy-MM-dd).
     * 
     * @return String con la fecha en formato "yyyy-MM-dd"
     */
    @Override
    public String toString() {
        String dd = (dia < 10) ? ("0" + dia) : String.valueOf(dia);
        String mm = (mes < 10) ? ("0" + mes) : String.valueOf(mes);
        return año + "-" + mm + "-" + dd;
    }

    /**
     * Compara esta fecha con otro objeto para verificar igualdad.
     * Dos fechas son iguales si tienen el mismo día, mes y año.
     * 
     * @param obj Objeto a comparar
     * @return true si las fechas son iguales, false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Fecha fecha = (Fecha) obj;
        return dia == fecha.dia && mes == fecha.mes && año == fecha.año;
    }

    /**
     * Genera un código hash para esta fecha.
     * 
     * @return Código hash basado en día, mes y año
     */
    @Override
    public int hashCode() {
        int result = dia;
        result = 31 * result + mes;
        result = 31 * result + año;
        return result;
    }
}

/*
 * POSIBLES MEJORAS PARA LA CLASE Fecha:
 * 
 * 1. Validación completa de fechas según el mes (febrero con 28/29 días, 
 *    meses con 30 o 31 días) y años bisiestos
 * 
 * 2. Añadir validación de rangos de años razonables (ej: entre 1900 y 2100)
 * 
 * 3. Implementar la interfaz Comparable<Fecha> para poder comparar fechas
 *    y ordenar empleados por fecha de contratación
 * 
 * 4. Añadir métodos útiles como:
 *    - calcularEdad(Fecha fechaNacimiento)
 *    - calcularAntiguedad(Fecha fechaContratacion)
 *    - esMayor(Fecha otraFecha)
 *    - diasEntre(Fecha otraFecha)
 * 
 * 5. Considerar usar LocalDate de java.time (Java 8+) en lugar de una clase propia,
 *    ya que está mejor implementada, validada y es el estándar moderno
 * 
 * 6. Añadir un constructor alternativo que acepte String con formato "yyyy-MM-dd"
 * 
 * 7. Implementar Serializable si se necesita persistir objetos Fecha
 */