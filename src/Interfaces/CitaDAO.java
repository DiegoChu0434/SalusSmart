package Interfaces;

import Sql.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CitaDAO {

    public boolean insertar(Citas cita) {
        String sql = "INSERT INTO citaMedica (fecha_hora, tipo_atencion, estado, id_medico, id_centro) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cita.getFechaHora());
            ps.setString(2, cita.getTipoAtencion());
            ps.setString(3, cita.getEstado());
            ps.setInt(4, cita.getIdMedico());
            ps.setInt(5, cita.getIdCentro());

            ps.executeUpdate();
            return true;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

        public List<Citas> listar() {
         List<Citas> lista = new ArrayList<>();
         String sql = "SELECT * FROM citamedica";

         try (Connection conn = Conexion.getConexion();
              PreparedStatement ps = conn.prepareStatement(sql);
              ResultSet rs = ps.executeQuery()) {

             while (rs.next()) {
                 Citas cita = new Citas(
                     rs.getInt("id_cita"),
                     rs.getString("fecha_hora"),
                     rs.getString("tipo_atencion"),
                     rs.getString("estado"),
                     rs.getInt("id_paciente"),
                     rs.getInt("id_medico"),
                     rs.getInt("id_centro")
                 );
                 lista.add(cita);
             }

         } catch (SQLException | ClassNotFoundException e) {
             e.printStackTrace();
         }

         return lista;
     }

    public boolean actualizar(Citas cita) {
        String sql = "UPDATE citaMedica SET fecha_hora=?, tipo_atencion=?, estado=?, id_medico=?, id_centro=? WHERE id_cita=?";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cita.getFechaHora());
            ps.setString(2, cita.getTipoAtencion());
            ps.setString(3, cita.getEstado());
            ps.setInt(5, cita.getIdMedico());
            ps.setInt(6, cita.getIdCentro());
            ps.setInt(7, cita.getIdCita());

            ps.executeUpdate();
            return true;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(int idCita) {
        String sql = "DELETE FROM citaMedica WHERE id_cita=?";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idCita);
            ps.executeUpdate();
            return true;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

        public Citas buscarPorId(int idCita) {
         String sql = "SELECT * FROM citamedica WHERE id_cita=?";
         Citas cita = null;

         try (Connection conn = Conexion.getConexion();
              PreparedStatement ps = conn.prepareStatement(sql)) {

             ps.setInt(1, idCita);
             ResultSet rs = ps.executeQuery();

             if (rs.next()) {
                 cita = new Citas(
                     rs.getInt("id_cita"),
                     rs.getString("fecha_hora"),
                     rs.getString("tipo_atencion"),
                     rs.getString("estado"),
                     rs.getInt("id_paciente"),
                     rs.getInt("id_medico"),
                     rs.getInt("id_centro")
                 );
             }

         } catch (SQLException | ClassNotFoundException e) {
             e.printStackTrace();
         }

         return cita;
     }
        public boolean insertarConPaciente(Citas cita) {
          String sql = "INSERT INTO citamedica (fecha_hora, tipo_atencion, estado, id_paciente, id_medico, id_centro) VALUES (?, ?, ?, ?, ?, ?)";

          try (Connection conn = Conexion.getConexion();
               PreparedStatement ps = conn.prepareStatement(sql)) {

              ps.setString(1, cita.getFechaHora());
              ps.setString(2, cita.getTipoAtencion());
              ps.setString(3, cita.getEstado());
              ps.setInt(4, cita.getIdPaciente());
              ps.setInt(5, cita.getIdMedico());
              ps.setInt(6, cita.getIdCentro());

              return ps.executeUpdate() > 0;

          } catch (SQLException | ClassNotFoundException e) {
              e.printStackTrace();
              return false;
          }
      }
}
