package es.ejercicio2;

/**
 * Clase utilitaria Plantilla con métodos estáticos.
 * Proporciona operaciones comunes sobre conjuntos de empleados,
 * como totalización de sueldos y aplicación de descuentos.
 * Esta clase no puede ser instanciada.
 * 
 * @author diegowolder
 * @version 1.0
 */
public final class Plantilla {

    /** Porcentaje de descuento para jefes (5%) */
    private static final double DESCUENTO_JEFE = 0.05;
    
    /** Porcentaje de descuento para empleados normales (10%) */
    private static final double DESCUENTO_EMPLEADO = 0.10;

    /**
     * Constructor privado para evitar instanciación de esta clase utilitaria.
     */
    private Plantilla() { /* No instanciable */ }

    /**
     * Calcula la suma total de todos los sueldos de los empleados.
     * 
     * @param empleados Array de empleados cuyos sueldos se van a totalizar
     * @return Total de sueldos brutos, o 0.0 si el array es nulo o está vacío
     */
    public static double totalizarSueldos(Empleado[] empleados) {
        double total = 0.0;
        if (empleados == null) return total;
        for (Empleado e : empleados) {
            if (e != null) total += e.getSueldo();
        }
        return total;
    }
    
    /**
     * Método comentado para futuro control de descuentos por empleado.
     * Podría implementarse para controlar las veces que un empleado 
     * ha tenido descuentos aplicados a su sueldo.
     * 
     * @param empleado Empleado a verificar
     * @return true si se puede aplicar descuento, false en caso contrario
     */
    /*
    public static boolean controlDescontarPorcentaje(Empleado empleado) {
       return true; 
    }
    */
    
    /**
     * Aplica un descuento porcentual al sueldo del empleado según su tipo.
     * Los Jefes tienen un descuento del 5%, los Empleados normales del 10%.
     * 
     * @param empleado Empleado al que se le aplicará el descuento (puede ser null)
     */
    public static void descontarPorcentaje(Empleado empleado) {
        if (empleado == null) return;  
        
        double descuento;
        if (empleado instanceof Jefe) {
            descuento = DESCUENTO_JEFE;
        } else if (empleado instanceof Empleado) {
            descuento = DESCUENTO_EMPLEADO;
        } else {
            descuento = 0.0;
        }
        
        empleado.setSueldo(empleado.getSueldo() * (1.0 - descuento));
    }
}

/*
 * POSIBLES MEJORAS PARA LA CLASE Plantilla:
 * 
 * 1. Implementar el método controlDescontarPorcentaje() para llevar un registro
 *    de cuántas veces se ha descontado a cada empleado (usando un Map<Integer, Integer>)
 * 
 * 2. Añadir más métodos estadísticos útiles:
 *    - calcularSueldoPromedio(Empleado[] empleados)
 *    - obtenerSueldoMaximo(Empleado[] empleados)
 *    - obtenerSueldoMinimo(Empleado[] empleados)
 *    - calcularMedianaSueldos(Empleado[] empleados)
 * 
 * 3. Añadir métodos para filtrar empleados:
 *    - obtenerEmpleadosPorDepartamento(Empleado[] empleados, String departamento)
 *    - obtenerJefes(Empleado[] empleados)
 *    - obtenerEmpleadosConSueldoMayorA(Empleado[] empleados, double sueldo)
 * 
 * 4. Implementar métodos de ordenación:
 *    - ordenarPorSueldo(Empleado[] empleados)
 *    - ordenarPorAntiguedad(Empleado[] empleados)
 *    - ordenarPorNombre(Empleado[] empleados)
 * 
 * 5. Añadir validación en descontarPorcentaje() para evitar que el sueldo
 *    quede en valores negativos o por debajo del salario mínimo
 * 
 * 6. Crear método descontarPorcentajePersonalizado(Empleado empleado, double porcentaje)
 *    para descuentos variables
 * 
 * 7. Implementar un sistema de log para registrar todas las operaciones de descuento
 *    y subidas de sueldo (auditoría)
 * 
 * 8. Añadir métodos para generar reportes:
 *    - generarReporteNomina(Empleado[] empleados)
 *    - exportarDatosCSV(Empleado[] empleados, String rutaArchivo)
 * 
 * 9. Cambiar de arrays a List<Empleado> para mayor flexibilidad y uso de Streams (Java 8+)
 * 
 * 10. Implementar métodos usando Streams de Java 8:
 *     - totalizarSueldos usando empleados.stream().mapToDouble(Empleado::getSueldo).sum()
 *     - filtrados más eficientes y legibles
 * 
 * 11. Añadir método validarCoherenciaNomina() que verifique que todos los sueldos
 *     estén dentro de rangos razonables
 * 
 * 12. Crear método calcularTotalIRPF(Empleado[] empleados) para calcular deducciones totales
 * 
 * 13. Documentar mejor qué representa cada porcentaje de descuento (¿Seguridad Social? ¿IRPF?)
 */