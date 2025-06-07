package stratego_marvel_proyecto_final;

import javax.swing.JButton;

public class Tablero {

    private JButton[][] botones = new JButton[10][10];

    public Tablero(JButton[][] botones) {
        this.botones = botones;
    }

    public void inicializar() {
        ocultarBotones();
    }

    public void ocultarBotones() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                botones[i][j].setVisible(false);
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
}
