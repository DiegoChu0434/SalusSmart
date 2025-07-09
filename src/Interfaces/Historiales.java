package Interfaces;

public class Historiales {
    private int idHistorial;
    private String nombrePaciente;
    private String fechaCita;
    private String nombreMedico;
    private String especialidad;
    private String centroSalud;
    private String estado;
    private int idCita;

    public Historiales(int idHistorial, String nombrePaciente, String fechaCita,
                      String nombreMedico, String especialidad, String centroSalud, String estado) {
        this.idHistorial = idHistorial;
        this.nombrePaciente = nombrePaciente;
        this.fechaCita = fechaCita;
        this.nombreMedico = nombreMedico;
        this.especialidad = especialidad;
        this.centroSalud = centroSalud;
        this.estado = estado;
    }
    
    public Historiales(int idHistorial, int idCita, String nombrePaciente, String fechaCita,
                      String nombreMedico, String especialidad, String centroSalud, String estado) {
        this.idHistorial = idHistorial;
        this.idCita = idCita;
        this.nombrePaciente = nombrePaciente;
        this.fechaCita = fechaCita;
        this.nombreMedico = nombreMedico;
        this.especialidad = especialidad;
        this.centroSalud = centroSalud;
        this.estado = estado;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCentroSalud() {
        return centroSalud;
    }

    public void setCentroSalud(String centroSalud) {
        this.centroSalud = centroSalud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
