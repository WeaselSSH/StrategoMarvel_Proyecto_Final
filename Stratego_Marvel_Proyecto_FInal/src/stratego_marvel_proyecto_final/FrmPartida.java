package stratego_marvel_proyecto_final;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class FrmPartida extends javax.swing.JFrame {

    private JButton botones[][] = new JButton[10][10];
    private Tablero tablero;


    public FrmPartida() {
        initComponents();
        crearBotones();
        tablero = new Tablero(botones, lblTurno, this);
        tablero.inicializar();
    }

    private void crearBotones() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                botones[i][j] = new javax.swing.JButton();
                int fila = i;
                int columna = j;

                botones[i][j].addActionListener(e -> {
                    tablero.botonClick(fila, columna);
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
        jLabel1 = new javax.swing.JLabel();
        lblTurno = new javax.swing.JLabel();
        btnCementerio = new javax.swing.JButton();
        rendirsebutton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelTablero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelTablero.setOpaque(false);
        panelTablero.setLayout(new java.awt.GridLayout(10, 10));
        jPanel1.add(panelTablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 640, 635));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tablero.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 640, -1));

        lblTurno.setFont(new java.awt.Font("Bangers", 0, 36)); // NOI18N
        lblTurno.setText("TURNO: HEROES");
        jPanel1.add(lblTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, 310, -1));

        btnCementerio.setText("Cementerio");
        btnCementerio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCementerioActionPerformed(evt);
            }
        });
        jPanel1.add(btnCementerio, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 680, 150, 40));

        rendirsebutton.setText("Rendirse");
        rendirsebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rendirsebuttonActionPerformed(evt);
            }
        });
        jPanel1.add(rendirsebutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 130, 130, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCementerioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCementerioActionPerformed
        // TODO add your handling code here:
        FrmCementerio cementerio = new FrmCementerio(
                tablero.fichasDerrotadasBuenos, tablero.cantHeroesDerrotados,
                tablero.fichasDerrotadasMalos, tablero.cantVillanosDerrotados
        );
        cementerio.setVisible(true);
    }//GEN-LAST:event_btnCementerioActionPerformed

    private void rendirsebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rendirsebuttonActionPerformed
        String turnoActual = tablero.getTurno();
        
        int opcion = JOptionPane.showConfirmDialog(null, 
                "¿Desea Rendirse?", "", JOptionPane.YES_NO_OPTION);
        
        switch(opcion){
            case JOptionPane.YES_OPTION:
                if(turnoActual.equals("BUENO")){
                    DatosGlobales.jugadorContricante.partidaGanada();//Agregado de puntos
                    PanelRendirseH rendidoB = new PanelRendirseH(this);
                    rendidoB.setVisible(true);
                }else if(turnoActual.equals("MALO")){
                    DatosGlobales.jugadorHost.partidaGanada();
                    PanelRendirseV rendidoV = new PanelRendirseV(this);
                    rendidoV.setVisible(true);
                }
                break;
            case JOptionPane.NO_OPTION:
                break;
        }
        
        
    }//GEN-LAST:event_rendirsebuttonActionPerformed

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
    private javax.swing.JButton btnCementerio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTurno;
    private javax.swing.JPanel panelTablero;
    private javax.swing.JButton rendirsebutton;
    // End of variables declaration//GEN-END:variables
}
