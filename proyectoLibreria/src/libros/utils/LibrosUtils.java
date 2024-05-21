package libros.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LibrosUtils {

    public static ArrayList<String> registrarLibroDatosComun(){
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> datosComun = new ArrayList<>();

        System.out.println("Ingresa el nombre del libro: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingresa el autor del libro: ");
        String autor = scanner.nextLine();
        System.out.println("Ingresa la editorial del libro: ");
        String editorial = scanner.nextLine();
        System.out.println("Ingresa el dia de publicacion del libro: ");
        int dia = scanner.nextInt();
        System.out.println("Ingresa el mes de publicacion del libro: ");
        int mes = scanner.nextInt();
        System.out.println("Ingresa el año de publicacion del libro: ");
        int año = scanner.nextInt();
        LocalDate fecha = LocalDate.of(año,mes,dia);
        System.out.println("Ingresa el precio del libro: ");
        double precio = scanner.nextDouble();
        System.out.println("Ingresa el stock del libro: ");
        int stock = scanner.nextInt();

        datosComun.addAll(Arrays.asList(nombre,autor,editorial,String.valueOf(fecha),String.valueOf(precio),String.valueOf(stock)));

        return datosComun;
    }
}