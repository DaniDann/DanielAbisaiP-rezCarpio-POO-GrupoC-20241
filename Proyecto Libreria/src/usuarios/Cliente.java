package usuarios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import libreria.utils.DatosComun;
import libreria.Libreria;
import usuarios.utils.Rol;
public class Cliente extends Usuario {
    private LocalDate fechaRegistro;
    public Cliente (String nombre, String apellido, String telefono, String nombreUsuario, String contraseña , String fechaNacimiento){
        super(nombre,apellido,telefono,Rol.CLIENTE,nombreUsuario,contraseña,fechaNacimiento);
        this.fechaRegistro = LocalDate.now();
    }
    @Override
    public String toString(){
        return String.format("%s, Fecha registro: %s",super.toString(),fechaRegistro);
    }
    public static void registrarCliente() {
        ArrayList<String> datosComun = DatosComun.obtenerDatosComun(Rol.CLIENTE);
        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        String telefono = datosComun.get(2);
        String nombreUsuario = datosComun.get(3);
        String contraseña = datosComun.get(4);
        String fechaNacimiento = datosComun.get(5);

        Cliente cliente = new Cliente(nombre, apellido, telefono, nombreUsuario, contraseña, fechaNacimiento);

        if (!Libreria.usuarios.containsKey(Rol.CLIENTE)) {
            Libreria.usuarios.put(Rol.CLIENTE, new ArrayList<Usuario>());
        }
        Libreria.usuarios.get(Rol.CLIENTE).add(cliente);
        System.out.println("\nCliente registrado exitosamente");

    }
    public static void mostrarClientes() {
        System.out.println("\n Clientes de la Biblioteca");

        for (Usuario usuario : Libreria.usuarios.get(Rol.CLIENTE)) {
            Cliente cliente = (Cliente) usuario;
            System.out.println(cliente.toString());
        }
    }
    public static void eliminarCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEliminar Cliente");
        mostrarClientes();
        System.out.println("Ingrese el nombre de usuario del cliente que desea eliminar:");
        String nombreUsuario = scanner.nextLine();

        ArrayList<Usuario> clientes = Libreria.usuarios.get(Rol.CLIENTE);
        if (clientes != null) {
            for (Usuario usuario : clientes) {
                if (usuario instanceof Cliente && usuario.getNombreUsuario().equals(nombreUsuario)) {
                    clientes.remove(usuario);
                    System.out.println("Cliente eliminado correctamente.");
                    return;
                }
            }
        }
        System.out.println("Cliente no encontrado.");
    }
}