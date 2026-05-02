package dao;

import model.Venta;
import util.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VentaDAO {
    //!METODO LISTAR
    public List<Venta> listar(){
        //?Iniciar conexion mysql
        Conexion cn = new Conexion();
        Connection con = cn.conectar();
        //?Atributos
        List<Venta> lista=new ArrayList<>();
        String sql ="SELECT * FROM TABLE venta";
        try{
            //Hace la consulta
            PreparedStatement ps = con.prepareStatement(sql);
            //Guarda los resultados de la consulta
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Venta v = new Venta();
                v.setId(rs.getInt("id"));
                v.setFecha(rs.getDate("fecha").toLocalDate());
                v.setTotal(rs.getDouble("total"));
                v.setUsuario(rs.getString("usuario"));
                lista.add(v);
            }
        }catch (SQLException e){
            System.out.println("Error no se pudo listar:  "+e.getMessage());
        }
        return lista;
    }
    //!METODO AGREGAR
    public void agregar(Venta v){
        //?Conexion con mysql
        Conexion cn = new Conexion();
        Connection con = cn.conectar();
        //?Atributos
        String sql ="INSER INTO venta (fecha,total,usuario) VALUES (?,?,?)";
        try {
            //Hace la consulta
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(v.getFecha()));
            ps.setDouble(2,v.getTotal());
            ps.setString(3,v.getUsuario());
        }catch (SQLException e){
            System.out.println("Error en la venta:  "+e.getMessage());
        }
    }
}
