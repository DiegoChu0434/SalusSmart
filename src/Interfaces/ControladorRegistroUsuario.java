package Interfaces;

import Sql.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControladorRegistroUsuario {
    private Connection conexion;
    
    public ControladorRegistroUsuario() {
        try {
            this.conexion = Conexion.getConexion();
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos: " + e.getMessage());
        }
    }
    
    public boolean registrarUsuario(String nombre, String apellido, String correo, String dni, 
            String fecha, String direccion, String telefono, String contraseña, String rol) {
        try {
            String sql = "INSERT INTO usuarios (nombre, apellido, correo, dni, fecha_nacimiento, " +
                    "direccion, telefono, contraseña, rol) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setString(1, nombre);
            stmt.setString(2, apellido);
            stmt.setString(3, correo);
            stmt.setString(4, dni);
            stmt.setString(5, fecha);
            stmt.setString(6, direccion);
            stmt.setString(7, telefono);
            stmt.setString(8, contraseña);
            stmt.setString(9, rol);
            
            int resultado = stmt.executeUpdate();
            return resultado > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar usuario: " + e.getMessage());
            return false;
        }
    }
    
    // Método para validar la conexión
    public boolean testConexion() {
        try {
            return conexion != null && !conexion.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }
} 