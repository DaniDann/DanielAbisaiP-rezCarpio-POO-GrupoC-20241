package libreria;
import utils.UsuarioEnSesion;
import java.util.Scanner;


public class Menu {
    private Libreria libreria = new Libreria();
    private Usuario usuarioActual = null;

    public  void iniciarSesion(){
        Scanner scanner = new Scanner(System.in);
        boolean datosCorrectos = false;

        do {
            System.out.println("\n BIENVENIDOS AL SISTEMA DE LA BIBLIOTECA");
            System.out.println("Para continuar inicia sesion\n");

            System.out.println("Ingresa tu usuario: ");
            String usuario = scanner.nextLine();

            System.out.println("Ingresa tu contraseña: ");
            String contraseña = scanner.nextLine();

            Usuario usuarioActual = libreria.verificarInicioSesion(usuario, contraseña);
            if (usuarioActual != null){
                datosCorrectos = true;
                UsuarioEnSesion.obtenerInstancia().setUsuarioActual(usuarioActual);
                selecionarMenu();
            }else{
                System.out.println("Usuario o contraseña incorrectos");
                System.out.println("Intenta de nuevo");
            }
        }while (!datosCorrectos);
    }
    private void selecionarMenu(){
        Usuario usuario = UsuarioEnSesion.obtenerInstancia().getUsuarioActual();
        switch (usuario.getRol()){
            case CLIENTE ->/*Funciones lambda*/ mostrarMenuCliente();
            case ASISTENTE -> mostrarMenuAsistente();
            case GERENTE -> mostrarMenuGerente();
        }
    }
    private void mostrarMenuCliente(){
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("BIENVENIDO CLIENTE:");
            System.out.println("1. Ver libros disponibles");
            System.out.println("2. Consultar rentas");
            System.out.println("3. Consultar mis datos");
            System.out.println("4. Editar mi infomacion");
            System.out.println("5. Cerrar sesion");
            System.out.println("Seleccione una opción:");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    libreria.mostrarLibros();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                    iniciarSesion();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intenta de nuevo.");
            }
        } while (opcion != 5);
    }

    private void mostrarMenuAsistente(){
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("BIENVENIDO ASISTENTE:");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Consultar clientes");
            System.out.println("3. Registrar libro");
            System.out.println("4. Consultar libros");
            System.out.println("5. Cerrar sesion");
            System.out.println("Seleccione una opción:");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    libreria.registrarCliente();
                    break;
                case 2:
                    libreria.mostrarClientes();
                    break;
                case 3:
                    libreria.registrarLibro();
                    break;
                case 4:
                    libreria.mostrarLibros();
                    break;
                case 5:
                    UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                    iniciarSesion();
                    break;
            }
        } while (opcion != 5);

    }
    private void mostrarMenuGerente(){
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("BIENVENIDO GERENTE:");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Registrar asistente");
            System.out.println("3. Registrar gerente");
            System.out.println("4. Registrar libro");
            System.out.println("5. Consultar clientes");
            System.out.println("6. Consultar asistentes");
            System.out.println("7. Consultar gerentes");
            System.out.println("8. Consultar libros");
            System.out.println("9. Eliminar cliente");
            System.out.println("10. Eliminar asistente");
            System.out.println("11. Eliminar gerente");
            System.out.println("12. Cerrar sesion");
            System.out.println("Seleccione una opción:");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    libreria.registrarCliente();
                    break;
                case 2:
                    libreria.registrarAsistente();
                    break;
                case 3:
                    libreria.registrarGerente();
                    break;
                case 4:
                    libreria.registrarLibro();
                    break;
                case 5:
                    libreria.mostrarClientes();
                case 6:
                    libreria.mostrarAsistentes();
                    break;
                case 7:
                    libreria.mostrarGerentes();
                    break;
                case 8:
                    libreria.mostrarLibros();
                case 9:
                    libreria.eliminarCliente();
                    break;
                case 10:
                    libreria.eliminarAsistente();
                    break;
                case 11:
                    libreria.eliminarGerente();
                    break;
                case 12 :
                    UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                    iniciarSesion();
                    break;
            }
        } while (opcion != 12);
    }
}