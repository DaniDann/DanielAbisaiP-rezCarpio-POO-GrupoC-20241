package libros;

import libreria.Libreria;
import libros.constants.Genero;
import libros.constants.TerrorSubgenero;
import libros.utils.LibrosUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LibroTerror extends Libro{
    private TerrorSubgenero subgenero;
    public LibroTerror(String titulo, String autor, LocalDate fechaPublicacion, String editorial, double precio, int stock, TerrorSubgenero subgenero) {
        super(titulo, autor, fechaPublicacion, editorial, precio, Genero.TERROR, stock);
        this.subgenero = subgenero;
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

        TerrorSubgenero subgeneroInput = null;
        System.out.println("Ingresa el subgénero del libro:");
        System.out.println("1. Psicologico");
        System.out.println("2. Monjas");

        int opcionSubgenero = scanner.nextInt();

        switch (opcionSubgenero) {
            case 1:
                subgeneroInput = TerrorSubgenero.PSICOLIGICO;
                break;
            case 2:
                subgeneroInput = TerrorSubgenero.MONJAS;
                break;
            default:
                System.out.println("Opción no válida. Selecciona 1 o 2.");
                return;
        }

        LibroTerror libroTerror = new LibroTerror(nombre, autor, fecha, editorial, precio, stock, subgeneroInput);

        Libreria.libros.get(Genero.TERROR).add(libroTerror);
        Libreria.serializar();
        System.out.println("Libro registrado exitosamente en la librería.");
    }

    public static void eliminarLibro(String titulo) {
        Iterator<Libro> iterator = Libreria.libros.get(Genero.TERROR).iterator();
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
        List<Libro> librosTerror = Libreria.libros.get(Genero.TERROR);

        if (librosTerror.isEmpty()) {
            System.out.println("No hay libros de terror registrados en la librería.");
        } else {
            System.out.println("Listado de libros de terror:");
            for (Libro libro : librosTerror) {
                System.out.println(libro.toString());
            }
        }
    }

    @Override
    public void filtrarPorPrecioMayorA(double precio){
        Libreria.libros.get(Genero.TERROR)
                .stream()
                .filter(libro -> libro.getPrecio() > precio).forEach(libro -> System.out.println(libro.toString()));
    }

    @Override
    protected void filtrarLibroPorInicialDeAutor(String inicial) {
        Libreria.libros.get(Genero.TERROR)
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
