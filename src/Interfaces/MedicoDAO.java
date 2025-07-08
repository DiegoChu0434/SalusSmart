package Interfaces;

import Sql.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAO {

   
    public boolean insertar(Medico medico) {
    
        String sqlUsuario = "INSERT INTO Usuario (nombres, apellidos, dni, fecha_nacimiento, direccion, contacto, rol) VALUES (?, ?, ?, ?, ?, ?, 'medico')";
        String sqlPersonalMedico = "INSERT INTO PersonalMedico (id_medico, especialidad) VALUES (?, ?)";

        try (Connection conn = Conexion.getConexion()) {
            conn.setAutoCommit(false);

            try (PreparedStatement psUsuario = conn.prepareStatement(sqlUsuario, Statement.RETURN_GENERATED_KEYS)) {
                psUsuario.setString(1, medico.getNombre());
                psUsuario.setString(2, medico.getApellido());
                psUsuario.setInt(3, medico.getDni());
                psUsuario.setString(4, medico.getFechaNacimiento());
                psUsuario.setString(5, medico.getDireccion());
                psUsuario.setString(6, medico.getCelular());
               
                psUsuario.executeUpdate();

                ResultSet rs = psUsuario.getGeneratedKeys();
                if (rs.next()) {
                    int idUsuarioGenerado = rs.getInt(1);

                    try (PreparedStatement psMedico = conn.prepareStatement(sqlPersonalMedico)) {
                        psMedico.setInt(1, idUsuarioGenerado);
                        psMedico.setString(2, medico.getEspecialidad());
                        psMedico.executeUpdate();
                    }

                    conn.commit();
                    return true;
                } else {
                    conn.rollback();
                    return false;
                }
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }


   
    public List<Medico> listar() {
        List<Medico> lista = new ArrayList<>();
        String sql = "SELECT u.id_usuario, u.nombre, u.apellido, u.dni, u.fecha_nacimiento, u.direccion, u.celular, pm.especialidad " +
                     "FROM Usuario u INNER JOIN PersonalMedico pm ON u.id_usuario = pm.idmedico";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Medico medico = new Medico(
                        rs.getInt("id_usuario"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("dni"),
                        rs.getString("fecha_nacimiento"),
                        rs.getString("direccion"),
                        rs.getString("celular")
                );
                medico.setEspecialidad(rs.getString("especialidad"));
                lista.add(medico);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return lista;
    }

    
    public boolean actualizar(Medico medico) {
        String sqlUsuario = "UPDATE Usuario SET nombre=?, apellido=?, dni=?, fecha_nacimiento=?, direccion=?, celular=? WHERE id_usuario=?";
        String sqlEspecialidad = "UPDATE PersonalMedico SET especialidad=? WHERE idmedico=?";

        try (Connection conn = Conexion.getConexion()) {
            conn.setAutoCommit(false);

            try (PreparedStatement psUsuario = conn.prepareStatement(sqlUsuario)) {
                psUsuario.setString(1, medico.getNombre());
                psUsuario.setString(2, medico.getApellido());
                psUsuario.setInt(3, medico.getDni());
                psUsuario.setString(4, medico.getFechaNacimiento());
                psUsuario.setString(5, medico.getDireccion());
                psUsuario.setString(6, medico.getCelular());
                psUsuario.setInt(7, medico.getId_usuario());
                psUsuario.executeUpdate();
            }

            try (PreparedStatement psEspecialidad = conn.prepareStatement(sqlEspecialidad)) {
                psEspecialidad.setString(1, medico.getEspecialidad());
                psEspecialidad.setInt(2, medico.getId_usuario());
                psEspecialidad.executeUpdate();
            }

            conn.commit();
            return true;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    public boolean eliminar(int id) {
        String sqlPersonalMedico = "DELETE FROM PersonalMedico WHERE idmedico=?";
        String sqlUsuario = "DELETE FROM Usuario WHERE id_usuario=?";

        try (Connection conn = Conexion.getConexion()) {
            conn.setAutoCommit(false);

            try (PreparedStatement psMedico = conn.prepareStatement(sqlPersonalMedico)) {
                psMedico.setInt(1, id);
                psMedico.executeUpdate();
            }

            try (PreparedStatement psUsuario = conn.prepareStatement(sqlUsuario)) {
                psUsuario.setInt(1, id);
                psUsuario.executeUpdate();
            }

            conn.commit();
            return true;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

 
    public Medico buscarPorId(int id) {
        String sql = "SELECT u.id_usuario, u.nombre, u.apellido, u.dni, u.fecha_nacimiento, u.direccion, u.celular, pm.especialidad " +
                     "FROM Usuario u INNER JOIN PersonalMedico pm ON u.id_usuario = pm.idmedico WHERE u.id_usuario = ?";

        Medico medico = null;

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                medico = new Medico(
                        rs.getInt("id_usuario"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("dni"),
                        rs.getString("fecha_nacimiento"),
                        rs.getString("direccion"),
                        rs.getString("celular")
                );
                medico.setEspecialidad(rs.getString("especialidad"));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return medico;
    }
        public List<String> obtenerEspecialidades() {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT especialidad FROM personalmedico";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(rs.getString("especialidad"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
        public int obtenerIdMedicoPorEspecialidad(String especialidad) {
            int idMedico = -1;
            String sql = "SELECT id_medico FROM personalmedico WHERE especialidad = ?";
            try (Connection conn = Conexion.getConexion();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, especialidad);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    idMedico = rs.getInt("id_medico");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return idMedico;
        }

    public List<Medico> obtenerTodosLosMedicos() {
        List<Medico> medicos = new ArrayList<>();
        String sql = "SELECT id_medico, nombre, apellido FROM personalmedico";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Medico medico = new Medico();
                medico.setId(rs.getInt("id_medico"));
                medico.setNombre(rs.getString("nombre"));
                medico.setApellido(rs.getString("apellido"));
                medicos.add(medico);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return medicos;
    }

    public List<Medico> obtenerMedicosPorEspecialidad(String especialidad) {
        List<Medico> medicos = new ArrayList<>();
        String sql = "SELECT id_medico, nombre, apellido FROM personalmedico WHERE especialidad = ?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, especialidad);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Medico medico = new Medico();
                medico.setId(rs.getInt("id_medico"));
                medico.setNombre(rs.getString("nombre"));
                medico.setApellido(rs.getString("apellido"));
                medicos.add(medico);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return medicos;
    }
}

 
  
