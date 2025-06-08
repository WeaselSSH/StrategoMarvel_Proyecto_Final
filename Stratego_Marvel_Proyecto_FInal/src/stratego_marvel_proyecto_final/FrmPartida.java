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
        
        
        //Colocar ficha de rango#2
        int filasRango2[]= {6,7}; //Se indican las filas correspondientes donde pueden generarse las fichas de rango2
        
        //Se toma una fila y columna de manera random
        int filarank2= filasRango2[random.nextInt(filasRango2.length)];
        int columnarank2 = random.nextInt(10);
        
        //Verifica si no hay ficha en dicha casilla
        if(botones[filarank2][columnarank2].getIcon()== null){
            //Colocacion de ficha
            botones[filarank2][columnarank2].setIcon(new ImageIcon(getClass().getResource("/imagenes/spidergirl.png")));
        }
        
        
        
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
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 502, 502));

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
