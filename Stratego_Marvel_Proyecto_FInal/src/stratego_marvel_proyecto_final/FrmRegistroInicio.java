package stratego_marvel_proyecto_final;

public class FrmRegistroInicio extends javax.swing.JFrame {

    private String modo;
    public static String placeholderUsuario = "Tu nombre de usuario";
    public static String placeholderContrasena = "Tu contraseña";
    
    private RegistroInicio registroInicio = new RegistroInicio();

    public FrmRegistroInicio(String modo) {
        this.modo = modo;
        initComponents();
        
        registroInicio.agregarPlaceholder(txtUsuario, placeholderUsuario);
        registroInicio.agregarPlaceholder(txtContrasena, placeholderContrasena);
        modificarTextos();
    }
    
    private void modificarTextos() {
        if (modo.equals("login")) {
            btnRegistrarInicio.setText("Iniciar sesión");
            lblTitulo.setText("INICIO DE SESION");
        } else if (modo.equals("registro")) {
            btnRegistrarInicio.setText("Registrarse");
            lblTitulo.setText("CREAR JUGADOR");
        }

        if (modo.equals("login")) {
            btnCancelarRegresar.setText("Regresar");
        } else if (modo.equals("registro")) {
            btnCancelarRegresar.setText("Cancelar");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JPasswordField();
        btnRegistrarInicio = new javax.swing.JButton();
        btnCancelarRegresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Bangers", 1, 48)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("INICIO DE SESION");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 300, -1));

        txtUsuario.setBackground(new java.awt.Color(216, 27, 47));
        txtUsuario.setFont(new java.awt.Font("Komika Axis", 0, 12)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(51, 51, 51));
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setText("Tu nombre de usuario");
        txtUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 158, 50));

        txtContrasena.setBackground(new java.awt.Color(216, 27, 47));
        txtContrasena.setFont(new java.awt.Font("Komika Axis", 0, 12)); // NOI18N
        txtContrasena.setForeground(new java.awt.Color(51, 51, 51));
        txtContrasena.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtContrasena.setText("Tu contraseña");
        txtContrasena.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 158, 50));

        btnRegistrarInicio.setBackground(new java.awt.Color(216, 27, 47));
        btnRegistrarInicio.setFont(new java.awt.Font("Bangers", 0, 20)); // NOI18N
        btnRegistrarInicio.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarInicio.setText("Registrarse");
        btnRegistrarInicio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnRegistrarInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarInicioActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrarInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 120, 50));

        btnCancelarRegresar.setBackground(new java.awt.Color(216, 27, 47));
        btnCancelarRegresar.setFont(new java.awt.Font("Bangers", 0, 20)); // NOI18N
        btnCancelarRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelarRegresar.setText("Cancelar");
        btnCancelarRegresar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnCancelarRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelarRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 120, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/backgroundRegistroInicio.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 310, 430));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarInicioActionPerformed
        // TODO add your handling code here:
        String usuario = txtUsuario.getText();
        String contrasena = new String(txtContrasena.getPassword()).trim();

        if (modo.equals("login")) {
            registroInicio.iniciarSesion(this, usuario, contrasena);
        } else if (modo.equals("registro")) {
            registroInicio.registrarUsuario(this, usuario, contrasena);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
