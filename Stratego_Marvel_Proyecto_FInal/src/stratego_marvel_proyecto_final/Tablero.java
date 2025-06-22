package stratego_marvel_proyecto_final;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.util.Random;
import javax.swing.border.LineBorder;
import javax.swing.border.Border;
import java.awt.Color;
import javax.swing.JLabel;

public class Tablero {

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

    //inicializado en bueno porque empiezan los buenos
    private String turnoActual = "BUENO";

    private int filaSeleccionada;
    private int columnaSeleccionada;
    private Ficha fichaSeleccionada;

    public Tablero(JButton[][] botones, JLabel turno) {
        this.botones = botones;
        this.lblTurno = turno;
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
                ? "/imagenes/novaBlast.png"
                : "/imagenes/pumpkinBomb.png";

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
                ? "/imagenes/novaBlast.png"
                : "/imagenes/pumpkinBomb.png";

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

    private void agregarQuitarBorde(int fil, int col) {
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

    private Ficha obtenerFicha(String rutaImagen) {
        Ficha[] fichas = DatosGlobales.fichas();
        for (Ficha ficha : fichas) {
            if (rutaImagen.equals(ficha.getRutaImagen())) {
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

    private boolean moverFicha(int filaOrigen, int columnaOrigen, int filaDestino, int columnaDestino) {

        //se obtienen las imagenes
        ImageIcon imagenOrigen = (ImageIcon) botones[filaOrigen][columnaOrigen].getIcon();
        ImageIcon imagenDestino = (ImageIcon) botones[filaDestino][columnaDestino].getIcon();

        if (imagenOrigen == null) {
            return false;
        }

        Ficha fichaOrigen = obtenerFicha(imagenOrigen.getDescription());
        Ficha fichaDestino = (imagenDestino != null) ? obtenerFicha(imagenDestino.getDescription()) : null;

        if (fichaDestino == null) {
            botones[filaDestino][columnaDestino].setIcon(imagenOrigen);
            botones[filaOrigen][columnaOrigen].setIcon(null);
            return true;
        } else { //logica de combate
            if (fichaDestino.getTipo().equals("BOMBA")) {
                if (fichaOrigen.getRango() == 3) {
                    botones[filaDestino][columnaDestino].setIcon(imagenOrigen);
                    botones[filaOrigen][columnaOrigen].setIcon(null);
                    return true;
                } else {
                    botones[filaOrigen][columnaOrigen].setIcon(null);
                    botones[filaDestino][columnaDestino].setIcon(null);
                    return true;
                }
            } else {
                int rangoOrigen = fichaOrigen.getRango();
                int rangoDestino = fichaDestino.getRango();

                if (rangoOrigen == 1 && rangoDestino == 10) {
                    botones[filaDestino][columnaDestino].setIcon(imagenOrigen);
                    botones[filaOrigen][columnaOrigen].setIcon(null);
                    return true;
                }

                if (rangoOrigen == 1 && rangoDestino == 10) {
                    botones[filaDestino][columnaDestino].setIcon(imagenOrigen);
                    botones[filaOrigen][columnaOrigen].setIcon(null);
                    return true;
                }

                if (rangoOrigen > rangoDestino) {
                    botones[filaDestino][columnaDestino].setIcon(imagenOrigen);
                    botones[filaOrigen][columnaOrigen].setIcon(null);
                    return true;
                } else if (rangoOrigen < rangoDestino) {
                    botones[filaOrigen][columnaOrigen].setIcon(null);
                    return true;
                } else {
                    botones[filaOrigen][columnaOrigen].setIcon(null);
                    botones[filaDestino][columnaDestino].setIcon(null);
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

}
