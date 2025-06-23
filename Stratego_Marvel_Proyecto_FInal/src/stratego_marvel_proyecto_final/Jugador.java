package stratego_marvel_proyecto_final;

public class Jugador {

    private String usuario;
    private String log[] = new String[5];
    private String contrasena;
    private int puntos;
    private int vecesBueno;
    private int vecesMalo;
    private int victorias;
    private int derrotas;
    private boolean eliminado = false;

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
        this.victorias++;
    }
    
    public void partidaPerdida() {
        this.derrotas++;
    }

    public int getHeroes() {
        return vecesBueno;
    }

    public int getVillanos() {
        return vecesMalo;
    }

    public int getVictorias() {
        return victorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public void setContrasena(String nuevaContrasena) {
        this.contrasena = nuevaContrasena;
    }
    
    public void setLog (String log) {
        for (int i = 0; i < this.log.length; i++) {
            if (this.log[i] != null) {
                this.log[i] = log;
                break;
            }
        }
    }
    
    public void getLog() {
    }

}
