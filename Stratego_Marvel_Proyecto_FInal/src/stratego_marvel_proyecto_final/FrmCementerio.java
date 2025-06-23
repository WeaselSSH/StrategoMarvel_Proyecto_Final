package stratego_marvel_proyecto_final;

import javax.swing.ImageIcon;

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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblBueno = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblMalo = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("HEROES DERROTADOS");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel3.setText("CEMENTERIO");

        jLabel4.setText("VILLANOS DERROTADOS");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(80, 80, 80))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(208, 208, 208))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblBueno;
    private javax.swing.JTable tblMalo;
    // End of variables declaration//GEN-END:variables
}
