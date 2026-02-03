package es.ejercicio2;

/**
 * Clase Empleado.
 * numEmpleado se asigna automáticamente internamente; no se pasa por parámetro.
 */
public class Empleado extends Persona {

    private String nss;
    private int numEmpleado;
    private Fecha fechaContratacion;
    private double irpf;
    private String cargo;
    private double sueldo;

    // Contadores estáticos para asignación automática de códigos(Los jefes empiezan en el 200 millones mientras los empleados normales por el 100000000)
    //En algún momento puede llegar a solaparse el codigo de Empleado con el de los jefes pero es muy improbable con tal cantidad de números.
    private static int NEXT_CODIGO_EMPLEADO = 100000000;
    private static int NEXT_CODIGO_JEFE = 200000000;

    public Empleado() {
        super();
        this.nss = null;
        asignarNumEmpleadoAutomatico();
        this.fechaContratacion = null;
        this.irpf = 0.0;
        this.cargo = null;
        this.sueldo = 0.0;
    }

    /**
     * Constructor por defecto por si no queremos rellenar algunos datos.
     * Nombre, sexo, fechaContratacion y sueldo.
     * @param nombre
     * @param sexo
     * @param fechaContratacion
     * @param sueldo
     */
    public Empleado(String nombre, char sexo, Fecha fechaContratacion, double sueldo) {
        super(nombre, sexo, null, null); // dni y fechaNac no se pasan aquí
        this.nss = null;
        asignarNumEmpleadoAutomatico();
        this.fechaContratacion = fechaContratacion;
        this.irpf = 0.0;
        this.cargo = null;
        this.sueldo = sueldo;
    }

    /**
     * Constructor completo (no se permite pasar numEmpleado, Lo asinga automaticamente).
     * Mantiene la firma con los atributos solicitados.
     * @param nss
     * @param fechaContratacion
     * @param irpf
     * @param cargo
     * @param nombre
     * @param sexo
     * @param dni
     * @param fechaNac
     */
    public Empleado(String nss, Fecha fechaContratacion, double irpf, String cargo,
                    String nombre, char sexo, String dni, Fecha fechaNac) {
        super(nombre, sexo, dni, fechaNac);
        this.nss = nss;
        asignarNumEmpleadoAutomatico();
        this.fechaContratacion = fechaContratacion;
        this.irpf = irpf;
        this.cargo = cargo;
        this.sueldo = 0.0;
    }

    private void asignarNumEmpleadoAutomatico() {
        if (this instanceof Jefe) {
            this.numEmpleado = NEXT_CODIGO_JEFE++;
        } else {
            this.numEmpleado = NEXT_CODIGO_EMPLEADO++;
        }
    }

    // Getters y setters (tal como pide el enunciado)
    public String getNss() { return nss; }
    public void setNss(String nss) { this.nss = nss; }

    public int getNumEmpleado() { return numEmpleado; } // sin setter, asignación automática

    public Fecha getFechaContratacion() { return fechaContratacion; }
    public void setFechaContratacion(Fecha fechaContratacion) { this.fechaContratacion = fechaContratacion; }

    public double getIrpf() { return irpf; }
    public void setIrpf(double irpf) { this.irpf = irpf; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public double getSueldo() { return sueldo; }
    public void setSueldo(double sueldo) { this.sueldo = sueldo; }

    @Override
    public String toString() {
        return "Empleado--->nss='" + nss + "', numEmpleado=" + numEmpleado
                + ", fechaContratacion=" + fechaContratacion
                + ", irpf=" + irpf + ", cargo='" + cargo
                + "', nombre='" + getNombre() + "', sexo=" + getSexo()
                + ", dni='" + getDni() + "', fechaNac=" + getFechaNac()
                + ", sueldo=" + sueldo;
    }
}