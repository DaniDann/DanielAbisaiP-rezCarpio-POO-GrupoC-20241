import java.util.*;
public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema("124578");
        Scanner scanner = new Scanner(System.in);

        System.out.println("----- BIENVENIDO A LA TIENDA EL RAYITO -----");
        System.out.print("Por favor, introduce la contraseña para acceder al menu: ");
        String passwordIngresada = scanner.nextLine();
        if (!sistema.login(passwordIngresada)) {
            System.out.println("Contraseña incorrecta. Acceso denegado.");
            return;
        }

        while (true) {
            System.out.println("1. Registrar cliente");
            System.out.println("2. Registrar producto");
            System.out.println("3. Eliminar cliente");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Número de clientes");
            System.out.println("6. Número de productos");
            System.out.println("7. Ver productos");
            System.out.println("8. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del cliente: ");
                    String nombreCliente = scanner.nextLine();
                    Cliente clientes = new Cliente(nombreCliente);
                    sistema.registrarCliente(clientes);
                    break;
                case 2:
                    System.out.println("¿Qué tipo de producto quieres registrar?");
                    System.out.println("1. Electrodoméstico");
                    System.out.println("2. Producto de limpieza");
                    System.out.println("3. Producto de belleza");
                    System.out.println("4. Alimento");
                    System.out.print("Elige una opción: ");
                    int tipoProducto = scanner.nextInt();
                    scanner.nextLine();  // consume newline

                    System.out.print("Nombre del producto: ");
                    String nombreProducto = scanner.nextLine();
                    System.out.print("Precio del producto: ");
                    double precioProducto = scanner.nextDouble();
                    scanner.nextLine();  // consume newline
                    Date fechaImportacion = new Date();  // la fecha actual
                    System.out.print("Número de serie del producto: ");
                    String numeroSerie = scanner.nextLine();

                    switch (tipoProducto) {
                        case 1:
                            System.out.print("Marca del electrodoméstico: ");
                            String marca = scanner.nextLine();
                            Electrodomesticos electrodomestico = new Electrodomesticos(nombreProducto, precioProducto, fechaImportacion, numeroSerie, marca);
                            sistema.registrarProducto(electrodomestico);
                            break;
                        case 2:
                            System.out.print("¿Es biodegradable el producto de limpieza? (true/false): ");
                            boolean esBiodegradable = scanner.nextBoolean();
                            scanner.nextLine();  // consume newline
                            Limpieza limpieza = new Limpieza(nombreProducto, precioProducto, fechaImportacion, numeroSerie, esBiodegradable);
                            sistema.registrarProducto(limpieza);
                            break;
                        case 3:
                            System.out.print("¿Es vegano el producto de belleza? (true/false): ");
                            boolean esVegano = scanner.nextBoolean();
                            scanner.nextLine();  // consume newline
                            Maquillaje belleza = new Maquillaje(nombreProducto, precioProducto, fechaImportacion, numeroSerie, esVegano);
                            sistema.registrarProducto(belleza);
                            break;
                        case 4:
                            System.out.print("Fecha de caducidad del alimento (dd/MM/yyyy): ");
                            String fechaCaducidad = scanner.nextLine();
                            Alimento alimento = new Alimento(nombreProducto, precioProducto, fechaImportacion, numeroSerie, fechaCaducidad);
                            sistema.registrarProducto(alimento);
                            break;
                        default:
                            System.out.println("Opción no válida");
                    }
                    break;
                case 3:
                    System.out.print("Nombre del cliente a eliminar: ");
                    String nombreClienteEliminar = scanner.nextLine();
                    Cliente clienteEliminar = null;
                    for (Cliente cliente : sistema.getTienda().getClientes()) {
                        if (cliente.getNombre().equals(nombreClienteEliminar)) {
                            clienteEliminar = cliente;
                            break;
                        }
                    }
                    if (clienteEliminar != null) {
                        sistema.eliminarCliente(clienteEliminar);
                        System.out.println("Cliente eliminado exitosamente.");
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Número de serie del producto a eliminar: ");
                    String numeroSerieEliminar = scanner.nextLine();
                    Producto productoEliminar = null;
                    for (Producto producto : sistema.getTienda().getProductos()) {
                        if (producto.getNumeroSerie().equals(numeroSerieEliminar)) {
                            productoEliminar = producto;
                            break;
                        }
                    }
                    if (productoEliminar != null) {
                        sistema.eliminarProducto(productoEliminar);
                        System.out.println("Producto eliminado exitosamente.");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 5:
                    System.out.println("Número de clientes: " + sistema.numeroClientes());
                    break;
                case 6:
                    System.out.println("Número de productos: " + sistema.numeroProductos());
                    break;
                case 7:
                    System.out.println("Productos:");
                    for (Producto producto : sistema.getTienda().getProductos()) {
                        System.out.println("Nombre: " + producto.getNombre() + ", Precio: " + producto.getPrecio() + ", Número de serie: " + producto.getNumeroSerie());
                    }
                    break;
                case 8:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}
