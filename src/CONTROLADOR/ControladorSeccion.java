package CONTROLADOR;

import DATA.DataSeccion;
import MODELO.MetodosOrdenamiento;
import MODELO.Proceso;
import MODELO.Seccion;
import VISTA.moduloSeccion;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class ControladorSeccion {

    moduloSeccion s;
    DataSeccion data;

    public ControladorSeccion(moduloSeccion s) {
        this.s = s;
        data = new DataSeccion();
    }

    public void initDiseño() {
//        dao.rellenarCombo(s.comboGrado, "grados", "idGrado");
//        dao.rellenarCombo(s.comboTutor, "docentes", "codigo");
        limpiar();
        selectButtons();
        Proceso.transparentarTxtField(s.comboSeccion);
        Proceso.transparentarTxtField(s.comboFecha);
    }

    public void consultar() {
//        dao.consultar(s.tablaSecciones);
//        initCombosFiltros();
//        eventoFiltrando(s.comboAula, s.comboDivision, s.comboFecha, s.comboGrado, s.comboSeccion, s.comboTutor);
        data.consultar(s.tablaSecciones);
    }

    /**
     * *
     * activo prueba suspendido
     */
    private void initCombos() {
        s.comboTutor.removeAllItems();
        for (int i = 0; i < new DATA.DataDocente().getConsultar(0).size(); i++) {
            String estadoDocente = new DATA.DataDocente().getConsultar(5).get(i).toString();
            if (estadoDocente.equalsIgnoreCase("activo") || estadoDocente.equalsIgnoreCase("prueba")) {
                Object codDocente = new DATA.DataDocente().getConsultar(0).get(i).toString();
                s.comboTutor.addItem(codDocente);
            }
        }
    }

//
//    private void initCombosFiltros() {
//        dao.rellenarComboFiltros(s.filtroComboSeccion, "secciones", "idSeccion");
//        dao.rellenarComboFiltros(s.filtroComboGrado, "secciones", "grado");
//        dao.rellenarComboFiltros(s.filtroComboDivision, "secciones", "division");
//        dao.rellenarComboFiltros(s.filtroComboTutor, "secciones", "tutor");
//        dao.rellenarComboFiltros(s.filtroComboAula, "secciones", "aula");
//        dao.rellenarComboFiltros(s.filtroComboFecha, "secciones", "fecha");
//    }
    public void limpiar() {
        initCombos();
        s.comboGrado.setSelectedIndex(0);
        s.comboDivision.setSelectedIndex(0);
        s.comboFecha.setText(Proceso.obtenerFechaActual().toString());
//        s.comboTutor.setSelectedIndex(0);
        s.comboAula.setSelectedIndex(0);
        consultar();
        filaSeleccionada = -1;
        s.tablaSecciones.clearSelection();
        s.comboGrado.setEnabled(true);
        s.comboDivision.setEnabled(true);
        s.comboAula.setEnabled(true);
    }

    public void registrar() {
        int msj = JOptionPane.YES_NO_OPTION;
        int confi = JOptionPane.showConfirmDialog(null, "Confirmar registro", "Confirmacion", msj);
        if (confi == 0) {
            try {
                String grado = s.comboGrado.getSelectedItem().toString();
                String division = s.comboDivision.getSelectedItem().toString();
                String tutor = s.comboTutor.getSelectedItem().toString();
                String aula = s.comboAula.getSelectedItem().toString();
                Date fecha = Proceso.obtenerFechaActual();
                String idSeccion = generarCodigo(division, aula, grado);
                Seccion seccion = new Seccion(idSeccion, tutor, grado, aula, division, fecha);
                data.registrar(seccion);
                limpiar();
            } catch (java.lang.ClassCastException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }

    }

    public void actualizar() {
        if (filaSeleccionada >= 0) {
            int mesj = JOptionPane.YES_NO_OPTION;
            int confir = JOptionPane.showConfirmDialog(null, "Confirmar modificacion", "Error", mesj);
            if (confir == 0) {
                String idSeccion = Proceso.datoFilaColumna(s.tablaSecciones, filaSeleccionada, "seccion").toString();
                String tutor = s.comboTutor.getSelectedItem().toString();
                String grado = s.comboGrado.getSelectedItem().toString();
                String division = s.comboDivision.getSelectedItem().toString();
                String aula = s.comboAula.getSelectedItem().toString();
                Date fecha = Proceso.obtenerFechaActual();
                Seccion seccion = new Seccion(idSeccion, tutor, grado, aula, division, fecha);
                data.actualizar(seccion);
                limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void borrar() {
        if (filaSeleccionada >= 0) {
            int mesj = JOptionPane.YES_NO_OPTION;
            int confir = JOptionPane.showConfirmDialog(null, "Confirmar eliminacion", "Error", mesj);
            if (confir == 0) {
                String idSeccion = Proceso.datoFilaColumna(s.tablaSecciones, filaSeleccionada, "seccion").toString();
                data.borrar(idSeccion);
                limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String generarCodigo(String division, String aula, String grado) {
        return grado + division + String.format("%02d", Integer.valueOf(aula));
    }

    int filaSeleccionada = -1;

    public void tablaSeccionesMouseClicked() {
        filaSeleccionada = s.tablaSecciones.getSelectedRow();
        String idSeccion = Proceso.datoFilaColumna(s.tablaSecciones, filaSeleccionada, "seccion").toString();
        String fecha = Proceso.datoFilaColumna(s.tablaSecciones, filaSeleccionada, "fecha").toString();
        String grado = Proceso.datoFilaColumna(s.tablaSecciones, filaSeleccionada, "grado").toString();
        String division = Proceso.datoFilaColumna(s.tablaSecciones, filaSeleccionada, "division").toString();
        String tutor = Proceso.datoFilaColumna(s.tablaSecciones, filaSeleccionada, "tutor").toString();
        String aula = Proceso.datoFilaColumna(s.tablaSecciones, filaSeleccionada, "aula").toString();
        s.comboSeccion.setText(idSeccion);
        s.comboFecha.setText(fecha);
        s.comboGrado.setSelectedItem(grado);
        s.comboDivision.setSelectedItem(division);
        s.comboTutor.setSelectedItem(tutor);
        s.comboAula.setSelectedItem(aula);
//        s.comboGrado.setEnabled(false);
//        s.comboDivision.setEnabled(false);
//        s.comboAula.setEnabled(false);
    }

//
//    private HashMap<String, String> hash() {
//        HashMap<String, String> datos = new HashMap<>();
//        datos.put("idSeccion", Proceso.evitarNulo(s.comboSeccion.getSelectedItem()));
//        datos.put("aula", Proceso.evitarNulo(s.comboAula.getSelectedItem()));
//        datos.put("division", Proceso.evitarNulo(s.comboDivision.getSelectedItem()));
//        datos.put("fecha", Proceso.evitarNulo(s.comboFecha.getSelectedItem()));
//        datos.put("grado", Proceso.evitarNulo(s.comboGrado.getSelectedItem()));
//        datos.put("tutor", Proceso.evitarNulo(s.comboTutor.getSelectedItem()));
//        return datos;
//    }
    private void filtrar() {
//        dao.filtroAvanzado(s.tablaSecciones, hash());
    }

    private void eventoFiltrando(JComboBox... combo) {
        for (JComboBox c : combo) {
            c.addActionListener((java.awt.event.ActionEvent evt) -> {
                filtrar();
            });

        }
    }

    public void ordenar() {
        int columna = s.comboColumnas.getSelectedIndex();
        MetodosOrdenamiento.ordenarPorColumna(s.tablaSecciones, columna, ascendente);
    }

    boolean ascendente = true;

    private void selectButtons() {
        Enumeration<AbstractButton> buttons = s.buttonGroup1.getElements();
        while (buttons.hasMoreElements()) {
            AbstractButton button = buttons.nextElement();
            button.addActionListener((ActionEvent e) -> {
                if (button.isSelected()) {
//                System.out.println("Selected RadioButton: " + button.getActionCommand());
                    String nombreBoton = button.getText();
                    if (nombreBoton.equalsIgnoreCase("ascendente")) {
                        ascendente = true;
                    } else if (nombreBoton.equalsIgnoreCase("descendente")) {
                        ascendente = false;
                    }
                    ordenar();
//                    seleccionado = button.getText();
                }
            });
        }
    }

}
