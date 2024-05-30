package usuarios;

import libreria.utils.DatosComun;
import usuarios.utils.EmpleadoUtils;
import usuarios.utils.Rol;
import libreria.Libreria;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Asistente extends Usuario implements EmpleadoUtils {
    private LocalDate fechaInicio;
    private double sueldo;
    private String RFC;
    public Asistente (String nombre, String apellido, String telefono, double sueldo, String RFC,String nombreUsuario, String contraseña, String fechaNacimiento){
        super(nombre,apellido,telefono, Rol.ASISTENTE,nombreUsuario,contraseña,fechaNacimiento);
        this.sueldo = sueldo;
        this.RFC = RFC;
        this.fechaInicio = LocalDate.now();
    }
    public String toString(){
        return String.format("%s, Fecha inicio: %s, Sueldo: %f, RFC: %s",super.toString(),fechaInicio,sueldo,RFC);
    }
    public static void registrarAsistente() {
        ArrayList<String> datosComun = DatosComun.obtenerDatosComun(Rol.ASISTENTE);
        Scanner scanner = new Scanner(System.in);

        String nombre = datosComun.get(0);

        String apellido = datosComun.get(1);

        String telefono = datosComun.get(2);

        System.out.println("Ingrese el sueldo");
        double sueldo = scanner.nextDouble();

        System.out.println("Ingrese el RFC");
        String RFC = scanner.nextLine();

        String nombreUsuario = datosComun.get(3);

        String contraseña = datosComun.get(4);

        String fechaNacimiento =datosComun.get(5);

        Asistente asistente = new Asistente(nombre, apellido, telefono, sueldo, RFC, nombreUsuario, contraseña, fechaNacimiento);

        if (!Libreria.usuarios.containsKey(Rol.ASISTENTE)) {
            Libreria.usuarios.put(Rol.ASISTENTE, new ArrayList<Usuario>());
        }
        Libreria.serializar();
        System.out.println("\nAsistente registrado exitosamente");
    }
    public static void mostrarAsistentes() {
        System.out.println("\n Asistentes de la Biblioteca");
        for (Usuario usuario : Libreria.usuarios.get(Rol.ASISTENTE)) {
            Asistente asistente = (Asistente) usuario;
            System.out.println(asistente.toString());
        }
    }
    public static void eliminarAsistente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEliminar Asistente");
        mostrarAsistentes();
        System.out.println("Ingrese el nombre de usuario del asistente que desea eliminar:");
        String nombreUsuario = scanner.nextLine();

        ArrayList<Usuario> asistentes = Libreria.usuarios.get(Rol.ASISTENTE);
        if (asistentes != null) {
            for (Usuario usuario : asistentes) {
                if (usuario instanceof Asistente && usuario.getNombreUsuario().equals(nombreUsuario)) {
                    asistentes.remove(usuario);
                    System.out.println("Asistente eliminado correctamente.");
                    return;
                }
            }
        }
        System.out.println("Asistente no encontrado.");
    }
    @Override
    public void checarEntrada(){
        System.out.println("Checar entrada por correo");
    }
    @Override
    public void checarSalida(){
        System.out.println("Checar salida por correo");
    }
}
