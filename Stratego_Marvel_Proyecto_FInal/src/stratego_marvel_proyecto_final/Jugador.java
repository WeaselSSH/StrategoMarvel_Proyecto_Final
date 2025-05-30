package stratego_marvel_proyecto_final;

public class Jugador {

    private static String usuario;
    private static String contrasena;
    
    public Jugador(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    // Getters y Setters si los necesitás
    public String getUsuario() {
        return usuario;
    }

    public static String getContrasena() {
        return contrasena;
    }
}
