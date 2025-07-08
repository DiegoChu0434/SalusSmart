package Interfaces;

import Sql.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacientesDAO {

   
    private Connection conn;

    public PacientesDAO() {
        try {
            conn = Conexion.getConexion();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Usuario buscarPacientePorDNI(String dni) {
        String sql = "SELECT id_usuario, nombres, apellidos, dni, fecha_nacimiento, direccion, contacto, correo, rol FROM Usuario WHERE dni = ? AND rol = 'paciente'";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Usuario(
                    rs.getInt("id_usuario"),             
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getInt("dni"),                  
                    rs.getString("fecha_nacimiento"),
                    rs.getString("direccion"),
                    rs.getString("contacto"),
                    rs.getString("correo"),
                    "", 
                    rs.getString("rol")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
}

    public boolean eliminarPaciente(int dni) {
        String sql = "DELETE FROM Usuario WHERE dni = ? AND rol = 'paciente'";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, dni);
            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarPaciente(Usuario paciente) {
        String sql = "UPDATE Usuario SET nombre = ?, apellido = ?, fechaNacimiento = ?, direccion = ?, celular = ?, correo = ? WHERE dni = ? AND rol = 'paciente'";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getApellido());
            ps.setString(3, paciente.getFechaNacimiento());
            ps.setString(4, paciente.getDireccion());
            ps.setString(5, paciente.getCelular());
            ps.setString(6, paciente.getCorreo());
            ps.setInt(7, paciente.getDni());
            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
        public int obtenerIdPacientePorNombre(String nombre) {
            String sql = "SELECT p.id_paciente " +
             "FROM paciente p " +
             "INNER JOIN usuario u ON p.id_usuario = u.id_usuario " +
             "WHERE u.nombres = ?";


            try (Connection conn = Conexion.getConexion();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, nombre);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getInt("id_paciente");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return -1;
        }
        
          public void registrarSiNoExiste(int idUsuario) {
        String verificarSQL = "SELECT * FROM paciente WHERE id_paciente = ?";
        String insertarSQL = "INSERT INTO paciente (id_paciente) VALUES (?)";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement verificar = conn.prepareStatement(verificarSQL)) {

            verificar.setInt(1, idUsuario);
            ResultSet rs = verificar.executeQuery();

            if (!rs.next()) {
                try (PreparedStatement insertar = conn.prepareStatement(insertarSQL)) {
                    insertar.setInt(1, idUsuario);
                    insertar.executeUpdate();
                    System.out.println("Paciente registrado en tabla 'paciente'.");
                }
            } else {
                System.out.println("Paciente ya existe en tabla 'paciente'.");
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Usuario> obtenerTodosLosUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT id_usuario, nombres, apellidos, dni, fecha_nacimiento, direccion, contacto, correo, rol FROM Usuario";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario(
                    rs.getInt("id_usuario"),
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getInt("dni"),
                    rs.getString("fecha_nacimiento"),
                    rs.getString("direccion"),
                    rs.getString("contacto"),
                    rs.getString("correo"),
                    "", // contraseña no se pasa
                    rs.getString("rol")
                );
                lista.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
