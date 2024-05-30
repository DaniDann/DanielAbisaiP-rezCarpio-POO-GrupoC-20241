import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import libreria.Menu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
            Menu menu = new Menu();
            menu.iniciarSesion();


        // Lectura y escritura de archivos

        //Escritura de archivos

        /*Estudiante estudiante = new Estudiante("1","Juan","4431033125");
        Estudiante estudiante2 = new Estudiante("2","Pedro","0000000000");
        Trabajador trabajador = new Trabajador("1","Alberto","1414141414");
        Trabajador trabajador2 = new Trabajador("2","karen","4421010201");


        HashMap<String, ArrayList<?>> data = new HashMap<>();


        ArrayList<Trabajador> trabajadores = new ArrayList<>();
        trabajadores.add(trabajador);
        trabajadores.add(trabajador2);

        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(estudiante);
        estudiantes.add(estudiante2);

        data.put("Trabajadores:",trabajadores);
        data.put("Estudiantes:",estudiantes);

        //Gson json = new Gson();
        Gson json = new GsonBuilder().setPrettyPrinting().create();


        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("data.json"));
            json.toJson(data,writer);
            writer.close();
        }catch (IOException e){
            System.out.println(e);
        }catch (Exception e){
            System.out.println(e);
        }*/

    }
}
