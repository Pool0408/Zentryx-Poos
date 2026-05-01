package dao;

import util.Conexion;

import java.sql.*;

public class ProductosDAO {
    //!METODO LISTAR
    public void listar(){
        //?Crear la conexion
        Conexion cn = new Conexion();
        Connection con = cn.conectar();
        //?Atributos
        String sql ="SELECT *FROM productos";
        //?Mysql
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.printf("%-3s| %-11s| %-6s| %-13s| %-5s%n", "ID", "Nombre", "Precio", "Categoria", "Stock");
            System.out.println("---+------------+-------+-------------+-----");
            while (rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                String categoria = rs.getString("Categoria");
                int stock = rs.getInt("stock");
                System.out.printf("%-3d| %-11s| %-6.2f| %-13s| %-5d%n", id, nombre, precio, categoria, stock);;
            }
        }catch (SQLException e){
            System.out.println("Error a listar Productos:  "+e.getMessage());
        }finally {
            cn.desconectar();
        }
    }
    //!METODO AGREGAR
    public void agregar(String nombre,String categoria,double precio,int stock){
        //?Crear Conexion
        Conexion cn = new Conexion();
        Connection con = cn.conectar();
        //?Atributos
        String sql ="INSERT INTO productos (nombre,precio,categoria,stock) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,nombre);
            ps.setDouble(2,precio);
            ps.setString(3,categoria);
            ps.setInt(4,stock);
            int filas = ps.executeUpdate();
            if (filas>0){
                System.out.println("Producto agregado correctamente");
            }
        }catch (SQLException e){
            System.out.println("Error al agregar: "+e.getMessage());
        }finally {
            cn.desconectar();
        }
    }
    //!METODO ELIMINAR
    public void eliminar(int id){
        //?CREAR CONEXION
        Conexion cn = new Conexion();
        Connection con = cn.conectar();
        //?ATRIBUTOS
        String sql="DELETE FROM productos WHERE id = ?";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1,id);
            int filas=ps.executeUpdate();
            if (filas>0){
                System.out.println("Producto con id : " +id+"eliminado exitosamente");
            }else {
                System.out.println("No se encontro el id");
            }
        }catch (SQLException e){
            System.out.println("Error al eliminar: "+e.getMessage() );
        }finally {
            cn.desconectar();
        }
    }
}
