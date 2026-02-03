package es.ejercicio2;
/**
 * Clase Fecha inmutable (solo lectura).
 */
public final class Fecha {

    private final int dia;
    private final int mes;
    private final int año;

    public Fecha(int dia, int mes, int año) {
        // Comprobaciones básicas (no agrego más validaciones solicitadas)
        if (mes < 1 || mes > 12) throw new IllegalArgumentException("Mes inválido: " + mes);
        if (dia < 1 || dia > 31) throw new IllegalArgumentException("Día inválido: " + dia);
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    public int getDia() { return dia; }
    public int getMes() { return mes; }
    public int getAño() { return año; }

    @Override
    public String toString() {
        String dd = (dia < 10) ? ("0" + dia) : String.valueOf(dia);
        String mm = (mes < 10) ? ("0" + mes) : String.valueOf(mes);
        return año + "-" + mm + "-" + dd;
    }
}