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

    private boolean fichaDisponible = false; //Variable que dara luz verde para efectuarse el movimiento
    

    public Tablero(JButton[][] botones) {
        this.botones = botones;
    }
    
    
    
    //Metodo que brindara informacion si la ficha se encuentra ocupada
    public boolean fichaOcupada(int fila, int columna){
        if(botones[fila][columna].getIcon() == null){
            return false;
        }
        return true;
    }

    public void inicializar() {
        ocultarBotones();
        asignarTierraYBombas();
        asignarFichasRestantes(DatosGlobales.fichas(), "BUENO");
        asignarFichasRestantes(DatosGlobales.fichas(), "MALO");
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
        agregarQuitarBorde(fila, columna);
        
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
        Ficha fichaSeleccionada = obtenerFicha(rutaImagen, rutaImagen);
        if (fichaSeleccionada == null) {
            return;
        }

        Border borde = fichaSeleccionada.getBando().equals("BUENO") ? bordeAzul : bordeRojo;
        botones[fil][col].setBorder(borde);
        bordeActivo[fil][col] = true;
        
        
        
        if(fichaSeleccionada.getBando().equals("BUENO")){
            //ImageIcon backCard = new ImageIcon(getClass().getResource("/imagenes/backcard.png"));
            botones[fil][col].setEnabled(true);
        }else if(fichaSeleccionada.getBando().equals("MALO")){
            botones[fil][col].setEnabled(true);
        }//Esto activa la ficha independientemente de cual sea el caso. Con tal sea abarcada la zona por el rectangulo de seleccion

        

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

                    ImageIcon icono = (ImageIcon) botones[nuevaFila][nuevaCol].getIcon();

                    if (icono != null) {
                        Ficha fichaEncontrada = obtenerFicha(icono.getDescription(), icono.getDescription());
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

                ImageIcon icono = (ImageIcon) botones[nuevaFila][nuevaCol].getIcon();

                if (icono != null) {
                    Ficha fichaEncontrada = obtenerFicha(icono.getDescription(), icono.getDescription());
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

    public Ficha obtenerFicha(String rutaImagen, String revez) {
        Ficha[] fichas = DatosGlobales.fichas();
        for (Ficha ficha : fichas) {
            if (rutaImagen.contains(ficha.getRutaImagen()) || rutaImagen.contains(ficha.getBackCard())) {
                return ficha;
            }
        }
        return null;
    }
    
    public Ficha obtenerFicha2(String rutaRevez){ //Metodo para obtener la ficha a base de la imagen trasera
          Ficha[] fichas = DatosGlobales.fichas();
        for (Ficha ficha2 : fichas) {
            if (rutaRevez.contains(ficha2.getBackCard())) {
                return ficha2;
            }
        }
        return null;
    }

    private boolean posicionValida(int fila, int columna) {
        return fila >= 0 && fila < 10 && columna >= 0 && columna < 10;
    }

     
    //Este metodo servirá para referenciar al posicion del boton que se ha presionado
    public JButton referenciaBoton(int fila, int columna){
        JButton referenceBoton =botones[fila][columna]; 
        return referenceBoton;
    }
    
    
    public void visibilidadTurnos(boolean turnos){
        

        //ImageIcon backCard = new ImageIcon(getClass().getResource("/imagenes/backcard.png"));
          for(int i=0; i<botones.length; i++){//Evaluacion de fichas de bando villano para ocultar
                for(int j=0; j<botones.length; j++){
                    
                    ImageIcon infoFicha= (ImageIcon) botones[i][j].getIcon();//Obtengo info de la imagen que contenga la ficha 
                    //JButton fichaactual= botones[i][j];
                   //Ficha selectedFicha= (Ficha) fichaactual.getClientProperty("ficha");
                    if(infoFicha==null){
                        continue;//No hay ficha en esta casilla
                    }
                    
                    Ficha selecFicha = null;
                    Ficha selecFichaBack=null;
                    
                    try{
                        selecFicha = obtenerFicha(infoFicha.getDescription(), infoFicha.getDescription());
                       // selecFichaBack=obtenerFicha2(infoFicha.getDescription());
                        System.out.println("Se obtuvo front card");
                    }catch(NullPointerException e){
                        selecFicha = obtenerFicha2(infoFicha.getDescription());//Intenta con la ruta del reverso
                        System.out.println("Se obtuvo backcard");
                    }
                    
                    if(selecFicha==null){
                        botones[i][j].putClientProperty("ficha", null);
                        botones[i][j].putClientProperty("bando", null);
                        botones[i][j].putClientProperty("rango", null);
                        botones[i][j].putClientProperty("fila",i);
                        botones[i][j].putClientProperty("col", j);

                        continue;//No se pudo identificar la ficha
                    }
                            
                    
                    
                    
                    //Obtencion de informacion
                    String bandoFicha=selecFicha.getBando();
                    String rutaFrontal=selecFicha.getRutaImagen();
                    String rutaTrasera= selecFicha.getBackCard();
                    int rangoFicha = selecFicha.getRango();
                    
                    ImageIcon frontCard= new ImageIcon(getClass().getResource(rutaFrontal));
                    ImageIcon BackCard= new ImageIcon(getClass().getResource(rutaTrasera));
                        
                    //Guardado directo en boton
                    botones[i][j].putClientProperty("ficha", selecFicha);
                    botones[i][j].putClientProperty("bando", bandoFicha);
                    botones[i][j].putClientProperty("rango", rangoFicha);
                    botones[i][j].putClientProperty("fila",i);
                    botones[i][j].putClientProperty("col", j);
                    
                    //Logica de visibilidad segun turnos
                    if(turnos){
                        if(bandoFicha.equals("BUENO")){
                            botones[i][j].setIcon(frontCard);
                        }else if(bandoFicha.equals("MALO")){
                            botones[i][j].setIcon(BackCard);
                        }
                    }else{
                        if(bandoFicha.equals("MALO")){
                            botones[i][j].setIcon(frontCard);
                        }else if(bandoFicha.equals("BUENO")){
                            botones[i][j].setIcon(BackCard);
                        }
                    }
                    
                    
                    
                        //try{
                        /*
                            String rutFicha = infoFicha.getDescription();//Obtengo la ruta
                            try{
                                selecFicha = obtenerFicha(rutFicha); //EN base a ruta de personaje
                            }catch(NullPointerException e){
                                selecFicha= obtenerFicha2(rutFicha); //En base a ruta de imagen trasera
                                continue;
                            }
                            //obtengo informacion de la ficha en base a la ruta

                            
                            
                            /*
                            
                            String bandFicha= selecFicha.getBando();//AQUIIIIIIIIIIIIIIIII
                            
                            String RealImage=selecFicha.getRutaImagen();
                            System.out.println(RealImage);
                            frontCard= new ImageIcon(getClass().getResource(RealImage));
                            String backImage=selecFicha.getBackCard();
                            System.out.println(backImage);
                            BackCard= new ImageIcon(getClass().getResource(backImage));
                            
                            bandoFicha=bandFicha;
                            rutaFicha=rutFicha;
                        //}catch(NullPointerException e){//caso que sea el back de la ficha
                            if(turnos==true){
                                if(bandoFicha.equals("BUENO")){
                                    botones[i][j].setIcon(frontCard);
                                    
                                }else if(bandoFicha.equals("MALO")){
                                    botones[i][j].setIcon(BackCard);
                                }
                                
                                
                                /*
                                if(botones[i][j].getClientProperty("BANDO").equals("BUENO")){
                                    botones[i][j].setIcon(new ImageIcon(getClass().getResource("rutaReal")));
                                }else if(botones[i][j].getClientProperty("BANDO").equals("MALO")){
                                   botones[i][j].setIcon(backCard); 
                                }
                                */
                            /*
                            }else if(turnos==false){
                                if(bandoFicha.equals("MALO")){
                                    botones[i][j].setIcon(frontCard);
                                }else if(bandoFicha.equals("BUENO")){
                                    botones[i][j].setIcon(BackCard);
                                }
                                /*
                                 if(botones[i][j].getClientProperty("BANDO").equals("MALO")){
                                     botones[i][j].setIcon(new ImageIcon(getClass().getResource("rutaReal")));
                                 }else if(botones[i][j].getClientProperty("BANDO").equals("BUENO")){
                                     botones[i][j].setIcon(backCard); 
                                 }
                                */
                            
                        
                        
                        
                        /*
                        if(bandoFicha.equals(null)){
                            boolean esTurnoPropio= (turnos && bandoFicha.equals("BUENO")) || (!turnos && bandoFicha.equals("MALO"));
                            if(esTurnoPropio){
                                botones[i][j].setIcon(new ImageIcon(getClass().getResource("rutaReal")));
                            }else{
                                 botones[i][j].setIcon(backCard);
                            }
                        }else{
                            botones[i][j].putClientProperty("BANDO", bandoFicha);
                            botones[i][j].putClientProperty("rutaReal", rutaFicha);
                        }
                        */
                        
                        /*
                        boolean esTurnoPropio= (turnos && bandoFicha.equals("BUENO")) || (!turnos && bandoFicha.equals("MALO"));
                        
                        if(turnos==true){
                            if(botones[i][j].getClientProperty("BANDO").equals("BUENO")){
                                botones[i][j].setIcon(new ImageIcon(getClass().getResource("rutaReal")));
                            }else if(botones[i][j].getClientProperty("BANDO").equals("MALO")){
                               botones[i][j].setIcon(backCard); 
                            }
                            
                        }else if(turnos==false){
                             if(botones[i][j].getClientProperty("BANDO").equals("MALO")){
                                 botones[i][j].setIcon(new ImageIcon(getClass().getResource("rutaReal")));
                             }else if(botones[i][j].getClientProperty("BANDO").equals("BUENO")){
                                 botones[i][j].setIcon(backCard); 
                             }
                        }
                        */
                        
                        /*
                        if(bandoFicha.equals("MALO")){
                            //Se establece el icono back de la carta
                            botones[i][j].setIcon(backCard);
                        }

                        if(bandoFicha.equals("BUENO")){
                            botones[i][j].setIcon(new ImageIcon(getClass().getResource(rutaFicha)));
                        }
*/                  /*
                    }catch(NullPointerException e){
                        if (infoFicha == null) {
                            System.out.println("No se detecto info info en esta casilla, casilla vacia");
                            
                        }else{
                            System.out.println("Si detecto algo y es problema interno");
                        }
                        
                        if(verificacionf==false){
                            System.out.println("No se creo el objeto de ficha correctamente");
                        }else{
                            System.out.println("Si creo el objeto de ficha correctamente");
                        }
                        
                        if(verificacionb=false){
                            System.out.println("No se determino el banod correctamente");
                        }else{
                            System.out.println("Se determino el bando correctamente");
                        }
                        
                    }
                    */
                }//fin for1
            }//fin for2
        
        
        
        
        
       /*
        if(turnos==true){
            //Desarrollo para mostrar y manipular fichas de heroes
            for(int i=0; i<botones.length; i++){//Evaluacion de fichas de bando villano para ocultar
                for(int j=0; j<botones.length; j++){
                    
                    
                    
                    
                    ImageIcon infoFicha= (ImageIcon) botones[i][j].getIcon();//Obtengo info de la imagen que contenga la ficha 
                    
                    
                    
                    
                    
                       try{
                        
                        if (infoFicha == null) {
                        botones[i][j].setIcon(null);
                        botones[i][j].putClientProperty("bando", null);//Propiedad a boton de bando
                        botones[i][j].putClientProperty("rutaReal", null);
                        }
                        
                        
                        
                        String rutaFicha = infoFicha.getDescription();//Obtengo la ruta
                        Ficha selecFicha = obtenerFicha(rutaFicha);//obtengo informacion de la ficha en base a la ruta
                        String bandoFicha= selecFicha.getBando();
                        
                        
                        
                        botones[i][j].putClientProperty("BANDO", bandoFicha);
                        botones[i][j].putClientProperty("rutaReal", rutaFicha);
                        
                        boolean esTurnoPropio= (turnos && bandoFicha.equals("BUENO"));
                        
                        if(esTurnoPropio){
                            botones[i][j].setIcon(new ImageIcon(getClass().getResource("rutaReal")));
                        }else{
                             botones[i][j].setIcon(backCard);
                        }
                        
                        /*
                        if(bandoFicha.equals("MALO")){
                            //Se establece el icono back de la carta
                            botones[i][j].setIcon(backCard);
                        }

                        if(bandoFicha.equals("BUENO")){
                            botones[i][j].setIcon(new ImageIcon(getClass().getResource(rutaFicha)));
                        }

                          
                        
                    }catch(NullPointerException e){
                        System.out.println("Casilla Vacia");
                    };  
                }
            }

            
        }else if(turnos==false){
            //Desarrollo para mostrar y manipular fichas de villanos
               for(int i=0; i<botones.length; i++){
                for(int j=0; j<botones.length; j++){
                    ImageIcon infoFicha= (ImageIcon) botones[i][j].getIcon();//Obtengo info de la imagen que contenga la ficha 
                    
                    try{
                        
                        if (infoFicha == null) {
                            botones[i][j].setIcon(null);
                            botones[i][j].putClientProperty("bando", null);//Propiedad a boton de bando
                            botones[i][j].putClientProperty("rutaReal", null);
                        }
                        
                        //String OriginalRute = (String) botones[i][j].getClientProperty("rutaReal");
                        //botones[i][j].setIcon(new ImageIcon(getClass().getResource(OriginalRute)));


                        String rutaFicha = infoFicha.getDescription();//Obtengo la ruta
                        Ficha selecFicha = obtenerFicha(rutaFicha);//obtengo informacion de la ficha en base a la ruta
                        String bandoFicha= selecFicha.getBando();
                        
                   
                        
                        botones[i][j].putClientProperty("BANDO", bandoFicha);
                        botones[i][j].putClientProperty("rutaReal", rutaFicha);

                            boolean esTurnoPropio= (turnos && bandoFicha.equals("MALO")) || (!turnos && bandoFicha.equals("BUENO"));

                            if(esTurnoPropio){
                               botones[i][j].setIcon(new ImageIcon(getClass().getResource("rutaReal")));
                            }else{
                                 botones[i][j].setIcon(backCard);
                        }
                    }catch(NullPointerException e){
                        System.out.println("Casilla Vacia");
                    };
                }

            }
        }
      */
        
        
    }
    
    

}
