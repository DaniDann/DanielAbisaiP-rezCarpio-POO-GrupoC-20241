import usuarios.utils.Rol;

public class Estudiante {

        private String id;
        private String nombre;
        private String telefono;

        public Estudiante(String id,String nombre, String telefono) {
            this.id = id;
            this.nombre = nombre;
            this.telefono = telefono;
        }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
