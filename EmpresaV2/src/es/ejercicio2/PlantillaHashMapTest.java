package es.ejercicio2;

/**
 * Clase de prueba para demostrar la funcionalidad del HashMap en Plantilla.
 * Prueba el registro, búsqueda y gestión de empleados mediante HashMap.
 * 
 * @author diegowolder
 * @version 1.0
 */
public class PlantillaHashMapTest {

    /**
     * Método principal que ejecuta las pruebas del HashMap en Plantilla.
     * 
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        System.out.println("=== PRUEBAS DE HASHMAP EN PLANTILLA ===\n");
        
        // Limpiar cualquier dato previo
        Plantilla.limpiarEmpleados();
        
        // Crear algunos empleados
        Empleado emp1 = new Empleado("Diego", Persona.Sexo.MASCULINO, new Fecha(15, 11, 2000), 1000.12);
        Empleado emp2 = new Jefe("Alfonso", Persona.Sexo.DESCONOCIDO, new Fecha(10, 2, 2000), 1200, "rrhh");
        Empleado emp3 = new Empleado("Benito", Persona.Sexo.DESCONOCIDO, new Fecha(1, 6, 2014), 250);
        Empleado emp4 = new Jefe("Mónica", Persona.Sexo.DESCONOCIDO, new Fecha(8, 4, 2012), 1300, "contabilidad");
        
        System.out.println("--- 1. REGISTRO DE EMPLEADOS EN HASHMAP ---");
        System.out.println("Empleados antes de registrar: " + Plantilla.obtenerNumeroEmpleados());
        
        Plantilla.registrarEmpleado(emp1);
        Plantilla.registrarEmpleado(emp2);
        Plantilla.registrarEmpleado(emp3);
        Plantilla.registrarEmpleado(emp4);
        
        System.out.println("Empleados registrados: " + Plantilla.obtenerNumeroEmpleados());
        System.out.println("Empleado 1 - Número: " + emp1.getNumEmpleado() + ", Nombre: " + emp1.getNombre());
        System.out.println("Empleado 2 - Número: " + emp2.getNumEmpleado() + ", Nombre: " + emp2.getNombre());
        System.out.println("Empleado 3 - Número: " + emp3.getNumEmpleado() + ", Nombre: " + emp3.getNombre());
        System.out.println("Empleado 4 - Número: " + emp4.getNumEmpleado() + ", Nombre: " + emp4.getNombre());
        
        System.out.println("\n--- 2. BÚSQUEDA DE EMPLEADOS POR NÚMERO ---");
        Empleado encontrado = Plantilla.obtenerEmpleado(emp1.getNumEmpleado());
        if (encontrado != null) {
            System.out.println("Empleado encontrado por número " + emp1.getNumEmpleado() + ": " + encontrado.getNombre());
        }
        
        encontrado = Plantilla.obtenerEmpleado(emp3.getNumEmpleado());
        if (encontrado != null) {
            System.out.println("Empleado encontrado por número " + emp3.getNumEmpleado() + ": " + encontrado.getNombre());
        }
        
        System.out.println("\n--- 3. TOTALIZACIÓN DE SUELDOS CON HASHMAP ---");
        double totalHashMap = Plantilla.totalizarSueldos();
        System.out.printf("Total de sueldos (desde HashMap): %.2f€\n", totalHashMap);
        
        System.out.println("\n--- 4. CONTROL DE DESCUENTOS ---");
        System.out.println("Descuentos aplicados a " + emp1.getNombre() + " antes: " + Plantilla.obtenerNumeroDescuentos(emp1));
        System.out.println("¿Se puede aplicar descuento a " + emp1.getNombre() + "? " + Plantilla.controlDescontarPorcentaje(emp1));
        
        System.out.println("\nAplicando primer descuento a " + emp1.getNombre() + "...");
        System.out.println("Sueldo antes: " + emp1.getSueldo());
        Plantilla.descontarPorcentaje(emp1);
        System.out.println("Sueldo después: " + emp1.getSueldo());
        System.out.println("Descuentos aplicados: " + Plantilla.obtenerNumeroDescuentos(emp1));
        System.out.println("¿Se puede aplicar descuento nuevamente? " + Plantilla.controlDescontarPorcentaje(emp1));
        
        System.out.println("\nAplicando segundo descuento a " + emp1.getNombre() + "...");
        Plantilla.descontarPorcentaje(emp1);
        System.out.println("Sueldo después del segundo descuento: " + emp1.getSueldo());
        System.out.println("Descuentos aplicados: " + Plantilla.obtenerNumeroDescuentos(emp1));
        
        System.out.println("\n--- 5. DESCUENTOS EN JEFE vs EMPLEADO ---");
        System.out.println("Sueldo de " + emp2.getNombre() + " (Jefe) antes: " + emp2.getSueldo());
        Plantilla.descontarPorcentaje(emp2);
        System.out.println("Sueldo de " + emp2.getNombre() + " (Jefe) después: " + emp2.getSueldo() + " (descuento 5%)");
        System.out.println("Descuentos aplicados a Jefe: " + Plantilla.obtenerNumeroDescuentos(emp2));
        
        System.out.println("\nSueldo de " + emp3.getNombre() + " (Empleado) antes: " + emp3.getSueldo());
        Plantilla.descontarPorcentaje(emp3);
        System.out.println("Sueldo de " + emp3.getNombre() + " (Empleado) después: " + emp3.getSueldo() + " (descuento 10%)");
        System.out.println("Descuentos aplicados a Empleado: " + Plantilla.obtenerNumeroDescuentos(emp3));
        
        System.out.println("\n--- 6. ELIMINACIÓN DE EMPLEADOS ---");
        System.out.println("Empleados antes de eliminar: " + Plantilla.obtenerNumeroEmpleados());
        Empleado eliminado = Plantilla.eliminarEmpleado(emp3.getNumEmpleado());
        System.out.println("Empleado eliminado: " + (eliminado != null ? eliminado.getNombre() : "null"));
        System.out.println("Empleados después de eliminar: " + Plantilla.obtenerNumeroEmpleados());
        
        System.out.println("\n--- 7. TOTAL DE SUELDOS DESPUÉS DE CAMBIOS ---");
        System.out.printf("Total de sueldos actual: %.2f€\n", Plantilla.totalizarSueldos());
        
        System.out.println("\n--- 8. LIMPIEZA DE DATOS ---");
        Plantilla.limpiarEmpleados();
        System.out.println("Empleados después de limpiar: " + Plantilla.obtenerNumeroEmpleados());
        System.out.printf("Total de sueldos después de limpiar: %.2f€\n", Plantilla.totalizarSueldos());
        
        System.out.println("\n=== FIN DE PRUEBAS ===");
    }
}
