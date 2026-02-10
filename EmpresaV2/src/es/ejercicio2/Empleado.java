package es.ejercicio2;

/**
 * Clase Empleado que extiende Persona. Representa a un empleado de la empresa
 * con sus datos laborales. El numEmpleado se asigna automáticamente mediante
 * contadores estáticos.
 *
 * @author diegowolder
 * @version 1.0
 */
public class Empleado extends Persona {

    /**
     * Número de la Seguridad Social del empleado
     */
    private String nss;

    /**
     * Número único de empleado (asignado automáticamente)
     */
    private int numEmpleado;

    /**
     * Fecha de contratación del empleado
     */
    private Fecha fechaContratacion;

    /**
     * IRPF aplicable al empleado
     */
    private double irpf;

    /**
     * Cargo del empleado
     */
    private String cargo;

    /**
     * Sueldo bruto del empleado
     */
    private double sueldo;

    /**
     * Código inicial para empleados normales
     */
    private static final int CODIGO_INICIAL_EMPLEADO = 100000000;

    /**
     * Código inicial para jefes
     */
    private static final int CODIGO_INICIAL_JEFE = 200000000;

    /**
     * IRPF mínimo permitido (0%)
     */
    private static final double IRPF_MINIMO = 0.0;

    /**
     * IRPF máximo permitido (100%)
     */
    private static final double IRPF_MAXIMO = 1.0;

    /**
     * Contador estático para asignación automática de códigos de empleados
     * normales. Los empleados normales empiezan en 100 millones.
     */
    private static int NEXT_CODIGO_EMPLEADO = CODIGO_INICIAL_EMPLEADO;

    /**
     * Contador estático para asignación automática de códigos de jefes. Los
     * jefes empiezan en 200 millones. Nota: En algún momento puede llegar a
     * solaparse el código de Empleado con el de los Jefes, pero es muy
     * improbable con tal cantidad de números.
     */
    private static int NEXT_CODIGO_JEFE = CODIGO_INICIAL_JEFE;

    /**
     * Constructor por defecto que inicializa los atributos con valores nulos o
     * por defecto. Asigna automáticamente un número de empleado.
     */
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
     * Constructor simplificado para crear empleados con datos básicos. Útil
     * cuando no se quieren rellenar todos los datos.
     *
     * @param nombre Nombre del empleado
     * @param sexo Sexo del empleado (MASCULINO, FEMENINO, DESCONOCIDO)
     * @param fechaContratacion Fecha de contratación del empleado
     * @param sueldo Sueldo bruto del empleado (debe ser >= 0)
     * @throws IllegalArgumentException si el sueldo es negativo
     */
    public Empleado(String nombre, Sexo sexo, Fecha fechaContratacion, double sueldo) {
        super(nombre, sexo, null, null); // DNI y fechaNac no se pasan aquí
        if (sueldo < 0) {
            throw new IllegalArgumentException("El sueldo no puede ser negativo: " + sueldo);
        }
        this.nss = null;
        asignarNumEmpleadoAutomatico();
        this.fechaContratacion = fechaContratacion;
        this.irpf = 0.0;
        this.cargo = null;
        this.sueldo = sueldo;
    }

    /**
 * Constructor completo con todos los atributos.
 * El numEmpleado NO se pasa como parámetro, se asigna automáticamente.
 * <p>
 * <b>Ejemplo de uso:</b>
 * <pre>
 * new Empleado(
 *     "123456789012",                    // nss
 *     LocalDate.of(2024, 1, 15),         // fechaContratacion
 *     0.15,                              // irpf
 *     "Desarrollador",                   // cargo
 *     "Diego Wolder",                    // nombre
 *     Sexo.MASCULINO,                    // sexo
 *     "12345678A",                       // dni
 *     LocalDate.of(1990, 5, 20)          // fechaNac
 * )
 * </pre>
 * </p>
 * 
 * @param nss Número de la Seguridad Social (ej: "123456789012")
 * @param fechaContratacion Fecha de contratación (ej: LocalDate.of(2024, 1, 15))
 * @param irpf IRPF entre 0.0 y 1.0 (ej: 0.15 para 15%)
 * @param cargo Cargo del empleado (ej: "Desarrollador")
 * @param nombre Nombre completo (ej: "Diego Wolder")
 * @param sexo Sexo.MASCULINO, Sexo.FEMENINO o Sexo.DESCONOCIDO
 * @param dni DNI del empleado (ej: "12345678A")
 * @param fechaNac Fecha de nacimiento (ej: LocalDate.of(1990, 5, 20))
 * @throws IllegalArgumentException si el IRPF está fuera del rango 0.0-1.0
 */
    public Empleado(String nss, Fecha fechaContratacion, double irpf, String cargo,
            String nombre, Sexo sexo, String dni, Fecha fechaNac) {
        super(nombre, sexo, dni, fechaNac);
        if (irpf < IRPF_MINIMO || irpf > IRPF_MAXIMO) {
            throw new IllegalArgumentException("El IRPF debe estar entre " + IRPF_MINIMO + " y " + IRPF_MAXIMO + ". Valor recibido: " + irpf);
        }
        this.nss = nss;
        asignarNumEmpleadoAutomatico();
        this.fechaContratacion = fechaContratacion;
        this.irpf = irpf;
        this.cargo = cargo;
        this.sueldo = 0.0;
    }

    /**
     * Asigna automáticamente el número de empleado según el tipo. Si es un
     * Jefe, asigna códigos desde 200000000. Si es un Empleado normal, asigna
     * códigos desde 100000000.
     *
     * @throws IllegalStateException si el tipo de empleado no es reconocido
     */
    private synchronized void asignarNumEmpleadoAutomatico() {
        this.numEmpleado = (this instanceof Jefe) ? NEXT_CODIGO_JEFE++
                : (this instanceof Empleado) ? NEXT_CODIGO_EMPLEADO++
                        : lanzarExcepcionTipoNoReconocido();
    }

    /**
     * Método auxiliar que lanza una excepción para tipos de empleado no
     * reconocidos.
     *
     * @return Nunca retorna (siempre lanza excepción)
     * @throws IllegalStateException siempre
     */
    private int lanzarExcepcionTipoNoReconocido() {
        throw new IllegalStateException("Tipo de empleado no reconocido");
    }

    /**
     * Obtiene el número de la Seguridad Social del empleado.
     *
     * @return NSS del empleado
     */
    public String getNss() {
        return nss;
    }

    /**
     * Establece el número de la Seguridad Social del empleado.
     *
     * @param nss Nuevo NSS del empleado
     */
    public void setNss(String nss) {
        this.nss = nss;
    }

    /**
     * Obtiene el número único de empleado (asignado automáticamente). Este
     * atributo no tiene setter porque se asigna automáticamente.
     *
     * @return Número de empleado
     */
    public int getNumEmpleado() {
        return numEmpleado;
    }

    /**
     * Obtiene la fecha de contratación del empleado.
     *
     * @return Fecha de contratación
     */
    public Fecha getFechaContratacion() {
        return fechaContratacion;
    }

    /**
     * Establece la fecha de contratación del empleado.
     *
     * @param fechaContratacion Nueva fecha de contratación
     */
    public void setFechaContratacion(Fecha fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    /**
     * Obtiene el IRPF aplicable al empleado.
     *
     * @return IRPF del empleado
     */
    public double getIrpf() {
        return irpf;
    }

    /**
     * Establece el IRPF aplicable al empleado.
     *
     * @param irpf Nuevo IRPF del empleado (debe estar entre 0.0 y 1.0)
     * @throws IllegalArgumentException si el IRPF está fuera del rango válido
     */
    public void setIrpf(double irpf) {
        if (irpf < IRPF_MINIMO || irpf > IRPF_MAXIMO) {
            throw new IllegalArgumentException("El IRPF debe estar entre " + IRPF_MINIMO + " y " + IRPF_MAXIMO + ". Valor recibido: " + irpf);
        }
        this.irpf = irpf;
    }

    /**
     * Obtiene el cargo del empleado.
     *
     * @return Cargo del empleado
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * Establece el cargo del empleado.
     *
     * @param cargo Nuevo cargo del empleado
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * Obtiene el sueldo bruto del empleado.
     *
     * @return Sueldo del empleado
     */
    public double getSueldo() {
        return sueldo;
    }

    /**
     * Establece el sueldo bruto del empleado.
     *
     * @param sueldo Nuevo sueldo del empleado (debe ser >= 0)
     * @throws IllegalArgumentException si el sueldo es negativo
     */
    public void setSueldo(double sueldo) {
        if (sueldo < 0) {
            throw new IllegalArgumentException("El sueldo no puede ser negativo: " + sueldo);
        }
        this.sueldo = sueldo;
    }

    /**
     * Devuelve una representación en String de todos los datos del empleado.
     *
     * @return String con todos los atributos del empleado
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empleado ---> nss='").append(nss)
                .append("', numEmpleado=").append(numEmpleado)
                .append(", fechaContratacion=").append(fechaContratacion)
                .append(", irpf=").append(irpf)
                .append(", cargo='").append(cargo)
                .append("', nombre='").append(getNombre())
                .append("', sexo=").append(getSexo())
                .append(", dni='").append(getDni())
                .append("', fechaNac=").append(getFechaNac())
                .append(", sueldo=").append(sueldo);
        return sb.toString();
    }

    /**
     * Compara este empleado con otro objeto para verificar igualdad. Dos
     * empleados son iguales si tienen el mismo número de empleado.
     *
     * @param obj Objeto a comparar
     * @return true si los empleados son iguales, false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Empleado empleado = (Empleado) obj;
        return numEmpleado == empleado.numEmpleado;
    }

    /**
     * Genera un código hash para este empleado.
     *
     * @return Código hash basado en numEmpleado
     */
    @Override
    public int hashCode() {
        return numEmpleado;
    }
}

/*
 * POSIBLES MEJORAS PARA LA CLASE Empleado:
 * 
 * 1. Validar el formato del NSS (Número de la Seguridad Social) según normativa española
 * 
 * 2. Añadir método calcularSueldoNeto() que aplique IRPF y otras deducciones
 * 
 * 3. Implementar Comparable<Empleado> para ordenar empleados por diferentes criterios
 *    (por sueldo, por antigüedad, por número de empleado, etc.)
 * 
 * 4. Separar los contadores estáticos en una clase dedicada (ej: GeneradorCodigos)
 *    para mejor organización y evitar dependencias circulares
 * 
 * 5. Crear métodos de utilidad como:
 *    - calcularAntiguedad() que devuelva años trabajados
 *    - aplicarSubidaSueldo(double porcentaje)
 *    - esJefe() que retorne boolean
 * 
 * 6. Validar que fechaContratacion no sea posterior a la fecha actual
 * 
 * 7. Considerar usar BigDecimal para sueldo e IRPF para mayor precisión decimal
 * 
 * 8. Mejorar el toString() para que sea más legible (saltos de línea, tabulaciones)
 *    o crear un método toStringDetallado()
 */
