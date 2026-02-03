package es.ejercicio2;

/**
 * Clase de prueba con el main pedido en el enunciado.
 */
public class EmpresaTest {

    public static void main(String[] args) {

        Empleado e[] = new Empleado[8];

        // Constructor: Nombre, sexo, fecha-contr. y sueldo
        e[0] = new Empleado("Diego", 'H', new Fecha(15, 11, 2000), 1000.12);
        e[1] = new Jefe("Alfonso", 'H', new Fecha(10, 2, 2000), 1200, "rrhh"); // depto.
        e[2] = new Empleado("Benito", 'H', new Fecha(1, 6, 2014), 1250);
        e[3] = new Jefe("Mónica", 'M', new Fecha(8, 4, 2012), 1300, "contabilidad");
        e[4] = new Empleado("Alfredo", 'H', new Fecha(1, 10, 2010), 995.20);
        e[5] = new Empleado("Vicente", 'H', new Fecha(14, 11, 2020), 1020.45);
        e[6] = new Empleado("Silvio", 'H', new Fecha(25, 9, 2019), 1070.50);
        e[7] = new Empleado("Marta", 'M', new Fecha(3, 4, 2018), 1020.45);

        // Listamos el array usando toString()
        for (Empleado emple : e) {
            System.out.println(emple);
        }

        // Invoca al método subirSueldo() para un empleado y comprueba su aplicación.
        System.out.println("\n--- probar subirSueldo ---");
        System.out.println("Sueldo antes de " + e[0].getNombre() + "--->" + e[0].getSueldo());
        if (e[1] instanceof Jefe) {
            ((Jefe) e[1]).subirSueldo(e[0], 200);
            System.out.println("Sueldo después--->" + e[0].getSueldo());
        }

        // Intento inválido: un Jefe intenta subir sueldo a otro Jefe (debe rechazarse)
        if (e[1] instanceof Jefe) { //Al tratarse del empleado en posicion 2 del array de un jefe entra en el if
            ((Jefe) e[1]).subirSueldo(e[1], 100); //Casteamos e[1] a la clase Jefe para poder llamar a subirSueldo
            System.out.println("\n Intento inválido," + e[1].getNombre() + "--->no puede subir el sueldo a<---" + e[1].getNombre());
        }

        // Totalizar sueldos
        System.out.println("\nTotal sueldos brutos: " + Plantilla.totalizarSueldos(e));
        
    }
}
