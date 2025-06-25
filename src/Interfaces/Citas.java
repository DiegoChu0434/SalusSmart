
package Interfaces;
public class Citas {
    private int idCita;
    private String fechaHora;
    private String tipoAtencion;
    private String estado;
    private int idMedico;
    private int idCentro;

    public Citas(int idCita, String fechaHora, String tipoAtencion, String estado,  int idMedico, int idCentro) {
        this.idCita = idCita;
        this.fechaHora = fechaHora;
        this.tipoAtencion = tipoAtencion;
        this.estado = estado;
        this.idMedico = idMedico;
        this.idCentro = idCentro;
    }

    public Citas(String fechaHora, String tipoAtencion, String estado,int idMedico, int idCentro) {
        this.fechaHora = fechaHora;
        this.tipoAtencion = tipoAtencion;
        this.estado = estado;
        this.idMedico = idMedico;
        this.idCentro = idCentro;
    }

    public int getIdCita() { return idCita; }
    public String getFechaHora() { return fechaHora; }
    public String getTipoAtencion() { return tipoAtencion; }
    public String getEstado() { return estado; }
    public int getIdMedico() { return idMedico; }
    public int getIdCentro() { return idCentro; }
}
