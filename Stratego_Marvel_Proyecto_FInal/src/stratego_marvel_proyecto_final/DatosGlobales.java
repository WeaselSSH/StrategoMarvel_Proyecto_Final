package stratego_marvel_proyecto_final;

public class DatosGlobales {
    
    public static ListaJugadores listaJugadores = new ListaJugadores();

    public static Ficha[] obtenerFichasBuenos() {
        return new Ficha[]{
            // fichas rango 2
            new Ficha("/imagenes/gambit.png", "RANGO_2", 2),
            new Ficha("/imagenes/spidergirl.png", "RANGO_2", 2),
            new Ficha("/imagenes/iceMan.png", "RANGO_2", 2),
            new Ficha("/imagenes/storm.png", "RANGO_2", 2),
            new Ficha("/imagenes/phoenix.png", "RANGO_2", 2),
            new Ficha("/imagenes/drStrange.png", "RANGO_2", 2),
            new Ficha("/imagenes/elektra.png", "RANGO_2", 2),
            new Ficha("/imagenes/nightcrawler.png", "RANGO_2", 2),
            // Fichas normales:
            new Ficha("/imagenes/mrFantastic.png", "NORMAL", 10),
            new Ficha("/imagenes/captainAmerica.png", "NORMAL", 9),
            new Ficha("/imagenes/professorX.png", "NORMAL", 8),
            new Ficha("/imagenes/nickFury.png", "NORMAL", 8),
            new Ficha("/imagenes/spiderMan.png", "NORMAL", 7),
            new Ficha("/imagenes/wolverine.png", "NORMAL", 7),
            new Ficha("/imagenes/namor.png", "NORMAL", 7),
            new Ficha("/imagenes/daredevil.png", "NORMAL", 6),
            new Ficha("/imagenes/silverSurfer.png", "NORMAL", 6),
            new Ficha("/imagenes/hulk.png", "NORMAL", 6),
            new Ficha("/imagenes/ironMan.png", "NORMAL", 6),
            new Ficha("/imagenes/thor.png", "NORMAL", 5),
            new Ficha("/imagenes/humanTorch.png", "NORMAL", 5),
            new Ficha("/imagenes/cyclops.png", "NORMAL", 5),
            new Ficha("/imagenes/invisibleWoman.png", "NORMAL", 5),
            new Ficha("/imagenes/ghostRider.png", "NORMAL", 4),
            new Ficha("/imagenes/punisher.png", "NORMAL", 4),
            new Ficha("/imagenes/blade.png", "NORMAL", 4),
            new Ficha("/imagenes/thing.png", "NORMAL", 4),
            new Ficha("/imagenes/emmaFrost.png", "NORMAL", 3),
            new Ficha("/imagenes/sheHulk.png", "NORMAL", 3),
            new Ficha("/imagenes/giantMan.png", "NORMAL", 3),
            new Ficha("/imagenes/beast.png", "NORMAL", 3),
            new Ficha("/imagenes/colossus.png", "NORMAL", 3),
            new Ficha("/imagenes/blackWidow.png", "NORMAL", 1)
        };
    }
}
