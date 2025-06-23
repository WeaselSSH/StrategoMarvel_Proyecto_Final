package stratego_marvel_proyecto_final;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.util.Random;
import javax.swing.border.LineBorder;
import javax.swing.border.Border;
import java.awt.Color;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Tablero {

    Ficha fichasDerrotadasBuenos[] = new Ficha[50];
    Ficha fichasDerrotadasMalos[] = new Ficha[50];

    private String nombreJugadorHeroe = DatosGlobales.jugadorHeroe.getUsuario().toUpperCase();
    private String nombreJugadorVillian = DatosGlobales.jugadorVillian.getUsuario().toUpperCase();
    String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

    Random random = new Random();
    private JButton[][] botones = new JButton[10][10];
    private JLabel lblTurno;
    Border bordeAzul = new LineBorder(new Color(0, 0, 130), 5);
    Border bordeRojo = new LineBorder(new Color(140, 0, 0), 5);
    //boolean que sirve para la validación tanto de bordes visuales como movimiento (backend y frontend por asi decirlo)
    private final boolean[][] bordeActivo = new boolean[10][10];

    //coordenadas de las casillas de lago (o sea las que están deshabilitadas)
    private final int[][] casillasLago = {
        {4, 2}, {4, 3}, {5, 2}, {5, 3},
        {4, 6}, {4, 7}, {5, 6}, {5, 7}
    };

    private int cantHeroes = 0;
    private int cantVillanos = 0;

    int cantHeroesDerrotados = 0;
    int cantVillanosDerrotados = 0;

    //inicializado en bueno porque empiezan los buenos
    private String turnoActual = "BUENO";

    private int filaSeleccionada;
    private int columnaSeleccionada;
    private Ficha fichaSeleccionada;

    private JFrame savedpartida;//guarda el formpartida para cerrarlo cuando todo termine

    public Tablero(JButton[][] botones, JLabel turno, JFrame partida) {
        savedpartida = partida;
        this.botones = botones;
        this.lblTurno = turno;
    }

    //Metodo que brindara informacion si la ficha se encuentra ocupada
    public boolean fichaOcupada(int fila, int columna) {
        if (botones[fila][columna].getIcon() == null) {
            return false;
        }
        return true;
    }

    public void inicializar() {
        ocultarBotones();
        asignarTierraYBombas();
        asignarFichasRestantes(DatosGlobales.fichas(), "BUENO");
        asignarFichasRestantes(DatosGlobales.fichas(), "MALO");
        bloquearLago();
    }

    private void asignarTierraYBombas() {
        for (Ficha ficha : DatosGlobales.fichas()) {
            if (ficha.getTipo().equals("TIERRA")) {
                int fila = ficha.getBando().equals("BUENO") ? 9 : 0;
                int columna = random.nextInt(8) + 1;

                ImageIcon imagen;
                if (ficha.getBando().equals(turnoActual)) {
                    imagen = new ImageIcon(getClass().getResource(ficha.getRutaImagen()));
                } else {
                    imagen = new ImageIcon(getClass().getResource("/imagenes/backcard.png"));
                }
                imagen.setDescription(ficha.getRutaImagen());
                botones[fila][columna].setIcon(imagen);

                asignarBombas(columna, fila, ficha.getBando());
                asignarBombasRestantes(ficha.getBando());
            }
        }
    }

    private void asignarBombas(int columna, int fila, String bando) {
        String rutaBomba = bando.equals("BUENO")
                ? "/imagenes/Nova_Blast.png"
                : "/imagenes/Pumpkin_Bomb.png";

        ImageIcon bomba1;
        if (bando.equals(turnoActual)) {
            bomba1 = new ImageIcon(getClass().getResource(rutaBomba));
        } else {
            bomba1 = new ImageIcon(getClass().getResource("/imagenes/backcard.png"));
        }
        bomba1.setDescription(rutaBomba);
        botones[fila][columna - 1].setIcon(bomba1);

        ImageIcon bomba2;
        if (bando.equals(turnoActual)) {
            bomba2 = new ImageIcon(getClass().getResource(rutaBomba));
        } else {
            bomba2 = new ImageIcon(getClass().getResource("/imagenes/backcard.png"));
        }
        bomba2.setDescription(rutaBomba);
        botones[fila][columna + 1].setIcon(bomba2);

        ImageIcon bomba3;
        if (bando.equals(turnoActual)) {
            bomba3 = new ImageIcon(getClass().getResource(rutaBomba));
        } else {
            bomba3 = new ImageIcon(getClass().getResource("/imagenes/backcard.png"));
        }
        bomba3.setDescription(rutaBomba);

        if (bando.equalsIgnoreCase("BUENO")) {
            botones[fila - 1][columna].setIcon(bomba3);
        } else {
            botones[fila + 1][columna].setIcon(bomba3);
        }
    }

    private void asignarBombasRestantes(String bando) {
        String rutaBomba = bando.equals("BUENO")
                ? "/imagenes/Nova_Blast.png"
                : "/imagenes/Pumpkin_Bomb.png";

        int[] filasDisponibles = bando.equals("BUENO") ? new int[]{8, 9} : new int[]{0, 1};

        int bombasColocadas = 0;
        while (bombasColocadas < 3) {
            int fila = filasDisponibles[random.nextInt(filasDisponibles.length)];
            int columna = random.nextInt(10);

            if (botones[fila][columna].getIcon() == null) {
                ImageIcon imagen;
                if (bando.equals(turnoActual)) {
                    imagen = new ImageIcon(getClass().getResource(rutaBomba));
                } else {
                    imagen = new ImageIcon(getClass().getResource("/imagenes/backcard.png"));
                }
                imagen.setDescription(rutaBomba);
                botones[fila][columna].setIcon(imagen);
                bombasColocadas++;
            }
        }
    }

    private void asignarFichasRestantes(Ficha[] fichas, String bando) {
        int[] filasRango2 = bando.equals("BUENO") ? new int[]{6, 7} : new int[]{2, 3};
        int[] filasNormales = bando.equals("BUENO") ? new int[]{6, 7, 8, 9} : new int[]{0, 1, 2, 3};

        for (Ficha ficha : fichas) {
            if (ficha.getBando().equalsIgnoreCase(bando)) {
                if (ficha.getTipo().equals("RANGO_2")) {
                    colocarFicha(ficha, filasRango2);
                } else if (ficha.getTipo().equals("NORMAL")) {
                    colocarFicha(ficha, filasNormales);
                }
            }
        }
    }

    private void colocarFicha(Ficha ficha, int[] filasPosibles) {
        boolean colocado = false;

        while (!colocado) {
            int fila = filasPosibles[random.nextInt(filasPosibles.length)];
            int columna = random.nextInt(10);

            if (botones[fila][columna].getIcon() == null) {
                ImageIcon imagen;

                if (ficha.getBando().equals(turnoActual)) {
                    // Mostrar imagen real
                    imagen = new ImageIcon(getClass().getResource(ficha.getRutaImagen()));
                } else {
                    // Mostrar la backcard
                    imagen = new ImageIcon(getClass().getResource("/imagenes/backcard.png"));
                }

                imagen.setDescription(ficha.getRutaImagen());
                botones[fila][columna].setIcon(imagen);
                colocado = true;
            }
        }
    }

    public void ocultarBotones() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                botones[i][j].setOpaque(false);
                botones[i][j].setContentAreaFilled(false);
            }
        }
    }

    public void mostrarBotones() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                botones[i][j].setVisible(true);
            }
        }
    }

    public void botonClick(int fila, int columna) {
        //castearlo a imagen
        ImageIcon imagen = (ImageIcon) botones[fila][columna].getIcon();

        if (fichaSeleccionada == null) {
            if (imagen != null) {
                Ficha ficha = obtenerFicha(imagen.getDescription());

                //validar que sea el turno del jugador, el bando y todo eso
                if (ficha != null && ficha.getBando().equals(turnoActual)
                        && !ficha.getTipo().equals("TIERRA") && !ficha.getTipo().equals("BOMBA")) {

                    fichaSeleccionada = ficha;
                    filaSeleccionada = fila;
                    columnaSeleccionada = columna;
                    agregarQuitarBorde(fila, columna);
                }
            }
        } else {
            if (fila == filaSeleccionada && columna == columnaSeleccionada) {
                //resetear las variables donde se almacena la ficha actual y lo demás
                fichaSeleccionada = null;
                filaSeleccionada = -1;
                columnaSeleccionada = -1;
                quitarBordes();
                return;
            }

            if (bordeActivo[fila][columna]) {
                //aquí se usa la lègica de marcar borde para la logica con el boolean borde activo
                boolean movido = moverFicha(filaSeleccionada, columnaSeleccionada, fila, columna);
                if (movido) {
                    //si la ficha se ha movido se cambia de turno
                    if (turnoActual.equals("BUENO")) {
                        turnoActual = "MALO";
                        lblTurno.setText("TURNO: VILLANOS");
                    } else {
                        turnoActual = "BUENO";
                        lblTurno.setText("TURNO: HEROES");
                    }
                    actualizarImagenes();
                }
            }

            fichaSeleccionada = null;
            filaSeleccionada = -1;
            columnaSeleccionada = -1;
            quitarBordes();
        }
    }

    private void agregarQuitarBorde(int fil, int col) {//Genera espacio de bordes
        if (bordeActivo[fil][col]) {
            quitarBordes();
            return;
        }

        quitarBordes();

        ImageIcon imagen = (ImageIcon) botones[fil][col].getIcon();
        if (imagen == null) {
            return;
        }

        String rutaImagen = imagen.getDescription();
        Ficha fichaSeleccionada = obtenerFicha(rutaImagen);
        if (fichaSeleccionada == null) {
            return;
        }

        Border borde = fichaSeleccionada.getBando().equals("BUENO") ? bordeAzul : bordeRojo;
        botones[fil][col].setBorder(borde);
        bordeActivo[fil][col] = true;

        if (fichaSeleccionada.getBando().equals("BUENO")) {
            //ImageIcon backCard = new ImageIcon(getClass().getResource("/imagenes/backcard.png"));
            botones[fil][col].setEnabled(true);
        } else if (fichaSeleccionada.getBando().equals("MALO")) {
            botones[fil][col].setEnabled(true);
        }//Esto activa la ficha independientemente de cual sea el caso. Con tal sea abarcada la zona por el rectangulo de seleccion

        boolean esRango2 = fichaSeleccionada.getTipo().equals("RANGO_2");
        marcarBordes(fil, col, borde, esRango2, fichaSeleccionada.getBando());
    }

    private void marcarBordes(int fil, int col, Border borde, boolean rango2, String bandoFichaSeleccionada) {
        //aqui es donde ocurre la lógica para mover también
        int[][] direcciones = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        for (int[] dir : direcciones) {
            int nuevaFila = fil;
            int nuevaCol = col;

            if (rango2) {
                while (true) {
                    nuevaFila += dir[0];
                    nuevaCol += dir[1];

                    if (!posicionValida(nuevaFila, nuevaCol)) {
                        break;
                    }

                    if (verificarCasillaLago(nuevaFila, nuevaCol)) {
                        break;
                    }

                    ImageIcon imagen = (ImageIcon) botones[nuevaFila][nuevaCol].getIcon();

                    if (imagen != null) {
                        Ficha fichaEncontrada = obtenerFicha(imagen.getDescription());

                        if (fichaEncontrada != null) {
                            if (fichaEncontrada.getBando().equals(bandoFichaSeleccionada)) {
                                break;
                            } else {
                                botones[nuevaFila][nuevaCol].setBorder(borde);
                                bordeActivo[nuevaFila][nuevaCol] = true;
                                botones[nuevaFila][nuevaCol].setEnabled(true);//Activa solo el marcado dentro de casilla
                                break;
                            }
                        }
                    }

                    botones[nuevaFila][nuevaCol].setBorder(borde);
                    bordeActivo[nuevaFila][nuevaCol] = true;
                }
            } else {
                nuevaFila += dir[0];
                nuevaCol += dir[1];

                if (!posicionValida(nuevaFila, nuevaCol)) {
                    continue;
                }

                if (verificarCasillaLago(nuevaFila, nuevaCol)) {
                    continue;
                }
                //en estas se usa continue porque si no no deja mover en las otras direcciones porque se iría del ciclo

                ImageIcon imagen = (ImageIcon) botones[nuevaFila][nuevaCol].getIcon();

                if (imagen != null) {
                    Ficha fichaEncontrada = obtenerFicha(imagen.getDescription());

                    if (fichaEncontrada != null && !fichaEncontrada.getBando().equals(bandoFichaSeleccionada)) {
                        botones[nuevaFila][nuevaCol].setBorder(borde);
                        bordeActivo[nuevaFila][nuevaCol] = true;
                    }
                } else {
                    botones[nuevaFila][nuevaCol].setBorder(borde);
                    bordeActivo[nuevaFila][nuevaCol] = true;
                }
            }
        }
    }

    private void quitarBordes() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                botones[i][j].setBorder(null);
                bordeActivo[i][j] = false;
            }
        }
    }

    public Ficha obtenerFicha(String rutaImagen) {
        Ficha[] fichas = DatosGlobales.fichas();
        for (Ficha ficha : fichas) {
            if (rutaImagen.equals(ficha.getRutaImagen())) {
                return ficha;
            }
        }
        return null;
    }

    public Ficha buscarxNombre(String nombre) {//Metodo que permitira ubicar la fecha mediante nombre, util para animaciones
        Ficha[] fichas = DatosGlobales.fichas();
        for (Ficha ficha : fichas) {
            if (nombre.equals(ficha.getName())) {
                return ficha;
            }
        }
        return null;
    }

    private boolean posicionValida(int fila, int columna) {
        return fila >= 0 && fila < 10 && columna >= 0 && columna < 10;
    }

    private void bloquearLago() {
        for (int[] posicion : casillasLago) {
            int fila = posicion[0];
            int columna = posicion[1];

            botones[fila][columna].setEnabled(false);
        }
    }

    private boolean verificarCasillaLago(int fila, int columna) {
        for (int[] pos : casillasLago) {
            if (pos[0] == fila && pos[1] == columna) {
                return true;
            }
        }
        return false;
    }

    private void agregarFichaDerrotada(Ficha ficha) {
        if (ficha.getBando().equalsIgnoreCase("BUENO")) {
            if (cantHeroesDerrotados < fichasDerrotadasBuenos.length) {
                fichasDerrotadasBuenos[cantHeroesDerrotados] = ficha;
                cantHeroesDerrotados++;
            }
        } else {
            if (cantVillanosDerrotados < fichasDerrotadasMalos.length) {
                fichasDerrotadasMalos[cantVillanosDerrotados] = ficha;
                cantVillanosDerrotados++;
            }
        }
    }

    private boolean moverFicha(int filaOrigen, int columnaOrigen, int filaDestino, int columnaDestino) {

        //se obtienen las imagenes
        ImageIcon imagenOrigen = (ImageIcon) botones[filaOrigen][columnaOrigen].getIcon();
        ImageIcon imagenDestino = (ImageIcon) botones[filaDestino][columnaDestino].getIcon();

        if (imagenOrigen == null) {
            return false;
        }
        //XD

        Ficha fichaOrigen = obtenerFicha(imagenOrigen.getDescription());
        Ficha fichaDestino = (imagenDestino != null) ? obtenerFicha(imagenDestino.getDescription()) : null;

        //Obtencion de nombres de las fichas
        String nombreOrigen = fichaOrigen.getName();
        String nombreDestino;

        if (fichaDestino == null) {
            botones[filaDestino][columnaDestino].setIcon(imagenOrigen);
            botones[filaOrigen][columnaOrigen].setIcon(null);
            return true;
        } else { //logica de combate
            nombreDestino = fichaDestino.getName();//Set de mombre en caso que ficha destino no sea null
            Ficha defenTemp = this.buscarxNombre(nombreDestino);//Busca la ficha de acuerdo a su nombre
            ImageIcon imagDefense = new ImageIcon(getClass().getResource(defenTemp.getRutaImagen()));//Establece la imagen verdadera de la ficha

            if (fichaDestino.getTipo().equals("BOMBA")) {
                if (fichaOrigen.getRango() == 3) {
                    animacionBombaDesct(imagDefense, imagenOrigen, nombreOrigen);
                    agregarFichaDerrotada(fichaDestino);
                    botones[filaDestino][columnaDestino].setIcon(imagenOrigen);
                    botones[filaOrigen][columnaOrigen].setIcon(null);
                    return true;
                } else {
                    animacionBombaAct(imagDefense, imagenOrigen, nombreOrigen);
                    agregarFichaDerrotada(fichaOrigen);
                    agregarFichaDerrotada(fichaDestino);
                    botones[filaOrigen][columnaOrigen].setIcon(null);
                    botones[filaDestino][columnaDestino].setIcon(null);
                    return true;
                }
            } else {
                int rangoOrigen = fichaOrigen.getRango();
                int rangoDestino = fichaDestino.getRango();

                //Reubicacion de verificacion de captura tierra
                if (rangoDestino == 12) {
                    DatosGlobales.jugadorHeroe.partidaGanada();
                    DatosGlobales.jugadorVillian.partidaPerdida();
                    DatosGlobales.victoriaHeroes++;
                    DatosGlobales.jugadorHeroe.setLog(nombreJugadorHeroe + " VENCEDOR USANDO LOS HEROES CAPTURANDO LA TIERRA DE "
                            + nombreJugadorVillian + " " + "[" + fecha + "]");
                    animacionWinHeroes();
                    bloquear();
                    return true;
                } else if (rangoDestino == 11) {
                    DatosGlobales.jugadorVillian.partidaGanada();//Agregado de puntos
                    DatosGlobales.jugadorHeroe.partidaPerdida();
                    DatosGlobales.victoriaVillanos++;
                    DatosGlobales.jugadorHeroe.setLog(nombreJugadorVillian + " VENCEDOR USANDO LOS HEROES CAPTURANDO LA TIERRA DE "
                            + nombreJugadorHeroe + " " + "[" + fecha + "]");
                    animacionWinVillanos();
                    bloquear();
                    return true;
                }//Indicar movimiento no valido

                if (rangoOrigen == 1 && rangoDestino == 10) {
                    agregarFichaDerrotada(fichaDestino);
                    animacionLucha(imagenOrigen, imagDefense, nombreOrigen);
                    botones[filaDestino][columnaDestino].setIcon(imagenOrigen);
                    botones[filaOrigen][columnaOrigen].setIcon(null);
                    return true;
                }

                if (rangoOrigen > rangoDestino) {
                    agregarFichaDerrotada(fichaDestino);
                    animacionLucha(imagenOrigen, imagDefense, nombreOrigen);
                    botones[filaDestino][columnaDestino].setIcon(imagenOrigen);
                    botones[filaOrigen][columnaOrigen].setIcon(null);
                    WinOrLoose(savedpartida);
                    return true;
                } else if (rangoOrigen < rangoDestino) {
                    agregarFichaDerrotada(fichaOrigen);
                    animacionLucha(imagDefense, imagenOrigen, nombreDestino);
                    botones[filaOrigen][columnaOrigen].setIcon(null);
                    WinOrLoose(savedpartida);
                    return true;
                } else {
                    animacionEmpate(imagenOrigen, imagDefense);
                    agregarFichaDerrotada(fichaOrigen);
                    agregarFichaDerrotada(fichaDestino);
                    botones[filaOrigen][columnaOrigen].setIcon(null);
                    botones[filaDestino][columnaDestino].setIcon(null);
                    WinOrLoose(savedpartida);
                    return true;
                }

            }
        }
    }

    private void actualizarImagenes() { //lógica para cambiar la backcard
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                ImageIcon imagen = (ImageIcon) botones[i][j].getIcon();
                if (imagen == null) {
                    continue;
                }

                String descripcion = imagen.getDescription();
                Ficha ficha = obtenerFicha(descripcion);

                if (ficha == null) {
                    continue;
                }

                ImageIcon nuevaImagen;

                if (ficha.getBando().equals(turnoActual)) {
                    nuevaImagen = new ImageIcon(getClass().getResource(ficha.getRutaImagen()));
                } else {
                    nuevaImagen = new ImageIcon(getClass().getResource("/imagenes/backcard.png"));
                }

                nuevaImagen.setDescription(ficha.getRutaImagen());
                botones[i][j].setIcon(nuevaImagen);
            }
        }
    }

    //Este metodo servirá para referenciar al posicion del boton que se ha presionado
    public JButton referenciaBoton(int fila, int columna) {
        JButton referenceBoton = botones[fila][columna];
        return referenceBoton;
    }

    public void conteoFichas() {//Metodo que revisa la cantidad de fichas jugables en el tablero
        //Valores que actualizaran la cantidad
        int UpdateCantH = 0;
        int UpdateCantV = 0;
        //Recorrido para revision
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones.length; j++) {
                ImageIcon infoFicha = (ImageIcon) botones[i][j].getIcon();//Obtengo info de la imagen que contenga la ficha 

                if (infoFicha == null) {
                    continue;//No hay ficha en esta casilla
                }

                Ficha selecFicha = null;

                try {
                    selecFicha = obtenerFicha(infoFicha.getDescription());//Obtencion de la ficha 
                } catch (NullPointerException e) {
                    System.out.println("Womp Womp");
                }

                //Obtencion del bando de la ficha
                String bandoFicha = selecFicha.getBando();

                if (bandoFicha.equals("BUENO")) {
                    System.out.println("Conto uno bueno");
                    UpdateCantH++;
                } else if (bandoFicha.equals("MALO")) {
                    System.out.println("Conto uno malo");
                    UpdateCantV++;
                }
            }
        }

        //Actualiza la cantidad de fichas jugables
        cantHeroes = UpdateCantH - 7;
        cantVillanos = UpdateCantV - 7;

    }

    public void WinOrLoose(JFrame ventana) {
        //Este metodo evalua el win/Lose mediante la cantidad de fichas jugables que quedan en el tablero
        conteoFichas();//Ejecutre el conteo de fichas jugables

        int cantidadHeroes = cantHeroes;
        int cantidadVillanos = cantVillanos;

        //Verificacion de Win/Lose mediante cantidad 
        if (cantidadHeroes == 0 && cantidadVillanos == 0) {
            DatosGlobales.jugadorHeroe.setLog(nombreJugadorHeroe + "HA EMPATADO CON"
                    + " " + nombreJugadorVillian + " POR FALTA DE FICHAS MOVIBLES " + "[" + fecha + "]");
            DatosGlobales.jugadorVillian.setLog(nombreJugadorVillian + "HA EMPATADO CON"
                    + " " + nombreJugadorHeroe + " POR FALTA DE FICHAS MOVIBLES " + "[" + fecha + "]");
            animacionEmpatexFichas();
            bloquear();

        } else if (cantidadHeroes > cantidadVillanos && cantidadVillanos == 0) {
            DatosGlobales.jugadorHeroe.partidaGanada();
            DatosGlobales.jugadorVillian.partidaPerdida();
            DatosGlobales.victoriaHeroes++;
            DatosGlobales.jugadorHeroe.setLog(nombreJugadorHeroe + " VENCEDOR USANDO LOS HEROES"
                    + " DEBIDO A QUE " + nombreJugadorVillian + " SE HA QUEDADO SIN FICHAS MOVIBLES " + "[" + fecha + "]");
            animacionNoFichasV();
            bloquear();

        } else if (cantidadVillanos > cantidadHeroes && cantidadHeroes == 0) {
            DatosGlobales.jugadorVillian.partidaGanada();//Agregado de puntos
            DatosGlobales.jugadorHeroe.partidaPerdida();
            DatosGlobales.jugadorHeroe.setLog(nombreJugadorVillian + " VENCEDOR USANDO LOS HEROES"
                    + " DEBIDO A QUE " + nombreJugadorHeroe + " SE HA QUEDADO SIN FICHAS MOVIBLES " + "[" + fecha + "]");
            DatosGlobales.victoriaVillanos++;
            animacionNoFichasH();
            bloquear();

        }
    }

    //Animaciones de lucha 
    public void animacionLucha(ImageIcon imagHeroe, ImageIcon imagVillano, String nombre) {
        PanelLucha lucha = new PanelLucha(imagHeroe, imagVillano, nombre);
        lucha.setVisible(true);

    }

    public void animacionEmpate(ImageIcon imagAtak, ImageIcon imageDef) {
        PanelEmpate empate = new PanelEmpate(imagAtak, imageDef);
        empate.setVisible(true);
    }

    public void animacionBombaAct(ImageIcon imagBomb, ImageIcon imageInd, String nombre) {
        PanelBombaActivada bombact = new PanelBombaActivada(imagBomb, imageInd, nombre);
        bombact.setVisible(true);
    }

    public void animacionBombaDesct(ImageIcon imagBomb, ImageIcon imageInd, String nombre) {
        PanelBombaDesactivada bombact = new PanelBombaDesactivada(imagBomb, imageInd, nombre);
        bombact.setVisible(true);
    }

    //Animaciones para ganar/perder partidas
    public void animacionWinHeroes() {//mostrar animacion de win heroes
        PanelWin winheroes = new PanelWin(savedpartida);
        winheroes.setVisible(true);
    }

    public void animacionWinVillanos() {//mostrar animacion de win villanos
        PanelLoose winVillanos = new PanelLoose(savedpartida);
        winVillanos.setVisible(true);
    }

    public void animacionNoFichasV() {
        PanelNoFichasV winHeroesF = new PanelNoFichasV(savedpartida);
        winHeroesF.setVisible(true);
    }

    public void animacionNoFichasH() {
        PanelNoFichasH winVillanosF = new PanelNoFichasH(savedpartida);
        winVillanosF.setVisible(true);
    }

    //Caso de empate por no fichas
    public void animacionEmpatexFichas() {
        PanelEmpateNoFichas empatesupremo = new PanelEmpateNoFichas(savedpartida);
        empatesupremo.setVisible(true);
    }

    public String getTurno() {
        return turnoActual;
    }

    public void bloquear() {
        savedpartida.setEnabled(false);
    }

    public void desbloquear() {
        savedpartida.setEnabled(true);
    }

}
