package Interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConexionDB {
    Connection obtenerConexion() throws SQLException, ClassNotFoundException;
} 

