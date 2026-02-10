package es.ejercicio2;

/**
 * Clase de prueba con el main pedido en el enunciado.
 * Ejecuta diferentes escenarios para probar las funcionalidades de Empleado, Jefe y Plantilla.
 * 
 * @author diegowolder
 * @version 1.0.2
 */
public class EmpresaTest {

    /**
     * Método principal que ejecuta las pruebas del sistema de gestión de empleados.
     * Crea empleados y jefes, prueba subidas de sueldo, descuentos y totalización.
     * 
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {

        Empleado empleados[] = new Empleado[8];

        // Constructor: Nombre, sexo, fecha de contratación y sueldo
        empleados[0] = new Empleado("Diego", Persona.Sexo.MASCULINO, new Fecha(15, 11, 2000), 1000.12);
        empleados[1] = new Jefe("Alfonso", Persona.Sexo.DESCONOCIDO, new Fecha(10, 2, 2000), 1200, "rrhh"); // departamento
        empleados[2] = new Empleado("Benito", Persona.Sexo.DESCONOCIDO, new Fecha(1, 6, 2014), 250);
        empleados[3] = new Jefe("Mónica", Persona.Sexo.DESCONOCIDO, new Fecha(8, 4, 2012), 1300, "contabilidad");
        empleados[4] = new Empleado("Alfredo", Persona.Sexo.DESCONOCIDO, new Fecha(1, 10, 2010), 995.20);
        empleados[5] = new Empleado("Vicente", Persona.Sexo.DESCONOCIDO, new Fecha(14, 11, 2020), 1020.45);
        empleados[6] = new Empleado("Silvio", Persona.Sexo.DESCONOCIDO, new Fecha(25, 9, 2019), 1070.50);
        empleados[7] = new Empleado("Marta", Persona.Sexo.DESCONOCIDO, new Fecha(3, 4, 2018), 1020.45);
        

        // Listamos el array usando toString()
        for (Empleado emple : empleados) {
            System.out.println(emple);
        }
        

        // Invoca al método subirSueldo() para un empleado y comprueba su aplicación
        System.out.println("\n--- Probar subirSueldo ---");
        System.out.println("Sueldo antes de " + empleados[0].getNombre() + " ---> " + empleados[0].getSueldo());
        if (empleados[1] instanceof Jefe) {
            boolean exito = ((Jefe) empleados[1]).subirSueldo(empleados[0], 200);
            System.out.println("Sueldo después ---> " + empleados[0].getSueldo());
            System.out.println("Operación exitosa: " + exito);
        }

        // Intento inválido: un Jefe intenta subir sueldo a otro Jefe (debe rechazarse)
        if (empleados[1] instanceof Jefe) { // Al tratarse del empleado en posición 1 del array de un jefe, entra en el if
            boolean exito = ((Jefe) empleados[1]).subirSueldo(empleados[1], 100); // Casteamos empleados[1] a la clase Jefe para poder llamar a subirSueldo
            System.out.println("\nIntento inválido, " + empleados[1].getNombre() + " ---> no puede subir el sueldo a <--- " + empleados[1].getNombre());
            System.out.println("Operación exitosa: " + exito);
        }
        
        System.out.println("\nEmpleado antes de descontar porcentaje de " + empleados[0].getNombre() + ": " + empleados[0].getSueldo());
        Plantilla.descontarPorcentaje(empleados[0]);
        System.out.println("Empleado después de descontar porcentaje de " + empleados[0].getNombre() + ": " + empleados[0].getSueldo());

        // Totalizar sueldos
        System.out.printf("\nTotal sueldos brutos: %.2f€ ", Plantilla.totalizarSueldos(empleados));
        
    }
}

/*
 * POSIBLES MEJORAS PARA LA CLASE EmpresaTest:
 * 
 * 1. Separar las pruebas en métodos individuales para mejor organización y legibilidad
 *    (ej: probarCreacionEmpleados(), probarSubidaSueldo(), probarDescuentos())
 * 
 * 2. Utilizar un framework de testing como JUnit en lugar de un main con println
 *    para poder hacer assertions y validar resultados automáticamente
 * 
 * 3. Añadir manejo de excepciones con try-catch para evitar que el programa falle
 *    ante datos incorrectos
 * 
 * 4. Usar List<Empleado> en lugar de array (más flexible y moderno)
 * 
 * 5. Añadir más casos de prueba:
 *    - Probar con arrays vacíos o nulos
 *    - Probar empleados con valores límite (sueldos negativos, fechas inválidas)
 *    - Probar la inmutabilidad de la clase Fecha
 *    - Verificar el comportamiento de los contadores estáticos de códigos
 * 
 * 6. Mostrar resultados esperados vs obtenidos para cada prueba
 * 
 * 7. Implementar un sistema de logs en lugar de System.out.println
 * 
 * 8. Añadir pruebas para verificar que los Jefes tienen códigos >= 200000000
 *    y los Empleados >= 100000000
 */