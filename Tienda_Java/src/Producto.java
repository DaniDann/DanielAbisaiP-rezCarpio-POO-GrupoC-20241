import java.util.Date;
public class Producto {
    private String nombre;
    private double precio;
    private Date fechaImportacion;
    private String numeroSerie;
    static int stock = 0;

    Producto(String nombre, double precio, Date fechaImportacion, String numeroSerie) {
        this.nombre = nombre;
        this.precio = precio;
        this.fechaImportacion = fechaImportacion;
        this.numeroSerie = numeroSerie;
    }

    static void agregarStock() {
        stock++;
    }

    static void eliminarStock() {
        if (stock > 0) {
            stock--;
        } else {
            System.out.println("No hay stock disponible");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFechaImportacion() {
        return fechaImportacion;
    }

    public void setFechaImportacion(Date fechaImportacion) {
        this.fechaImportacion = fechaImportacion;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public static int getStock() {
        return stock;
    }

    public static void setStock(int stock) {
        Producto.stock = stock;
    }
}