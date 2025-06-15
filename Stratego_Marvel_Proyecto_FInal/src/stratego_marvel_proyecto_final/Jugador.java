package stratego_marvel_proyecto_final;

public class Jugador {

    private String usuario;
    private String contrasena;
    private int puntos;
    private int vecesBueno;
    private int vecesMalo;
    
    //Creacion de variables de victorias y derrotas
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
    
    //Creacion de gets para obtener numero de veces como heroe y villanos
    public int getHeroes(){
        return vecesBueno;
    }//get para conocer veces como heroes
    
    public int getVillanos(){
        return vecesMalo;
    }//get para concoer veces como villano
    
    
    public int getVictorias(){
        return victorias;
    }//get para obtenr num de victorias
    
    public int getDerrotas(){
        return derrotas;
    }//get para obtener num de derrotas
    
    
    
    
}
