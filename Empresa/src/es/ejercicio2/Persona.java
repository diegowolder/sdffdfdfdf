package es.ejercicio2;

/**
 * Clase Persona (sin comprobaciones adicionales de DNI).
 */
public abstract class Persona {

    private String nombre;
    private char sexo;
    private String dni;
    private Fecha fechaNac;

    public Persona() {
        this.nombre = null;
        this.sexo = '?';
        this.dni = null;
        this.fechaNac = null;
    }

    // Constructor a partir de argumentos (como pide el enunciado)
    public Persona(String nombre, char sexo, String dni, Fecha fechaNac) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.dni = dni;
        this.fechaNac = fechaNac;
    }

    // Getters y setters (tal como pide el enunciado)
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public char getSexo() { return sexo; }
    public void setSexo(char sexo) { this.sexo = sexo; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; } // sin comprobación

    public Fecha getFechaNac() { return fechaNac; }
    public void setFechaNac(Fecha fechaNac) { this.fechaNac = fechaNac; }

    @Override
    //No utilizamos este ToString de persona
    public String toString() {
        return "Persona-[nombre='" + nombre + "', sexo=" + sexo + ", dni='" + dni + "', fechaNac=" + fechaNac + "]";
    }
}