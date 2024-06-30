package VISTA;

import CONTROLADOR.ControladorBuscarAlumno;
import MODELO.Proceso;

public class panelBuscarAlumno extends javax.swing.JPanel {

    String codigo;
    ControladorBuscarAlumno controlador;
    public panelBuscarAlumno() {
        initComponents();
        controlador = new ControladorBuscarAlumno(this);
        controlador.initDiseno();
    }

    public String getCodigo() {
        return codigo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new COMPONET.ScrollPaneWin11();
        tablaAlumno = new COMPONET.Tabla();
        panel14 = new COMPONET.Panel();
        jLabel14 = new javax.swing.JLabel();
        comboDniEstudiante = new COMPONET.ComboBoxSuggestion();
        btnBuscar = new COMPONET.Button();

        setBackground(new java.awt.Color(255, 255, 255));

        tablaAlumno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Dni", "Nombre", "Apellido", "Apoderado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaAlumnoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaAlumno);

        panel14.setBackground(new java.awt.Color(255, 255, 255));
        panel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        jLabel14.setText("Dni");
        panel14.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 137, -1));

        comboDniEstudiante.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        comboDniEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDniEstudianteActionPerformed(evt);
            }
        });
        panel14.add(comboDniEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 150, -1));

        btnBuscar.setBackground(MODELO.Config.C5);
        btnBuscar.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscar.setText("Buscar");
        btnBuscar.setCurrentCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btnBuscar.setShadowColor(new java.awt.Color(0, 0, 0));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        panel14.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 174, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panel14, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(panel14, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tablaAlumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAlumnoMouseClicked
        codigo = Proceso.datoFilaColumna(tablaAlumno, tablaAlumno.getSelectedRow(), "codigo").toString();
    }//GEN-LAST:event_tablaAlumnoMouseClicked

    private void comboDniEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDniEstudianteActionPerformed
        
    }//GEN-LAST:event_comboDniEstudianteActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        controlador.selectComboDniEstudiante();
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public COMPONET.Button btnBuscar;
    public COMPONET.ComboBoxSuggestion comboDniEstudiante;
    public javax.swing.JLabel jLabel14;
    public javax.swing.JScrollPane jScrollPane1;
    public COMPONET.Panel panel14;
    public COMPONET.Tabla tablaAlumno;
    // End of variables declaration//GEN-END:variables
}
