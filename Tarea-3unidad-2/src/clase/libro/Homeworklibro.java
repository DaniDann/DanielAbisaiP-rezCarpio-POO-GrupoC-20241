 package clase.libro;


public class Homeworklibro {

public static void main(String[] args) {

    Libro libroUno = new Libro();
    Libro libroDos = new Libro();
    Libro libroTres = new Libro();
    Libro libroCuatro = new Libro();
    
    System.out.println("\nInformacion de los libros: \n ");

    libroUno.mostrarInformacion();
    
        System.out.println("\n");

    
    libroDos.titulo = "El nombre de la rosa";
    libroDos.autor = "Umberto Eco";
    libroDos.anioPublicación = 1980;
    
    libroTres.titulo = "Cien años de soledad ";
    libroTres.autor = " Gabriel Garcia Marquez";
    libroTres.anioPublicación = 1967;
    
    libroCuatro.titulo = "El senor de los anillos ";
    libroCuatro.autor = "J.R.R. Tolkien ";
    libroCuatro.anioPublicación = 1954;
    
    System.out.println("Libro 2:");
    libroDos.mostrarInformacion();
    
    System.out.println("\nLibro 3:");
    libroTres.mostrarInformacion();
    
    System.out.println("\nLibro 4:");
    libroCuatro.mostrarInformacion();


  
}
}