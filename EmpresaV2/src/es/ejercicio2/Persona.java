package es.ejercicio2;

/**
 * Clase abstracta Persona (sin comprobaciones adicionales de DNI).
 * Representa los datos básicos de una persona en el sistema.
 * Esta clase no puede ser instanciada directamente, debe ser extendida.
 * 
 * @author diegowolder
 * @version 1.0
 */
public abstract class Persona {

    /** Nombre de la persona */
    private String nombre;
    
    /** Sexo de la persona (MASCULINO, FEMENINO, DESCONOCIDO) */
    private Sexo sexo;
    
    /** DNI de la persona (sin validación) */
    private String dni;
    
    /** Fecha de nacimiento de la persona */
    private Fecha fechaNac;
    
    /**
     * Enumeración que representa el sexo de una persona.
     */
    public static enum Sexo {
        /** Sexo masculino */
        MASCULINO,
        /** Sexo femenino */
        FEMENINO, 
        /** Sexo desconocido o no especificado */
        DESCONOCIDO;
    }

    /**
     * Constructor por defecto que inicializa los atributos a valores nulos o por defecto.
     */
    public Persona() {
        this.nombre = null;
        this.dni = null;
        this.fechaNac = null;
        this.sexo = Sexo.DESCONOCIDO;
    }

    /**
     * Constructor parametrizado que permite inicializar todos los atributos.
     * 
     * @param nombre Nombre de la persona
     * @param sexo Sexo de la persona (MASCULINO, FEMENINO, DESCONOCIDO)
     * @param dni DNI de la persona (sin validación de formato)
     * @param fechaNac Fecha de nacimiento de la persona
     */
    public Persona(String nombre, Sexo sexo, String dni, Fecha fechaNac) {
        this.nombre = nombre;
        this.sexo = (sexo != null) ? sexo : Sexo.DESCONOCIDO;
        this.dni = dni;
        this.fechaNac = fechaNac;
    }

    /**
     * Obtiene el nombre de la persona.
     * 
     * @return Nombre de la persona
     */
    public String getNombre() { return nombre; }
    
    /**
     * Establece el nombre de la persona.
     * 
     * @param nombre Nuevo nombre de la persona
     */
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }

    /**
     * Obtiene el sexo de la persona.
     * 
     * @return Sexo de la persona
     */
    public Sexo getSexo() { return sexo; }
    
    /**
     * Establece el sexo de la persona.
     * Si se pasa null, se asigna DESCONOCIDO por defecto.
     * 
     * @param sexo Nuevo sexo de la persona
     */
    public void setSexo(Sexo sexo) { 
        this.sexo = (sexo != null) ? sexo : Sexo.DESCONOCIDO;
    }

    /**
     * Obtiene el DNI de la persona.
     * 
     * @return DNI de la persona
     */
    public String getDni() { return dni; }
    
    /**
     * Establece el DNI de la persona (sin validación de formato).
     * 
     * @param dni Nuevo DNI de la persona
     */
    public void setDni(String dni) { this.dni = dni; }

    /**
     * Obtiene la fecha de nacimiento de la persona.
     * 
     * @return Fecha de nacimiento
     */
    public Fecha getFechaNac() { return fechaNac; }
    
    /**
     * Establece la fecha de nacimiento de la persona.
     * 
     * @param fechaNac Nueva fecha de nacimiento
     */
    public void setFechaNac(Fecha fechaNac) { this.fechaNac = fechaNac; }

}

/*
 * POSIBLES MEJORAS PARA LA CLASE Persona:
 * 
 * 1. Añadir validación del DNI español (8 dígitos + letra calculada) en el setter
 *    o crear un método validarDNI()
 * 
 * 2. Validar que el nombre no sea nulo o vacío, y que contenga solo caracteres válidos
 * 
 * 3. Implementar toString() para facilitar la depuración (aunque las subclases
 *    ya lo implementan, sería útil tener una versión base)
 * 
 * 4. Considerar hacer los atributos finales y eliminar setters para mayor inmutabilidad
 *    (si el diseño lo permite)
 * 
 * 5. Sobrescribir equals() y hashCode() basándose en el DNI (identificador único)
 * 
 * 6. Añadir validación en el constructor para evitar objetos en estados inconsistentes
 * 
 * 7. Crear constantes para valores por defecto en lugar de usar null
 * 
 * 8. Añadir método calcularEdad() que use fechaNac y devuelva la edad actual
 * 
 * 9. Considerar cambiar el enum Sexo a una clase separada o usar constantes
 *    más inclusivas si es necesario
 * 
 * 10. Documentar mejor con Javadoc qué subclases deben implementar y cómo usarlas
 */