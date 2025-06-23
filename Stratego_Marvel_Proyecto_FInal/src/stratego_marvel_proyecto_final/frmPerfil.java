package stratego_marvel_proyecto_final;

public class frmPerfil extends javax.swing.JFrame {

    private Jugador jugadorHost = DatosGlobales.jugadorHost;

    public frmPerfil() {
        initComponents();
        setLocationRelativeTo(null);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                new FrmMenuPrincipal().setVisible(true);
                dispose();
            }
        });
        cargarTextos();
    }

    private void cargarTextos() {
        lblHost.setText(DatosGlobales.jugadorHost.getUsuario());
        lblPuntaje.setText("Puntaje: " + DatosGlobales.jugadorHost.getPuntos());
        lblVictorias.setText("Victorias: " + DatosGlobales.jugadorHost.getVictorias());
        lblDerrotas.setText("Derrotas: " + DatosGlobales.jugadorHost.getDerrotas());
        lblVecesHeroe.setText("Veces como héroe: " + DatosGlobales.jugadorHost.getHeroes());
        lblVecesVillano.setText("Veces como villano: " + DatosGlobales.jugadorHost.getVillanos());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        label8 = new java.awt.Label();
        jPanel1 = new javax.swing.JPanel();
        btnLog = new javax.swing.JButton();
        btnContrasenia = new javax.swing.JButton();
        btnBorrarCuenta = new javax.swing.JButton();
        lblHost = new javax.swing.JLabel();
        lblDerrotas = new javax.swing.JLabel();
        lblVecesVillano = new javax.swing.JLabel();
        lblVecesHeroe = new javax.swing.JLabel();
        lblVictorias = new javax.swing.JLabel();
        lblPuntaje = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        label8.setFont(new java.awt.Font("Imprint MT Shadow", 1, 18)); // NOI18N
        label8.setText("Partidas como Heroe");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLog.setBackground(new java.awt.Color(199, 21, 37));
        btnLog.setFont(new java.awt.Font("Bangers", 0, 14)); // NOI18N
        btnLog.setForeground(new java.awt.Color(255, 255, 255));
        btnLog.setText("VER HISTORIAL DE BATALLAS");
        btnLog.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogActionPerformed(evt);
            }
        });
        jPanel1.add(btnLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 220, 40));

        btnContrasenia.setBackground(new java.awt.Color(199, 21, 37));
        btnContrasenia.setFont(new java.awt.Font("Bangers", 0, 12)); // NOI18N
        btnContrasenia.setForeground(new java.awt.Color(255, 255, 255));
        btnContrasenia.setText("CAMBIAR CONTRASEñA");
        btnContrasenia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContraseniaActionPerformed(evt);
            }
        });
        jPanel1.add(btnContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 150, 40));

        btnBorrarCuenta.setBackground(new java.awt.Color(199, 21, 37));
        btnBorrarCuenta.setFont(new java.awt.Font("Bangers", 0, 14)); // NOI18N
        btnBorrarCuenta.setForeground(new java.awt.Color(255, 255, 255));
        btnBorrarCuenta.setText("BORRAR CUENTA");
        btnBorrarCuenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnBorrarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarCuentaActionPerformed(evt);
            }
        });
        jPanel1.add(btnBorrarCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 140, 40));

        lblHost.setFont(new java.awt.Font("Bangers", 0, 36)); // NOI18N
        lblHost.setForeground(new java.awt.Color(255, 255, 255));
        lblHost.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHost.setText("Nombre de Usuario");
        jPanel1.add(lblHost, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 350, -1));

        lblDerrotas.setFont(new java.awt.Font("Bangers", 0, 18)); // NOI18N
        lblDerrotas.setForeground(new java.awt.Color(255, 255, 255));
        lblDerrotas.setText("Derrotas:");
        jPanel1.add(lblDerrotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 110, -1));

        lblVecesVillano.setFont(new java.awt.Font("Bangers", 0, 15)); // NOI18N
        lblVecesVillano.setForeground(new java.awt.Color(255, 255, 255));
        lblVecesVillano.setText("Veces como villano:");
        jPanel1.add(lblVecesVillano, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 170, -1));

        lblVecesHeroe.setFont(new java.awt.Font("Bangers", 0, 15)); // NOI18N
        lblVecesHeroe.setForeground(new java.awt.Color(255, 255, 255));
        lblVecesHeroe.setText("Veces como héroe:");
        jPanel1.add(lblVecesHeroe, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 170, -1));

        lblVictorias.setFont(new java.awt.Font("Bangers", 0, 18)); // NOI18N
        lblVictorias.setForeground(new java.awt.Color(255, 255, 255));
        lblVictorias.setText("Victorias:");
        jPanel1.add(lblVictorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 100, -1));

        lblPuntaje.setFont(new java.awt.Font("Bangers", 0, 24)); // NOI18N
        lblPuntaje.setForeground(new java.awt.Color(255, 255, 255));
        lblPuntaje.setText("puntaje");
        jPanel1.add(lblPuntaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 120, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/backgroundPerfilJugador.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 380));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContraseniaActionPerformed
        // TODO add your handling code here:

        String actual = javax.swing.JOptionPane.showInputDialog(this, "Ingresa tu contraseña actual:");
        if (!actual.equals(jugadorHost.getContrasena())) {
            javax.swing.JOptionPane.showMessageDialog(this, "Contraseña actual incorrecta.");
            return;
        }

        String nueva = javax.swing.JOptionPane.showInputDialog(this, "Ingresa tu nueva contraseña:");
        if (nueva.trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error: La nueva contraseña no puede estar vacía.");
            return;
        }

        if (nueva.length() != 5) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error: La nueva contraseña debe tener exactamente 5 caracteres.");
            return;
        }

        jugadorHost.setContrasena(nueva);
        javax.swing.JOptionPane.showMessageDialog(this, "Contraseña cambiada exitosamente!");
    }//GEN-LAST:event_btnContraseniaActionPerformed

    private void btnBorrarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarCuentaActionPerformed
        // TODO add your handling code here:
        String actual = javax.swing.JOptionPane.showInputDialog(this, "Ingresa tu contraseña actual:");
        if (!actual.equals(jugadorHost.getContrasena())) {
            javax.swing.JOptionPane.showMessageDialog(this, "Contraseña actual incorrecta.");
        } else {
            DatosGlobales.jugadorHost.setEliminado(true);
            javax.swing.JOptionPane.showMessageDialog(null, "Cuenta borrada exitosamente.");
            FrmMenuInicial2 menuInicial = new FrmMenuInicial2();
            menuInicial.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnBorrarCuentaActionPerformed

    private void btnLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogActionPerformed
        // TODO add your handling code here:
        FrmLog log = new FrmLog();
        log.setLocationRelativeTo(null);
        log.setVisible(true);
    }//GEN-LAST:event_btnLogActionPerformed

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
            java.util.logging.Logger.getLogger(frmPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPerfil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrarCuenta;
    private javax.swing.JButton btnContrasenia;
    private javax.swing.JButton btnLog;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private java.awt.Label label8;
    private javax.swing.JLabel lblDerrotas;
    private javax.swing.JLabel lblHost;
    private javax.swing.JLabel lblPuntaje;
    private javax.swing.JLabel lblVecesHeroe;
    private javax.swing.JLabel lblVecesVillano;
    private javax.swing.JLabel lblVictorias;
    // End of variables declaration//GEN-END:variables
}
