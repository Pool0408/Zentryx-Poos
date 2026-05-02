package dao;
import model.Usuarios;
import util.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuariosDAO {
    public Usuarios login (String usuario,String contrasena){
        Usuarios usuario1 = null;
        //?Crear Conexion
        Conexion cn = new Conexion();
        Connection con = cn.conectar();
        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND contrasena = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,usuario);
            ps.setString(2,contrasena);
            ResultSet rs =ps.executeQuery();
            if (rs.next()){
                usuario1=new Usuarios();
                usuario1.setNombre(rs.getString("usuario"));
                usuario1.setContrasena(rs.getString("contrasena"));
            }
        }catch (SQLException e){
            System.out.println("Error login: "+e.getMessage());
        }
        return usuario1;
    }
}
