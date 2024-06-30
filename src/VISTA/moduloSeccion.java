package VISTA;

import CONTROLADOR.ControladorSeccion;

public class moduloSeccion extends javax.swing.JPanel {

    ControladorSeccion controlador;

    public moduloSeccion() {
        initComponents();
        controlador = new ControladorSeccion(this);
        controlador.initDiseño();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new COMPONET.ScrollPaneWin11();
        tablaSecciones = new COMPONET.Tabla();
        panel2 = new COMPONET.Panel();
        panel13 = new COMPONET.Panel();
        jLabel13 = new javax.swing.JLabel();
        comboSeccion = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        panel14 = new COMPONET.Panel();
        jLabel14 = new javax.swing.JLabel();
        comboGrado = new COMPONET.ComboBoxSuggestion();
        panel15 = new COMPONET.Panel();
        jLabel15 = new javax.swing.JLabel();
        comboDivision = new COMPONET.ComboBoxSuggestion();
        panel16 = new COMPONET.Panel();
        jLabel16 = new javax.swing.JLabel();
        comboTutor = new COMPONET.ComboBoxSuggestion();
        panel17 = new COMPONET.Panel();
        jLabel17 = new javax.swing.JLabel();
        comboAula = new COMPONET.ComboBoxSuggestion();
        panel18 = new COMPONET.Panel();
        jLabel18 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        comboFecha = new javax.swing.JTextField();
        panel3 = new COMPONET.Panel();
        btnLimpiar = new COMPONET.Button();
        btnActualizar = new COMPONET.Button();
        btnRegistrar = new COMPONET.Button();
        btnEliminar = new COMPONET.Button();
        jPanel1 = new javax.swing.JPanel();
        btnAcendente = new javax.swing.JRadioButton();
        btnDesendente = new javax.swing.JRadioButton();
        comboColumnas = new COMPONET.ComboBoxSuggestion();

        setBackground(MODELO.Config.C1);

        jLabel1.setFont(new java.awt.Font("Century", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SECCION");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        tablaSecciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "N", "Seccion", "Grado", "Division", "Tutor", "Aula", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaSecciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaSeccionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaSecciones);
        if (tablaSecciones.getColumnModel().getColumnCount() > 0) {
            tablaSecciones.getColumnModel().getColumn(0).setMinWidth(70);
            tablaSecciones.getColumnModel().getColumn(0).setPreferredWidth(70);
            tablaSecciones.getColumnModel().getColumn(0).setMaxWidth(70);
        }

        panel2.setBackground(new java.awt.Color(255, 255, 255));
        panel2.setRoundBottomLeft(20);
        panel2.setRoundBottomRight(20);
        panel2.setRoundTopLeft(20);
        panel2.setRoundTopRight(20);

        panel13.setBackground(new java.awt.Color(255, 255, 255));
        panel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        jLabel13.setText("Seccion");
        panel13.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 137, -1));

        comboSeccion.setEditable(false);
        comboSeccion.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        comboSeccion.setSelectionColor(new java.awt.Color(0, 44, 73));
        comboSeccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                comboSeccionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                comboSeccionKeyTyped(evt);
            }
        });
        panel13.add(comboSeccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 160, 30));
        panel13.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 160, 10));

        panel14.setBackground(new java.awt.Color(255, 255, 255));
        panel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        jLabel14.setText("Grado");
        panel14.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 137, -1));

        comboGrado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1ro", "2do", "3ro", "4to", "5to", "6to" }));
        comboGrado.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        panel14.add(comboGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 150, -1));

        panel15.setBackground(new java.awt.Color(255, 255, 255));
        panel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        jLabel15.setText("Division");
        panel15.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 137, -1));

        comboDivision.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" }));
        comboDivision.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        panel15.add(comboDivision, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 150, -1));

        panel16.setBackground(new java.awt.Color(255, 255, 255));
        panel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        jLabel16.setText("Tutor");
        panel16.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 137, -1));

        comboTutor.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        panel16.add(comboTutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 150, -1));

        panel17.setBackground(new java.awt.Color(255, 255, 255));
        panel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        jLabel17.setText("# Aula");
        panel17.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 137, -1));

        comboAula.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100" }));
        comboAula.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        panel17.add(comboAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 150, -1));

        panel18.setBackground(new java.awt.Color(255, 255, 255));
        panel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        jLabel18.setText("Fecha");
        panel18.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 137, -1));
        panel18.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 160, 10));

        comboFecha.setEditable(false);
        comboFecha.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        comboFecha.setSelectionColor(new java.awt.Color(0, 44, 73));
        comboFecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                comboFechaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                comboFechaKeyTyped(evt);
            }
        });
        panel18.add(comboFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 160, 30));

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(panel14, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 37, Short.MAX_VALUE)
                        .addComponent(panel16, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 37, Short.MAX_VALUE)
                        .addComponent(panel18, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(panel13, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panel15, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panel17, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel13, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel15, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel17, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        panel3.setBackground(new java.awt.Color(255, 255, 255));
        panel3.setRoundBottomLeft(20);
        panel3.setRoundBottomRight(20);
        panel3.setRoundTopLeft(20);
        panel3.setRoundTopRight(20);

        btnLimpiar.setBackground(MODELO.Config.C5);
        btnLimpiar.setForeground(new java.awt.Color(0, 0, 0));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setCurrentCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        btnLimpiar.setShadowColor(new java.awt.Color(0, 0, 0));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(MODELO.Config.C5);
        btnActualizar.setForeground(new java.awt.Color(0, 0, 0));
        btnActualizar.setText("Actualizar");
        btnActualizar.setCurrentCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        btnActualizar.setShadowColor(new java.awt.Color(0, 0, 0));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnRegistrar.setBackground(MODELO.Config.C5);
        btnRegistrar.setForeground(new java.awt.Color(0, 0, 0));
        btnRegistrar.setText("Registrar");
        btnRegistrar.setCurrentCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        btnRegistrar.setShadowColor(new java.awt.Color(0, 0, 0));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(MODELO.Config.C5);
        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setText("Eliminar");
        btnEliminar.setCurrentCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        btnEliminar.setShadowColor(new java.awt.Color(0, 0, 0));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnAcendente.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(btnAcendente);
        btnAcendente.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnAcendente.setText("Ascendente");
        btnAcendente.setFocusPainted(false);

        btnDesendente.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(btnDesendente);
        btnDesendente.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnDesendente.setText("Descendente");
        btnDesendente.setFocusPainted(false);

        comboColumnas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "N", "Seccion", "Grado", "Division", "Tutor", "Aula", "Fecha" }));
        comboColumnas.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        comboColumnas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboColumnasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDesendente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAcendente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(comboColumnas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboColumnas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAcendente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDesendente)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(35, 35, 35)
                        .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        controlador.limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        controlador.actualizar();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        controlador.registrar();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        controlador.borrar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tablaSeccionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaSeccionesMouseClicked
        controlador.tablaSeccionesMouseClicked();
    }//GEN-LAST:event_tablaSeccionesMouseClicked

    private void comboSeccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboSeccionKeyReleased
        
    }//GEN-LAST:event_comboSeccionKeyReleased

    private void comboSeccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboSeccionKeyTyped
        
    }//GEN-LAST:event_comboSeccionKeyTyped

    private void comboFechaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboFechaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_comboFechaKeyReleased

    private void comboFechaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboFechaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_comboFechaKeyTyped

    private void comboColumnasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboColumnasActionPerformed
        controlador.ordenar();
    }//GEN-LAST:event_comboColumnasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JRadioButton btnAcendente;
    public COMPONET.Button btnActualizar;
    public javax.swing.JRadioButton btnDesendente;
    public COMPONET.Button btnEliminar;
    public COMPONET.Button btnLimpiar;
    public COMPONET.Button btnRegistrar;
    public javax.swing.ButtonGroup buttonGroup1;
    public COMPONET.ComboBoxSuggestion comboAula;
    public COMPONET.ComboBoxSuggestion comboColumnas;
    public COMPONET.ComboBoxSuggestion comboDivision;
    public javax.swing.JTextField comboFecha;
    public COMPONET.ComboBoxSuggestion comboGrado;
    public javax.swing.JTextField comboSeccion;
    public COMPONET.ComboBoxSuggestion comboTutor;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel13;
    public javax.swing.JLabel jLabel14;
    public javax.swing.JLabel jLabel15;
    public javax.swing.JLabel jLabel16;
    public javax.swing.JLabel jLabel17;
    public javax.swing.JLabel jLabel18;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JSeparator jSeparator1;
    public javax.swing.JSeparator jSeparator2;
    public COMPONET.Panel panel13;
    public COMPONET.Panel panel14;
    public COMPONET.Panel panel15;
    public COMPONET.Panel panel16;
    public COMPONET.Panel panel17;
    public COMPONET.Panel panel18;
    public COMPONET.Panel panel2;
    public COMPONET.Panel panel3;
    public COMPONET.Tabla tablaSecciones;
    // End of variables declaration//GEN-END:variables
}
