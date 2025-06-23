package stratego_marvel_proyecto_final;

public class FrmBatallas extends javax.swing.JFrame {

    public FrmBatallas() {
        initComponents();
        setLocationRelativeTo(null);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                new FrmUniversoMarvel().setVisible(true);
                dispose();
            }
        });
        
        cargarTextos();
    }

    private void cargarTextos() {
        int cantidadActivos = 0;
        for (int i = 0; i < DatosGlobales.listaJugadores.cantidad(); i++) {
            Jugador j = DatosGlobales.listaJugadores.obtener(i);
            if (!j.getEliminado()) {
                cantidadActivos++;
            }
        }

        lblUsuarioHist.setText("USUARIOS HISTORICOS: " + DatosGlobales.listaJugadores.cantidad());
        lblUsuarioAct.setText("USUARIOS ACTIVOS: " + cantidadActivos);
        lblVicVillanos1.setText("VICTORIA VILLANOS: " + DatosGlobales.victoriaVillanos);
        lblVicHeroes.setText("VICTORIA HEROES: " + DatosGlobales.victoriaHeroes);
        lblTotalBatallas.setText("BATALLAS TOTALES: " + DatosGlobales.partidasTotales);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblUsuarioHist = new javax.swing.JLabel();
        lblUsuarioAct = new javax.swing.JLabel();
        lblVicVillanos1 = new javax.swing.JLabel();
        lblVicHeroes = new javax.swing.JLabel();
        lblTotalBatallas = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsuarioHist.setFont(new java.awt.Font("Bangers", 1, 24)); // NOI18N
        lblUsuarioHist.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuarioHist.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsuarioHist.setText("USUARIOS HISTORICOS:");
        jPanel1.add(lblUsuarioHist, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 310, 50));

        lblUsuarioAct.setFont(new java.awt.Font("Bangers", 1, 24)); // NOI18N
        lblUsuarioAct.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuarioAct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsuarioAct.setText("USUARIOS ACTIVOS:");
        jPanel1.add(lblUsuarioAct, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 270, 50));

        lblVicVillanos1.setFont(new java.awt.Font("Bangers", 1, 24)); // NOI18N
        lblVicVillanos1.setForeground(new java.awt.Color(255, 255, 255));
        lblVicVillanos1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVicVillanos1.setText("VICTORIA VILLANOS:");
        jPanel1.add(lblVicVillanos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 300, 50));

        lblVicHeroes.setFont(new java.awt.Font("Bangers", 1, 24)); // NOI18N
        lblVicHeroes.setForeground(new java.awt.Color(255, 255, 255));
        lblVicHeroes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVicHeroes.setText("VICTORIA HEROES:");
        jPanel1.add(lblVicHeroes, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 260, 50));

        lblTotalBatallas.setFont(new java.awt.Font("Bangers", 1, 24)); // NOI18N
        lblTotalBatallas.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalBatallas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalBatallas.setText("BATALLAS TOTALES:");
        jPanel1.add(lblTotalBatallas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 500, 50));

        jLabel5.setFont(new java.awt.Font("Bangers", 1, 54)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("BATALLAS");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, -1, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/backgroundBatallas.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 700, 460));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            java.util.logging.Logger.getLogger(FrmBatallas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmBatallas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmBatallas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmBatallas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmBatallas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTotalBatallas;
    private javax.swing.JLabel lblUsuarioAct;
    private javax.swing.JLabel lblUsuarioHist;
    private javax.swing.JLabel lblVicHeroes;
    private javax.swing.JLabel lblVicVillanos1;
    // End of variables declaration//GEN-END:variables
}
