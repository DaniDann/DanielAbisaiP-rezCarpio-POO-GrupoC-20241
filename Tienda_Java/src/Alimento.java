import java.util.Date;

class Alimento extends Producto {
    private String fechaCaducidad;

    Alimento(String nombre, double precio, Date fechaImportacion, String numeroSerie, String fechaCaducidad) {
        super(nombre, precio, fechaImportacion, numeroSerie);
        this.fechaCaducidad = fechaCaducidad;
    }
}