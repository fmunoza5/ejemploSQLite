package cl.fmunoza.ejemplosqlite;

public class Contactos {

    String Nombre, telefono;
    int id;

    //CONSTRUCTORES
    public Contactos (){}
    public Contactos(String nombre, String telefono, int id) {
        Nombre = nombre;
        this.telefono = telefono;
        this.id = id;
    }

    public Contactos(String nombre, String telefono) {
        Nombre = nombre;
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
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
