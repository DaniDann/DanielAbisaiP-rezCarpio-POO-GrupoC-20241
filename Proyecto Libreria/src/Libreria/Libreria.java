package libreria;
import usuarios.Asistente;
import usuarios.Cliente;
import usuarios.Gerente;
import usuarios.utils.Rol;
import java.util.ArrayList;
import java.util.*;
public class Libreria {

    Scanner scanner = new Scanner(System.in);
    //@SuppressWarnings("rawTypes")
    //private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    public static final HashMap<Rol, ArrayList<Usuario> usuarios = new HashMap<Rol, ArrayList<Usuario>>();
    public Libreria(){
        if (!usuarios.containsKey(Rol.ASISTENTE)){
            usuarios.put(Rol.ASISTENTE, new ArrayList<>());
        }

        Asistente asistente = new Asistente("Joshua","Davalos","4431013128",2500,"wiifwifief65685","Joshua1020YT","124578","20/10/2005");
        usuarios.get(Rol.ASISTENTE).add(asistente);
    }
    private ArrayList<Libro> libros = new ArrayList<Libro>();

    public usuario verificarInicioSesion(String nombreUsuario, String contraseña) {
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

    public void registrarLibro() {
        System.out.println("\nRegistrar Libreria.Libro");

        System.out.println("Ingrese el título del libro:");
        String titulo = scanner.nextLine();

        System.out.println("Ingrese el autor del libro:");
        String autor = scanner.nextLine();

        System.out.println("Ingrese el año de publicación del libro:");
        int añoPublicacion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        System.out.println("Ingrese el ISBN del libro:");
        String isbn = scanner.nextLine();

        Libro libro = new Libro(titulo, autor, añoPublicacion, isbn);
        libros.add(libro);

        System.out.println("Libreria.Libro registrado correctamente.");
    }

    public void mostrarLibros() {
        System.out.println("\nLista de Libros:");
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }
}