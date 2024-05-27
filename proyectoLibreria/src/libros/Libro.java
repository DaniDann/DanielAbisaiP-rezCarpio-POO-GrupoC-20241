package libros;
import libros.constants.Genero;
import java.time.LocalDate;
// Streams -filter,map,anyMatch


    public abstract class Libro {
    private static int CANTIDAD_LIBROS = 1;
    private int id;
    private String titulo;
    private String autor;
    private LocalDate fechaPublicacion;
    private String editorial;
    private double precio;
    private Genero genero;
    private int stock;

    public Libro(String titulo, String autor, LocalDate fechaPublicacion, String editorial, double precio, Genero genero, int stock) {
        this.id = CANTIDAD_LIBROS;
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.editorial = editorial;
        this.precio = precio;
        this.genero = genero;
        this.stock = stock;
        CANTIDAD_LIBROS ++;
    }

    public abstract void filtrarPorPrecioMayorA(double precio);

    protected abstract void filtrarLibroPorInicialDeAutor(String inicial);

    protected abstract void filtrarLibroPorEditorial(String editorial);

    public String getAutor() {
        return autor;
    }

    public double getPrecio() {
        return precio;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEditorial() {
        return editorial;
    }
}