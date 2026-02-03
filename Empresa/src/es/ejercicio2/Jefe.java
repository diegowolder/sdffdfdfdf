package es.ejercicio2;

/**
 * Clase Jefe que extiende Empleado.
 */
public class Jefe extends Empleado {

    private String departamento;
    private int numSubordinados;

    public Jefe() {
        super();
        this.departamento = null;
        this.numSubordinados = 0;
    }

    /**
     * Constructor solicitado por el enunciado: nombre, sexo, fechaContratacion,
     * sueldo, departamento
     *
     * @param nombre
     * @param sexo
     * @param fechaContratacion
     * @param sueldo
     * @param departamento
     */
    public Jefe(String nombre, char sexo, Fecha fechaContratacion, double sueldo, String departamento) {
        super(nombre, sexo, fechaContratacion, sueldo);
        this.departamento = departamento;
        this.numSubordinados = 0;
        // numEmpleado ya se asignó en el constructor de Empleado
    }

    // Getters y setters (tal como pide el enunciado)
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getNumSubordinados() {
        return numSubordinados;
    }

    public void setNumSubordinados(int numSubordinados) {
        this.numSubordinados = numSubordinados;
    }

    /**
     * Solo permite subir sueldo a empleados que NO sean Jefe. Si se intenta
     * sobre un Jefe, la operación se rechaza (no se hace nada).
     *
     * @param empleado
     * @param incremento
     */
    public void subirSueldo(Empleado empleado, double incremento) {
        if (empleado == null ) {
            return;
        }
        if (empleado instanceof Jefe) {
            // Rechazar la operación: no se sube sueldo a otro Jefe
            return;
        }
        empleado.setSueldo(empleado.getSueldo() + incremento);
    }

    @Override
    public String toString() {
        return "Jefe--->nombre='" + getNombre() + "', numEmpleado=" + getNumEmpleado()
                + ", departamento='" + departamento + "', numSubordinados=" + numSubordinados
                + ", fechaContratacion=" + getFechaContratacion() + ", sueldo=" + getSueldo();
    }
}
