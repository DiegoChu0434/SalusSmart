package Interfaces;

public class Medico extends Usuario implements IGestionMedica {
    private String Especialidad;

    public Medico(int id_usuario, String nombre, String apellido, int dni, String fecha, String direccion, String celular) {
        super(id_usuario, nombre, apellido, dni, fecha, direccion, celular, null, null, null);
        this.Especialidad = Especialidad;
    }

    public Medico() {
        super(); 
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String Especialidad) {
        this.Especialidad = Especialidad;
    }

    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    public void setApellido(String apellido) {
        super.setApellido(apellido);
    }

    public void setId(int id) {
        super.setId_usuario(id);
    }

    public int getId() {
        return super.getId_usuario();
    }

    @Override
    public String toString() {
        return super.getNombre() + " " + super.getApellido();
    }

    @Override
    public void registrarCita(String fecha, String hora, int idPaciente) {
        System.out.println("Registrando cita para el paciente " + idPaciente);
    }

    @Override
    public void cancelarCita(int idCita) {
        System.out.println("Cancelando cita " + idCita);
    }

    @Override
    public void actualizarHistorialMedico(int idPaciente, String diagnostico, String tratamiento) {
        System.out.println("Actualizando historial médico del paciente " + idPaciente);
    }

    @Override
    public void verHistorialPaciente(int idPaciente) {
        System.out.println("Consultando historial del paciente " + idPaciente);
    }
}


