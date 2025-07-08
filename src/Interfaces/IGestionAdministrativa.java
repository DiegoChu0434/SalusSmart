package Interfaces;

public interface IGestionAdministrativa {
    void registrarNuevoUsuario(Usuario usuario);
    void eliminarUsuario(int idUsuario);
    void asignarRoles(int idUsuario, String rol);
    void gestionarHorarios(int idMedico, String horario);
} 