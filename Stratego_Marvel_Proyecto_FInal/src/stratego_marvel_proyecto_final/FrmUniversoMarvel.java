package stratego_marvel_proyecto_final;

public class FrmUniversoMarvel extends javax.swing.JFrame {

    public FrmUniversoMarvel() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnRanking = new javax.swing.JButton();
        btnBatallas = new javax.swing.JButton();
        regresarbutton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoUniversoMarvel.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Bangers", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LOGOUM.png"))); // NOI18N
        jLabel5.setText("UNIVERSO MARVEL");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 530, 60));

        btnRanking.setBackground(new java.awt.Color(242, 80, 53));
        btnRanking.setFont(new java.awt.Font("Bangers", 1, 18)); // NOI18N
        btnRanking.setForeground(new java.awt.Color(255, 255, 255));
        btnRanking.setText("Ranking");
        btnRanking.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        btnRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRankingActionPerformed(evt);
            }
        });
        jPanel1.add(btnRanking, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 130, 50));

        btnBatallas.setBackground(new java.awt.Color(242, 80, 53));
        btnBatallas.setFont(new java.awt.Font("Bangers", 1, 18)); // NOI18N
        btnBatallas.setForeground(new java.awt.Color(255, 255, 255));
        btnBatallas.setText("Batallas");
        btnBatallas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        btnBatallas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatallasActionPerformed(evt);
            }
        });
        jPanel1.add(btnBatallas, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 130, 50));

        regresarbutton.setBackground(new java.awt.Color(255, 51, 51));
        regresarbutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        regresarbutton.setForeground(new java.awt.Color(255, 255, 255));
        regresarbutton.setText("Regresar");
        regresarbutton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        regresarbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(regresarbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 283, 100, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoUniversoMarvel.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 570, 360));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRankingActionPerformed
        // TODO add your handling code here:
        FrmRanking ranking = new FrmRanking();
        ranking.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRankingActionPerformed

    private void btnBatallasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatallasActionPerformed
        // TODO add your handling code here:
        FrmBatallas batallas = new FrmBatallas();
        batallas.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBatallasActionPerformed

    private void regresarbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarbuttonActionPerformed
        new FrmMenuPrincipal().setVisible(true);
        dispose();
    }//GEN-LAST:event_regresarbuttonActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(FrmUniversoMarvel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmUniversoMarvel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmUniversoMarvel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmUniversoMarvel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmUniversoMarvel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatallas;
    private javax.swing.JButton btnRanking;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton regresarbutton;
    // End of variables declaration//GEN-END:variables
}
