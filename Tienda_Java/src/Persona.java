public class Persona {
    String nombre;
    String direccion;

    Persona(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    String getNombre() {
        return nombre;
    }

    void setNombre(String nombre) {
        this.nombre = nombre;
    }

    String getDireccion() {
        return direccion;
    }

    void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
