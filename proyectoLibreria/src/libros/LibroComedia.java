package libros;

import libreria.Libreria;
import libros.constants.ClasificacionLibro;
import libros.constants.Genero;
import libros.utils.LibrosUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LibroComedia extends Libro{
    public LibroComedia(String titulo, String autor, LocalDate fechaPublicacion, String editorial, double precio, int stock) {
        super(titulo, autor, fechaPublicacion, editorial, precio, Genero.COMEDIA, stock);
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

        LibroComedia libroComedia = new LibroComedia(nombre, autor, fecha, editorial, precio, stock);

        Libreria.libros.get(Genero.COMEDIA).add(libroComedia);
        System.out.println("Libro registrado exitosamente en la librería.");
    }

    public static void eliminarLibro(String titulo) {
        Iterator<Libro> iterator = Libreria.libros.get(Genero.COMEDIA).iterator();
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
        List<Libro> librosComedia = Libreria.libros.get(Genero.COMEDIA);

        if (librosComedia.isEmpty()) {
            System.out.println("No hay libros de terror registrados en la librería.");
        } else {
            System.out.println("Listado de libros de comedia:");
            for (Libro libro : librosComedia) {
                System.out.println(libro.toString());
            }
        }
    }

    @Override
    public void filtrarPorPrecioMayorA(double precio){
        Libreria.libros.get(Genero.COMEDIA)
                .stream()
                .filter(libro -> libro.getPrecio() > precio).forEach(libro -> System.out.println(libro.toString()));
    }

    @Override
    protected void filtrarLibroPorInicialDeAutor(String inicial) {
        Libreria.libros.get(Genero.COMEDIA)
                .stream()
                .map(libro -> libro.getAutor().toUpperCase())
                .forEach(libro -> System.out.println(libro.toString()));
    }

    @Override
    protected void filtrarLibroPorEditorial(String editorial){
        Libreria.libros.get(Genero.COMEDIA)
                .stream()
                .filter(libro -> libro instanceof LibroAccion)
                .filter(libro -> libro.getEditorial().equalsIgnoreCase(editorial))
                .forEach(libro -> System.out.println(libro.toString()));
    }
}