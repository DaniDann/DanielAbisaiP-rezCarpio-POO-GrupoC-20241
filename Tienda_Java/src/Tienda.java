import java.util.*;
public class Tienda {
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private ArrayList<Producto> productos = new ArrayList<Producto>();;

    Tienda() {
        this.clientes = new ArrayList<>();
        this.productos = new ArrayList<>();
    }

    void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    void registrarProducto(Producto producto) {
        productos.add(producto);
        Producto.agregarStock();
    }

    void eliminarCliente(Cliente cliente) {
        if (cliente.getCompras().isEmpty()) {
            clientes.remove(cliente);
        } else {
            System.out.println("El cliente tiene compras asociadas");
        }
    }

    void eliminarProducto(Producto producto) {
        if (Producto.stock > 0) {
            productos.remove(producto);
            Producto.eliminarStock();
        } else {
            System.out.println("El producto no está en stock");
        }
    }

    int numeroClientes() {
        return clientes.size();
    }

    int numeroProductos() {
        return productos.size();
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }
}
