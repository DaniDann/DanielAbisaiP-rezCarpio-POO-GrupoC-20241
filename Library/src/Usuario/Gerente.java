package Usuario ;


import utils.Rol;

public class Gerente extends Usuario{
    private double sueldo;
    private String INE;


    public Gerente(String nombre, String apellido, String telefono, String nombreUsuario, String contrasena) {
        super(nombre, apellido, telefono, Rol.GERENTE, nombreUsuario,contrasena);
        this.sueldo = sueldo;
        this.INE = INE;


    }
    @Override
    public String mostrarInfo() {
        return String.format("%s, Sueldo: %s", "%s, INE: %s,", super.mostrarInfo(), sueldo, INE);
    }
}