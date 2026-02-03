package es.ejercicio2;

/**
 * Clase utilitaria Plantilla con métodos estáticos.
 */
public final class Plantilla {

    private Plantilla() { /* no instanciable */ }
    public static double totalizarSueldos(Empleado[] empleados) {
        double total = 0.0;
        if (empleados == null) return total;
        for (Empleado e : empleados) {
            if (e != null) total += e.getSueldo();
        }
        return total;
       
    }

    public static void descontarPorcentaje(Empleado empleado) {
        if (empleado == null) return;
        double descuento = (empleado instanceof Jefe) ? 0.05 : 0.10;
        empleado.setSueldo(empleado.getSueldo() * (1.0 - descuento));
    }

}
