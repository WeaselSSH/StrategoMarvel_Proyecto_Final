package stratego_marvel_proyecto_final;

import java.awt.GridLayout;
import javax.swing.JButton;

public class FrmPartida extends javax.swing.JFrame {

    private JButton botones[][] = new JButton[10][10];

    public FrmPartida() {
        initComponents();
        arrayBotones();
        Tablero tablero = new Tablero(botones);
        tablero.inicializar();
    }

    private void arrayBotones() {
        // Fila 1
        botones[0][0] = btnTablero1;
        botones[0][1] = btnTablero2;
        botones[0][2] = btnTablero3;
        botones[0][3] = btnTablero4;
        botones[0][4] = btnTablero5;
        botones[0][5] = btnTablero6;
        botones[0][6] = btnTablero7;
        botones[0][7] = btnTablero8;
        botones[0][8] = btnTablero9;
        botones[0][9] = btnTablero10;

        // Fila 2
        botones[1][0] = btnTablero11;
        botones[1][1] = btnTablero12;
        botones[1][2] = btnTablero13;
        botones[1][3] = btnTablero14;
        botones[1][4] = btnTablero15;
        botones[1][5] = btnTablero16;
        botones[1][6] = btnTablero17;
        botones[1][7] = btnTablero18;
        botones[1][8] = btnTablero19;
        botones[1][9] = btnTablero20;

        // Fila 3
        botones[2][0] = btnTablero21;
        botones[2][1] = btnTablero22;
        botones[2][2] = btnTablero23;
        botones[2][3] = btnTablero24;
        botones[2][4] = btnTablero25;
        botones[2][5] = btnTablero26;
        botones[2][6] = btnTablero27;
        botones[2][7] = btnTablero28;
        botones[2][8] = btnTablero29;
        botones[2][9] = btnTablero30;

        // Fila 4
        botones[3][0] = btnTablero31;
        botones[3][1] = btnTablero32;
        botones[3][2] = btnTablero33;
        botones[3][3] = btnTablero34;
        botones[3][4] = btnTablero35;
        botones[3][5] = btnTablero36;
        botones[3][6] = btnTablero37;
        botones[3][7] = btnTablero38;
        botones[3][8] = btnTablero39;
        botones[3][9] = btnTablero40;

        // Fila 5
        botones[4][0] = btnTablero41;
        botones[4][1] = btnTablero42;
        botones[4][2] = btnTablero43;
        botones[4][3] = btnTablero44;
        botones[4][4] = btnTablero45;
        botones[4][5] = btnTablero46;
        botones[4][6] = btnTablero47;
        botones[4][7] = btnTablero48;
        botones[4][8] = btnTablero49;
        botones[4][9] = btnTablero50;

        // Fila 6
        botones[5][0] = btnTablero51;
        botones[5][1] = btnTablero52;
        botones[5][2] = btnTablero53;
        botones[5][3] = btnTablero54;
        botones[5][4] = btnTablero55;
        botones[5][5] = btnTablero56;
        botones[5][6] = btnTablero57;
        botones[5][7] = btnTablero58;
        botones[5][8] = btnTablero59;
        botones[5][9] = btnTablero60;

        // Fila 7
        botones[6][0] = btnTablero61;
        botones[6][1] = btnTablero62;
        botones[6][2] = btnTablero63;
        botones[6][3] = btnTablero64;
        botones[6][4] = btnTablero65;
        botones[6][5] = btnTablero66;
        botones[6][6] = btnTablero67;
        botones[6][7] = btnTablero68;
        botones[6][8] = btnTablero69;
        botones[6][9] = btnTablero70;

        // Fila 8
        botones[7][0] = btnTablero71;
        botones[7][1] = btnTablero72;
        botones[7][2] = btnTablero73;
        botones[7][3] = btnTablero74;
        botones[7][4] = btnTablero75;
        botones[7][5] = btnTablero76;
        botones[7][6] = btnTablero77;
        botones[7][7] = btnTablero78;
        botones[7][8] = btnTablero79;
        botones[7][9] = btnTablero80;

        // Fila 9
        botones[8][0] = btnTablero81;
        botones[8][1] = btnTablero82;
        botones[8][2] = btnTablero83;
        botones[8][3] = btnTablero84;
        botones[8][4] = btnTablero85;
        botones[8][5] = btnTablero86;
        botones[8][6] = btnTablero87;
        botones[8][7] = btnTablero88;
        botones[8][8] = btnTablero89;
        botones[8][9] = btnTablero90;

        // Fila 10
        botones[9][0] = btnTablero91;
        botones[9][1] = btnTablero92;
        botones[9][2] = btnTablero93;
        botones[9][3] = btnTablero94;
        botones[9][4] = btnTablero95;
        botones[9][5] = btnTablero96;
        botones[9][6] = btnTablero97;
        botones[9][7] = btnTablero98;
        botones[9][8] = btnTablero99;
        botones[9][9] = btnTablero100;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnTablero1 = new javax.swing.JButton();
        btnTablero2 = new javax.swing.JButton();
        btnTablero3 = new javax.swing.JButton();
        btnTablero4 = new javax.swing.JButton();
        btnTablero5 = new javax.swing.JButton();
        btnTablero6 = new javax.swing.JButton();
        btnTablero7 = new javax.swing.JButton();
        btnTablero8 = new javax.swing.JButton();
        btnTablero9 = new javax.swing.JButton();
        btnTablero10 = new javax.swing.JButton();
        btnTablero11 = new javax.swing.JButton();
        btnTablero12 = new javax.swing.JButton();
        btnTablero13 = new javax.swing.JButton();
        btnTablero14 = new javax.swing.JButton();
        btnTablero15 = new javax.swing.JButton();
        btnTablero16 = new javax.swing.JButton();
        btnTablero17 = new javax.swing.JButton();
        btnTablero18 = new javax.swing.JButton();
        btnTablero19 = new javax.swing.JButton();
        btnTablero20 = new javax.swing.JButton();
        btnTablero21 = new javax.swing.JButton();
        btnTablero22 = new javax.swing.JButton();
        btnTablero23 = new javax.swing.JButton();
        btnTablero24 = new javax.swing.JButton();
        btnTablero25 = new javax.swing.JButton();
        btnTablero26 = new javax.swing.JButton();
        btnTablero27 = new javax.swing.JButton();
        btnTablero28 = new javax.swing.JButton();
        btnTablero29 = new javax.swing.JButton();
        btnTablero30 = new javax.swing.JButton();
        btnTablero31 = new javax.swing.JButton();
        btnTablero32 = new javax.swing.JButton();
        btnTablero33 = new javax.swing.JButton();
        btnTablero34 = new javax.swing.JButton();
        btnTablero35 = new javax.swing.JButton();
        btnTablero36 = new javax.swing.JButton();
        btnTablero37 = new javax.swing.JButton();
        btnTablero38 = new javax.swing.JButton();
        btnTablero39 = new javax.swing.JButton();
        btnTablero40 = new javax.swing.JButton();
        btnTablero41 = new javax.swing.JButton();
        btnTablero42 = new javax.swing.JButton();
        btnTablero44 = new javax.swing.JButton();
        btnTablero45 = new javax.swing.JButton();
        btnTablero46 = new javax.swing.JButton();
        btnTablero47 = new javax.swing.JButton();
        btnTablero48 = new javax.swing.JButton();
        btnTablero49 = new javax.swing.JButton();
        btnTablero50 = new javax.swing.JButton();
        btnTablero51 = new javax.swing.JButton();
        btnTablero52 = new javax.swing.JButton();
        btnTablero53 = new javax.swing.JButton();
        btnTablero43 = new javax.swing.JButton();
        btnTablero54 = new javax.swing.JButton();
        btnTablero56 = new javax.swing.JButton();
        btnTablero57 = new javax.swing.JButton();
        btnTablero58 = new javax.swing.JButton();
        btnTablero59 = new javax.swing.JButton();
        btnTablero60 = new javax.swing.JButton();
        btnTablero61 = new javax.swing.JButton();
        btnTablero62 = new javax.swing.JButton();
        btnTablero63 = new javax.swing.JButton();
        btnTablero64 = new javax.swing.JButton();
        btnTablero65 = new javax.swing.JButton();
        btnTablero66 = new javax.swing.JButton();
        btnTablero67 = new javax.swing.JButton();
        btnTablero68 = new javax.swing.JButton();
        btnTablero69 = new javax.swing.JButton();
        btnTablero70 = new javax.swing.JButton();
        btnTablero71 = new javax.swing.JButton();
        btnTablero72 = new javax.swing.JButton();
        btnTablero73 = new javax.swing.JButton();
        btnTablero74 = new javax.swing.JButton();
        btnTablero75 = new javax.swing.JButton();
        btnTablero76 = new javax.swing.JButton();
        btnTablero77 = new javax.swing.JButton();
        btnTablero78 = new javax.swing.JButton();
        btnTablero55 = new javax.swing.JButton();
        btnTablero79 = new javax.swing.JButton();
        btnTablero80 = new javax.swing.JButton();
        btnTablero81 = new javax.swing.JButton();
        btnTablero82 = new javax.swing.JButton();
        btnTablero83 = new javax.swing.JButton();
        btnTablero84 = new javax.swing.JButton();
        btnTablero85 = new javax.swing.JButton();
        btnTablero86 = new javax.swing.JButton();
        btnTablero87 = new javax.swing.JButton();
        btnTablero88 = new javax.swing.JButton();
        btnTablero89 = new javax.swing.JButton();
        btnTablero90 = new javax.swing.JButton();
        btnTablero91 = new javax.swing.JButton();
        btnTablero92 = new javax.swing.JButton();
        btnTablero93 = new javax.swing.JButton();
        btnTablero94 = new javax.swing.JButton();
        btnTablero95 = new javax.swing.JButton();
        btnTablero96 = new javax.swing.JButton();
        btnTablero97 = new javax.swing.JButton();
        btnTablero98 = new javax.swing.JButton();
        btnTablero99 = new javax.swing.JButton();
        btnTablero100 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridLayout(10, 10));
        jPanel2.add(btnTablero1);
        jPanel2.add(btnTablero2);
        jPanel2.add(btnTablero3);
        jPanel2.add(btnTablero4);
        jPanel2.add(btnTablero5);
        jPanel2.add(btnTablero6);
        jPanel2.add(btnTablero7);
        jPanel2.add(btnTablero8);
        jPanel2.add(btnTablero9);
        jPanel2.add(btnTablero10);
        jPanel2.add(btnTablero11);
        jPanel2.add(btnTablero12);
        jPanel2.add(btnTablero13);
        jPanel2.add(btnTablero14);
        jPanel2.add(btnTablero15);
        jPanel2.add(btnTablero16);
        jPanel2.add(btnTablero17);
        jPanel2.add(btnTablero18);
        jPanel2.add(btnTablero19);
        jPanel2.add(btnTablero20);
        jPanel2.add(btnTablero21);
        jPanel2.add(btnTablero22);
        jPanel2.add(btnTablero23);
        jPanel2.add(btnTablero24);
        jPanel2.add(btnTablero25);
        jPanel2.add(btnTablero26);
        jPanel2.add(btnTablero27);
        jPanel2.add(btnTablero28);
        jPanel2.add(btnTablero29);
        jPanel2.add(btnTablero30);
        jPanel2.add(btnTablero31);
        jPanel2.add(btnTablero32);
        jPanel2.add(btnTablero33);
        jPanel2.add(btnTablero34);
        jPanel2.add(btnTablero35);
        jPanel2.add(btnTablero36);
        jPanel2.add(btnTablero37);
        jPanel2.add(btnTablero38);
        jPanel2.add(btnTablero39);
        jPanel2.add(btnTablero40);
        jPanel2.add(btnTablero41);
        jPanel2.add(btnTablero42);
        jPanel2.add(btnTablero44);
        jPanel2.add(btnTablero45);
        jPanel2.add(btnTablero46);
        jPanel2.add(btnTablero47);
        jPanel2.add(btnTablero48);
        jPanel2.add(btnTablero49);
        jPanel2.add(btnTablero50);
        jPanel2.add(btnTablero51);
        jPanel2.add(btnTablero52);
        jPanel2.add(btnTablero53);
        jPanel2.add(btnTablero43);
        jPanel2.add(btnTablero54);
        jPanel2.add(btnTablero56);
        jPanel2.add(btnTablero57);
        jPanel2.add(btnTablero58);
        jPanel2.add(btnTablero59);
        jPanel2.add(btnTablero60);
        jPanel2.add(btnTablero61);
        jPanel2.add(btnTablero62);
        jPanel2.add(btnTablero63);
        jPanel2.add(btnTablero64);
        jPanel2.add(btnTablero65);
        jPanel2.add(btnTablero66);
        jPanel2.add(btnTablero67);
        jPanel2.add(btnTablero68);
        jPanel2.add(btnTablero69);
        jPanel2.add(btnTablero70);
        jPanel2.add(btnTablero71);
        jPanel2.add(btnTablero72);
        jPanel2.add(btnTablero73);
        jPanel2.add(btnTablero74);
        jPanel2.add(btnTablero75);
        jPanel2.add(btnTablero76);
        jPanel2.add(btnTablero77);
        jPanel2.add(btnTablero78);
        jPanel2.add(btnTablero55);
        jPanel2.add(btnTablero79);
        jPanel2.add(btnTablero80);
        jPanel2.add(btnTablero81);
        jPanel2.add(btnTablero82);
        jPanel2.add(btnTablero83);
        jPanel2.add(btnTablero84);
        jPanel2.add(btnTablero85);
        jPanel2.add(btnTablero86);
        jPanel2.add(btnTablero87);
        jPanel2.add(btnTablero88);
        jPanel2.add(btnTablero89);
        jPanel2.add(btnTablero90);
        jPanel2.add(btnTablero91);
        jPanel2.add(btnTablero92);
        jPanel2.add(btnTablero93);
        jPanel2.add(btnTablero94);
        jPanel2.add(btnTablero95);
        jPanel2.add(btnTablero96);
        jPanel2.add(btnTablero97);
        jPanel2.add(btnTablero98);
        jPanel2.add(btnTablero99);
        jPanel2.add(btnTablero100);

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
    private javax.swing.JButton btnTablero1;
    private javax.swing.JButton btnTablero10;
    private javax.swing.JButton btnTablero100;
    private javax.swing.JButton btnTablero11;
    private javax.swing.JButton btnTablero12;
    private javax.swing.JButton btnTablero13;
    private javax.swing.JButton btnTablero14;
    private javax.swing.JButton btnTablero15;
    private javax.swing.JButton btnTablero16;
    private javax.swing.JButton btnTablero17;
    private javax.swing.JButton btnTablero18;
    private javax.swing.JButton btnTablero19;
    private javax.swing.JButton btnTablero2;
    private javax.swing.JButton btnTablero20;
    private javax.swing.JButton btnTablero21;
    private javax.swing.JButton btnTablero22;
    private javax.swing.JButton btnTablero23;
    private javax.swing.JButton btnTablero24;
    private javax.swing.JButton btnTablero25;
    private javax.swing.JButton btnTablero26;
    private javax.swing.JButton btnTablero27;
    private javax.swing.JButton btnTablero28;
    private javax.swing.JButton btnTablero29;
    private javax.swing.JButton btnTablero3;
    private javax.swing.JButton btnTablero30;
    private javax.swing.JButton btnTablero31;
    private javax.swing.JButton btnTablero32;
    private javax.swing.JButton btnTablero33;
    private javax.swing.JButton btnTablero34;
    private javax.swing.JButton btnTablero35;
    private javax.swing.JButton btnTablero36;
    private javax.swing.JButton btnTablero37;
    private javax.swing.JButton btnTablero38;
    private javax.swing.JButton btnTablero39;
    private javax.swing.JButton btnTablero4;
    private javax.swing.JButton btnTablero40;
    private javax.swing.JButton btnTablero41;
    private javax.swing.JButton btnTablero42;
    private javax.swing.JButton btnTablero43;
    private javax.swing.JButton btnTablero44;
    private javax.swing.JButton btnTablero45;
    private javax.swing.JButton btnTablero46;
    private javax.swing.JButton btnTablero47;
    private javax.swing.JButton btnTablero48;
    private javax.swing.JButton btnTablero49;
    private javax.swing.JButton btnTablero5;
    private javax.swing.JButton btnTablero50;
    private javax.swing.JButton btnTablero51;
    private javax.swing.JButton btnTablero52;
    private javax.swing.JButton btnTablero53;
    private javax.swing.JButton btnTablero54;
    private javax.swing.JButton btnTablero55;
    private javax.swing.JButton btnTablero56;
    private javax.swing.JButton btnTablero57;
    private javax.swing.JButton btnTablero58;
    private javax.swing.JButton btnTablero59;
    private javax.swing.JButton btnTablero6;
    private javax.swing.JButton btnTablero60;
    private javax.swing.JButton btnTablero61;
    private javax.swing.JButton btnTablero62;
    private javax.swing.JButton btnTablero63;
    private javax.swing.JButton btnTablero64;
    private javax.swing.JButton btnTablero65;
    private javax.swing.JButton btnTablero66;
    private javax.swing.JButton btnTablero67;
    private javax.swing.JButton btnTablero68;
    private javax.swing.JButton btnTablero69;
    private javax.swing.JButton btnTablero7;
    private javax.swing.JButton btnTablero70;
    private javax.swing.JButton btnTablero71;
    private javax.swing.JButton btnTablero72;
    private javax.swing.JButton btnTablero73;
    private javax.swing.JButton btnTablero74;
    private javax.swing.JButton btnTablero75;
    private javax.swing.JButton btnTablero76;
    private javax.swing.JButton btnTablero77;
    private javax.swing.JButton btnTablero78;
    private javax.swing.JButton btnTablero79;
    private javax.swing.JButton btnTablero8;
    private javax.swing.JButton btnTablero80;
    private javax.swing.JButton btnTablero81;
    private javax.swing.JButton btnTablero82;
    private javax.swing.JButton btnTablero83;
    private javax.swing.JButton btnTablero84;
    private javax.swing.JButton btnTablero85;
    private javax.swing.JButton btnTablero86;
    private javax.swing.JButton btnTablero87;
    private javax.swing.JButton btnTablero88;
    private javax.swing.JButton btnTablero89;
    private javax.swing.JButton btnTablero9;
    private javax.swing.JButton btnTablero90;
    private javax.swing.JButton btnTablero91;
    private javax.swing.JButton btnTablero92;
    private javax.swing.JButton btnTablero93;
    private javax.swing.JButton btnTablero94;
    private javax.swing.JButton btnTablero95;
    private javax.swing.JButton btnTablero96;
    private javax.swing.JButton btnTablero97;
    private javax.swing.JButton btnTablero98;
    private javax.swing.JButton btnTablero99;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
