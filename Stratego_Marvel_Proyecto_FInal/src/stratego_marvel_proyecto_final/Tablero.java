package stratego_marvel_proyecto_final;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.util.Random;
import javax.swing.border.LineBorder;
import javax.swing.border.Border;
import java.awt.Color;

public class Tablero {

    Random random = new Random();
    private JButton[][] botones = new JButton[10][10];
    Border bordeAzul = new LineBorder(Color.BLUE, 3);
    Border bordeRojo = new LineBorder(Color.RED, 3);
    private final boolean[][] bordeActivo = new boolean[10][10];
    private final int[][] casillasLago = {
        {4, 2}, {4, 3}, {5, 2}, {5, 3},
        {4, 6}, {4, 7}, {5, 6}, {5, 7}
    };

    //inicializado en bueno porque empiezan los buenos
    private String turnoActual = "BUENO";

    //inicializadas en ese valor para que el programa detecte como si fuera vacío la selección
    private int filaSeleccionada = -1;
    private int columnaSeleccionada = -1;
    private Ficha fichaSeleccionada = null;

    public Tablero(JButton[][] botones) {
        this.botones = botones;
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

                botones[fila][columna].setIcon(
                        new ImageIcon(getClass().getResource(ficha.getRutaImagen())));

                asignarBombas(columna, fila, ficha.getBando());
                asignarBombasRestantes(ficha.getBando());
            }
        }
    }

    private void asignarBombas(int columna, int fila, String bando) {
        String rutaBomba = bando.equals("BUENO")
                ? "/imagenes/novaBlast.png"
                : "/imagenes/pumpkinBomb.png";

        botones[fila][columna - 1].setIcon(
                new ImageIcon(getClass().getResource(rutaBomba)));
        botones[fila][columna + 1].setIcon(
                new ImageIcon(getClass().getResource(rutaBomba)));

        if (bando.equalsIgnoreCase("BUENO")) {
            botones[fila - 1][columna].setIcon(
                    new ImageIcon(getClass().getResource(rutaBomba)));
        } else {
            botones[fila + 1][columna].setIcon(
                    new ImageIcon(getClass().getResource(rutaBomba)));
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
                botones[fila][columna].setIcon(new ImageIcon(getClass().getResource(rutaBomba)));
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
                botones[fila][columna].setIcon(
                        new ImageIcon(getClass().getResource(ficha.getRutaImagen()))
                );
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
        ImageIcon icono = (ImageIcon) botones[fila][columna].getIcon();

        if (fichaSeleccionada == null) {
            if (icono != null) {
                Ficha ficha = obtenerFicha(icono.getDescription());
                if (ficha != null && ficha.getBando().equals(turnoActual) && !ficha.getTipo().equals("TIERRA") && !ficha.getTipo().equals("BOMBA")) {
                    fichaSeleccionada = ficha;
                    filaSeleccionada = fila;
                    columnaSeleccionada = columna;
                    agregarQuitarBorde(fila, columna);
                }
            }
        } else {
            if (fila == filaSeleccionada && columna == columnaSeleccionada) {
                fichaSeleccionada = null;
                filaSeleccionada = -1;
                columnaSeleccionada = -1;
                quitarBordes();
                return;
            }
            
            if (bordeActivo[fila][columna]) {
                boolean movido = moverFicha(filaSeleccionada, columnaSeleccionada, fila, columna);
                if (movido) {
                    turnoActual = turnoActual.equals("BUENO") ? "MALO" : "BUENO";
                    System.out.println("Turno cambiado a: " + turnoActual);
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

                    ImageIcon icono = (ImageIcon) botones[nuevaFila][nuevaCol].getIcon();

                    if (icono != null) {
                        Ficha fichaEncontrada = obtenerFicha(icono.getDescription());
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

                ImageIcon icono = (ImageIcon) botones[nuevaFila][nuevaCol].getIcon();

                if (icono != null) {
                    Ficha fichaEncontrada = obtenerFicha(icono.getDescription());
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
            if (rutaImagen.contains(ficha.getRutaImagen())) {
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
        } else {
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

}
