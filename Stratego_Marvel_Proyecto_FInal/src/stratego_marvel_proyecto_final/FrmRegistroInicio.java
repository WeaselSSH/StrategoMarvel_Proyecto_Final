package stratego_marvel_proyecto_final;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.text.JTextComponent;

public class FrmRegistroInicio extends javax.swing.JFrame {
    private String modo;

    public FrmRegistroInicio(String modo) {
        initComponents();
        this.modo = modo;
        
        if (modo.equals("login")) {
            btnRegistrarInicio.setText("Iniciar sesión");
        } else if (modo.equals("registro")) {
            btnRegistrarInicio.setText("Registrarse");
        }
        
        if (modo.equals("login")) {
            btnCancelarRegresar.setText("Regresar");
        } else if (modo.equals("registro")) {
            btnCancelarRegresar.setText("Cancelar");
        }
        
        utilidades.agregarPlaceholder(txtUsuario, DatosGlobales.placeholderUsuario);
        utilidades.agregarPlaceholder(txtContrasena, DatosGlobales.placeholderContrasena); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUsuario = new javax.swing.JTextField();
        btnRegistrarInicio = new javax.swing.JButton();
        txtContrasena = new javax.swing.JPasswordField();
        btnCancelarRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtUsuario.setForeground(new java.awt.Color(128, 128, 128));
        txtUsuario.setText("Tu nombre de usuario");

        btnRegistrarInicio.setText("Registrarse");
        btnRegistrarInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarInicioActionPerformed(evt);
            }
        });

        txtContrasena.setForeground(new java.awt.Color(128, 128, 128));
        txtContrasena.setText("Tu contraseña");

        btnCancelarRegresar.setText("Cancelar");
        btnCancelarRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(60, 60, 60)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(88, 88, 88)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnRegistrarInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                .addComponent(btnCancelarRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnRegistrarInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelarRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarInicioActionPerformed
        // TODO add your handling code here:
        String usuario = txtUsuario.getText();
        String contrasena = new String(txtContrasena.getPassword()).trim();
        
        if (modo.equals("login")) {
            utilidades.iniciarSesion(this, usuario, contrasena);
        } else if (modo.equals("registro")) {
            utilidades.registrarUsuario(this, usuario, contrasena);
        }
    }//GEN-LAST:event_btnRegistrarInicioActionPerformed

    private void btnCancelarRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarRegresarActionPerformed
        // TODO add your handling code here:
        
        FrmMenuInicial MenuPrincipal = new FrmMenuInicial();
        MenuPrincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarRegresarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmRegistroInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRegistroInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRegistroInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRegistroInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRegistroInicio("login").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarRegresar;
    private javax.swing.JButton btnRegistrarInicio;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
