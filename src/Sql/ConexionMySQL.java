package Sql;

import Interfaces.IConexionDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL implements IConexionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/salusmart";
    private static final String USER = "root";
    private static final String PASS = "";

    @Override
    public Connection obtenerConexion() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASS);
    }
} 