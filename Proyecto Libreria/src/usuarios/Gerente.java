package usuarios;

import libreria.utils.DatosComun;
import usuarios.utils.EmpleadoUtils;
import usuarios.utils.Rol;
import libreria.Libreria;

import java.util.ArrayList;
import java.util.Scanner;

public class Gerente extends Usuario implements EmpleadoUtils {
    private double sueldo;
    private String RFC;
    private String INE;
    public Gerente (String nombre, String apellido, String telefono, double sueldo, String RFC, String INE, String nombreUsuario, String contraseña, String fechaNacimiento){
        super(nombre,apellido,telefono, Rol.GERENTE,nombreUsuario,contraseña,fechaNacimiento);
        this.sueldo = sueldo;
        this.RFC = RFC;
        this.INE = INE;
    }
    @Override
    public String toString(){
        return String.format("%s, Sueldo: %f, RFC: %s, INE: %s",super.toString(),sueldo,RFC,INE);
    }
    public static void registrarGerente() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> datosComun = DatosComun.obtenerDatosComun(Rol.GERENTE);

        String nombre = datosComun.get(0);

        String apellido = datosComun.get(1);

        String telefono = datosComun.get(2);

        System.out.println("Ingresa el sueldo");
        double sueldo = scanner.nextDouble();

        System.out.println("Ingrese el RFC");
        String RFC = scanner.nextLine();

        System.out.println("Ingrese el INE");
        String INE = scanner.nextLine();

        String nombreUsuario = datosComun.get(3);

        String contraseña = datosComun.get(4);

        String fechaNacimiento = datosComun.get(5);

        Gerente gerente = new Gerente(nombre, apellido, telefono, sueldo, RFC, INE, nombreUsuario, contraseña,fechaNacimiento);

        if (!Libreria.usuarios.containsKey(Rol.GERENTE)) {
            Libreria.usuarios.put(Rol.GERENTE, new ArrayList<Usuario>());
        }
        Libreria.usuarios.get(Rol.GERENTE).add(gerente);

        System.out.println("\nGerente registrado exitosamente");
    }
    public static void mostrarGerentes() {
        System.out.println("\n Gerentes de la Biblioteca");
        for (Usuario usuario : Libreria.usuarios.get(Rol.GERENTE)) {
            Gerente gerente = (Gerente) usuario;
            System.out.println(gerente.toString());
        }
    }
    public static void eliminarGerente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEliminar Gerente");
        mostrarGerentes();
        System.out.println("Ingrese el nombre de usuario del gerente que desea eliminar:");
        String nombreUsuario = scanner.nextLine();

        ArrayList<Usuario> gerentes = Libreria.usuarios.get(Rol.GERENTE);
        if (gerentes != null) {
            for (Usuario usuario : gerentes) {
                if (usuario instanceof Gerente && usuario.getNombreUsuario().equals(nombreUsuario)) {
                    gerentes.remove(usuario);
                    System.out.println("Gerente eliminado correctamente.");
                    return;
                }
            }
        }
        System.out.println("Gerente no encontrado.");
    }
    @Override
    public void checarEntrada(){
        System.out.println("Checar entrada por huella");
    }
    @Override
    public void checarSalida(){
        System.out.println("Checar salida por huella");
    }
}