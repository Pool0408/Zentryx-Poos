package model;
public class Usuarios {
    //!ATRIBUTOS
    private String nombre;
    private String contrasena;
    //!CONSTRUCTOR
    //?Constructor vacio
    public Usuarios() {
    }
    //?Constructor lleno
    public Usuarios(String nombre, String contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;
    }
    //!GETTERS AND SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
