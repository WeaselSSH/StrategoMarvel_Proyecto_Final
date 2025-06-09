package stratego_marvel_proyecto_final;

public class DatosGlobales {

    public static ListaJugadores listaJugadores = new ListaJugadores();

    public static Ficha[] fichasBuenos() {
        return new Ficha[]{
            //tierra y bombas
            new Ficha("/imagenes/heroEarth.png", "TIERRA", "BUENO", 0),
            new Ficha("/imagenes/novaBlast.png", "BOMBA", "BUENO", 0),
            
            // fichas rango 2
            new Ficha("/imagenes/gambit.png", "RANGO_2", "BUENO", 2),
            new Ficha("/imagenes/spidergirl.png", "RANGO_2", "BUENO", 2),
            new Ficha("/imagenes/iceMan.png", "RANGO_2", "BUENO", 2),
            new Ficha("/imagenes/storm.png", "RANGO_2", "BUENO", 2),
            new Ficha("/imagenes/phoenix.png", "RANGO_2", "BUENO", 2),
            new Ficha("/imagenes/drStrange.png", "RANGO_2", "BUENO", 2),
            new Ficha("/imagenes/elektra.png", "RANGO_2", "BUENO", 2),
            new Ficha("/imagenes/nightcrawler.png", "RANGO_2", "BUENO", 2),
            // Fichas normales:
            new Ficha("/imagenes/mrFantastic.png", "NORMAL", "BUENO", 10),
            new Ficha("/imagenes/captainAmerica.png", "NORMAL", "BUENO", 9),
            new Ficha("/imagenes/professorX.png", "NORMAL", "BUENO", 8),
            new Ficha("/imagenes/nickFury.png", "NORMAL", "BUENO", 8),
            new Ficha("/imagenes/spiderMan.png", "NORMAL", "BUENO", 7),
            new Ficha("/imagenes/wolverine.png", "NORMAL", "BUENO", 7),
            new Ficha("/imagenes/namor.png", "NORMAL", "BUENO", 7),
            new Ficha("/imagenes/daredevil.png", "NORMAL", "BUENO", 6),
            new Ficha("/imagenes/silverSurfer.png", "NORMAL", "BUENO", 6),
            new Ficha("/imagenes/hulk.png", "NORMAL", "BUENO", 6),
            new Ficha("/imagenes/ironMan.png", "NORMAL", "BUENO", 6),
            new Ficha("/imagenes/thor.png", "NORMAL", "BUENO", 5),
            new Ficha("/imagenes/humanTorch.png", "NORMAL", "BUENO", 5),
            new Ficha("/imagenes/cyclops.png", "NORMAL", "BUENO", 5),
            new Ficha("/imagenes/invisibleWoman.png", "NORMAL", "BUENO", 5),
            new Ficha("/imagenes/ghostRider.png", "NORMAL", "BUENO", 4),
            new Ficha("/imagenes/punisher.png", "NORMAL", "BUENO", 4),
            new Ficha("/imagenes/blade.png", "NORMAL", "BUENO", 4),
            new Ficha("/imagenes/thing.png", "NORMAL", "BUENO", 4),
            new Ficha("/imagenes/emmaFrost.png", "NORMAL", "BUENO", 3),
            new Ficha("/imagenes/sheHulk.png", "NORMAL", "BUENO", 3),
            new Ficha("/imagenes/giantMan.png", "NORMAL", "BUENO", 3),
            new Ficha("/imagenes/beast.png", "NORMAL", "BUENO", 3),
            new Ficha("/imagenes/colossus.png", "NORMAL", "BUENO", 3),
            new Ficha("/imagenes/blackWidow.png", "NORMAL", "BUENO", 1)
        };
    }
}
