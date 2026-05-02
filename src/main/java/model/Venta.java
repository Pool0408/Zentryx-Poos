package model;

import java.time.LocalDate;

public class Venta {
    //!ATRIBUTOS
    private int id;
    private LocalDate fecha;
    private Double total;
    private String usuario;
    //!CONTRUCTORES
    public Venta() {
    }
    public Venta(int id, LocalDate fecha, Double total, String usuario) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.usuario = usuario;
    }
    //!GETTERS AND SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
