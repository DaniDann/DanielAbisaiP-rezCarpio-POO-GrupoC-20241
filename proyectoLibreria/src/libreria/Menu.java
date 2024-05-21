package libreria;

import libros.Libro;
import libros.LibroAccion;
import libros.LibroComedia;
import libros.LibroTerror;
import usuarios.Usuario;
import utils.UsuarioEnSesion;

import java.util.*;

public class Menu {
    private Libreria libreria = new Libreria();

    public void iniciarSesion() {
        Scanner scanner = new Scanner(System.in);
        boolean datosCorrectos = false;

        do {
            System.out.println("\nBienvenido al Sistema Biblioteca");
            System.out.println("Inicia sesión\n");

            System.out.println("Ingresa tu usuario: ");
            String usuario = scanner.nextLine();

            System.out.println("Ingresa tu contrasena: ");
            String contrasena = scanner.nextLine();

            Usuario usuarioActual = libreria.verificarInicioSesion(usuario, contrasena);
            if (usuarioActual != null) {
                datosCorrectos = true;
                UsuarioEnSesion.obtenerInstancia().setUsuarioActual(usuarioActual);
                seleccionarMenu();
            } else {
                System.out.println("\nUsuario y/o contrasena incorrectos. Intenta nuevamente.");
            }
        } while(!datosCorrectos);
    }

    private void seleccionarMenu() {
        Usuario usuario = UsuarioEnSesion.obtenerInstancia().getUsuarioActual();
        switch (usuario.getRol()) {
            case CLIENTE -> mostrarMenuCliente();
            case ASISTENTE -> mostrarMenuAsistente();
            case GERENTE -> mostrarMenuGerente();
        }
    }

    private void mostrarMenuCliente() {
        Scanner scanner = new Scanner(System.in);

        int opcion = 0;

        do {
            System.out.println("\nMenú Cliente");
            System.out.println("Selecciona una opción para continuar");
            System.out.println("1. Ver libros disponibles");
            System.out.println("2. Consultar mis rentas");
            System.out.println("3. Mostrar mis datos");
            System.out.println("4. Editar mi información");
            System.out.println("5. Cerrar sesión");

            System.out.println("Ingresa la opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    break;
                case 5:
                    UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                    iniciarSesion();
                    break;
            }
        } while(opcion != 5);
    }

    private void mostrarMenuAsistente() {
        Scanner scanner = new Scanner(System.in);

        int opcion = 0;
        do {
            System.out.println("\nMenú Asistente");
            System.out.println("Selecciona una opción para continuar");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Mostrar Clientes");
            System.out.println("3. Registrar libro");
            System.out.println("4. Mostrar libros");
            System.out.println("5. Cerrar sesión");

            System.out.println("Ingresa la opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    libreria.registrarCliente();
                    break;
                case 2:
                    libreria.mostrarClientes();
                    break;
                case 3:
                    menuRegistrarLibro();
                    break;
                case 4:
                    menuMostrarLibro();
                    break;
                case 5:
                    ;
                case 6:
                    UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                    iniciarSesion();
                    break;
            }
        } while(opcion != 6);
    }

    private void menuRegistrarLibro() {
        Scanner scanner = new Scanner(System.in);
        int opcionMenuRegistrarLibro = 0;
        boolean esDatoValido = false;

        do {
            System.out.println("\nRegistrar libro");
            System.out.println("Ingresa el tipo de libro que deseas registrar");
            System.out.println("1. Acción");
            System.out.println("2. Comedia");
            System.out.println("3. Terror");
            System.out.println("4. Salir");

            while (!esDatoValido) {
                try {
                    opcionMenuRegistrarLibro = scanner.nextInt();

                    if (opcionMenuRegistrarLibro > 4 || opcionMenuRegistrarLibro < 1) {
                        throw new InputMismatchException();
                    }
                    esDatoValido = true;
                } catch (InputMismatchException error) {
                    System.out.println("Valor incorrecto, intenta de nuevo");
                } finally {
                    scanner.nextLine();
                }
            }

            esDatoValido = false;

            switch (opcionMenuRegistrarLibro) {
                case 1:
                    LibroAccion.registrarLibro();
                    break;
                case 2:
                    LibroComedia.registrarLibro();
                    break;
                case 3:
                    LibroTerror.registrarLibro();
                    break;
            }

        } while(opcionMenuRegistrarLibro != 4);
    }

    private void menuMostrarLibro() {
        Scanner scanner = new Scanner(System.in);
        int opcionMenuMostrarLibro = 0;
        boolean esDatoValido = false;

        do {
            System.out.println("\nMostrar libro");
            System.out.println("Ingresa el tipo de libro que deseas registrar");
            System.out.println("1. Acción");
            System.out.println("2. Comedia");
            System.out.println("3. Terror");
            System.out.println("4. Salir");

            while (!esDatoValido) {
                try {
                    opcionMenuMostrarLibro = scanner.nextInt();

                    if (opcionMenuMostrarLibro > 4 || opcionMenuMostrarLibro < 1) {
                        throw new InputMismatchException();
                    }
                    esDatoValido = true;
                } catch (InputMismatchException error) {
                    System.out.println("Valor incorrecto, intenta de nuevo");
                } finally {
                    scanner.nextLine();
                }
            }

            esDatoValido = false;

            switch (opcionMenuMostrarLibro) {
                case 1:
                    LibroAccion.mostrarListadoLibros();
                    break;
                case 2:
                    LibroComedia.mostrarListadoLibros();
                    break;
                case 3:
                    LibroTerror.mostrarListadoLibros();
                    break;
            }

        } while(opcionMenuMostrarLibro != 4);
    }



    private void mostrarMenuGerente() {
        Scanner scanner = new Scanner(System.in);

        int opcion = 0;

        do {
            System.out.println("\nMenú Gerente");
            System.out.println("Selecciona una opción para continuar");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Mostrar Clientes");
            System.out.println("3. Registrar Asistente");
            System.out.println("4. Mostrar Asistentes");
            System.out.println("5. Cerrar sesión");

            switch (opcion) {
                case 1:
                    libreria.registrarCliente();
                    break;
                case 2:
                    libreria.mostrarClientes();
                    break;
                case 3:
                    libreria.registrarAsistente();
                    break;
                case 5:
                    UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                    iniciarSesion();
                    break;
            }
        } while(opcion != 3);
    }
}