
package Interfaces;

public class Hospitales {
    private int idCentro;
    private String nombre;
    private String direccion;
    private String gps;


    public Hospitales(int idCentro, String nombre, String direccion) {
    this.idCentro = idCentro;
    this.nombre = nombre;
    this.direccion = direccion;
    this.gps = "";
}

    public int getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(int idCentro) {
        this.idCentro = idCentro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

   
      
}
