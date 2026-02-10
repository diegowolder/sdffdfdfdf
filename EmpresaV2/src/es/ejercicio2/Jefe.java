package es.ejercicio2;

/**
 * Clase Jefe que extiende Empleado.
 * Representa a un empleado con responsabilidades de dirección de departamento.
 * Los jefes tienen la capacidad de modificar sueldos de empleados bajo su supervisión.
 * 
 * @author diegowolder
 * @version 1.0
 */
public class Jefe extends Empleado {

    /** Departamento que dirige el jefe */
    private String departamento;
    
    /** Número de empleados subordinados al jefe */
    private int numSubordinados;

    /**
     * Constructor por defecto que inicializa los atributos con valores por defecto.
     */
    public Jefe() {
        super();
        this.departamento = null;
        this.numSubordinados = 0;
    }

    /**
     * Constructor parametrizado solicitado por el enunciado.
     * 
     * @param nombre Nombre del jefe
     * @param sexo Sexo del jefe (MASCULINO, FEMENINO, DESCONOCIDO)
     * @param fechaContratacion Fecha de contratación del jefe
     * @param sueldo Sueldo bruto del jefe (debe ser >= 0)
     * @param departamento Departamento que dirige el jefe
     * @throws IllegalArgumentException si el sueldo es negativo
     */
    public Jefe(String nombre, Sexo sexo, Fecha fechaContratacion, double sueldo, String departamento) {
        super(nombre, sexo, fechaContratacion, sueldo);
        this.departamento = departamento;
        this.numSubordinados = 0;
        // numEmpleado ya se asignó automáticamente en el constructor de Empleado
    }

    /**
     * Obtiene el departamento que dirige el jefe.
     * 
     * @return Nombre del departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * Establece el departamento que dirige el jefe.
     * 
     * @param departamento Nuevo nombre del departamento
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * Obtiene el número de empleados subordinados al jefe.
     * 
     * @return Número de subordinados
     */
    public int getNumSubordinados() {
        return numSubordinados;
    }

    /**
     * Establece el número de empleados subordinados al jefe.
     * 
     * @param numSubordinados Nuevo número de subordinados (debe ser >= 0)
     * @throws IllegalArgumentException si el número de subordinados es negativo
     */
    public void setNumSubordinados(int numSubordinados) {
        if (numSubordinados < 0) {
            throw new IllegalArgumentException("El número de subordinados no puede ser negativo: " + numSubordinados);
        }
        this.numSubordinados = numSubordinados;
    }

    /**
     * Permite subir el sueldo solo a empleados que NO sean Jefe.
     * Si se intenta aplicar sobre un Jefe, la operación se rechaza silenciosamente.
     * 
     * @param empleado Empleado al que se le subirá el sueldo
     * @param incremento Cantidad a incrementar en el sueldo del empleado (debe ser > 0)
     * @return true si la subida fue exitosa, false si fue rechazada
     */
    public boolean subirSueldo(Empleado empleado, double incremento) {
        if (empleado == null) {
            return false;
        }
        if (empleado instanceof Jefe) {
            // Rechazar la operación: no se sube sueldo a otro Jefe
            return false;
        }
        if (incremento <= 0) {
            // No se permiten incrementos negativos o cero
            return false;
        }
        empleado.setSueldo(empleado.getSueldo() + incremento);
        return true;
    }

    /**
     * Devuelve una representación en String de todos los datos del jefe.
     * 
     * @return String con los atributos específicos del jefe y heredados de Empleado
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Jefe ---> nombre='").append(getNombre())
          .append("', numEmpleado=").append(getNumEmpleado())
          .append(", departamento='").append(departamento)
          .append("', numSubordinados=").append(numSubordinados)
          .append(", fechaContratacion=").append(getFechaContratacion())
          .append(", sueldo=").append(getSueldo());
        return sb.toString();
    }
}

/*
 * POSIBLES MEJORAS PARA LA CLASE Jefe:
 * 
 * 1. Validar que el departamento no sea nulo o vacío en el constructor y setter
 * 
 * 2. Añadir una colección (List<Empleado>) para gestionar los subordinados reales
 *    en lugar de solo contar con un entero
 * 
 * 3. Implementar métodos para gestionar subordinados:
 *    - agregarSubordinado(Empleado e)
 *    - eliminarSubordinado(Empleado e)
 *    - listarSubordinados()
 *    - actualizarNumSubordinados() automáticamente
 * 
 * 4. En subirSueldo(), validar que el incremento no exceda límites
 *    presupuestarios del departamento
 * 
 * 5. Implementar un método validarSubidaSueldo() que verifique si el jefe tiene
 *    autorización para subir cierta cantidad según su nivel jerárquico
 * 
 * 6. Añadir restricción: un Jefe solo puede subir sueldo a empleados de su departamento
 * 
 * 7. Considerar lanzar excepciones personalizadas (ej: SubidaSueldoNoAutorizadaException)
 *    en lugar de retornar boolean cuando se rechaza la operación
 * 
 * 8. Añadir método calcularPresupuestoDepartamento() que sume los sueldos de subordinados
 * 
 * 9. Implementar un sistema de aprobación de subidas de sueldo que requiera
 *    validación de múltiples jefes o gerencia
 */