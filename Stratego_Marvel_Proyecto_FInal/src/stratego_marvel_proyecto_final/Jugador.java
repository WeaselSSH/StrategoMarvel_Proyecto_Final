package stratego_marvel_proyecto_final;

public class Jugador {

    private String usuario;
    private String contrasena;
    private int puntos;
    private int vecesBueno;
    private int vecesMalo;
    
    public Jugador(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }
    
    public int getPuntos() {
        return puntos;
    }
    
    public void partidaGanada() {
        this.puntos += 3;
    }
}
