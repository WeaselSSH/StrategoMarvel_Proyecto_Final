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
        asignarTierraYBombas();
        asignarFichasBuenos(DatosGlobales.fichasBuenos());
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

    private void asignarTierraYBombas() {
        int filaBandera = 9;
        int columnaBandera = random.nextInt(8) + 1;

        // Colocar bandera (tierra)
        botones[filaBandera][columnaBandera].setIcon(
                new ImageIcon(getClass().getResource("/imagenes/heroEarth.png"))
        );

        // Colocar bombas alrededor
        botones[filaBandera][columnaBandera + 1].setIcon(
                new ImageIcon(getClass().getResource("/imagenes/novaBlast.png"))
        );
        botones[filaBandera][columnaBandera - 1].setIcon(
                new ImageIcon(getClass().getResource("/imagenes/novaBlast.png"))
        );
        botones[filaBandera - 1][columnaBandera].setIcon(
                new ImageIcon(getClass().getResource("/imagenes/novaBlast.png"))
        );

        // Colocar 3 bombas restantes en filas 8 y 9
        int fichasRestantes = 3;
        int[] filasPermitidas = {8, 9};

        for (int i = 0; i < fichasRestantes;) {
            int fila = filasPermitidas[random.nextInt(filasPermitidas.length)];
            int columna = random.nextInt(10);

            if (botones[fila][columna].getIcon() == null) {
                botones[fila][columna].setIcon(
                        new ImageIcon(getClass().getResource("/imagenes/novaBlast.png"))
                );
                i++;
            }
        }
    }

    private void asignarFichasBuenos(Ficha fichas[]) {

        //se colocan las rango 2
        for (Ficha ficha : fichas) {
            if (ficha.getTipo().equals("RANGO_2")) {
                colocarFicha(ficha, new int[]{6, 7});
            }
        }

        //luego todas las demas
        for (Ficha ficha : fichas) {
            if (ficha.getTipo().equals("NORMAL")) {
                colocarFicha(ficha, new int[]{6, 7, 8, 9});
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

    private Ficha obtenerFicha(String rutaImagen) {
        Ficha[] fichas = DatosGlobales.fichasBuenos();
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
    
    
}
