package stratego_marvel_proyecto_final;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.text.JTextComponent;

public class FrmCrearPlayer extends javax.swing.JFrame {
    
    private String placeholderUsuario = "Tu nombre de usuario";
    private String placeholderContrasena = "Tu contraseña";

    public FrmCrearPlayer() {
        initComponents();
        agregarPlaceholder(txtUsuario, placeholderUsuario);
        agregarPlaceholder(txtContrasena, placeholderContrasena);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUsuario = new javax.swing.JTextField();
        btnRegistrarse = new javax.swing.JButton();
        txtContrasena = new javax.swing.JPasswordField();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtUsuario.setForeground(new java.awt.Color(128, 128, 128));
        txtUsuario.setText("Tu nombre de usuario");

        btnRegistrarse.setText("Registrarse");
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });

        txtContrasena.setForeground(new java.awt.Color(128, 128, 128));
        txtContrasena.setText("Tu contraseña");

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
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
                                .addComponent(btnRegistrarse, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                .addComponent(btnRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
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
                .addComponent(btnRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
        // TODO add your handling code here:
        registrarUsuario();
    }//GEN-LAST:event_btnRegistrarseActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        FrmMenuPrincipal MenuPrincipal = new FrmMenuPrincipal();
        MenuPrincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void agregarPlaceholder(JTextComponent campo, String placeholder) {
        Color colorPlaceholder = Color.gray;
        Color colorTexto = Color.black;

        char defaultEchoChar = (campo instanceof JPasswordField)
                ? ((JPasswordField) campo).getEchoChar()
                : (char) 0;

        if (campo instanceof JPasswordField pass) {
            pass.setEchoChar((char) 0);
        }

        campo.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                String texto = campo instanceof JPasswordField
                        ? String.valueOf(((JPasswordField) campo).getPassword())
                        : campo.getText();

                if (texto.equals(placeholder)) {
                    campo.setText("");
                    campo.setForeground(colorTexto);

                    if (campo instanceof JPasswordField pass) {
                        pass.setEchoChar(defaultEchoChar);
                    }
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                String texto = campo instanceof JPasswordField
                        ? String.valueOf(((JPasswordField) campo).getPassword())
                        : campo.getText();

                if (texto.isEmpty()) {
                    campo.setForeground(colorPlaceholder);
                    campo.setText(placeholder);

                    if (campo instanceof JPasswordField pass) {
                        pass.setEchoChar((char) 0);
                    }
                }
            }
        });
    }

    public void registrarUsuario() {
        String usuario = txtUsuario.getText().trim();
        String contrasena = new String(txtContrasena.getPassword()).trim();

        if (usuario.equals("") || usuario.equals(placeholderUsuario)
                || contrasena.equals("") || contrasena.equals(placeholderContrasena)) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error: uno de los campos se encuentra vacío.");
            return;
        }

        if (contrasena.length() != 5) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error: La contraseña debe tener exactamente 5 caracteres.");
            return;
        }
        
        if (DatosGlobales.jugadores.containsKey(usuario)) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error: Nombre de usuario registrado previamente.");
            return;
        }

        Jugador nuevoJugador = new Jugador(usuario, contrasena);
        DatosGlobales.jugadores.put(usuario, nuevoJugador);
        
        javax.swing.JOptionPane.showMessageDialog(this, "Jugador creado correctamente.");
    }

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
            java.util.logging.Logger.getLogger(FrmCrearPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCrearPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCrearPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCrearPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCrearPlayer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
