package stratego_marvel_proyecto_final;

public class DatosGlobales {

    public static ListaJugadores listaJugadores = new ListaJugadores();
    public static Jugador jugadorHost = null;
    public static Jugador jugadorContricante= null;

    public static Ficha[] fichas() {
        return new Ficha[]{
            //tierra y bombas
            new Ficha("/imagenes/heroEarth.png", "TIERRA", "BUENO", 0, "TierraHeroes"),
            new Ficha("/imagenes/Nova_Blast.png", "BOMBA", "BUENO", 0, "Nova Blas"),
            //tierra y bombas malos
            new Ficha("/imagenes/villainEarth.png", "TIERRA", "MALO", 0, "TierraVillanos"),
            new Ficha("/imagenes/Pumpkin_Bomb.png", "BOMBA", "MALO", 0, "Pumpking Bomb"),
            // fichas rango 2
            new Ficha("/imagenes/Gambit.png", "RANGO_2", "BUENO", 2, "Gambit"),
            new Ficha("/imagenes/Spider_Girl.png", "RANGO_2", "BUENO", 2, "Spider Girl"),
            new Ficha("/imagenes/Ice_Man.png", "RANGO_2", "BUENO", 2, "Ice Man"),
            new Ficha("/imagenes/Storm.png", "RANGO_2", "BUENO", 2, "Storm"),
            new Ficha("/imagenes/Phoenix.png", "RANGO_2", "BUENO", 2, "Phoenix"),
            new Ficha("/imagenes/Dr_Strange.png", "RANGO_2", "BUENO", 2, "Dr. Strange"),
            new Ficha("/imagenes/Elektra.png", "RANGO_2", "BUENO", 2, "Elektra"),
            new Ficha("/imagenes/Night_Crawler.png", "RANGO_2", "BUENO", 2, "Night Crawler"),
            // Fichas normales:
            new Ficha("/imagenes/Mr_Fantastic.png", "NORMAL", "BUENO", 10, "Mr. Fantastic"),
            new Ficha("/imagenes/Captain_America.png", "NORMAL", "BUENO", 9, "Captain America"),
            new Ficha("/imagenes/Professor_X.png", "NORMAL", "BUENO", 8, "Professor X"),
            new Ficha("/imagenes/Nick_Fury.png", "NORMAL", "BUENO", 8, "Nick Fury"),
            new Ficha("/imagenes/Spider_Man.png", "NORMAL", "BUENO", 7, "Spider Man"),
            new Ficha("/imagenes/Wolverine.png", "NORMAL", "BUENO", 7, "Wolverine"),
            new Ficha("/imagenes/Namor.png", "NORMAL", "BUENO", 7, "Namor"),
            new Ficha("/imagenes/Daredevil.png", "NORMAL", "BUENO", 6, "Daredevil"),
            new Ficha("/imagenes/Silver_Surfer.png", "NORMAL", "BUENO", 6, "Silver Surfer"),
            new Ficha("/imagenes/Hulk.png", "NORMAL", "BUENO", 6, "Hulk"),
            new Ficha("/imagenes/Iron_Man.png", "NORMAL", "BUENO", 6, "Iron Man"),
            new Ficha("/imagenes/Thor.png", "NORMAL", "BUENO", 5, "Thor"),
            new Ficha("/imagenes/Human_Torch.png", "NORMAL", "BUENO", 5, "Human Torch"),
            new Ficha("/imagenes/Cyclops.png", "NORMAL", "BUENO", 5, "Cyclops"),
            new Ficha("/imagenes/Invisible_Woman.png", "NORMAL", "BUENO", 5, "Invisible Woman"),
            new Ficha("/imagenes/Ghost_Rider.png", "NORMAL", "BUENO", 4, "Ghost Rider"),
            new Ficha("/imagenes/Punisher.png", "NORMAL", "BUENO", 4, "Punisher"),
            new Ficha("/imagenes/Blade.png", "NORMAL", "BUENO", 4, "Blade"),
            new Ficha("/imagenes/Thing.png", "NORMAL", "BUENO", 4, "Thing"),
            new Ficha("/imagenes/Emma_Frost.png", "NORMAL", "BUENO", 3,"Emma Frost"),
            new Ficha("/imagenes/She_Hulk.png", "NORMAL", "BUENO", 3, "SheHulk"),
            new Ficha("/imagenes/Giant_Man.png", "NORMAL", "BUENO", 3, "GiantMan"),
            new Ficha("/imagenes/Beast.png", "NORMAL", "BUENO", 3, "Beast"),
            new Ficha("/imagenes/Colossus.png", "NORMAL", "BUENO", 3, "Colossus"),
            new Ficha("/imagenes/Black_Widow.png", "NORMAL", "BUENO", 1, "BlackWidow"),
            // fichas rango 2 malos
            new Ficha("/imagenes/Electro.png", "RANGO_2", "MALO", 2, "Electro"),
            new Ficha("/imagenes/Sentinel.png", "RANGO_2", "MALO", 2, "Sentinel"),
            new Ficha("/imagenes/Sentinel_2.png", "RANGO_2", "MALO", 2, "Sentinel"),
            new Ficha("/imagenes/Viper.png", "RANGO_2", "MALO", 2,"Viper"),
            new Ficha("/imagenes/Leader.png", "RANGO_2", "MALO", 2,"Leader"),
            new Ficha("/imagenes/Sand_Man.png", "RANGO_2", "MALO", 2,"SandMan"),
            new Ficha("/imagenes/Ultron.png", "RANGO_2", "MALO", 2, "Ultron"),
            new Ficha("/imagenes/Mr_Sinister.png", "RANGO_2", "MALO", 2, "Mr. Sinister"),
            // Fichas normales malos:
            new Ficha("/imagenes/Dr_Doom.png", "NORMAL", "MALO", 10, "Dr. Doom"),
            new Ficha("/imagenes/Galactus.png", "NORMAL", "MALO", 9, "Galactus"),
            new Ficha("/imagenes/Kingpin.png", "NORMAL", "MALO", 8, "Kingpin"),
            new Ficha("/imagenes/Magneto.png", "NORMAL", "MALO", 8, "Magneto"),
            new Ficha("/imagenes/Apocalypse.png", "NORMAL", "MALO", 7, "Apocalypse"),
            new Ficha("/imagenes/Green_Goblin.png", "NORMAL", "MALO", 7, "Green Globlin"),
            new Ficha("/imagenes/Venom.png", "NORMAL", "MALO", 7, "Venom"),
            new Ficha("/imagenes/Bullseye.png", "NORMAL", "MALO", 6, "Bullseye"),
            new Ficha("/imagenes/Omega_Red.png", "NORMAL", "MALO", 6,"Omega Red"),
            new Ficha("/imagenes/Onslaught.png", "NORMAL", "MALO", 6, "Onslaught"),
            new Ficha("/imagenes/Red_Skull.png", "NORMAL", "MALO", 6,"RedSkull"),
            new Ficha("/imagenes/Mystique.png", "NORMAL", "MALO", 5,"Mystique"),
            new Ficha("/imagenes/Mysterio.png", "NORMAL", "MALO", 5,"Mysterio"),
            new Ficha("/imagenes/Dr_Octopus.png", "NORMAL", "MALO", 5,"Dr. Octopus"),
            new Ficha("/imagenes/Deadpool.png", "NORMAL", "MALO", 5,"Deadpool"),
            new Ficha("/imagenes/Abomination.png", "NORMAL", "MALO", 4,"Abomination"),
            new Ficha("/imagenes/Thanos.png", "NORMAL", "MALO", 4,"Thanos"),
            new Ficha("/imagenes/Black_Cat.png", "NORMAL", "MALO", 4,"BlackCat"),
            new Ficha("/imagenes/Sabretooth.png", "NORMAL", "MALO", 4,"Sabretooth"),
            new Ficha("/imagenes/Juggernaut.png", "NORMAL", "MALO", 3,"Juggernaut"),
            new Ficha("/imagenes/Rhino.png", "NORMAL", "MALO", 3,"Rhino"),
            new Ficha("/imagenes/Carnage.png", "NORMAL", "MALO", 3,"Carnage"),
            new Ficha("/imagenes/Mole_Man.png", "NORMAL", "MALO", 3,"MoleMan"),
            new Ficha("/imagenes/Lizard.png", "NORMAL", "MALO", 3,"Lizard"),
            new Ficha("/imagenes/Black_Widow_Villain.png", "NORMAL", "MALO", 1,"BlackWidow Villain")
        };
    }
}
