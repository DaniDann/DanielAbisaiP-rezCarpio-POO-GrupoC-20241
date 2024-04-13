package Usuario;
import utils.Rol;

public class Usuario {
    private static int CANTIDAD_USUARIOS = 1;
    private int id;
    private String nombre;
    private String apellido;
    private String telefono;
    private Rol rol;
    private String nombreUsuario;
    private String contrasena;
// utils ó helpers


    public Usuario(String nombre, String apellido, String telefono, Rol rol, String nombreUsuario, String contrasena) {

        this.id = CANTIDAD_USUARIOS ;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.rol = rol;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        CANTIDAD_USUARIOS ++;
    }

    public String mostrarInfo (){
        return String.format("id: %d, Nombre completo: %s %s, telefono: %s, rol: %s",
                id,nombre,apellido,telefono,rol);

    }

    public String getContrasena() {
        return contrasena;
    }

    public static void setCantidadUsuarios(int cantidadUsuarios) {
        CANTIDAD_USUARIOS = cantidadUsuarios;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public static int getCantidadUsuarios() {
        return CANTIDAD_USUARIOS;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public Rol getRol() {
        return rol;
    }
}