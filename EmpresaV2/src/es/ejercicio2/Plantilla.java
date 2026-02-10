package es.ejercicio2;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase utilitaria Plantilla con métodos estáticos.
 * Proporciona operaciones comunes sobre conjuntos de empleados,
 * como totalización de sueldos y aplicación de descuentos.
 * Esta clase no puede ser instanciada.
 * 
 * @author diegowolder
 * @version 2.0
 */
public final class Plantilla {

    /** Porcentaje de descuento para jefes (5%) */
    private static final double DESCUENTO_JEFE = 0.05;
    
    /** Porcentaje de descuento para empleados normales (10%) */
    private static final double DESCUENTO_EMPLEADO = 0.10;
    
    /** HashMap para almacenar empleados por número de empleado */
    private static final Map<Integer, Empleado> empleadosPorNumero = new HashMap<>();
    
    /** Map para controlar el número de descuentos aplicados por empleado */
    private static final Map<Integer, Integer> descuentosPorEmpleado = new HashMap<>();

    /**
     * Constructor privado para evitar instanciación de esta clase utilitaria.
     */
    private Plantilla() { /* No instanciable */ }
    
    /**
     * Registra un empleado en el HashMap por su número de empleado.
     * 
     * @param empleado Empleado a registrar (no puede ser null)
     * @return true si se registró correctamente, false si el empleado es null
     */
    public static boolean registrarEmpleado(Empleado empleado) {
        if (empleado == null) return false;
        empleadosPorNumero.put(empleado.getNumEmpleado(), empleado);
        return true;
    }
    
    /**
     * Obtiene un empleado por su número de empleado.
     * 
     * @param numEmpleado Número del empleado a buscar
     * @return Empleado correspondiente al número, o null si no existe
     */
    public static Empleado obtenerEmpleado(int numEmpleado) {
        return empleadosPorNumero.get(numEmpleado);
    }
    
    /**
     * Elimina un empleado del HashMap por su número de empleado.
     * 
     * @param numEmpleado Número del empleado a eliminar
     * @return Empleado eliminado, o null si no existía
     */
    public static Empleado eliminarEmpleado(int numEmpleado) {
        descuentosPorEmpleado.remove(numEmpleado);
        return empleadosPorNumero.remove(numEmpleado);
    }
    
    /**
     * Obtiene el número total de empleados registrados.
     * 
     * @return Número de empleados en el HashMap
     */
    public static int obtenerNumeroEmpleados() {
        return empleadosPorNumero.size();
    }
    
    /**
     * Limpia todos los empleados registrados.
     */
    public static void limpiarEmpleados() {
        empleadosPorNumero.clear();
        descuentosPorEmpleado.clear();
    }

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
     * Calcula la suma total de todos los sueldos de los empleados registrados en el HashMap.
     * 
     * @return Total de sueldos brutos de todos los empleados registrados
     */
    public static double totalizarSueldos() {
        double total = 0.0;
        for (Empleado e : empleadosPorNumero.values()) {
            if (e != null) total += e.getSueldo();
        }
        return total;
    }
    
    /**
     * Controla si se puede aplicar descuento a un empleado.
     * Verifica el número de descuentos aplicados previamente.
     * 
     * @param empleado Empleado a verificar
     * @return true si se puede aplicar descuento, false en caso contrario
     */
    public static boolean controlDescontarPorcentaje(Empleado empleado) {
        if (empleado == null) return false;
        Integer numDescuentos = descuentosPorEmpleado.get(empleado.getNumEmpleado());
        return numDescuentos == null || numDescuentos == 0;
    }
    
    /**
     * Obtiene el número de descuentos aplicados a un empleado.
     * 
     * @param empleado Empleado a consultar
     * @return Número de descuentos aplicados, o 0 si no se ha aplicado ninguno
     */
    public static int obtenerNumeroDescuentos(Empleado empleado) {
        if (empleado == null) return 0;
        Integer numDescuentos = descuentosPorEmpleado.get(empleado.getNumEmpleado());
        return numDescuentos == null ? 0 : numDescuentos;
    }
    
    /**
     * Aplica un descuento porcentual al sueldo del empleado según su tipo.
     * Los Jefes tienen un descuento del 5%, los Empleados normales del 10%.
     * Registra el descuento aplicado en el Map de control.
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
        
        // Registrar el descuento aplicado
        int numEmpleado = empleado.getNumEmpleado();
        Integer numDescuentos = descuentosPorEmpleado.get(numEmpleado);
        descuentosPorEmpleado.put(numEmpleado, numDescuentos == null ? 1 : numDescuentos + 1);
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