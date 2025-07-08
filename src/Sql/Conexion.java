package Sql;

import Interfaces.IConexionDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion implements IConexionDB {

    private static final String URL = "jdbc:mysql://localhost:3306/Sistema";
    private static final String USER = "root";
    private static final String PASSWORD = ""; 

    public static Connection getConexion() throws SQLException, ClassNotFoundException {      
        return new Conexion().obtenerConexion();
    }

    @Override
    public Connection obtenerConexion() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}




