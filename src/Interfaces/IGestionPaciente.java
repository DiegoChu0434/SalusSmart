package Interfaces;

public interface IGestionPaciente {
    void solicitarCita(int idMedico, String fecha, String hora);
    void cancelarCitaPaciente(int idCita);
    void verHistorialPropio();
    void actualizarDatosPersonales(String direccion, String telefono);
} 

