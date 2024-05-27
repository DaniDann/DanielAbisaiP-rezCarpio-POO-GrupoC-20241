import java.util.*;
public class Cliente {
    String nombre;
    private ArrayList<Producto> compras = new ArrayList<Producto>();;

    Cliente(String nombre) {
        this.nombre = nombre;
        this.compras = new ArrayList<>();
    }

    void comprar(Producto producto) {
        compras.add(producto);
        Producto.eliminarStock();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Producto> getCompras() {
        return compras;
    }

    public void setCompras(ArrayList<Producto> compras) {
        this.compras = compras;
    }
}
