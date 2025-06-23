package stratego_marvel_proyecto_final;

public class Jugador {

    private String usuario;
    private String log[] = new String[5];
    private int cantidadLogs;
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
        this.cantidadLogs = 0;
        this.puntos = 0;
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

    public void setLog(String log) {
        if (cantidadLogs < this.log.length) {
            this.log[cantidadLogs] = log;
            cantidadLogs++;
        } else {
            for (int i = 1; i < this.log.length; i++) {
                this.log[i - 1] = this.log[i];
            }
            this.log[this.log.length - 1] = log;
        }
    }

    public String[] getLog() {
        return this.log;
    }

    public int getCantidadLogs() {
        return this.cantidadLogs;
    }

}
