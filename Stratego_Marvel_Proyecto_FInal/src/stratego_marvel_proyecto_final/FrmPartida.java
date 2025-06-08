package stratego_marvel_proyecto_final;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.util.Random;


public class FrmPartida extends javax.swing.JFrame {

    private JButton botones[][] = new JButton[10][10];
    Random random = new Random();

    public FrmPartida() {
        initComponents();
        crearBotones();
        Tablero tablero = new Tablero(botones);
        tablero.inicializar();
        asignarFichasBuenos();
    }

    private void crearBotones() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                botones[i][j] = new javax.swing.JButton();

                jPanel2.add(botones[i][j]);
            }
        }
    }

    private void asignarFichasBuenos() {
        //Fila correspondiente a bandera
        int filaBandera = 9; //De abajo para arriba? xd
        //columna random para bandera
        int columnaBandera = random.nextInt(8) + 1;

        //colocar tierra
        botones[filaBandera][columnaBandera].setIcon(new ImageIcon(getClass().getResource("/imagenes/heroEarth.png")));

        //colocar bombas alrededor (por medio de coordenadas)
        botones[filaBandera][columnaBandera + 1].setIcon(new ImageIcon(getClass().getResource("/imagenes/novaBlast.png")));
        botones[filaBandera][columnaBandera - 1].setIcon(new ImageIcon(getClass().getResource("/imagenes/novaBlast.png")));
        botones[filaBandera - 1][columnaBandera].setIcon(new ImageIcon(getClass().getResource("/imagenes/novaBlast.png")));

        //bombas restantes
        int bombasRestantes = 3;
        int filasPermitidas[] = {8, 9};

        while (bombasRestantes > 0) {
            int fila = filasPermitidas[random.nextInt(filasPermitidas.length)];
            int columna = random.nextInt(10);
            
            //Verificar si no hay nada en el boton como tal
            if (botones[fila][columna].getIcon() == null) {
                //Asignacion de bomba
                botones[fila][columna].setIcon(new ImageIcon(getClass().getResource("/imagenes/novaBlast.png")));
                bombasRestantes--;
            }
        }
        
        
        //Colocar ficha de rango#2------------------------
        int filasRango2[]= {6,7}; //Se indican las filas correspondientes donde pueden generarse las fichas de rango2
        int Rango2restantes= 8; //Hay 8 fichas de rango 2 por colocar en el tablero
        String fichasRango2[]= {"/imagenes/spidergirl.png", "/imagenes/gambit.png", "/imagenes/iceMan.png", "/imagenes/storm.png", "/imagenes/phoenix.png", 
            "/imagenes/drStrange.png", "/imagenes/elektra.png", "/imagenes/nightcrawler.png"};
        
        int controlador=0;
        //Creador de arreglo para llevar historial de fichas de rango 2 en el tablero
        String fichasGeneradas[]= new String[8];
        
        while(Rango2restantes > 0){
            //Se toma una fila y columna de manera random
            int filarank2= filasRango2[random.nextInt(filasRango2.length)];
            int columnarank2 = random.nextInt(10);
            int fichaRandom= random.nextInt(8);
            String fichaSeleccionada= fichasRango2[fichaRandom];

            //Verificador de ficha repetidas
            if(controlador == 0){
                //Verifica si no hay ficha en dicha casilla
                if(botones[filarank2][columnarank2].getIcon()== null){
                //Colocacion de ficha
                botones[filarank2][columnarank2].setIcon(new ImageIcon(getClass().getResource(fichaSeleccionada)));//getResource(fichaSeleccionada) para que puede escoger de las 8 fichas de rango 2
                fichasGeneradas[controlador]= fichaSeleccionada;
                controlador++;
                Rango2restantes--;
                }
            }else{
                //Boolean que controla si ya se repitió la ficha
                boolean repetida=false;
                //Ciclo utilizado para revisar el historial de fichas ya colocadas 
                for(int i=0; i<fichasGeneradas.length; i++){
                    if(fichaSeleccionada.equals(fichasGeneradas[i])){
                        repetida=true;
                    }
                }
                
                if(repetida==false){
                    if(botones[filarank2][columnarank2].getIcon()== null){
                        botones[filarank2][columnarank2].setIcon(new ImageIcon(getClass().getResource(fichaSeleccionada)));//getResource(fichaSeleccionada) para que puede escoger de las 8 fichas de rango 2
                        fichasGeneradas[controlador]= fichaSeleccionada;
                        controlador++;
                        Rango2restantes--;
                    }
                }
            }//Fin condicional if
            
            /*
            //Comprobante de fichas generadas rango 2
            for(int i=0; i<fichasGeneradas.length; i++){
                System.out.println(fichasGeneradas[i]);
            }
            */
  
        }
        
    
        //Desarrollo de generacion de fichas rango 3----------------------------------
        int filaRango3 = 6;
        int Rango3Restantes= 5;
        String fichasRango3[]={"/imagenes/emmafrost.png","/imagenes/sheHulk.png","/imagenes/giantMan.png","/imagenes/beast.png","/imagenes/colossus.png"};
        int controladorRank3= 0;
        String fichasGeneradasRank3[]= new String[5];
        
        while(Rango3Restantes>0){
            int columnarank3 = random.nextInt(10);
            int fichaRandom= random.nextInt(5);
            String fichaSeleccionada= fichasRango3[fichaRandom];
            
            
            if(controladorRank3 == 0){
                //Verifica si no hay ficha en dicha casilla
                if(botones[filaRango3][columnarank3].getIcon()== null){
                //Colocacion de ficha
                botones[filaRango3][columnarank3].setIcon(new ImageIcon(getClass().getResource(fichaSeleccionada)));
                fichasGeneradasRank3[controladorRank3]= fichaSeleccionada;
                controladorRank3++;
                Rango3Restantes--;
                }
            }else{
                //Boolean que controla si ya se repitió la ficha
                boolean repetida=false;
                //Ciclo utilizado para revisar el historial de fichas ya colocadas 
                for(int i=0; i<fichasGeneradasRank3.length; i++){
                    if(fichaSeleccionada.equals(fichasGeneradasRank3[i])){
                        repetida=true;
                    }
                }
                
                if(repetida==false){
                    if(botones[filaRango3][columnarank3].getIcon()== null){
                        botones[filaRango3][columnarank3].setIcon(new ImageIcon(getClass().getResource(fichaSeleccionada)));
                        fichasGeneradasRank3[controladorRank3]= fichaSeleccionada;
                        controladorRank3++;
                        Rango3Restantes--;
                    }
                }
            }//Fin condicional if
            
            
          
            
        }

        /*
            //Comprobante de fichas generadas rango 3
            for(int i=0; i<fichasGeneradasRank3.length; i++){
                System.out.println(fichasGeneradasRank3[i]);
            }
        */
            
            
            


        
        
        
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridLayout(10, 10));
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 502, 502));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tablero.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 500, 500));

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
