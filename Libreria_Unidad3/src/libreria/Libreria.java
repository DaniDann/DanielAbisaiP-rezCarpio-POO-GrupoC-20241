package libreria;
import com.google.gson.annotations.Expose;
import libros.Libro;
import libros.Serializer.librosSerializer;
import libros.constants.Genero;
import usuarios.Asistente;
import usuarios.Cliente;
import usuarios.Gerente;
import usuarios.Serializer.serializer;
import usuarios.Usuario;
import usuarios.utils.Rol;
import java.util.ArrayList;
import java.util.*;

public class Libreria {
    @Expose(serialize = false, deserialize = false)
    private Scanner leer = new Scanner(System.in);
    //private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    public static final HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap<Rol, ArrayList<Usuario>>(); //para poder acceder a este desde otras clases y que no se cambie su valor.
    public static  final HashMap<Genero, ArrayList<Libro>> libros = new HashMap<Genero, ArrayList<Libro>>();
    public Libreria(){

        inicializarHashMap();


    }
    private  void inicializarHashMap() {
        Asistente asistente = new Asistente ( "Joshua", "Davalos","4431013128",  20000,  "DAD", "Joshua",  "123", String.format("2005, 10, 20"));
        Gerente gerente = new Gerente ( "Juan", "Perez","4432145863",  30000,  "JUAN1737", "JUAIDWUJED",  "Juan","123", String.format("2000, 10, 24"));

        usuarios.put(Rol.CLIENTE, new ArrayList<Usuario>());
        usuarios.put(Rol.ASISTENTE, new ArrayList<Usuario>());
        usuarios.get(Rol.ASISTENTE).add(asistente);
        usuarios.put(Rol.GERENTE, new ArrayList<Usuario>());
        usuarios.get(Rol.GERENTE).add(gerente);
        libros.put(Genero.TERROR, new ArrayList<Libro>());
        libros.put(Genero.ACCION, new ArrayList<Libro>());
        libros.put(Genero.COMEDIA, new ArrayList<Libro>());
    }



    public Usuario verificarInicioSesion(String nombreUsuario, String contraseña) {
        for (Map.Entry<Rol, ArrayList<Usuario>> entry : usuarios.entrySet()) {
            for (Usuario usuario : entry.getValue()) {
                if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContrasena().equals(contraseña)) {
                    return usuario;
                }
            }
        }
        return null;
    }
    public static void registrarCliente(){
        Cliente.registrarCliente();
    }


    public static void registrarAsistente() {
        Asistente.registrarAsistente();
    }

    public static void registrarGerente() {
        Gerente.registrarGerente();
    }

    public void mostrarClientes() {
        Cliente.mostrarClientes();
    }

    public void mostrarAsistentes() {
       Asistente.mostrarAsistentes();
    }

    public void mostrarGerentes() {
       Gerente.mostrarGerentes();
    }

    public void eliminarCliente() {
        Cliente.eliminarCliente();
    }

    public void eliminarAsistente() {
        Asistente.eliminarAsistente();
    }

    public void eliminarGerente() {
        Gerente.eliminarGerente();
    }
    public  static void serializar(){
        serializer.serialize(usuarios);
        librosSerializer.serialize(libros);
    }
}