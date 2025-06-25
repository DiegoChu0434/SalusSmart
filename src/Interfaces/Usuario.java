package Interfaces;

public class Usuario {
    int id_usuario;
    private String nombre;
    private String apellido;
    private int dni;
    private String fecha; 
    private String direccion;
    private String celular; 
    private String correo;
    private String contraseña;
    private String rol;

    public Usuario(int id_usuario,String nombre, String apellido, int dni, String fecha, String direccion,
                   String celular, String correo, String contraseña, String rol) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fecha = fecha;
        this.direccion = direccion;
        this.celular = celular;
        this.correo = correo;
        this.contraseña = contraseña;
        this.rol = rol;
    }

 
   public int getId_usuario() { return id_usuario; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public int getDni() { return dni; }
    public String getFechaNacimiento() { return fecha; }
    public String getDireccion() { return direccion; }
    public String getCelular() { return celular; }
    public String getCorreo() { return correo; }
    public String getContraseña() { return contraseña; }
    public String getRol() { return rol; }

    double getId() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
