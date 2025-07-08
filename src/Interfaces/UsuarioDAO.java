package Interfaces;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.base.Preconditions;
import Sql.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.ArrayList;

public class UsuarioDAO {
    private static UsuarioDAO instancia;
    private final IConexionDB conexionDB;
    
   
    private final Cache<Integer, Usuario> userCache;
    
 
    private UsuarioDAO() {
        this.conexionDB = new Conexion();
        
        this.userCache = CacheBuilder.newBuilder()
            .maximumSize(100)                  
            .expireAfterWrite(15, TimeUnit.MINUTES) 
            .recordStats()                     
            .build();
    }

    
    public UsuarioDAO(IConexionDB conexionDB) {
        this.conexionDB = conexionDB;
        this.userCache = CacheBuilder.newBuilder()
            .maximumSize(100)
            .expireAfterWrite(15, TimeUnit.MINUTES)
            .recordStats()
            .build();
    }

    public static UsuarioDAO getInstance() {
        if (instancia == null) {
            instancia = new UsuarioDAO();
        }
        return instancia;
    }

    public boolean registrarUsuario(Usuario usuario) {
       
         Preconditions.checkNotNull(usuario, "El usuario no puede ser null");
        Preconditions.checkArgument(usuario.getDni() > 0, "DNI inválido");
        Preconditions.checkArgument(usuario.getCorreo() != null && !usuario.getCorreo().isEmpty(),
            "El correo no puede estar vacío");

        String sql = "INSERT INTO Usuario (nombres, apellidos, dni, fecha_nacimiento, direccion, contacto, correo, contraseña, rol) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = conexionDB.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setInt(3, usuario.getDni());
            ps.setString(4, usuario.getFechaNacimiento());
            ps.setString(5, usuario.getDireccion());
            ps.setString(6, usuario.getCelular());
            ps.setString(7, usuario.getCorreo());
            ps.setString(8, usuario.getContraseña());
            ps.setString(9, usuario.getRol());

            int filas = ps.executeUpdate();
            if (filas > 0) {
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int idGenerado = generatedKeys.getInt(1);
                    usuario.setId(idGenerado); // Necesario: método setId
                }

                userCache.put(usuario.getDni(), usuario);
                return true;
            }

            return false;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Optional<Usuario> buscarUsuarioPorDni(int dni) {
        Preconditions.checkArgument(dni > 0, "DNI inválido");

        
        Usuario cachedUser = userCache.getIfPresent(dni);
        if (cachedUser != null) {
            return Optional.of(cachedUser);
        }

        String sql = "SELECT * FROM Usuario WHERE dni = ?";
        try (Connection conn = conexionDB.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Usuario usuario = new Usuario(
                    rs.getInt("id_usuario"),
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getInt("dni"),
                    rs.getString("fecha_nacimiento"),
                    rs.getString("direccion"),
                    rs.getString("contacto"),
                    rs.getString("correo"),
                    rs.getString("contraseña"),
                    rs.getString("rol")
                );
             
                userCache.put(dni, usuario);
                return Optional.of(usuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public boolean existeUsuarioPorDniOCorreo(int dni, String correo) {
        Preconditions.checkArgument(dni > 0, "DNI inválido");
        Preconditions.checkNotNull(correo, "El correo no puede ser null");

      
        if (userCache.getIfPresent(dni) != null) {
            return true;
        }

        String sql = "SELECT COUNT(*) FROM Usuario WHERE dni = ? OR correo = ?";
        try (Connection conn = conexionDB.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, dni);
            ps.setString(2, correo);

            ResultSet rs = ps.executeQuery();
            return rs.next() && rs.getInt(1) > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public Optional<Usuario> validarLogin(String correo, String contraseña) {
         Preconditions.checkNotNull(correo, "El correo no puede ser null");
    Preconditions.checkNotNull(contraseña, "La contraseña no puede ser null");

    String sql = "SELECT * FROM Usuario WHERE correo = ? AND contraseña = ?";

    try (Connection conn = conexionDB.obtenerConexion();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, correo);
        ps.setString(2, contraseña);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Usuario usuario = new Usuario(
                rs.getInt("id_usuario"),
                rs.getString("nombres"),
                rs.getString("apellidos"),
                rs.getInt("dni"),
                rs.getString("fecha_nacimiento"),
                rs.getString("direccion"),
                rs.getString("contacto"),
                rs.getString("correo"),
                rs.getString("contraseña"),
                rs.getString("rol")
            );
            return Optional.of(usuario);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return Optional.empty();
    }

 
    public String getCacheStats() {
        return userCache.stats().toString();
    }

    public List<Usuario> obtenerTodosLosUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuario";

        try (Connection conn = conexionDB.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = new Usuario(
                    rs.getInt("id_usuario"),
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getInt("dni"),
                    rs.getString("fecha_nacimiento"),
                    rs.getString("direccion"),
                    rs.getString("contacto"),
                    rs.getString("correo"),
                    rs.getString("contraseña"),
                    rs.getString("rol")
                );
                usuarios.add(usuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }
}
