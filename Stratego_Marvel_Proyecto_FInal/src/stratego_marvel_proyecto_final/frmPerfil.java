package stratego_marvel_proyecto_final;

public class frmPerfil extends javax.swing.JFrame {
    private Jugador jugadorHost = DatosGlobales.jugadorHost;
    
    public frmPerfil() {
        initComponents();
        cargarTextos();
    }
    
        private void cargarTextos() {
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
        btnContrasenia = new javax.swing.JButton();
        btnBorrarCuenta = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblHost = new javax.swing.JLabel();
        lblDerrotas = new javax.swing.JLabel();
        lblVecesVillano = new javax.swing.JLabel();
        lblVecesHeroe = new javax.swing.JLabel();
        lblVictorias = new javax.swing.JLabel();
        lblPuntaje = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHistorialBatallas = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        label8.setFont(new java.awt.Font("Imprint MT Shadow", 1, 18)); // NOI18N
        label8.setText("Partidas como Heroe");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnContrasenia.setBackground(new java.awt.Color(24, 78, 230));
        btnContrasenia.setFont(new java.awt.Font("Bangers", 0, 18)); // NOI18N
        btnContrasenia.setForeground(new java.awt.Color(255, 255, 255));
        btnContrasenia.setText("CAMBIAR CONTRASEñA");
        btnContrasenia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.add(btnContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 480, 180, 40));

        btnBorrarCuenta.setBackground(new java.awt.Color(24, 78, 230));
        btnBorrarCuenta.setFont(new java.awt.Font("Bangers", 0, 18)); // NOI18N
        btnBorrarCuenta.setForeground(new java.awt.Color(255, 255, 255));
        btnBorrarCuenta.setText("BORRAR CUENTA");
        btnBorrarCuenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.add(btnBorrarCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, 180, 40));

        jLabel1.setFont(new java.awt.Font("Bangers", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("HISTORIAL DE PARTIDAS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 190, -1));

        lblHost.setFont(new java.awt.Font("Bangers", 0, 48)); // NOI18N
        lblHost.setForeground(new java.awt.Color(255, 255, 255));
        lblHost.setText("Nombre de Usuario");
        jPanel1.add(lblHost, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 330, -1));

        lblDerrotas.setFont(new java.awt.Font("Bangers", 0, 18)); // NOI18N
        lblDerrotas.setForeground(new java.awt.Color(255, 255, 255));
        lblDerrotas.setText("Derrotas:");
        jPanel1.add(lblDerrotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 110, -1));

        lblVecesVillano.setFont(new java.awt.Font("Bangers", 0, 18)); // NOI18N
        lblVecesVillano.setForeground(new java.awt.Color(255, 255, 255));
        lblVecesVillano.setText("Veces como villano:");
        jPanel1.add(lblVecesVillano, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 160, -1));

        lblVecesHeroe.setFont(new java.awt.Font("Bangers", 0, 18)); // NOI18N
        lblVecesHeroe.setForeground(new java.awt.Color(255, 255, 255));
        lblVecesHeroe.setText("Veces como héroe:");
        jPanel1.add(lblVecesHeroe, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 150, -1));

        lblVictorias.setFont(new java.awt.Font("Bangers", 0, 18)); // NOI18N
        lblVictorias.setForeground(new java.awt.Color(255, 255, 255));
        lblVictorias.setText("Victorias:");
        jPanel1.add(lblVictorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 100, -1));

        lblPuntaje.setFont(new java.awt.Font("Bangers", 0, 24)); // NOI18N
        lblPuntaje.setForeground(new java.awt.Color(255, 255, 255));
        lblPuntaje.setText("puntaje");
        jPanel1.add(lblPuntaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 120, -1));

        tblHistorialBatallas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblHistorialBatallas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 270, 200));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/backgroundPerfilJugador.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label8;
    private javax.swing.JLabel lblDerrotas;
    private javax.swing.JLabel lblHost;
    private javax.swing.JLabel lblPuntaje;
    private javax.swing.JLabel lblVecesHeroe;
    private javax.swing.JLabel lblVecesVillano;
    private javax.swing.JLabel lblVictorias;
    private javax.swing.JTable tblHistorialBatallas;
    // End of variables declaration//GEN-END:variables
}
