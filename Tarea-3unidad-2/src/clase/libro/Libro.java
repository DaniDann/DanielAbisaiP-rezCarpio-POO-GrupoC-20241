 package clase.libro;

/**
 *
 * @author Aaron
 */
public class Libro {
    // Atributos con valores iniciales
    String titulo = "Guia del autoestopista galactico";
    String autor = " Douglas Adams ";
    int anioPublicacion = 1979;
    int anioPublicación;
    
    // Metodo para mostrar los atributos del libro
    public void mostrarInformacion() {
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Anio de Publicacion: " + anioPublicacion);
    }
}