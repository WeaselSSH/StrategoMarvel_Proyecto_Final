package stratego_marvel_proyecto_final;

public class DatosGlobales {

    public static ListaJugadores listaJugadores = new ListaJugadores();
    public static Jugador jugadorHost = null;
    public static Jugador jugadorContricante= null;

    public static Ficha[] fichas() {
        return new Ficha[]{
            //tierra y bombas
            new Ficha("/imagenes/heroEarth.png", "TIERRA", "BUENO", 0),
            new Ficha("/imagenes/Nova_Blast.png", "BOMBA", "BUENO", 0),
            //tierra y bombas malos
            new Ficha("/imagenes/villainEarth.png", "TIERRA", "MALO", 0),
            new Ficha("/imagenes/Pumpkin_Bomb.png", "BOMBA", "MALO", 0),
            // fichas rango 2
            new Ficha("/imagenes/Gambit.png", "RANGO_2", "BUENO", 2),
            new Ficha("/imagenes/Spider_Girl.png", "RANGO_2", "BUENO", 2),
            new Ficha("/imagenes/Ice_Man.png", "RANGO_2", "BUENO", 2),
            new Ficha("/imagenes/Storm.png", "RANGO_2", "BUENO", 2),
            new Ficha("/imagenes/Phoenix.png", "RANGO_2", "BUENO", 2),
            new Ficha("/imagenes/Dr_Strange.png", "RANGO_2", "BUENO", 2),
            new Ficha("/imagenes/Elektra.png", "RANGO_2", "BUENO", 2),
            new Ficha("/imagenes/Night_Crawler.png", "RANGO_2", "BUENO", 2),
            // Fichas normales:
            new Ficha("/imagenes/Mr_Fantastic.png", "NORMAL", "BUENO", 10),
            new Ficha("/imagenes/Captain_America.png", "NORMAL", "BUENO", 9),
            new Ficha("/imagenes/Professor_X.png", "NORMAL", "BUENO", 8),
            new Ficha("/imagenes/Nick_Fury.png", "NORMAL", "BUENO", 8),
            new Ficha("/imagenes/Spider_Man.png", "NORMAL", "BUENO", 7),
            new Ficha("/imagenes/Wolverine.png", "NORMAL", "BUENO", 7),
            new Ficha("/imagenes/Namor.png", "NORMAL", "BUENO", 7),
            new Ficha("/imagenes/Daredevil.png", "NORMAL", "BUENO", 6),
            new Ficha("/imagenes/Silver_Surfer.png", "NORMAL", "BUENO", 6),
            new Ficha("/imagenes/Hulk.png", "NORMAL", "BUENO", 6),
            new Ficha("/imagenes/Iron_Man.png", "NORMAL", "BUENO", 6),
            new Ficha("/imagenes/Thor.png", "NORMAL", "BUENO", 5),
            new Ficha("/imagenes/Human_Torch.png", "NORMAL", "BUENO", 5),
            new Ficha("/imagenes/Cyclops.png", "NORMAL", "BUENO", 5),
            new Ficha("/imagenes/Invisible_Woman.png", "NORMAL", "BUENO", 5),
            new Ficha("/imagenes/Ghost_Rider.png", "NORMAL", "BUENO", 4),
            new Ficha("/imagenes/Punisher.png", "NORMAL", "BUENO", 4),
            new Ficha("/imagenes/Blade.png", "NORMAL", "BUENO", 4),
            new Ficha("/imagenes/Thing.png", "NORMAL", "BUENO", 4),
            new Ficha("/imagenes/Emma_Frost.png", "NORMAL", "BUENO", 3),
            new Ficha("/imagenes/She_Hulk.png", "NORMAL", "BUENO", 3),
            new Ficha("/imagenes/Giant_Man.png", "NORMAL", "BUENO", 3),
            new Ficha("/imagenes/Beast.png", "NORMAL", "BUENO", 3),
            new Ficha("/imagenes/Colossus.png", "NORMAL", "BUENO", 3),
            new Ficha("/imagenes/Black_Widow.png", "NORMAL", "BUENO", 1),
            // fichas rango 2 malos
            new Ficha("/imagenes/Electro.png", "RANGO_2", "MALO", 2),
            new Ficha("/imagenes/Sentinel.png", "RANGO_2", "MALO", 2),
            new Ficha("/imagenes/Sentinel_2.png", "RANGO_2", "MALO", 2),
            new Ficha("/imagenes/Viper.png", "RANGO_2", "MALO", 2),
            new Ficha("/imagenes/Leader.png", "RANGO_2", "MALO", 2),
            new Ficha("/imagenes/Sand_Man.png", "RANGO_2", "MALO", 2),
            new Ficha("/imagenes/Ultron.png", "RANGO_2", "MALO", 2),
            new Ficha("/imagenes/Mr_Sinister.png", "RANGO_2", "MALO", 2),
            // Fichas normales malos:
            new Ficha("/imagenes/Dr_Doom.png", "NORMAL", "MALO", 10),
            new Ficha("/imagenes/Galactus.png", "NORMAL", "MALO", 9),
            new Ficha("/imagenes/Kingpin.png", "NORMAL", "MALO", 8),
            new Ficha("/imagenes/Magneto.png", "NORMAL", "MALO", 8),
            new Ficha("/imagenes/Apocalypse.png", "NORMAL", "MALO", 7),
            new Ficha("/imagenes/Green_Goblin.png", "NORMAL", "MALO", 7),
            new Ficha("/imagenes/Venom.png", "NORMAL", "MALO", 7),
            new Ficha("/imagenes/Bullseye.png", "NORMAL", "MALO", 6),
            new Ficha("/imagenes/Omega_Red.png", "NORMAL", "MALO", 6),
            new Ficha("/imagenes/Onslaught.png", "NORMAL", "MALO", 6),
            new Ficha("/imagenes/Red_Skull.png", "NORMAL", "MALO", 6),
            new Ficha("/imagenes/Mystique.png", "NORMAL", "MALO", 5),
            new Ficha("/imagenes/Mysterio.png", "NORMAL", "MALO", 5),
            new Ficha("/imagenes/Dr_Octopus.png", "NORMAL", "MALO", 5),
            new Ficha("/imagenes/Deadpool.png", "NORMAL", "MALO", 5),
            new Ficha("/imagenes/Abomination.png", "NORMAL", "MALO", 4),
            new Ficha("/imagenes/Thanos.png", "NORMAL", "MALO", 4),
            new Ficha("/imagenes/Black_Cat.png", "NORMAL", "MALO", 4),
            new Ficha("/imagenes/Sabretooth.png", "NORMAL", "MALO", 4),
            new Ficha("/imagenes/Juggernaut.png", "NORMAL", "MALO", 3),
            new Ficha("/imagenes/Rhino.png", "NORMAL", "MALO", 3),
            new Ficha("/imagenes/Carnage.png", "NORMAL", "MALO", 3),
            new Ficha("/imagenes/Mole_Man.png", "NORMAL", "MALO", 3),
            new Ficha("/imagenes/Lizard.png", "NORMAL", "MALO", 3),
            new Ficha("/imagenes/Black_Widow_Villain.png", "NORMAL", "MALO", 1)
        };
    }
}
