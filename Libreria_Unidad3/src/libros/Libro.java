package libros;
import com.google.gson.annotations.Expose;
import libros.constants.Genero;
import java.time.LocalDate;
    // Streams -filter,map,anyMatch
    /*
    1.- Filtrar libros que tengan un precio arriba de (Parametro)
    2.- Filtrar los libros que tengan un autor que su nombre inicia con la letra (parametro)
     */
public abstract class Libro {
    @Expose
    private static int CANTIDAD_LIBROS = 1;
    @Expose
    private int id;
    @Expose
    private String titulo;
    @Expose
    private String autor;
    @Expose
    private LocalDate fechaPublicacion;
    @Expose
    private String editorial;
    @Expose
    private double precio;
    @Expose
    private Genero genero;
    @Expose
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

