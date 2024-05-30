package libros;

import libreria.Libreria;
import libros.constants.ClasificacionLibro;
import libros.constants.Genero;
import libros.constants.TerrorSubgenero;
import libros.utils.LibrosUtils;

import java.time.LocalDate;
import java.util.*;

public class LibroAccion extends Libro{
    private ClasificacionLibro clasificacion;
    public LibroAccion(String titulo, String autor, LocalDate fechaPublicacion, String editorial, double precio, int stock, ClasificacionLibro clasificacion) {
        super(titulo, autor, fechaPublicacion, editorial, precio,Genero.ACCION, stock);
        this.clasificacion = clasificacion;
    }

    public static void registrarLibro(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> datosComun = LibrosUtils.registrarLibroDatosComun();
        String nombre = datosComun.get(0);
        String autor = datosComun.get(1);
        String editorial = datosComun.get(2);
        LocalDate fecha = LocalDate.parse(datosComun.get(3));
        double precio = Double.parseDouble(datosComun.get(4));
        int stock = Integer.parseInt(datosComun.get(5));

        ClasificacionLibro clasificacionLibro = null;

        System.out.println("Ingresa la clasificación del libro:");
        System.out.println("1. A");
        System.out.println("2. B");
        System.out.println("3. C");

        int opcionClasificacion = scanner.nextInt();

        switch (opcionClasificacion) {
            case 1:
                clasificacionLibro = ClasificacionLibro.A;
                break;
            case 2:
                clasificacionLibro = ClasificacionLibro.B;
                break;
            case 3:
                clasificacionLibro = ClasificacionLibro.C;
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }

        LibroAccion libroAccion = new LibroAccion(nombre, autor, fecha, editorial, precio, stock, clasificacionLibro);

        Libreria.libros.get(Genero.ACCION).add(libroAccion);
        Libreria.serializar();
        System.out.println("Libro registrado exitosamente en la librería.");
    }

    public static void eliminarLibro(String titulo) {
        Iterator<Libro> iterator = Libreria.libros.get(Genero.ACCION).iterator();
        while (iterator.hasNext()) {
            Libro libro = iterator.next();
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                iterator.remove(); // Elimina el libro de la lista
                System.out.println("Libro '" + titulo + "' eliminado de la librería.");
                return;
            }
        }
        System.out.println("No se encontró el libro con título '" + titulo + "' en la librería.");
    }
    public static void mostrarListadoLibros() {
        List<Libro> librosAccion = Libreria.libros.get(Genero.ACCION);

        if (librosAccion.isEmpty()) {
            System.out.println("No hay libros de terror registrados en la librería.");
        } else {
            System.out.println("Listado de libros de accion:");
            for (Libro libro : librosAccion) {
                System.out.println(libro.toString());
            }
        }
    }

    @Override
    public void filtrarPorPrecioMayorA(double precio){
        Libreria.libros.get(Genero.ACCION)
                .stream()
                .filter(libro -> libro.getPrecio() > precio).forEach(libro -> System.out.println(libro.toString()));
    }

    @Override
    protected void filtrarLibroPorInicialDeAutor(String inicial) {
        Libreria.libros.get(Genero.ACCION)
                .stream()
                .map(libro -> libro.getAutor().toUpperCase())
                .forEach(libro -> System.out.println(libro.toString()));
    }

    @Override
    protected void filtrarLibroPorEditorial(String editorial){
        Libreria.libros.get(Genero.TERROR)
                .stream()
                .filter(libro -> libro instanceof LibroAccion)
                .filter(libro -> libro.getEditorial().equalsIgnoreCase(editorial))
                .forEach(libro -> System.out.println(libro.toString()));
    }
}
