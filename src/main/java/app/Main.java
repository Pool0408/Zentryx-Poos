package app;

import dao.UsuariosDAO;
import dao.VentaDAO;
import model.Usuarios;
import model.Venta;
import util.Conexion;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UsuariosDAO p = new UsuariosDAO();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese usuario");
        String usuario = scanner.nextLine();
        System.out.println("Ingrese contraseña");
        String contrasena = scanner.nextLine();
        Usuarios u = p.login(usuario,contrasena);
        if (u!=null){
            System.out.println("Ingreso Exitoso");
        }else{
            System.out.println("Usuario o contraseña Incorrecta");
        }
    }
}
