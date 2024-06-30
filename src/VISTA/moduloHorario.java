package VISTA;

import CONTROLADOR.ControladorHorario;

public class moduloHorario extends javax.swing.JPanel {

    ControladorHorario controlador;

    public moduloHorario() {
        initComponents();
        controlador = new ControladorHorario(this);
        controlador.initDiseño();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        panel1 = new COMPONET.Panel();
        panel6 = new COMPONET.Panel();
        jLabel7 = new javax.swing.JLabel();
        comboSeccion = new COMPONET.Combobox();
        panel7 = new COMPONET.Panel();
        jLabel8 = new javax.swing.JLabel();
        comboRangoHorario = new COMPONET.Combobox();
        panel8 = new COMPONET.Panel();
        jLabel9 = new javax.swing.JLabel();
        comboCurso = new COMPONET.Combobox();
        panel9 = new COMPONET.Panel();
        jLabel10 = new javax.swing.JLabel();
        comboDia = new COMPONET.Combobox();
        jLabel3 = new javax.swing.JLabel();
        panel3 = new COMPONET.Panel();
        btnCursos = new COMPONET.Button();
        btnRegistrar = new COMPONET.Button();
        btnLimpiar = new COMPONET.Button();
        btnDescargar = new COMPONET.Button();
        panelHorario = new COMPONET.Panel();
        jScrollPane1 = new COMPONET.ScrollPaneWin11();
        tablaHorario = new COMPONET.Tabla();
        txtTituloHorario = new javax.swing.JLabel();
        txtDocente = new javax.swing.JLabel();

        setBackground(MODELO.Config.C1);

        jLabel1.setFont(new java.awt.Font("Century", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("HORARIO");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setRoundBottomLeft(15);
        panel1.setRoundBottomRight(15);
        panel1.setRoundTopLeft(15);
        panel1.setRoundTopRight(15);

        panel6.setBackground(new java.awt.Color(255, 255, 255));
        panel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        jLabel7.setText("Seccion");
        panel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 137, -1));

        comboSeccion.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        comboSeccion.setLabeText("");
        comboSeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSeccionActionPerformed(evt);
            }
        });
        panel6.add(comboSeccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 140, 40));

        panel7.setBackground(new java.awt.Color(255, 255, 255));
        panel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        jLabel8.setText("Rango Horario");
        panel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 137, -1));

        comboRangoHorario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "07:30 - 09:00", "09:00 - 10:30", "10:45 - 12:15", "12:15 - 13:45" }));
        comboRangoHorario.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        comboRangoHorario.setLabeText("");
        comboRangoHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboRangoHorarioActionPerformed(evt);
            }
        });
        panel7.add(comboRangoHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 140, 40));

        panel8.setBackground(new java.awt.Color(255, 255, 255));
        panel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        jLabel9.setText("Curso");
        panel8.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 137, -1));

        comboCurso.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        comboCurso.setLabeText("");
        panel8.add(comboCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 140, 40));

        panel9.setBackground(new java.awt.Color(255, 255, 255));
        panel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        jLabel10.setText("Dia");
        panel9.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 137, -1));

        comboDia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "lunes", "martes", "miercoles", "jueves", "viernes" }));
        comboDia.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        comboDia.setLabeText("");
        comboDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDiaActionPerformed(evt);
            }
        });
        panel9.add(comboDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 140, 40));

        jLabel3.setFont(new java.awt.Font("Century", 0, 40)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nuevo Horario");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        panel3.setBackground(new java.awt.Color(255, 255, 255));

        btnCursos.setBackground(MODELO.Config.C2);
        btnCursos.setForeground(new java.awt.Color(0, 0, 0));
        btnCursos.setText("Cursos");
        btnCursos.setCurrentCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCursos.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        btnCursos.setShadowColor(new java.awt.Color(0, 0, 0));
        btnCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCursosActionPerformed(evt);
            }
        });

        btnRegistrar.setBackground(MODELO.Config.C4);
        btnRegistrar.setForeground(new java.awt.Color(0, 0, 0));
        btnRegistrar.setText("Registar");
        btnRegistrar.setCurrentCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        btnRegistrar.setShadowColor(new java.awt.Color(0, 0, 0));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(MODELO.Config.C4);
        btnLimpiar.setForeground(new java.awt.Color(0, 0, 0));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setCurrentCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        btnLimpiar.setShadowColor(new java.awt.Color(0, 0, 0));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnDescargar.setBackground(MODELO.Config.C4);
        btnDescargar.setForeground(new java.awt.Color(0, 0, 0));
        btnDescargar.setText("Descargar");
        btnDescargar.setCurrentCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDescargar.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        btnDescargar.setShadowColor(new java.awt.Color(0, 0, 0));
        btnDescargar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDescargarMouseClicked(evt);
            }
        });
        btnDescargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDescargar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(btnCursos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDescargar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel6, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel8, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27))
            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel1Layout.createSequentialGroup()
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel1Layout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addComponent(jLabel3)
                    .addContainerGap(547, Short.MAX_VALUE)))
        );

        panelHorario.setBackground(new java.awt.Color(255, 255, 255));
        panelHorario.setRoundBottomLeft(15);
        panelHorario.setRoundBottomRight(15);
        panelHorario.setRoundTopLeft(15);
        panelHorario.setRoundTopRight(15);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tablaHorario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "HORA", "LUNES", "MARTES", "MIERCOLES", "JUEVES", "VIERNES"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaHorario.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tablaHorario.setGridColor(new java.awt.Color(255, 255, 255));
        tablaHorario.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tablaHorario.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tablaHorario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaHorarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaHorario);
        if (tablaHorario.getColumnModel().getColumnCount() > 0) {
            tablaHorario.getColumnModel().getColumn(0).setMinWidth(80);
            tablaHorario.getColumnModel().getColumn(0).setPreferredWidth(80);
            tablaHorario.getColumnModel().getColumn(0).setMaxWidth(80);
        }

        txtTituloHorario.setFont(new java.awt.Font("Century", 0, 48)); // NOI18N
        txtTituloHorario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTituloHorario.setText("Horario 0ro AZ");
        txtTituloHorario.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        txtDocente.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        txtDocente.setText("Docente: ");
        txtDocente.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout panelHorarioLayout = new javax.swing.GroupLayout(panelHorario);
        panelHorario.setLayout(panelHorarioLayout);
        panelHorarioLayout.setHorizontalGroup(
            panelHorarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHorarioLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
                .addGap(30, 30, 30))
            .addGroup(panelHorarioLayout.createSequentialGroup()
                .addComponent(txtTituloHorario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDocente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelHorarioLayout.setVerticalGroup(
            panelHorarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHorarioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelHorarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTituloHorario, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(txtDocente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(panelHorario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tablaHorarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaHorarioMouseClicked

    }//GEN-LAST:event_tablaHorarioMouseClicked

    private void btnCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCursosActionPerformed
        controlador.btnCursos();
    }//GEN-LAST:event_btnCursosActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        controlador.registrar();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        controlador.limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnDescargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescargarActionPerformed
        controlador.imageAvatar1MouseClicked(evt);
    }//GEN-LAST:event_btnDescargarActionPerformed

    private void comboSeccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSeccionActionPerformed
        controlador.selectCombo();
    }//GEN-LAST:event_comboSeccionActionPerformed

    private void comboRangoHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboRangoHorarioActionPerformed
        controlador.selectCelda();
    }//GEN-LAST:event_comboRangoHorarioActionPerformed

    private void comboDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDiaActionPerformed
        controlador.selectCelda();
    }//GEN-LAST:event_comboDiaActionPerformed

    private void btnDescargarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDescargarMouseClicked

    }//GEN-LAST:event_btnDescargarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public COMPONET.Button btnCursos;
    public COMPONET.Button btnDescargar;
    public COMPONET.Button btnLimpiar;
    public COMPONET.Button btnRegistrar;
    public COMPONET.Combobox comboCurso;
    public COMPONET.Combobox comboDia;
    public COMPONET.Combobox comboRangoHorario;
    public COMPONET.Combobox comboSeccion;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JScrollPane jScrollPane1;
    public COMPONET.Panel panel1;
    public COMPONET.Panel panel3;
    public COMPONET.Panel panel6;
    public COMPONET.Panel panel7;
    public COMPONET.Panel panel8;
    public COMPONET.Panel panel9;
    public COMPONET.Panel panelHorario;
    public COMPONET.Tabla tablaHorario;
    public javax.swing.JLabel txtDocente;
    public javax.swing.JLabel txtTituloHorario;
    // End of variables declaration//GEN-END:variables
}
