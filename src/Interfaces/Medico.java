
package Interfaces;

public class Medico extends Usuario implements IGestionMedica {
    private String Especialidad;

    public Medico(int id_usuario, String nombre, String apellido, int dni, String fecha, String direccion, String celular) {
        super(id_usuario, nombre, apellido, dni, fecha, direccion, celular, null, null, null);
        this.Especialidad = Especialidad;
    }
    

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String Especialidad) {
        this.Especialidad = Especialidad;
    }
    
    @Override
    public void registrarCita(String fecha, String hora, int idPaciente) {
        // Implementación del método
        System.out.println("Registrando cita para el paciente " + idPaciente);
    }

    @Override
    public void cancelarCita(int idCita) {
        // Implementación del método
        System.out.println("Cancelando cita " + idCita);
    }

    @Override
    public void actualizarHistorialMedico(int idPaciente, String diagnostico, String tratamiento) {
        // Implementación del método
        System.out.println("Actualizando historial médico del paciente " + idPaciente);
    }

    @Override
    public void verHistorialPaciente(int idPaciente) {
        // Implementación del método
        System.out.println("Consultando historial del paciente " + idPaciente);
    }
}
