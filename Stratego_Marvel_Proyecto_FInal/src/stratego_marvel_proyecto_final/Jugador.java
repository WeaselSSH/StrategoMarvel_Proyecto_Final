package stratego_marvel_proyecto_final;

public class Jugador {

    private String usuario;
    private String contrasena;
    private int puntos;
    private int vecesBueno;
    private int vecesMalo;
    private int victorias;
    private int derrotas;
    
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
    
    public int getHeroes(){
        return vecesBueno;
    }
    
    public int getVillanos(){
        return vecesMalo;
    }
    
    public int getVictorias(){
        return victorias;
    }
    
    public int getDerrotas(){
        return derrotas;
    }
    
    public void setContrasena(String nuevaContrasena) {
        this.contrasena = nuevaContrasena;
    }
}
