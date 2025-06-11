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
    private int fila;
    Border bordeAzul = new LineBorder(Color.BLUE, 3);
    private boolean[][] bordeActivo = new boolean[10][10];

    public Tablero(JButton[][] botones) {
        this.botones = botones;
    }

    public void inicializar() {
        ocultarBotones();
        asignarTierraYBombas(DatosGlobales.fichas());
        asignarFichasRestantes(DatosGlobales.fichas(), "BUENO");
        asignarFichasRestantes(DatosGlobales.fichas(), "MALO");

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

    private void asignarTierraYBombas(Ficha fichas[]) {
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

        int filasDisponibles[] = bando.equals("BUENO") ? new int[]{8, 9} : new int[]{0, 1};

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
        int filasRango2[] = bando.equals("BUENO") ? new int[]{6, 7} : new int[]{2, 3};
        int filasNormales[] = bando.equals("BUENO") ? new int[]{6, 7, 8, 9} : new int[]{0, 1, 2, 3};

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

    private void colocarFicha(Ficha ficha, int filasPosibles[]) {
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

    public void botonClick(int fila, int columna) {
        Border bordeActual = botones[fila][columna].getBorder();
        agregarQuitarBorde(fila, columna);
    }

    private void agregarQuitarBorde(int fila, int columna) {

        if (bordeActivo[fila][columna]) {
            quitarTodosLosBordes();
            return;
        }

        quitarTodosLosBordes();

        ImageIcon imagen = (ImageIcon) botones[fila][columna].getIcon();
        if (imagen == null) {
            return;
        }

        String rutaImagen = imagen.getDescription();

        Ficha fichaSeleccionada = obtenerFicha(rutaImagen);

        if (fichaSeleccionada != null && fichaSeleccionada.getBando().equals("BUENO")) {
            botones[fila][columna].setBorder(bordeAzul);
            bordeActivo[fila][columna] = true;

            int movimientos[][] = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
            };

            for (int movimiento[] : movimientos) {
                int nuevaFila = fila + movimiento[0];
                int nuevaColumna = columna + movimiento[1];

                if (posicionValida(nuevaFila, nuevaColumna)) {
                    ImageIcon imagenAdyacente = (ImageIcon) botones[nuevaFila][nuevaColumna].getIcon();
                    if (imagenAdyacente == null) {
                        botones[nuevaFila][nuevaColumna].setBorder(bordeAzul);
                        bordeActivo[nuevaFila][nuevaColumna] = true;
                    } else {
                        String rutaIconoAdyacente = imagenAdyacente.getDescription();

                        Ficha fichaAdyacente = obtenerFicha(rutaIconoAdyacente);
                        if (fichaAdyacente != null && !fichaAdyacente.getBando().equals("BUENO")) {
                            botones[nuevaFila][nuevaColumna].setBorder(bordeAzul);
                            bordeActivo[nuevaFila][nuevaColumna] = true;
                        }
                    }
                }
            }
        }
    }

    private void quitarTodosLosBordes() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                botones[i][j].setBorder(null);
                bordeActivo[i][j] = false;
            }
        }
    }

}
