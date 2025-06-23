package stratego_marvel_proyecto_final;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableCellRenderer;

public class FrmCementerio extends javax.swing.JFrame {

    private Ficha fichasDerrotadasBuenos[];
    private int cantidadDerrotadasBuenos;

    private Ficha fichasDerrotadasMalos[];
    private int cantidadDerrotadasMalos;

    public FrmCementerio(Ficha buenos[], int cantBuenos, Ficha malos[], int cantMalos) {
        initComponents();
        this.fichasDerrotadasBuenos = buenos;
        this.cantidadDerrotadasBuenos = cantBuenos;
        this.fichasDerrotadasMalos = malos;
        this.cantidadDerrotadasMalos = cantMalos;
        configurarModelo();
        llenarTablas();
    }

    private void configurarModelo() {
        tblBueno.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"Rango", "Nombre"}
        ));

        tblMalo.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"Rango", "Nombre"}
        ));
    }

    private void llenarTablas() {
        javax.swing.table.DefaultTableModel modeloBuenos = (javax.swing.table.DefaultTableModel) tblBueno.getModel();
        javax.swing.table.DefaultTableModel modeloMalos = (javax.swing.table.DefaultTableModel) tblMalo.getModel();

        for (int i = 0; i < cantidadDerrotadasBuenos; i++) {
            Ficha ficha = fichasDerrotadasBuenos[i];
            modeloBuenos.addRow(new Object[]{ficha.getRango(), obtenerNombre(ficha.getRutaImagen())});
        }

        for (int i = 0; i < cantidadDerrotadasMalos; i++) {
            Ficha ficha = fichasDerrotadasMalos[i];
            modeloMalos.addRow(new Object[]{ficha.getRango(), obtenerNombre(ficha.getRutaImagen())});
        }
    }

    private String obtenerNombre(String ruta) {
        String nombre = ruta.substring(ruta.lastIndexOf("/") + 1, ruta.lastIndexOf("."));
        nombre = nombre.replace("_", " ");
        return nombre.substring(0, 1).toUpperCase() + nombre.substring(1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblBueno = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblMalo = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblBueno.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblBueno);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 270, -1));

        tblMalo.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tblMalo);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 270, -1));

        jLabel5.setFont(new java.awt.Font("Bangers", 1, 52)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CEMENTERIO");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 370, 40));

        jLabel6.setFont(new java.awt.Font("Bangers", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Heroes Derrotados");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 220, 40));

        jLabel7.setFont(new java.awt.Font("Bangers", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Villanos Derrotados");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 240, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/backgroundCementerio.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 660));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblBueno;
    private javax.swing.JTable tblMalo;
    // End of variables declaration//GEN-END:variables
}
