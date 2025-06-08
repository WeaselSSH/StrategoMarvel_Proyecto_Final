package stratego_marvel_proyecto_final;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.util.Random;

public class Tablero {

    Random random = new Random();
    private JButton[][] botones = new JButton[10][10];
    private int fila;

    public Tablero(JButton[][] botones) {
        this.botones = botones;
    }

    public void inicializar() {
        ocultarBotones();
        asignarTierraYBombas();
        asignarFichasBuenos(DatosGlobales.obtenerFichasBuenos());
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

}
