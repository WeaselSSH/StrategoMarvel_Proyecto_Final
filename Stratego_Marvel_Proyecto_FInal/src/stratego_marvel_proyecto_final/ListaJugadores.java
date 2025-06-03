package stratego_marvel_proyecto_final;

public class ListaJugadores {

    private Jugador jugadores[] = new Jugador[10];
    private int tamanio;

    public ListaJugadores() {
        jugadores = new Jugador[10];
        tamanio = 0;
    }

    public void agregar(Jugador jugador) {
        if (tamanio == jugadores.length) {
            // redimensionar
            Jugador[] nuevo = new Jugador[jugadores.length * 2];
            for (int i = 0; i < jugadores.length; i++) {
                nuevo[i] = jugadores[i];
            }
            jugadores = nuevo;
        }
        jugadores[tamanio] = jugador;
        tamanio++;
    }

    public Jugador obtener(int indice) {
        if (indice >= 0 && indice < tamanio) {
            return jugadores[indice];
        }
        return null;
    }

    public int cantidad() {
        return tamanio;
    }

}
