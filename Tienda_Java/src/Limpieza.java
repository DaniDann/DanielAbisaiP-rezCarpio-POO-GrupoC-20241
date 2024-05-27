import java.util.Date;

public class Limpieza extends Producto {
    boolean esBiodegradable;

    Limpieza(String nombre, double precio, Date fechaImportacion, String numeroSerie, boolean esBiodegradable) {
        super(nombre, precio, fechaImportacion, numeroSerie);
        this.esBiodegradable = esBiodegradable;
    }
}
