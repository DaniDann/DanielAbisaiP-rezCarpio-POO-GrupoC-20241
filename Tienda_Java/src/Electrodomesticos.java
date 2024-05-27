import java.util.*;
public class Electrodomesticos extends Producto {
    String marca;

    Electrodomesticos(String nombre, double precio, Date fechaImportacion, String numeroSerie, String marca) {
        super(nombre, precio, fechaImportacion, numeroSerie);
        this.marca = marca;
    }
}
