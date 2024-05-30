package libreria.utils;

import usuarios.Usuario;
import usuarios.utils.Rol;
import libreria.Libreria;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class DatosComun {
    public static ArrayList<String> obtenerDatosComun(Rol rol) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> datosComun = new ArrayList<String>();
        String rolUsuario = rol == Rol.CLIENTE ? "Cliente" : rol == Rol.ASISTENTE ? "Asistente" : "Gerente";
        System.out.println(String.format("Bienvenidos al registro del %s", rolUsuario));

        System.out.println("Ingresa los siguientes datos:");

        System.out.println("Ingresa el nombre:");
        String nombre = scanner.nextLine();

        System.out.println("Ingresa el apellido:");
        String apellido = scanner.nextLine();

        String telefono = registrarTelefonoUsuario();

        String nombreUsuario = registrarNombreUsuario();

        System.out.println("Ingrese contraseña:");
        String contraseña = scanner.nextLine();

        String fechaNacimiento = registrarFechaNacimiento();

        datosComun.addAll(Arrays.asList(nombre, apellido, telefono, nombreUsuario, contraseña, fechaNacimiento));

        return datosComun;
    }
    private static String registrarTelefonoUsuario() {
        Scanner scanner = new Scanner(System.in);
        String telefono = "";
        boolean telefonoExistente;

        do {
            System.out.println("Ingresa telefono:");
            telefono = scanner.nextLine();

            telefonoExistente = false;

            for (ArrayList<Usuario> listaUsuarios : Libreria.usuarios.values()) {
                for (Usuario usuario : listaUsuarios) {
                    if (usuario.getTelefono().equals(telefono)) {
                        telefonoExistente = true;
                        break;
                    }
                }
                if (telefonoExistente) {
                    break;
                }
            }

            if (telefonoExistente) {
                System.out.println("El telefono ya se encuentra registrado. Intenta de nuevo");
            }
        } while (telefonoExistente);

        return telefono;
    }

    private static String registrarNombreUsuario() {
        Scanner scanner = new Scanner(System.in);
        String nombreUsuario = "";
        boolean nombreUsuarioExistente;

        do {
            System.out.println("Ingrese el nombre de usuario:");
            nombreUsuario = scanner.nextLine();

            nombreUsuarioExistente = false;

            for (ArrayList<Usuario> listaUsuarios : Libreria.usuarios.values()) {
                for (Usuario usuario : listaUsuarios) {
                    if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                        nombreUsuarioExistente = true;
                        break;
                    }
                }
                if (nombreUsuarioExistente) {
                    break;
                }
            }

            if (nombreUsuarioExistente) {
                System.out.println("El nombre de usuario ya se encuentra registrado. Intenta de nuevo");
            }
        } while (nombreUsuarioExistente);

        return nombreUsuario;
    }

    private static String registrarFechaNacimiento(){
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        String fechaNacimientoString;
        Date fechaNacimiento = null;

        do {
            System.out.println("Ingrese la fecha de nacimiento (formato dd/MM/yyyy):");
            fechaNacimientoString = scanner.nextLine();

            try {
                fechaNacimiento = sdf.parse(fechaNacimientoString);
            } catch (ParseException e) {
                System.out.println("Formato de fecha incorrecto. Intente nuevamente.");
                continue;
            }
            if (!fechaEsValida(fechaNacimiento)) {
                System.out.println("La fecha de nacimiento no es válida. Intente nuevamente.");
            }

        } while (!fechaEsValida(fechaNacimiento));

        return sdf.format(fechaNacimiento);
    }

    private static boolean fechaEsValida(Date fecha) {
        Date fechaActual = new Date();
        return !fecha.after(fechaActual);
    }

}
