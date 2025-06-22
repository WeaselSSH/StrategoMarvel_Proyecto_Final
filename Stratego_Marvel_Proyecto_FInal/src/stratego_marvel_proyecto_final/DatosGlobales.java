package stratego_marvel_proyecto_final;

public class DatosGlobales {

    public static ListaJugadores listaJugadores = new ListaJugadores();
    public static Jugador jugadorHost = null;
    public static Jugador jugadorContricante= null;

    public static Ficha[] fichas() {
        return new Ficha[]{
            //tierra y bombas
            new Ficha("/imagenes/heroEarth.png", "TIERRA", "BUENO", 11,"/backsides/backcard1.png", "TierraHeroe"),//Set de rango 11 para que el rango 0 sea exclusivo de bombas
            new Ficha("/imagenes/novaBlast.png", "BOMBA", "BUENO", 0,"/backsides/backcard2.png", "NovaBlast"),//Agregado el nombre como propiedad para poder acceder a el a la hora de mostrar las luchas
            //tierra y bombas malos
            new Ficha("/imagenes/villainEarth.png", "TIERRA", "MALO", 12,"/backsides/backcard3.png", "TierraVillanos"),
            new Ficha("/imagenes/pumpkinBomb.png", "BOMBA", "MALO", 0,"/backsides/backcard4.png", "PumpkingBomb"),
            // fichas rango 2
            new Ficha("/imagenes/gambit.png", "RANGO_2", "BUENO", 2,"/backsides/backcard5.png", "Gambit"),
            new Ficha("/imagenes/spidergirl.png", "RANGO_2", "BUENO", 2,"/backsides/backcard6.png", "SpiderGirl"),
            new Ficha("/imagenes/iceMan.png", "RANGO_2", "BUENO", 2,"/backsides/backcard7.png", "IceMan"),
            new Ficha("/imagenes/storm.png", "RANGO_2", "BUENO", 2,"/backsides/backcard8.png", "Storm"),
            new Ficha("/imagenes/phoenix.png", "RANGO_2", "BUENO", 2,"/backsides/backcard9.png", "Phoenix"),
            new Ficha("/imagenes/drStrange.png", "RANGO_2", "BUENO", 2,"/backsides/backcard10.png", "Dr. Strange"),
            new Ficha("/imagenes/elektra.png", "RANGO_2", "BUENO", 2,"/backsides/backcard11.png", "Elektra"),
            new Ficha("/imagenes/nightcrawler.png", "RANGO_2", "BUENO", 2,"/backsides/backcard12.png", "NightCrawler"),
            // Fichas normales:
            new Ficha("/imagenes/mrFantastic.png", "NORMAL", "BUENO", 10,"/backsides/backcard13.png", "Mr. Fantastic"),
            new Ficha("/imagenes/captainAmerica.png", "NORMAL", "BUENO", 9,"/backsides/backcard14.png", "Captain America"),
            new Ficha("/imagenes/professorX.png", "NORMAL", "BUENO", 8,"/backsides/backcard15.png", "Professor X"),
            new Ficha("/imagenes/nickFury.png", "NORMAL", "BUENO", 8,"/backsides/backcard16.png", "NickFury"),
            new Ficha("/imagenes/spiderMan.png", "NORMAL", "BUENO", 7,"/backsides/backcard17.png", "SpiderMan"),
            new Ficha("/imagenes/wolverine.png", "NORMAL", "BUENO", 7,"/backsides/backcard18.png", "Wolverine"),
            new Ficha("/imagenes/namor.png", "NORMAL", "BUENO", 7,"/backsides/backcard19.png", "Namor"),
            new Ficha("/imagenes/daredevil.png", "NORMAL", "BUENO", 6,"/backsides/backcard20.png", "DareDevil"),
            new Ficha("/imagenes/silverSurfer.png", "NORMAL", "BUENO", 6,"/backsides/backcard21.png", "SilverSurfer"),
            new Ficha("/imagenes/hulk.png", "NORMAL", "BUENO", 6,"/backsides/backcard22.png", "Hulk"),
            new Ficha("/imagenes/ironMan.png", "NORMAL", "BUENO", 6,"/backsides/backcard23.png", "IronMan"),
            new Ficha("/imagenes/thor.png", "NORMAL", "BUENO", 5,"/backsides/backcard24.png", "Thor"),
            new Ficha("/imagenes/humanTorch.png", "NORMAL", "BUENO", 5,"/backsides/backcard25.png", "HumanTorch"),
            new Ficha("/imagenes/cyclops.png", "NORMAL", "BUENO", 5,"/backsides/backcard26.png", "Cyclops"),
            new Ficha("/imagenes/invisibleWoman.png", "NORMAL", "BUENO", 5,"/backsides/backcard27.png", "Invisible Woman"),
            new Ficha("/imagenes/ghostRider.png", "NORMAL", "BUENO", 4,"/backsides/backcard28.png", "GhostRider"),
            new Ficha("/imagenes/punisher.png", "NORMAL", "BUENO", 4,"/backsides/backcard29.png", "Punisher"),
            new Ficha("/imagenes/blade.png", "NORMAL", "BUENO", 4,"/backsides/backcard30.png", "Blade"),
            new Ficha("/imagenes/thing.png", "NORMAL", "BUENO", 4,"/backsides/backcard31.png", "Thing"),
            new Ficha("/imagenes/emmaFrost.png", "NORMAL", "BUENO", 3,"/backsides/backcard32.png", "EmmaFrost"),
            new Ficha("/imagenes/sheHulk.png", "NORMAL", "BUENO", 3,"/backsides/backcard33.png", "SheHulk"),
            new Ficha("/imagenes/giantMan.png", "NORMAL", "BUENO", 3,"/backsides/backcard34.png", "GiantMan"),
            new Ficha("/imagenes/beast.png", "NORMAL", "BUENO", 3,"/backsides/backcard35.png", "Beast"),
            new Ficha("/imagenes/colossus.png", "NORMAL", "BUENO", 3,"/backsides/backcard36.png", "Colossus"),
            new Ficha("/imagenes/blackWidow.png", "NORMAL", "BUENO", 1,"/backsides/backcard37.png", "BlackWidow"),
            // fichas rango 2 malos
            new Ficha("/imagenes/electro.png", "RANGO_2", "MALO", 2,"/backsides/backcard38.png", "Electro"),
            new Ficha("/imagenes/sentinel.png", "RANGO_2", "MALO", 2,"/backsides/backcard39.png", "Sentinel"),
            new Ficha("/imagenes/sentinel2.png", "RANGO_2", "MALO", 2,"/backsides/backcard40.png", "Sentinel"),
            new Ficha("/imagenes/viper.png", "RANGO_2", "MALO", 2,"/backsides/backcard41.png", "Viper"),
            new Ficha("/imagenes/leader.png", "RANGO_2", "MALO", 2,"/backsides/backcard42.png", "Leader"),
            new Ficha("/imagenes/sandman.png", "RANGO_2", "MALO", 2,"/backsides/backcard43.png", "SandMan"),
            new Ficha("/imagenes/ultron.png", "RANGO_2", "MALO", 2,"/backsides/backcard44.png", "Ultron"),
            new Ficha("/imagenes/mrSinister.png", "RANGO_2", "MALO", 2,"/backsides/backcard45.png", "Mr. Sinister"),
            // Fichas normales malos:
            new Ficha("/imagenes/drDoom.png", "NORMAL", "MALO", 10,"/backsides/backcard46.png", "Dr. Doom"),
            new Ficha("/imagenes/galactus.png", "NORMAL", "MALO", 9,"/backsides/backcard47.png", "Galactus"),
            new Ficha("/imagenes/kingpin.png", "NORMAL", "MALO", 8,"/backsides/backcard48.png", "KingPin"),
            new Ficha("/imagenes/magneto.png", "NORMAL", "MALO", 8,"/backsides/backcard49.png", "Magneto"),
            new Ficha("/imagenes/apocalypse.png", "NORMAL", "MALO", 7,"/backsides/backcard50.png", "Apocalypse"),
            new Ficha("/imagenes/greengoblin.png", "NORMAL", "MALO", 7,"/backsides/backcard51.png", "GreenGoblin"),
            new Ficha("/imagenes/venom.png", "NORMAL", "MALO", 7,"/backsides/backcard52.png", "Venom"),
            new Ficha("/imagenes/bullseye.png", "NORMAL", "MALO", 6,"/backsides/backcard53.png", "Bullseye"),
            new Ficha("/imagenes/omegaRed.png", "NORMAL", "MALO", 6,"/backsides/backcard54.png", "OmegaRed"),
            new Ficha("/imagenes/onslaught.png", "NORMAL", "MALO", 6,"/backsides/backcard55.png", "Onslaught"),
            new Ficha("/imagenes/redSkull.png", "NORMAL", "MALO", 6,"/backsides/backcard56.png", "RedSkull"),
            new Ficha("/imagenes/mystique.png", "NORMAL", "MALO", 5,"/backsides/backcard57.png", "Mystique"),
            new Ficha("/imagenes/mysterio.png", "NORMAL", "MALO", 5,"/backsides/backcard58.png", "Mysterio"),
            new Ficha("/imagenes/drOctopus.png", "NORMAL", "MALO", 5,"/backsides/backcard59.png", "Dr. Octopus"),
            new Ficha("/imagenes/deadpool.png", "NORMAL", "MALO", 5,"/backsides/backcard60.png", "Deadpool"),
            new Ficha("/imagenes/abomination.png", "NORMAL", "MALO", 4,"/backsides/backcard61.png", "Abomination"),
            new Ficha("/imagenes/thanos.png", "NORMAL", "MALO", 4,"/backsides/backcard62.png", "Thanos"),
            new Ficha("/imagenes/blackCat.png", "NORMAL", "MALO", 4,"/backsides/backcard63.png", "BlackCat"),
            new Ficha("/imagenes/sabretooth.png", "NORMAL", "MALO", 4,"/backsides/backcard64.png", "SabreTooth"),
            new Ficha("/imagenes/juggernaut.png", "NORMAL", "MALO", 3,"/backsides/backcard65.png", "Juggernaut"),
            new Ficha("/imagenes/rhino.png", "NORMAL", "MALO", 3,"/backsides/backcard66.png", "Rhino"),
            new Ficha("/imagenes/carnage.png", "NORMAL", "MALO", 3,"/backsides/backcard67.png", "Carnage"),
            new Ficha("/imagenes/moleMan.png", "NORMAL", "MALO", 3,"/backsides/backcard68.png", "MoleMan"),
            new Ficha("/imagenes/lizard.png", "NORMAL", "MALO", 3,"/backsides/backcard69.png", "Lizard"),
            new Ficha("/imagenes/blackWidowVillain.png", "NORMAL", "MALO", 1,"/backsides/backcard70.png", "BlackWidow")
        };
    }
}
