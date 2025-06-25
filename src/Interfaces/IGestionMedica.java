package Interfaces;

public interface IGestionMedica {
    void registrarCita(String fecha, String hora, int idPaciente);
    void cancelarCita(int idCita);
    void actualizarHistorialMedico(int idPaciente, String diagnostico, String tratamiento);
    void verHistorialPaciente(int idPaciente);
} 