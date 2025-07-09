package Interfaces;

import Sql.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HospitalDAO {

    public boolean insertar(Hospitales hospital) {
        String sql = "INSERT INTO centrosalud (nombre, direccion, ubicacion_gps) VALUES (?, ?, ?)";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, hospital.getNombre());
            ps.setString(2, hospital.getDireccion());
            ps.setString(3, hospital.getGps());

            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Hospitales> listar() {
        List<Hospitales> lista = new ArrayList<>();
        String sql = "SELECT id_centro, nombre, direccion, ubicacion_gps FROM centrosalud";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Hospitales hospital = new Hospitales(
                    rs.getInt("id_centro"),
                    rs.getString("nombre"),
                    rs.getString("direccion")
                );
                lista.add(hospital);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean actualizar(Hospitales hospital) {
        String sql = "UPDATE centrosalud SET nombre = ?, direccion = ?, ubicacion_gps = ? WHERE id_centro = ?";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, hospital.getNombre());
            ps.setString(2, hospital.getDireccion());
            ps.setString(3, hospital.getGps());
            ps.setInt(4, hospital.getIdCentro());

            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(int id_centro) {
        String sql = "DELETE FROM centrosalud WHERE id_centro = ?";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id_centro);
            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

        public List<String> listarNombres() {
         List<String> nombres = new ArrayList<>();
         String sql = "SELECT nombre FROM centrosalud";

         try (Connection conn = Conexion.getConexion();
              PreparedStatement ps = conn.prepareStatement(sql);
              ResultSet rs = ps.executeQuery()) {

             while (rs.next()) {
                 nombres.add(rs.getString("nombre"));
             }

         } catch (Exception e) {
             e.printStackTrace();
         }

         return nombres;
     }
        
         public int obtenerIdCentroPorNombre(String nombre) {
            String sql = "SELECT id_centro FROM centrosalud WHERE nombre = ?";
            try (Connection conn = Conexion.getConexion();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, nombre);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) return rs.getInt("id_centro");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return -1; 
        }
         
         public String obtenerNombreCentroPorId(int idCentro) {
            String sql = "SELECT nombre FROM centrosalud WHERE id_centro = ?";
            try (Connection con = Conexion.getConexion();
                 PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, idCentro);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getString("nombre");
                }   
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
         
       

}
