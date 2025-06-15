package stratego_marvel_proyecto_final;

public class DatosGlobales {

    public static ListaJugadores listaJugadores = new ListaJugadores();
    public static Jugador jugadorHost = null;

    public static Ficha[] fichas() {
        return new Ficha[]{
            //tierra y bombas
            new Ficha("/imagenes/heroEarth.png", "TIERRA", "BUENO", 0),
            new Ficha("/imagenes/novaBlast.png", "BOMBA", "BUENO", 0),
            //tierra y bombas malos
            new Ficha("/imagenes/villainEarth.png", "TIERRA", "MALO", 0),
            new Ficha("/imagenes/pumpkinBomb.png", "BOMBA", "MALO", 0),
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
            new Ficha("/imagenes/blackWidow.png", "NORMAL", "BUENO", 1),
            // fichas rango 2 malos
            new Ficha("/imagenes/electro.png", "RANGO_2", "MALO", 2),
            new Ficha("/imagenes/sentinel.png", "RANGO_2", "MALO", 2),
            new Ficha("/imagenes/sentinel2.png", "RANGO_2", "MALO", 2),
            new Ficha("/imagenes/viper.png", "RANGO_2", "MALO", 2),
            new Ficha("/imagenes/leader.png", "RANGO_2", "MALO", 2),
            new Ficha("/imagenes/sandman.png", "RANGO_2", "MALO", 2),
            new Ficha("/imagenes/ultron.png", "RANGO_2", "MALO", 2),
            new Ficha("/imagenes/mrSinister.png", "RANGO_2", "MALO", 2),
            // Fichas normales malos:
            new Ficha("/imagenes/drDoom.png", "NORMAL", "MALO", 10),
            new Ficha("/imagenes/galactus.png", "NORMAL", "MALO", 9),
            new Ficha("/imagenes/kingpin.png", "NORMAL", "MALO", 8),
            new Ficha("/imagenes/magneto.png", "NORMAL", "MALO", 8),
            new Ficha("/imagenes/apocalypse.png", "NORMAL", "MALO", 7),
            new Ficha("/imagenes/greengoblin.png", "NORMAL", "MALO", 7),
            new Ficha("/imagenes/venom.png", "NORMAL", "MALO", 7),
            new Ficha("/imagenes/bullseye.png", "NORMAL", "MALO", 6),
            new Ficha("/imagenes/omegaRed.png", "NORMAL", "MALO", 6),
            new Ficha("/imagenes/onslaught.png", "NORMAL", "MALO", 6),
            new Ficha("/imagenes/redSkull.png", "NORMAL", "MALO", 6),
            new Ficha("/imagenes/mystique.png", "NORMAL", "MALO", 5),
            new Ficha("/imagenes/mysterio.png", "NORMAL", "MALO", 5),
            new Ficha("/imagenes/drOctopus.png", "NORMAL", "MALO", 5),
            new Ficha("/imagenes/deadpool.png", "NORMAL", "MALO", 5),
            new Ficha("/imagenes/abomination.png", "NORMAL", "MALO", 4),
            new Ficha("/imagenes/thanos.png", "NORMAL", "MALO", 4),
            new Ficha("/imagenes/blackCat.png", "NORMAL", "MALO", 4),
            new Ficha("/imagenes/sabretooth.png", "NORMAL", "MALO", 4),
            new Ficha("/imagenes/juggernaut.png", "NORMAL", "MALO", 3),
            new Ficha("/imagenes/rhino.png", "NORMAL", "MALO", 3),
            new Ficha("/imagenes/carnage.png", "NORMAL", "MALO", 3),
            new Ficha("/imagenes/moleMan.png", "NORMAL", "MALO", 3),
            new Ficha("/imagenes/lizard.png", "NORMAL", "MALO", 3),
            new Ficha("/imagenes/blackWidowVillain.png", "NORMAL", "MALO", 1)
        };
    }
}
