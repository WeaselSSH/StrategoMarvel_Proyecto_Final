package stratego_marvel_proyecto_final;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.util.Random;
import javax.swing.JOptionPane;

public class FrmPartida extends javax.swing.JFrame {

    private Ficha fichasBuenos[] = DatosGlobales.fichas();
    private JButton botones[][] = new JButton[10][10];
    private Tablero tablero;
    Random random = new Random();
    
    private JButton casillaInicio;
    //Coordenadas para efectuar el movimiento
    private int filaInicio;
    private int columnaInicio;
    private int filaFinal;
    private int columnaFinal;
    private int filaInicialProvisional;
    private int columnaProvisional;

    private int filaFinalComparativa;
    private int filaFinalComparativa2;
    private int revisionColumna1;
    private int revisionColumna2;
    
    
    //------------------
    private JButton casillaFinal;
    
    
    //JButton que servirá para guardar registro de la casilla seleccionada referente a movimiento
    JButton casillaSeleccionada = null;
    Ficha extractor;
    
    //Variable de turnos
    boolean estadoTurno=true; //true= heroes ; false=villanos
    boolean gameStatus=true;

    public FrmPartida() {
        initComponents();
        crearBotones();
        tablero = new Tablero(botones);
        tablero.inicializar();
        tablero.visibilidadTurnos(estadoTurno);
    }

    private void crearBotones() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                botones[i][j] = new javax.swing.JButton();
                int fila = i;
                int columna = j;

                //Listener que verifica si se le ha hecho click al boton
                botones[i][j].addActionListener(e -> {
                    tablero.botonClick(fila, columna);
                    //tablero.referenciaBoton(fila, columna);
                    
                });
                
                
                
                //Listener de movimiento
                botones[i][j].addActionListener(e ->{
                    if(casillaSeleccionada == null){
                        //Caso en el que no haya ninguna ficha seleccionada con anterioridad
                        if(tablero.fichaOcupada(fila,columna)){
                            System.out.println("Obtiene info de click 1");
                            //Indica que si hay una casilla seleccionada
                            casillaSeleccionada = botones[fila][columna];
                            
                            //Posicion de la ficha seleccionada 
                            filaInicio= (int) casillaSeleccionada.getClientProperty("fila");
                            columnaInicio= (int) casillaSeleccionada.getClientProperty("col");
                            filaInicialProvisional=(int) casillaSeleccionada.getClientProperty("fila");
                            columnaProvisional=(int) casillaSeleccionada.getClientProperty("col");
                            filaFinalComparativa=filaInicialProvisional-1;//Mueve hacia delante
                            filaFinalComparativa2=filaInicialProvisional+1;//Mueve hacia atras
                            revisionColumna1=columnaProvisional+1;
                            revisionColumna2=columnaProvisional-1;
                            
                        
                            
                            
                        }else{
                            //No se recoge nada
                        }
                    }else{
                        //Caso cuando ya hay una ficha previamente seleccionada
                        
                        //Comprobantes de rango de ambas fichas en comparacion
                        String rangoFichaSeleccionada="";
                        String rangoFichaOcupada="";
                        
                        //Obtener informacion de ficha ya seleccionada
                        ImageIcon tipofichaSelecc= (ImageIcon) casillaSeleccionada.getIcon();
                        Ficha fichaselecc = null;                      
                        if (tipofichaSelecc == null) {
                            System.out.println("No hay ficha seleccionada");
                            return;
                        }else{
                            fichaselecc = (Ficha) casillaSeleccionada.getClientProperty("ficha"); //obtengo info de ficha
                        }
        
                        
                        int rangoFichaSelecc=0;//Rango de ficha seleccionada para mover
                        String rutaIconoFichaSelecc = tipofichaSelecc.getDescription();
                        System.out.println(rutaIconoFichaSelecc);
                        
                        Ficha selected = tablero.obtenerFicha(rutaIconoFichaSelecc, rutaIconoFichaSelecc);
                        if(fichaselecc!= null){
                            rangoFichaSelecc= (int) casillaSeleccionada.getClientProperty("rango");
                        }else{
                            System.out.println("No hay ficha seleccionada");
                        }
                        

                        


                        
                        
                        
                        //Obtencion del rango de la ficha ya seleccionado

                        System.out.println("Se obtuvo el rango");
                        System.out.println(rangoFichaSelecc);
                        
                        if(rangoFichaSelecc ==1 || rangoFichaSelecc == 3 || rangoFichaSelecc == 4 ||
                                rangoFichaSelecc == 5 || rangoFichaSelecc == 6 || rangoFichaSelecc == 7 || rangoFichaSelecc == 8 || rangoFichaSelecc == 9 || rangoFichaSelecc ==10){
                            
                            
                            System.out.println("Entra al comparador de rango");
                            //Compara si se esta moviento solamente una casilla

                            int filaComp=fila;
                            int columnaComp=columna;

                            //Desarrollo de comprobante de movimiento a base de valor absoluto
                            int diferenciaFila =Math.abs(filaComp -filaInicialProvisional);
                            int diferenciaColumna = Math.abs(columnaComp - columnaProvisional);
                            
                            
                            //Verificador de que casilla se encuentra para establecer que no se pase
                            if((diferenciaFila+diferenciaColumna)!=1){
                                System.out.println("No se ejecuta el movimiento, se sale del rango destinado");
                                casillaSeleccionada= null;
                                filaInicialProvisional=0;
                                filaFinalComparativa=0;
                                filaFinalComparativa2=0;
                                rangoFichaSelecc=0;
                                columnaProvisional=0;
                                revisionColumna1=0;
                                revisionColumna2=0;

                            }else{
                                //Comprobar si hay una ficha en la casilla hacia donde se va a mover
                                if(tablero.fichaOcupada(fila, columna)){//Caso en que si haya una ficha 
                                    System.out.println("Entra a campo de ficha Ocupada");
                                    //Proceso para conocer el bando de la ficha seleccionada
                                    ImageIcon tipofichaAMover = (ImageIcon) botones[fila][columna].getIcon();
                                    String rutaIconoFichaAMover = tipofichaAMover.getDescription();


                                    //Proceso para conocer el bando de la ficha que ocupa el lugar de la casilla a donde se va a mover
                                    for(Ficha infoFicha: DatosGlobales.fichas()){
                                   
                                        if (rutaIconoFichaAMover.contains(infoFicha.getRutaImagen())) {
                                            rangoFichaSeleccionada=infoFicha.getBando();
                                        }
                                    }

                                    //Mismo proceso pero para ficha ya seleccionada
                                    for(Ficha infoFicha: DatosGlobales.fichas()){
                                  
                                         if (rutaIconoFichaSelecc.contains(infoFicha.getRutaImagen())) {
                                            rangoFichaOcupada=infoFicha.getBando();
                                        }
                                        
                                        
                                    }
                                    
                                    System.out.println("He aqui los rangos de las fichas: ");
                                    System.out.println(rangoFichaSeleccionada);
                                    System.out.println(rangoFichaOcupada);

                                    //Comprueba caso en que sean del mismo bando -No se efectua movimiento
                                    if(rangoFichaSeleccionada.equals(rangoFichaOcupada)){
                                        System.out.println("No se efectua movimiento");
                                        rangoFichaSeleccionada="";
                                        rangoFichaOcupada=""; //Reseteo del registro de rangos
                                        casillaSeleccionada= null;
                                        rangoFichaSelecc=0;
                                        filaInicialProvisional=0;
                                        filaFinalComparativa=0;
                                        filaFinalComparativa2=0;
                                        rangoFichaSelecc=0;
                                        columnaProvisional=0;
                                        
                                    }else{
                                        System.out.println("Entra a proceso de combate");
                                        JButton fichaAtacante=casillaSeleccionada;
                                        JButton fichaDefensora = botones[fila][columna];
                                        
                                        
                                        //Proceso para obtener rango de ficha de defensa
                                        ImageIcon ImageDefensa= (ImageIcon) fichaDefensora.getIcon();
                        
                                        if (ImageDefensa == null) {
                                        return;
                                        }
                                        String rutaDefensa = ImageDefensa.getDescription();
                                        Ficha infoDefensa= tablero.obtenerFicha(rutaDefensa, rutaDefensa);
                                        
                                        int rankDefensa= infoDefensa.getRango();
                                        int rankAtaque=rangoFichaSelecc;
                                        
                                        //Verificacion de los distintos tipos de casos y excepciones de fichas
                                        if(rankAtaque==3 && rankDefensa==0){ //Casos en donde ficha de rank 3 desactiva una bomba
                                            System.out.println("¡Se ha desactivado una bomba!");
                                            fichaDefensora.setIcon(null);
                                            filaFinal= fila;
                                            columnaFinal=columna;

                                            ImageIcon imagenInicial = (ImageIcon) botones[filaInicio][columnaInicio].getIcon();
                                            //String rutaImagenInicial = imagenInicial.getDescription();
                                            botones[filaFinal][columnaFinal].setIcon(imagenInicial);
                                            botones[filaInicio][columnaInicio].setIcon(null);

                                            //Limpia la casilla seleccionada
                                            filaInicio=0;
                                            columnaInicio=0;
                                            filaFinal=0;
                                            columnaFinal=0;
                                            casillaSeleccionada=null;
                                            rangoFichaSelecc=0;

                                            filaInicialProvisional=0;
                                            filaFinalComparativa=0;
                                            filaFinalComparativa2=0;
                                            rangoFichaSelecc=0;
                                            columnaProvisional=0;
                                            
                                            //Actualizacion de turno a la hora de hacer movimiento
                                            if(estadoTurno==true){
                                                estadoTurno=false;
                                            }else{
                                                estadoTurno=true;
                                            }
                                            System.out.println("Estado de turno: "+estadoTurno);
                                            tablero.visibilidadTurnos(estadoTurno);
                                            tablero.WinOrLoose(this);

                                            
                                        }else if(rankDefensa==0){
                                            System.out.println("¡Se ha activado una bomba!");
                                            fichaAtacante.setIcon(null);//Elimina a ficha de ataque
                                            
                                            //Limpieza de datos
                                            filaInicio=0;
                                            columnaInicio=0;
                                            filaFinal=0;
                                            columnaFinal=0;
                                            casillaSeleccionada=null;
                                            rangoFichaSelecc=0;

                                            filaInicialProvisional=0;
                                            filaFinalComparativa=0;
                                            filaFinalComparativa2=0;
                                            rangoFichaSelecc=0;
                                            columnaProvisional=0;
                                            
                                            //Actualizacion de turno a la hora de hacer movimiento
                                            if(estadoTurno==true){
                                                estadoTurno=false;
                                            }else{
                                                estadoTurno=true;
                                            }
                                            System.out.println("Estado de turno: "+estadoTurno);
                                            tablero.visibilidadTurnos(estadoTurno);
                                            tablero.WinOrLoose(this);
                                            
                                        }else if(rankAtaque==10 && rankDefensa==1){
                                           System.out.println("Una ficha de rango 1 derrotó al gigante de 10 :0");
                                           fichaAtacante.setIcon(null);//Elimina a ficha de ataque 
                                            //Limpieza de datos
                                            filaInicio=0;
                                            columnaInicio=0;
                                            filaFinal=0;
                                            columnaFinal=0;
                                            casillaSeleccionada=null;
                                            rangoFichaSelecc=0;

                                            filaInicialProvisional=0;
                                            filaFinalComparativa=0;
                                            filaFinalComparativa2=0;
                                            rangoFichaSelecc=0;
                                            columnaProvisional=0;
                                            
                                            //Actualizacion de turno a la hora de hacer movimiento
                                            if(estadoTurno==true){
                                                estadoTurno=false;
                                            }else{
                                                estadoTurno=true;
                                            }
                                            System.out.println("Estado de turno: "+estadoTurno);
                                            tablero.visibilidadTurnos(estadoTurno);
                                            tablero.WinOrLoose(this);
                                            
                                        }else if(rankAtaque==1 && rankDefensa==10){//Caso que la ficha 1 pueda atacar a la ficha 10
                                            System.out.println("Una ficha de rango 1 derrotó al gigante de 10 :0");
                                            fichaDefensora.setIcon(null);//Hace la funcion de eliminar a ficha
                                            //Desarrolla procedimiento de movimiento
                                            filaFinal= fila;
                                            columnaFinal=columna;
                                            //efectua el metodo de movimiento
                                            System.out.println("Entro al proceso de mover ficha");


                                            ImageIcon imagenInicial = (ImageIcon) botones[filaInicio][columnaInicio].getIcon();
                                            //String rutaImagenInicial = imagenInicial.getDescription();
                                            botones[filaFinal][columnaFinal].setIcon(imagenInicial);
                                            botones[filaInicio][columnaInicio].setIcon(null);

                                            //Limpia la casilla seleccionada
                                            filaInicio=0;
                                            columnaInicio=0;
                                            filaFinal=0;
                                            columnaFinal=0;
                                            casillaSeleccionada=null;
                                            rangoFichaSelecc=0;

                                            filaInicialProvisional=0;
                                            filaFinalComparativa=0;
                                            filaFinalComparativa2=0;
                                            rangoFichaSelecc=0;
                                            columnaProvisional=0;
                                            
                                            
                                            //Actualizacion de turno a la hora de hacer movimiento
                                            if(estadoTurno==true){
                                                estadoTurno=false;
                                            }else{
                                                estadoTurno=true;
                                            }
                                            System.out.println("Estado de turno: "+estadoTurno);
                                            tablero.visibilidadTurnos(estadoTurno);
                                            tablero.WinOrLoose(this);
                                            
                                            
                                        }else if(rankAtaque>rankDefensa){
                                            System.out.println("Ha vencido la ficha de ataque");
                                            fichaDefensora.setIcon(null);//Hace la funcion de eliminar a ficha
                                            //Desarrolla procedimiento de movimiento
                                            filaFinal= fila;
                                            columnaFinal=columna;
                                            //efectua el metodo de movimiento
                                            System.out.println("Entro al proceso de mover ficha");


                                            ImageIcon imagenInicial = (ImageIcon) botones[filaInicio][columnaInicio].getIcon();
                                            //String rutaImagenInicial = imagenInicial.getDescription();
                                            botones[filaFinal][columnaFinal].setIcon(imagenInicial);
                                            botones[filaInicio][columnaInicio].setIcon(null);

                                            //Limpia la casilla seleccionada
                                            filaInicio=0;
                                            columnaInicio=0;
                                            filaFinal=0;
                                            columnaFinal=0;
                                            casillaSeleccionada=null;
                                            rangoFichaSelecc=0;

                                            filaInicialProvisional=0;
                                            filaFinalComparativa=0;
                                            filaFinalComparativa2=0;
                                            rangoFichaSelecc=0;
                                            columnaProvisional=0;
                                            
                                            //Actualizacion de turno a la hora de hacer movimiento
                                            if(estadoTurno==true){
                                                estadoTurno=false;
                                            }else{
                                                estadoTurno=true;
                                            }
                                            System.out.println("Estado de turno: "+estadoTurno);
                                            tablero.visibilidadTurnos(estadoTurno);
                                            tablero.WinOrLoose(this);
                                            
                                            
                                            
                                        }else if(rankDefensa>rankAtaque){
                                            System.out.println("Ha vencido la ficha de defensa");
                                            fichaAtacante.setIcon(null);//Elimina a ficha de ataque
                                            
                                            //Limpieza de datos
                                            filaInicio=0;
                                            columnaInicio=0;
                                            filaFinal=0;
                                            columnaFinal=0;
                                            casillaSeleccionada=null;
                                            rangoFichaSelecc=0;

                                            filaInicialProvisional=0;
                                            filaFinalComparativa=0;
                                            filaFinalComparativa2=0;
                                            rangoFichaSelecc=0;
                                            columnaProvisional=0;
                                            
                                            //Actualizacion de turno a la hora de hacer movimiento
                                            if(estadoTurno==true){
                                                estadoTurno=false;
                                            }else{
                                                estadoTurno=true;
                                            }
                                            System.out.println("Estado de turno: "+estadoTurno);
                                            tablero.visibilidadTurnos(estadoTurno);
                                            tablero.WinOrLoose(this);
                                            
                                            
                                        }else if(rankDefensa==rankAtaque){
                                            //Ambas fichas se destruyen 
                                            System.out.println("Empate, ambas se destruyen");
                                            filaFinal=fila;
                                            columnaFinal=columna;
                                            botones[filaFinal][columnaFinal].setIcon(null);
                                            botones[filaInicio][columnaInicio].setIcon(null);
                                            //Limpieza de datos
                                            filaInicio=0;
                                            columnaInicio=0;
                                            filaFinal=0;
                                            columnaFinal=0;
                                            casillaSeleccionada=null;
                                            rangoFichaSelecc=0;

                                            filaInicialProvisional=0;
                                            filaFinalComparativa=0;
                                            filaFinalComparativa2=0;
                                            rangoFichaSelecc=0;
                                            columnaProvisional=0; 
                                            
                                            //Actualizacion de turno a la hora de hacer movimiento
                                            if(estadoTurno==true){
                                                estadoTurno=false;
                                            }else{
                                                estadoTurno=true;
                                            }
                                            System.out.println("Estado de turno: "+estadoTurno);
                                            tablero.visibilidadTurnos(estadoTurno);
                                            tablero.WinOrLoose(this);
                                            
                                            
                                        }
                                        
                                        //Verificar en caso que se haya capturado las tierras 
                                        if(rankAtaque==1 && rankDefensa==11){
                                            //Villanos han capturado la tierra
                                            JOptionPane.showMessageDialog(null, "Los Villanos Han Capturado la Tierra. Los villanos ganan.");
                                            fichaDefensora.setIcon(null);
                                            filaFinal= fila;
                                            columnaFinal=columna;
                                            ImageIcon imagenInicial = (ImageIcon) botones[filaInicio][columnaInicio].getIcon();
                                            //String rutaImagenInicial = imagenInicial.getDescription();
                                            botones[filaFinal][columnaFinal].setIcon(imagenInicial);
                                            botones[filaInicio][columnaInicio].setIcon(null);

                                            this.dispose();
                                        }
                                        
                                        if(rankAtaque==1 && rankDefensa==12){
                                            //Heroes salvan la tierra
                                            JOptionPane.showMessageDialog(null, "Los Heroes han Salvado la Tierra. Los Heroes ganan.");
                                            fichaDefensora.setIcon(null);
                                            filaFinal= fila;
                                            columnaFinal=columna;
                                            ImageIcon imagenInicial = (ImageIcon) botones[filaInicio][columnaInicio].getIcon();
                                            //String rutaImagenInicial = imagenInicial.getDescription();
                                            botones[filaFinal][columnaFinal].setIcon(imagenInicial);
                                            botones[filaInicio][columnaInicio].setIcon(null);
                                            this.dispose();
                                        }
                                        
                                        
                                    }//Fin proceso de combate

                                }else{
                                    //Caso en donde casilla no esta ocupada
                                    filaFinal= fila;
                                    columnaFinal=columna;
                                    //efectua el metodo de movimiento
                                    System.out.println("Entro al proceso de mover ficha");


                                    ImageIcon imagenInicial = (ImageIcon) botones[filaInicio][columnaInicio].getIcon();
                                    //String rutaImagenInicial = imagenInicial.getDescription();
                                    botones[filaFinal][columnaFinal].setIcon(imagenInicial);
                                    botones[filaInicio][columnaInicio].setIcon(null);

                                    //Limpia la casilla seleccionada
                                    filaInicio=0;
                                    columnaInicio=0;
                                    filaFinal=0;
                                    columnaFinal=0;
                                    casillaSeleccionada=null;
                                    rangoFichaSelecc=0;
                                    
                                    filaInicialProvisional=0;
                                    filaFinalComparativa=0;
                                    filaFinalComparativa2=0;
                                    rangoFichaSelecc=0;
                                    columnaProvisional=0;
                                    //Actualizacion de turno a la hora de hacer movimiento
                                    if(estadoTurno==true){
                                        estadoTurno=false;
                                    }else{
                                        estadoTurno=true;
                                    }
                                    System.out.println("Estado de turno: "+estadoTurno);
                                    tablero.visibilidadTurnos(estadoTurno);
                                    tablero.WinOrLoose(this);
                                    
                                }
                            }
                            
                            
                        }else if(rangoFichaSelecc == 2){
                            //Comprobar si hay una ficha en la casilla hacia donde se va a mover
                                if(tablero.fichaOcupada(fila, columna)){//Caso en que si haya una ficha 
                                    System.out.println("Entra a campo de ficha Ocupada");
                                    //Proceso para conocer el bando de la ficha seleccionada
                                    ImageIcon tipofichaAMover = (ImageIcon) botones[fila][columna].getIcon();
                                    String rutaIconoFichaAMover = tipofichaAMover.getDescription();


                                    //Proceso para conocer el bando de la ficha que ocupa el lugar de la casilla a donde se va a mover
                                    for(Ficha infoFicha: DatosGlobales.fichas()){
                                        if (rutaIconoFichaAMover.contains(infoFicha.getRutaImagen())) {
                                            rangoFichaSeleccionada=infoFicha.getBando();
                                        }
                                    }

                                    //Mismo proceso pero para ficha ya seleccionada
                                    for(Ficha infoFicha: DatosGlobales.fichas()){
                                        if (rutaIconoFichaSelecc.contains(infoFicha.getRutaImagen())) {
                                            rangoFichaOcupada=infoFicha.getBando();
                                        }
                                    }

                                    //Comprueba caso en que sean del mismo bando -No se efectua movimiento
                                    if(rangoFichaSeleccionada.equals(rangoFichaOcupada)){
                                        System.out.println("No se efectua movimiento");
                                        rangoFichaSeleccionada="";
                                        rangoFichaOcupada=""; //Reseteo del registro de rangos
                                        casillaSeleccionada= null;
                                        rangoFichaSelecc=0;
                                        filaInicialProvisional=0;
                                        filaFinalComparativa=0;
                                        filaFinalComparativa2=0;
                                        rangoFichaSelecc=0;
                                        columnaProvisional=0;
                                        
                                        //Actualizacion de turno a la hora de hacer movimiento
                                        if(estadoTurno==true){
                                            estadoTurno=false;
                                        }else{
                                            estadoTurno=true;
                                        }
                                        System.out.println("Estado de turno: "+estadoTurno);
                                        tablero.visibilidadTurnos(estadoTurno);
                                        tablero.WinOrLoose(this);
                                        
                                        
                                    }else{
                                        System.out.println("Entra a proceso de combate");
                                        JButton fichaAtacante=casillaSeleccionada;
                                        JButton fichaDefensora = botones[fila][columna];
                                        
                                        //Proceso para obtener rango de ficha de defensa
                                        ImageIcon ImageDefensa= (ImageIcon) fichaDefensora.getIcon();
                        
                                        if (ImageDefensa == null) {
                                        return;
                                        }
                                        String rutaDefensa = ImageDefensa.getDescription();
                                        Ficha infoDefensa= tablero.obtenerFicha(rutaDefensa, rutaDefensa);
                                        
                                        int rankDefensa= infoDefensa.getRango();
                                        int rankAtaque=rangoFichaSelecc;
                                        
                                        //Verificar si la ficha de ataque es de mayor rango
                                        
                                        if(rankDefensa==0){
                                            System.out.println("¡Se ha activado una bomba!");
                                            fichaAtacante.setIcon(null);//Elimina a ficha de ataque
                                            
                                            //Limpieza de datos
                                            filaInicio=0;
                                            columnaInicio=0;
                                            filaFinal=0;
                                            columnaFinal=0;
                                            casillaSeleccionada=null;
                                            rangoFichaSelecc=0;

                                            filaInicialProvisional=0;
                                            filaFinalComparativa=0;
                                            filaFinalComparativa2=0;
                                            rangoFichaSelecc=0;
                                            columnaProvisional=0;
                                            
                                            //Actualizacion de turno a la hora de hacer movimiento
                                            if(estadoTurno==true){
                                                estadoTurno=false;
                                            }else{
                                                estadoTurno=true;
                                            }
                                            System.out.println("Estado de turno: "+estadoTurno);
                                            tablero.visibilidadTurnos(estadoTurno);
                                            tablero.WinOrLoose(this);
                                            
                                        }else if(rankAtaque>rankDefensa){
                                            System.out.println("Ha vencido la ficha de ataque");
                                            fichaDefensora.setIcon(null);//Hace la funcion de eliminar a ficha
                                            //Desarrolla procedimiento de movimiento
                                            filaFinal= fila;
                                            columnaFinal=columna;
                                            //efectua el metodo de movimiento
                                            System.out.println("Entro al proceso de mover ficha");


                                            ImageIcon imagenInicial = (ImageIcon) botones[filaInicio][columnaInicio].getIcon();
                                            //String rutaImagenInicial = imagenInicial.getDescription();
                                            botones[filaFinal][columnaFinal].setIcon(imagenInicial);
                                            botones[filaInicio][columnaInicio].setIcon(null);

                                            //Limpia la casilla seleccionada
                                            filaInicio=0;
                                            columnaInicio=0;
                                            filaFinal=0;
                                            columnaFinal=0;
                                            casillaSeleccionada=null;
                                            rangoFichaSelecc=0;

                                            filaInicialProvisional=0;
                                            filaFinalComparativa=0;
                                            filaFinalComparativa2=0;
                                            rangoFichaSelecc=0;
                                            columnaProvisional=0;
                                            
                                            //Actualizacion de turno a la hora de hacer movimiento
                                            if(estadoTurno==true){
                                                estadoTurno=false;
                                            }else{
                                                estadoTurno=true;
                                            }
                                            System.out.println("Estado de turno: "+estadoTurno);
                                            tablero.visibilidadTurnos(estadoTurno);
                                            tablero.WinOrLoose(this);
                                            
                                        }else if(rankDefensa>rankAtaque){
                                            System.out.println("Ha vencido la ficha de defensa");
                                            fichaAtacante.setIcon(null);//Elimina a ficha de ataque
                                            
                                            //Limpieza de datos
                                            filaInicio=0;
                                            columnaInicio=0;
                                            filaFinal=0;
                                            columnaFinal=0;
                                            casillaSeleccionada=null;
                                            rangoFichaSelecc=0;

                                            filaInicialProvisional=0;
                                            filaFinalComparativa=0;
                                            filaFinalComparativa2=0;
                                            rangoFichaSelecc=0;
                                            columnaProvisional=0;
                                            
                                            //Actualizacion de turno a la hora de hacer movimiento
                                            if(estadoTurno==true){
                                                estadoTurno=false;
                                            }else{
                                                estadoTurno=true;
                                            }
                                            System.out.println("Estado de turno: "+estadoTurno);
                                            tablero.visibilidadTurnos(estadoTurno);
                                            tablero.WinOrLoose(this);
                                            
                                        }else if(rankDefensa==rankAtaque){
                                            System.out.println("Se queda en un empate. Ambas se destruyen");
                                            
                                            filaFinal= fila;
                                            columnaFinal=columna;
                                            botones[filaFinal][columnaFinal].setIcon(null);
                                            botones[filaInicio][columnaInicio].setIcon(null);
                                            
                                            //Limpieza de datos
                                            filaInicio=0;
                                            columnaInicio=0;
                                            filaFinal=0;
                                            columnaFinal=0;
                                            casillaSeleccionada=null;
                                            rangoFichaSelecc=0;

                                            filaInicialProvisional=0;
                                            filaFinalComparativa=0;
                                            filaFinalComparativa2=0;
                                            rangoFichaSelecc=0;
                                            columnaProvisional=0;
                                            
                                            
                                            //Actualizacion de turno a la hora de hacer movimiento
                                            if(estadoTurno==true){
                                                estadoTurno=false;
                                            }else{
                                                estadoTurno=true;
                                            }
                                            System.out.println("Estado de turno: "+estadoTurno);
                                            tablero.visibilidadTurnos(estadoTurno);
                                            tablero.WinOrLoose(this);
                                            
                                        }
                                    }

                                }else{
                                    //Caso en donde casilla no esta ocupada
                                    filaFinal= fila;
                                    columnaFinal=columna;
                                    //efectua el metodo de movimiento
                                    System.out.println("Entro al proceso de mover ficha");


                                    ImageIcon imagenInicial = (ImageIcon) botones[filaInicio][columnaInicio].getIcon();
                                    //String rutaImagenInicial = imagenInicial.getDescription();
                                    botones[filaFinal][columnaFinal].setIcon(imagenInicial);
                                    botones[filaInicio][columnaInicio].setIcon(null);

                                    //Limpia la casilla seleccionada
                                    filaInicio=0;
                                    columnaInicio=0;
                                    filaFinal=0;
                                    columnaFinal=0;
                                    casillaSeleccionada=null;
                                    rangoFichaSelecc=0;
                                    
                                    filaInicialProvisional=0;
                                    filaFinalComparativa=0;
                                    filaFinalComparativa2=0;
                                    rangoFichaSelecc=0;
                                    columnaProvisional=0;
                                    
                                    //Actualizacion de turno a la hora de hacer movimiento
                                    if(estadoTurno==true){
                                        estadoTurno=false;
                                    }else{
                                        estadoTurno=true;
                                    }
                                    System.out.println("Estado de turno: "+estadoTurno);
                                    tablero.visibilidadTurnos(estadoTurno);
                                    tablero.WinOrLoose(this);
                                    
                                    
                                }
                        }else{
                        //Limpieza de datos
                        filaInicio=0;
                        columnaInicio=0;
                        filaFinal=0;
                        columnaFinal=0;
                        casillaSeleccionada=null;
                        rangoFichaSelecc=0;

                        filaInicialProvisional=0;
                        filaFinalComparativa=0;
                        filaFinalComparativa2=0;
                        columnaProvisional=0;
                        
                        //Actualizacion de turno a la hora de hacer movimiento
                        if(estadoTurno==true){
                            estadoTurno=false;
                        }else{
                            estadoTurno=true;
                        }
                        System.out.println("Estado de turno: "+estadoTurno);
                        tablero.visibilidadTurnos(estadoTurno);
                        tablero.WinOrLoose(this);
                        
                            
                        }
                    }
                });
                
                panelTablero.add(botones[i][j]);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelTablero = new javax.swing.JPanel();
        lblTablero = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelTablero.setOpaque(false);
        panelTablero.setLayout(new java.awt.GridLayout(10, 10));
        jPanel1.add(panelTablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 35, 502, 498));

        lblTablero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tablero.png"))); // NOI18N
        lblTablero.setText("jLabel1");
        jPanel1.add(lblTablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 500, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPartida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTablero;
    private javax.swing.JPanel panelTablero;
    // End of variables declaration//GEN-END:variables
}
