package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    //!ATRIBUTOS
    private static final String URL="jdbc:mysql://localhost:3306/zentryx";
    private static final String USUARIO ="root";
    private static final String CLAVE ="";
    private Connection conexion;
    //!ABRO LO CONEXION
    public Connection conectar(){
        try {
            conexion= DriverManager.getConnection(URL,USUARIO,CLAVE);
            System.out.println("Conexion Exitosa");
        }catch (SQLException e){
            System.out.println("Error al conectar: "+e.getMessage());
        }
        return conexion;
    }
    //!CIERRO LA CONEXION
    public void desconectar(){
        try {
            if (conexion!=null && !conexion.isClosed()){
                conexion.close();
                System.out.println("Conexion cerrada");
            }
        }catch (SQLException e){
            System.out.println("Error al cerrar");
        }
    }
}
