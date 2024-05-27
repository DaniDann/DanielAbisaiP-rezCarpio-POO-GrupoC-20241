package libreria;
import libros.Libro;
import libros.constants.Genero;
import usuarios.Asistente;
import usuarios.Cliente;
import usuarios.Gerente;
import usuarios.Usuario;
import usuarios.utils.Rol;
import java.util.ArrayList;
import java.util.*;
public class Libreria {

    Scanner scanner = new Scanner(System.in);
    public static final HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap<Rol, ArrayList<Usuario>>();
    public static final HashMap<Genero, ArrayList<Libro>> libros = new HashMap<>();
    public Libreria(){

        Asistente asistente = new Asistente("Danniel","Carpio","4432657890",27500,"PECD797782G","DaniDAn","89752","23/04/2004");

    }
    private  void inicializarHashMap() {
        usuarios.put(Rol.ASISTENTE, new ArrayList<>());
        usuarios.put(Rol.GERENTE, new ArrayList<>());
        usuarios.put(Rol.CLIENTE, new ArrayList<>());

        libros.put(Genero.TERROR, new ArrayList<>());
        libros.put(Genero.ACCION, new ArrayList<>());
        libros.put(Genero.COMEDIA, new ArrayList<>());
    }
    public Usuario verificarInicioSesion(String nombreUsuario, String contraseña) {
        for (Map.Entry<Rol, ArrayList<Usuario>> entry : usuarios.entrySet()) {
            for (Usuario usuario : entry.getValue()) {
                if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContraseña().equals(contraseña)) {
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
}