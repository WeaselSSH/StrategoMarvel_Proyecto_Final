package stratego_marvel_proyecto_final;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.util.Random;

public class FrmPartida extends javax.swing.JFrame {

    private Ficha fichasBuenos[] = DatosGlobales.fichasBuenos();
    private JButton botones[][] = new JButton[10][10];
    private Tablero tablero;
    Random random = new Random();
    
    private JButton casillaInicio;
    //Coordenadas para efectuar el movimiento
    private int filaInicio;
    private int columnaInicio;
    private int filaFinal;
    private int columnaFinal;
    //------------------
    private JButton casillaFinal;
    
    
    //JButton que servirá para guardar registro de la casilla seleccionada referente a movimiento
    JButton casillaSeleccionada = null;

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
                            //La logica de verificacion se desarrolla a partir del click 2
                            
                            //Indica que si hay una casilla seleccionada
                            casillaSeleccionada = botones[fila][columna];
                            
                            //Posicion de la ficha seleccionada 
                            filaInicio=fila;
                            columnaInicio= columna;
                        }else{
                            //No se recoge nada
                        }
                    }else{
                        //Caso cuando ya hay una ficha previamente seleccionada
                        
                        //Comprobantes de rango de ambas fichas en comparacion
                        String rangoFichaSeleccionada="";
                        String rangoFichaOcupada="";
                        
                        //Comprobar si hay una ficha en la casilla hacia donde se va a mover
                        if(tablero.fichaOcupada(fila, columna)){//Caso en que si haya una ficha 
                            System.out.println("Entra a campo de ficha Ocupada");
                            //Proceso para conocer el bando de la ficha seleccionada
                            ImageIcon tipofichaAMover = (ImageIcon) botones[fila][columna].getIcon();
                            ImageIcon tipofichaSelecc= (ImageIcon) casillaSeleccionada.getIcon();
                            String rutaIconoFichaAMover = tipofichaAMover.getDescription();
                            String rutaIconoFichaSelecc = tipofichaSelecc.getDescription();
                            
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
