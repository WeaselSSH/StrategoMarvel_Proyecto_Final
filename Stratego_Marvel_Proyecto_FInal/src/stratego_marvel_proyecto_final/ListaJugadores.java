package stratego_marvel_proyecto_final;

public class ListaJugadores {

    private final Jugador jugadores[] = new Jugador[50];
    private int tamanio;

    public ListaJugadores() {
        tamanio = 0;
    }

    public void agregar(Jugador jugador) {
        if (tamanio < jugadores.length) {
            jugadores[tamanio] = jugador;
            tamanio++;
        }
    }

    public Jugador obtener(int indice) {
        if (indice >= 0 && indice < tamanio) {
            return jugadores[indice];
        }
        return null;
    }
    
    public Jugador obtenerbyName(String nombre){//Devuelve el jugador mediante el nombre, usado en seleccion de jugador
        for(int i=0; i<jugadores.length; i++){
            Jugador playerTemp=jugadores[i];
             if(nombre.equals(playerTemp.getUsuario())){
                return playerTemp;
            }
        }
        return null;
    }

    public int cantidad() {
        return tamanio;
    }

}
