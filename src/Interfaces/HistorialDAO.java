
package Interfaces;


import Sql.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HistorialDAO {

    public List<Historiales> listarHistorial() {
        List<Historiales> lista = new ArrayList<>();
        String sql = "SELECT " +
                     "hc.id_historial, " +
                     "u_pac.nombres AS nombre_paciente, " +  
                     "c.fecha_hora, " +
                     "u_med.nombres AS nombre_medico, " +  
                     "pm.especialidad, " +
                     "cs.nombre AS centro_salud, " +
                     "c.estado " +
                     "FROM historialclinico hc " +
                     "INNER JOIN paciente p ON hc.id_paciente = p.id_paciente " +
                     "INNER JOIN usuario u_pac ON p.id_paciente = u_pac.id_usuario " +
                     "INNER JOIN citamedica c ON c.id_paciente = p.id_paciente " +
                     "INNER JOIN personalmedico pm ON c.id_medico = pm.id_medico " +
                     "INNER JOIN usuario u_med ON pm.id_medico = u_med.id_usuario " +
                     "INNER JOIN centrosalud cs ON c.id_centro = cs.id_centro " +
                     "WHERE c.estado = 'Pendiente'";  

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Historiales h = new Historiales(
                    rs.getInt("id_historial"),
                    rs.getString("nombre_paciente"),
                    rs.getString("fecha_hora"),
                    rs.getString("nombre_medico"),
                    rs.getString("especialidad"),
                    rs.getString("centro_salud"),
                    rs.getString("estado")
                );
                lista.add(h);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return lista;
    }


    public boolean actualizarEstadoCita(int idHistorial, String nuevoEstado) {
        String sql = 
        "UPDATE citamedica " +
        "SET estado = ? " +
        "WHERE id_paciente = (SELECT id_paciente FROM historialclinico WHERE id_historial = ?)";


        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nuevoEstado);
            ps.setInt(2, idHistorial);

            return ps.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

        public List<Historiales> listarHistorialPorUsuario(int idUsuario) {
        List<Historiales> lista = new ArrayList<>();
        String sql = "SELECT hc.id_historial, c.fecha_hora, u_med.nombres AS nombre_medico, " +
                     "pm.especialidad, cs.nombre AS centro_salud, c.estado " +
                     "FROM historialclinico hc " +
                     "INNER JOIN paciente p ON hc.id_paciente = p.id_paciente " +
                     "INNER JOIN usuario u_pac ON p.id_paciente = u_pac.id_usuario " +
                     "INNER JOIN citamedica c ON c.id_paciente = p.id_paciente " +
                     "INNER JOIN personalmedico pm ON c.id_medico = pm.id_medico " +
                     "INNER JOIN usuario u_med ON pm.id_medico = u_med.id_usuario " +
                     "INNER JOIN centrosalud cs ON c.id_centro = cs.id_centro " +
                     "WHERE u_pac.id_usuario = ?";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Historiales h = new Historiales(
                    rs.getInt("id_historial"),
                    "", // Nombre del paciente no se muestra en perfil
                    rs.getString("fecha_hora"),
                    rs.getString("nombre_medico"),
                    rs.getString("especialidad"),
                    rs.getString("centro_salud"),
                    rs.getString("estado")
                );
                lista.add(h);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}
