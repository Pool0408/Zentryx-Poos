package dao;

import model.Productos;
import util.Conexion;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductosDAO {
    //!METODO LISTAR
    public List<Productos> listar(){
        //?Crear la conexion
        Conexion cn = new Conexion();
        Connection con = cn.conectar();
        //?Atributos
        String sql ="SELECT *FROM productos";
        List<Productos> lista = new ArrayList<>();
        try {
            //Hace la consulta
            PreparedStatement ps =con.prepareStatement(sql);
            //Guarda los resultados de la consulta
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Productos p = new Productos();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setCategoria(rs.getString("categoria"));
                p.setPrecio(rs.getDouble("precio"));
                p.setStock(rs.getInt("stock"));
                lista.add(p);
            }
        }catch (SQLException e){
            System.out.println("Error al listar:  "+e.getMessage());
        }
        return lista;
    }
    //!METODO AGREGAR
    public void agregar(String nombre,String categoria,double precio,int stock){
        //?Crear Conexion
        Conexion cn = new Conexion();
        Connection con = cn.conectar();
        //?Atributos
        String sql ="INSERT INTO productos (nombre,precio,categoria,stock) VALUES(?,?,?,?)";
        try {
            //Hace la consulta
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,nombre);
            ps.setDouble(2,precio);
            ps.setString(3,categoria);
            ps.setInt(4,stock);
            //Modifica Datos
            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error al agregar: "+e.getMessage());
        }
    }
    //!METODO ELIMINAR
    public void eliminar(int id){
        //?Crear Conexion
        Conexion cn = new Conexion();
        Connection con = cn.conectar();
        //?Atributos
        String sql="DELETE FROM productos WHERE id = ?";
        try {
            //Hace la consulta
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1,id);
            //Modifica Datos
            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error al eliminar: "+e.getMessage() );
        }
    }
    //!METODO ACTUALIZAR PRODUCTO
    public void actualizar(Productos p){
        //?Crear conexion
        Conexion cn = new Conexion();
        Connection con = cn.conectar();
        //?Atributos
        String sql ="UPDATE productos SET nombre=? , precio=? ,categoria=?,stock=? WHERE id=?";
        try {
            //Hace la consulta
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.setString(3, p.getCategoria());
            ps.setInt(4, p.getStock());
            ps.setInt(5, p.getId());
            //Modifica Datos
            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error a actualizar producto: "+e.getMessage());
        }
    }

}
