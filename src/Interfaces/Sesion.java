package Interfaces;

public class Sesion {

    // Variable estática que mantiene la sesión activa
    private static Usuario usuarioActual;

    // Establece el usuario actual (al iniciar sesión o registrarse)
    public static void setUsuarioActual(Usuario usuario) {
        usuarioActual = usuario;
    }

    // Devuelve el usuario actualmente en sesión
    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }

    // Cierra la sesión (limpia el usuario guardado)
    public static void cerrarSesion() {
        usuarioActual = null;
    }

    // Verifica si hay un usuario en sesión
    public static boolean haySesionActiva() {
        return usuarioActual != null;
    }
}
