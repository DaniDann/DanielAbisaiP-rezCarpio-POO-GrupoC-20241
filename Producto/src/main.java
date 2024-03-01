public class main {
        public static void main(String[] args) {


            String[] nombreProducto1 = {"Audifonos billboard "};
            Producto producto1 = new Producto(nombreProducto1, 1045.99, 100);

            System.out.println("Nombre del producto : " + producto1.getNombre()[0]);
            System.out.println("Precio del producto  : " + producto1.getPrecio());
            System.out.println("Stock del producto  : " + producto1.getStock());

            producto1.aumentarStock(70);
            System.out.println("Nuevo stock del producto después de aumentarlo: " + producto1.getStock());

            producto1.reducirStock(80);
            System.out.println("Nuevo stock del producto después de reducirlo: " + producto1.getStock());
        }
    }


