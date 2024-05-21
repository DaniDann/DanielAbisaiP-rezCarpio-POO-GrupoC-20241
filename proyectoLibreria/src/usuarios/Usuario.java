package usuarios;

import usuarios.utils.Rol;

import java.time.LocalDate;

public abstract class Usuario {
    private static int CANTIDAD_USUARIOS = 1;
    private int id;
    private String nombre;
    private String apellido;
    private String telefono;
    private Rol rol;
    // Usuarios.Cliente, Asistente, Gerente
    private String nombreUsuario;
    private String contraseña;
    private String fechaNacimiento;

    public Usuario(String nombre, String apellido, String telefono, Rol rol, String nombreUsuario, String contraseña, String fechaNacimiento) {
        this.id = CANTIDAD_USUARIOS;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.rol = rol;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        CANTIDAD_USUARIOS ++;
        this.fechaNacimiento = fechaNacimiento;

    }
    public String toString(){
        return String.format("Id: %d, Nombre completo: %s %s, Fecha Nacimiento: %s, Telefono: %s, Nombre Usuario: %s, Rol: %s",id,nombre,apellido, fechaNacimiento, telefono, nombreUsuario, rol);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}