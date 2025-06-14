package stratego_marvel_proyecto_final;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.util.Random;

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
    
    //------------------
    private JButton casillaFinal;
    
    
    //JButton que servirá para guardar registro de la casilla seleccionada referente a movimiento
    JButton casillaSeleccionada = null;
    Ficha extractor;
    

    public FrmPartida() {
        initComponents();
        crearBotones();
        tablero = new Tablero(botones);
        tablero.inicializar();
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
                            filaInicio=fila;
                            columnaInicio= columna;
                            filaInicialProvisional=fila;
                            columnaProvisional=columna;
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
                        
                        if (tipofichaSelecc == null) {
                        return;
                        }
        
                        
                        int rangoFichaSelecc=0;
                        String rutaIconoFichaSelecc = tipofichaSelecc.getDescription();
                        System.out.println(rutaIconoFichaSelecc);
                        
                        Ficha selected = tablero.obtenerFicha(rutaIconoFichaSelecc);
                        rangoFichaSelecc= selected.getRango();
                        
                        
                        
                        
                        //Obtencion del rango de la ficha ya seleccionado
                        
                        /*
                        for(Ficha infoFicha: fichasBuenos){
                            System.out.println("Entra a ciclo");
                            if(rutaIconoFichaSelecc.equals(infoFicha)){
                                casillaSeleccionada.putClientProperty("Ficha", infoFicha);
                                Ficha selectedFicha = (Ficha) casillaSeleccionada.getClientProperty("Ficha");
                                rangoFichaSelecc= selectedFicha.getRango();
                                System.out.println("Se obtuvo rangooooooo");
                                System.out.println(rangoFichaSelecc);
                            }
                        }
                        */
                        
                        /*
                        for(Ficha infoFicha: DatosGlobales.fichasBuenos()){
                            String routeImage= infoFicha.getRutaImagen();
                            if(routeImage.equals(rutaIconoFichaSelecc)){
                                rangoFichaSelecc= infoFicha.getRango();
                                System.out.println("Se obtuvo rangooooooooooo");
                            }
                        }
                        */
                        System.out.println("Se obtuvo el rango");
                        System.out.println(rangoFichaSelecc);
                        
                        if(rangoFichaSelecc ==1 || rangoFichaSelecc == 3 || rangoFichaSelecc == 4 ||
                                rangoFichaSelecc == 5 || rangoFichaSelecc == 6 || rangoFichaSelecc == 7 || rangoFichaSelecc == 8 || rangoFichaSelecc == 9){
                            
                            System.out.println("Entra al comparador de rango");
                            //Compara si se esta moviento solamente una casilla
                            int filaFinalComparativa=filaInicialProvisional-1;
                            int filaComp=fila;
                            int columnaComp=columna;
                            if(filaComp!=filaFinalComparativa || columnaComp !=columnaProvisional){
                                System.out.println("No se ejecuta el movimiento, se sale del rango destinado");
                                filaInicialProvisional=0;
                                rangoFichaSelecc=0;
                            }else{
                                //Comprobar si hay una ficha en la casilla hacia donde se va a mover
                                if(tablero.fichaOcupada(fila, columna)){//Caso en que si haya una ficha 
                                    System.out.println("Entra a campo de ficha Ocupada");
                                    //Proceso para conocer el bando de la ficha seleccionada
                                    ImageIcon tipofichaAMover = (ImageIcon) botones[fila][columna].getIcon();
                                    String rutaIconoFichaAMover = tipofichaAMover.getDescription();


                                    //Proceso para conocer el bando de la ficha que ocupa el lugar de la casilla a donde se va a mover
                                    for(Ficha infoFicha: DatosGlobales.fichasBuenos()){
                                        if(infoFicha.equals(rutaIconoFichaAMover)){
                                            rangoFichaSeleccionada=infoFicha.getBando();
                                        }
                                    }

                                    //Mismo proceso pero para ficha ya seleccionada
                                    for(Ficha infoFicha: DatosGlobales.fichasBuenos()){
                                        if(infoFicha.equals(rutaIconoFichaSelecc)){
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
                                    }//Aqui se haria un else que inicializaria el procedimiento de combate

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
                                }
                            }
                            
                            
                        }else{
                            System.out.println("Se efectua un movimiento aun mayor mas libre");
                            rangoFichaSelecc=0;
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
