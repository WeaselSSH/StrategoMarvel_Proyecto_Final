package stratego_marvel_proyecto_final;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.util.Random;
import javax.swing.border.LineBorder;
import javax.swing.border.Border;
import java.awt.Color;
import java.util.HashSet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Creacion de clase tablero
public class Tablero {

    Random random = new Random();
    private JButton[][] botones = new JButton[10][10];//Representa la casilla como tal 
    private int fila;
    Border bordeAzul = new LineBorder(Color.BLUE, 3);
    private boolean[][] bordeActivo = new boolean[10][10];//Se crea un arreglo de mismas dimensiones que tablero para ubicar los bordes
    
    //Metodo que brindara informacion si la ficha se encuentra ocupada
    public boolean fichaOcupada(int fila, int columna){
        if(botones[fila][columna].getIcon() == null){
            return false;
        }
        return true;
    }
    
    private boolean fichaDisponible = false; //Variable que dara luz verde para efectuarse el movimiento
    
    //Constructor de tablero, necesita la informacion del arreglo de botones
    public Tablero(JButton[][] botones) {
        this.botones = botones;//Toda la informacion de los botones se guarda en la variable "botones"
    }

    public void inicializar() {
        ocultarBotones();
        asignarTierraYBombas();
        asignarFichasBuenos(DatosGlobales.fichasBuenos());
    }
    
    //Ocultan los botones creados
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
        //Mejor logica que evita la repeticion de una misma ficha
        for (Ficha ficha : fichas) {
            if (ficha.getTipo().equals("NORMAL")) {
                colocarFicha(ficha, new int[]{6, 7, 8, 9});
            }
        }
    }
                   //Ruta de almacenamiento de fichas -----Indicar en que filas se podrian colocar
    //Colocamiento inicial random
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

    //Obtiene la informacion del tipo de borde que tiene la casilla
    public void botonClick(int fila, int columna) {
        Border bordeActual = botones[fila][columna].getBorder();
        
        agregarQuitarBorde(fila, columna);
        //movimientoFicha(fila, columna);
    }

    private void agregarQuitarBorde(int fila, int columna) {

        //Quita los bordes de donde se han hecho click, me imagino,?
        //Verifica que se hayan quitado los bordes? ----De casualidad se encarga de activar desactivar un borde en caso de que ya no haga click
        if (bordeActivo[fila][columna]) {
            quitarTodosLosBordes();
            return;
        }

        quitarTodosLosBordes();

        //Obtiene información si de casualidad hay una ficha ubicada en la ficha donde se acaba de hacer click
        ImageIcon imagen = (ImageIcon) botones[fila][columna].getIcon();
        if (imagen == null) {
            return;
        }
        
        //Obtiene la informacion de ruta de la ficha que se ha seleccionado
        String rutaImagen = imagen.getDescription();

        //Hace mencion de la ubicacion en clase ficha 
        Ficha fichaSeleccionada = obtenerFicha(rutaImagen);

        
        if (fichaSeleccionada != null && fichaSeleccionada.getBando().equals("BUENO")) {
            botones[fila][columna].setBorder(bordeAzul);
            bordeActivo[fila][columna] = true; //Se activa el borde sobre la ficha seleccionada

            //Revisa cada una de las casilas para ver si estan disponibles
            int movimientos[][] = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
            };

            for (int movimiento[] : movimientos) {
                int nuevaFila = fila + movimiento[0];
                int nuevaColumna = columna + movimiento[1];

                //Verifica si la ficha seleccionada esta dentro de los limites del tablero
                //Esta seccion me da informacion de el contenido de la casilla siguiente
                if (posicionValida(nuevaFila, nuevaColumna)) {
                    ImageIcon imagenAdyacente = (ImageIcon) botones[nuevaFila][nuevaColumna].getIcon();
                    if (imagenAdyacente == null) {
                        botones[nuevaFila][nuevaColumna].setBorder(bordeAzul);
                        bordeActivo[nuevaFila][nuevaColumna] = true;
                        fichaDisponible = true;
                        
                        
                        
                        //En caso que no haya nada en imagen adyacente, delimita los bordes activos a la ficha adyacente tambien
                    } else {
                        //Esto investiga en caso de que se active el borde en caso que la ficha adyacente sea una enemiga
                        String rutaIconoAdyacente = imagenAdyacente.getDescription();

                        Ficha fichaAdyacente = obtenerFicha(rutaIconoAdyacente);
                        if (fichaAdyacente != null && !fichaAdyacente.getBando().equals("BUENO")) {
                            botones[nuevaFila][nuevaColumna].setBorder(bordeAzul);
                            bordeActivo[nuevaFila][nuevaColumna] = true;
                            
                            //fichaDisponible=true; //Posible a cambio para indicar que es ataque
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

    //Investiga que tipo de ficha es 
    private Ficha obtenerFicha(String rutaImagen) {
        Ficha[] fichas = DatosGlobales.fichasBuenos();
        for (Ficha ficha : fichas) {
            if (rutaImagen.contains(ficha.getRutaImagen())) {
                return ficha;
            }
        }
        return null;
    }

    //Investiga si la ficha seleccionada está dentro de los limites del tablero
    private boolean posicionValida(int fila, int columna) {
        return fila >= 0 && fila < 10 && columna >= 0 && columna < 10;
    }
    
    /*
    private void movimientoFicha(int fila, int columna){
                JButton fichaMovimiento= referenciaBoton(fila, columna);
        if(fichaMovimiento.getIcon()!= null){
            ImageIcon imagen = (ImageIcon) botones[fila][columna].getIcon();
            String rutaImagen = imagen.getDescription();
            botones[fila+1][columna].setIcon(new ImageIcon(getClass().getResource(rutaImagen)));
            botones[fila][columna].setIcon(null);
        }
    }
*/

    
    //Este metodo servirá para referenciar al posicion del boton que se ha presionado
    public JButton referenciaBoton(int fila, int columna){
        JButton referenceBoton =botones[fila][columna]; 
        return referenceBoton;
    }
    

    
}
