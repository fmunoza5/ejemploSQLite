package cl.fmunoza.ejemplosqlite;

public class Contactos {

    String Nombre, telefono;
    String id;

    //CONSTRUCTORES
    public Contactos (){}
    public Contactos(String nombre, String telefono, String id) {
        this.Nombre = nombre;
        this.telefono = telefono;
        this.id = id;
    }

    public Contactos(String nombre, String telefono) {
        this.Nombre = nombre;
        this.telefono = telefono;
    }

    // METODOS GET/SET
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
