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

    public void setLog(String nuevoLog) {
        if (cantidadLogs < log.length) {
            for (int i = cantidadLogs; i > 0; i--) {
                log[i] = log[i - 1];
            }
            log[0] = nuevoLog;
            cantidadLogs++;
        } else {
            for (int i = log.length - 1; i > 0; i--) {
                log[i] = log[i - 1];
            }
            log[0] = nuevoLog;
        }
    }

    public String[] getLog() {
        return this.log;
    }

    public int getCantidadLogs() {
        return this.cantidadLogs;
    }

}
