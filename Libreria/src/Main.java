import Usuario.Asistente;
import Usuario.Cliente;
import utils.Rol;

public class Main {
  public static void main (String[] args ){

    Cliente cliente = new Cliente("Camarón", "Davs","4433232456");
    System.out.println(cliente.mostrarInfo());

  }

}