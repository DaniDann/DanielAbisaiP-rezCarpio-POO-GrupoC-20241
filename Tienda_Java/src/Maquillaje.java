import java.util.Date;

public class Maquillaje extends Producto {
    boolean esVegano;

    Maquillaje(String nombre, double precio, Date fechaImportacion, String numeroSerie, boolean esVegano) {
        super(nombre, precio, fechaImportacion, numeroSerie);
        this.esVegano = esVegano;
    }
}
