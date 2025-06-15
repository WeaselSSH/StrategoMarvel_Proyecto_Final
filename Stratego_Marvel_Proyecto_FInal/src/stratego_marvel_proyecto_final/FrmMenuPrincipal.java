package stratego_marvel_proyecto_final;

public class FrmMenuPrincipal extends javax.swing.JFrame {

    public FrmMenuPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnUniversoMarvel = new javax.swing.JButton();
        JugarButton = new javax.swing.JButton();
        LogoutButton = new javax.swing.JButton();
        PerfilButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Bangers", 1, 54)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("MENU PRINCIPAL");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 330, 50));

        btnUniversoMarvel.setBackground(new java.awt.Color(229, 65, 40));
        btnUniversoMarvel.setFont(new java.awt.Font("Bangers", 0, 28)); // NOI18N
        btnUniversoMarvel.setForeground(new java.awt.Color(255, 255, 255));
        btnUniversoMarvel.setText("UNIVERSO MARVEL");
        btnUniversoMarvel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnUniversoMarvel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUniversoMarvelActionPerformed(evt);
            }
        });
        jPanel1.add(btnUniversoMarvel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 200, 60));

        JugarButton.setBackground(new java.awt.Color(229, 65, 40));
        JugarButton.setFont(new java.awt.Font("Bangers", 0, 28)); // NOI18N
        JugarButton.setForeground(new java.awt.Color(255, 255, 255));
        JugarButton.setText("Partida Nueva");
        JugarButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        JugarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JugarButtonActionPerformed(evt);
            }
        });
        jPanel1.add(JugarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 200, 60));

        LogoutButton.setBackground(new java.awt.Color(229, 65, 40));
        LogoutButton.setFont(new java.awt.Font("Bangers", 0, 28)); // NOI18N
        LogoutButton.setForeground(new java.awt.Color(255, 255, 255));
        LogoutButton.setText("Cerrar Sesión");
        LogoutButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        LogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutButtonActionPerformed(evt);
            }
        });
        jPanel1.add(LogoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, 200, 60));

        PerfilButton.setBackground(new java.awt.Color(229, 65, 40));
        PerfilButton.setFont(new java.awt.Font("Bangers", 0, 28)); // NOI18N
        PerfilButton.setForeground(new java.awt.Color(255, 255, 255));
        PerfilButton.setText("Mi Perfil");
        PerfilButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        PerfilButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PerfilButtonActionPerformed(evt);
            }
        });
        jPanel1.add(PerfilButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 200, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/backgroundMenuPrincipal.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 330));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JugarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JugarButtonActionPerformed
        new SeleccionJugadores().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_JugarButtonActionPerformed

    private void PerfilButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PerfilButtonActionPerformed
        System.out.println("Lleva a la vista del perfil");
        new frmPerfil().setVisible(true);
        this.dispose();

    }//GEN-LAST:event_PerfilButtonActionPerformed

    private void LogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutButtonActionPerformed
        new FrmMenuInicial().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogoutButtonActionPerformed

    private void btnUniversoMarvelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUniversoMarvelActionPerformed
        // TODO add your handling code here:
        FrmUniversoMarvel universoMarvel = new FrmUniversoMarvel();
        universoMarvel.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnUniversoMarvelActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JugarButton;
    private javax.swing.JButton LogoutButton;
    private javax.swing.JButton PerfilButton;
    private javax.swing.JButton btnUniversoMarvel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
