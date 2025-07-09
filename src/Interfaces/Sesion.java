package Interfaces;

public class Sesion {

    
    private static Usuario usuarioActual;

   
    public static void setUsuarioActual(Usuario usuario) {
        usuarioActual = usuario;
    }

  
    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }

   
    public static void cerrarSesion() {
        usuarioActual = null;
    }

   
    public static boolean haySesionActiva() {
        return usuarioActual != null;
    }
}
