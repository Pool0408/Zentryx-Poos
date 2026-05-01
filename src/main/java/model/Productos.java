package model;

public class Productos {
    //!ATRIBUTOS
    private String nombre;
    private String categoria;
    private Double precio;
    private int stock;
    //!CONSTRUCTORES
    //?Constructor vacio
    public Productos() {
    }
    //?Constructor lleno
    public Productos(String nombre, String categoria, Double precio, int stock) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }
    //!GETTERS AND SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
