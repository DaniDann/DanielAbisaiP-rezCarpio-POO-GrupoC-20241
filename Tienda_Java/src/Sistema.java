public class Sistema {
    private String password;
    private Tienda tienda;

    Sistema(String password) {
        this.password = password;
        this.tienda = new Tienda();
    }

    boolean login(String password) {
        if (this.password.equals(password)) {
            return true;
        } else {
            System.out.println("Contraseña incorrecta");
            return false;
        }
    }

    void registrarCliente(Cliente cliente) {
        if (login(password)) {
            tienda.registrarCliente(cliente);
        }
    }

    void registrarProducto(Producto producto) {
        if (login(password)) {
            tienda.registrarProducto(producto);
        }
    }

    void eliminarCliente(Cliente cliente) {
        if (login(password)) {
            tienda.eliminarCliente(cliente);
        }
    }

    void eliminarProducto(Producto producto) {
        if (login(password)) {
            tienda.eliminarProducto(producto);
        }
    }

    int numeroClientes() {
        if (login(password)) {
            return tienda.numeroClientes();
        }
        return -1;
    }

    int numeroProductos() {
        if (login(password)) {
            return tienda.numeroProductos();
        }
        return -1;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }
}
