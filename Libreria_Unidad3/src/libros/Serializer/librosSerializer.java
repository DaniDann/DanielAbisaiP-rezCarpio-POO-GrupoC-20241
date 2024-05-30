package libros.Serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import libros.Libro;
import libros.constants.Genero;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class librosSerializer {

    public static void serialize(HashMap<Genero, ArrayList<Libro>> libros) {
        Gson json = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("libros.json"));
            json.toJson(libros, writer);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

