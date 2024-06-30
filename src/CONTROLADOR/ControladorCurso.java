package CONTROLADOR;

import DATA.DataCurso;
import MODELO.Curso;
import MODELO.Proceso;
import VISTA.moduloCursos;
import java.awt.Color;
import javax.swing.JOptionPane;

public class ControladorCurso {

    moduloCursos c;
    DataCurso data;

    public ControladorCurso(moduloCursos c) {
        this.c = c;
        data = new DataCurso();
    }

    public void initDiseño() {
        Proceso.transparentarTxtField(c.txtNombreCurso);
        Proceso.transparentarTxtField(c.txtFecha);
        Proceso.transparentarTxtField(c.txtIDCurso);
        limpiar();
    }

    public void consultar() {
        data.consultar(c.tabla1);
    }

    private void rellenarComboIDDocente() {
        c.comboDocente.removeAllItems();
        for (int i = 0; i < new DATA.DataDocente().getConsultar(0).size(); i++) {
            String estadoDocente = new DATA.DataDocente().getConsultar(5).get(i).toString();
            if (estadoDocente.equalsIgnoreCase("activo") || estadoDocente.equalsIgnoreCase("prueba")) {
                Object codDocente = new DATA.DataDocente().getConsultar(0).get(i).toString();
                c.comboDocente.addItem(codDocente);
            }
        }
    }

    public void registrar() {
        int config = JOptionPane.YES_NO_OPTION;
        int dialog = JOptionPane.showConfirmDialog(null, "Confirmar registro", "Confirmacion", config);
        if (dialog == 0) {
            String nombreCurso = c.txtNombreCurso.getText();
            if (!nombreCurso.equals("")) {
                String idActualCurso = getIdActual();
                String idProfesor = c.comboDocente.getSelectedItem().toString();
                Curso curso = new Curso(idActualCurso, nombreCurso, idProfesor, Proceso.obtenerFechaActual());
                data.registrar(curso);
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese el nombre del curso", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void editar() {
        if (filaSeleccionada >= 0) {
            int config = JOptionPane.YES_NO_OPTION;
            int dialog = JOptionPane.showConfirmDialog(null, "Confirmar registro", "Confirmacion", config);
            if (dialog == 0) {
                String nombreCurso = c.txtNombreCurso.getText();
                if (!nombreCurso.equals("")) {
                    String idActualCurso = Proceso.datoFilaColumna(c.tabla1, filaSeleccionada, "ID").toString();
                    String idProfesor = c.comboDocente.getSelectedItem().toString();
                    Curso curso = new Curso(idActualCurso, nombreCurso, idProfesor, Proceso.obtenerFechaActual());
                    data.actualizar(curso);
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese el nombre del curso", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminar() {
        if (filaSeleccionada >= 0) {
            int config = JOptionPane.YES_NO_OPTION;
            int dialog = JOptionPane.showConfirmDialog(null, "Confirmar eliminacion", "Confirmacion", config);
            if (dialog == 0) {
                String idActualCurso = Proceso.datoFilaColumna(c.tabla1, filaSeleccionada, "ID").toString();
                data.borrar(idActualCurso);
                limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    int filaSeleccionada = -1;

    public void clickTabla() {
        filaSeleccionada = c.tabla1.getSelectedRow();
        String idCurso = Proceso.datoFilaColumna(c.tabla1, filaSeleccionada, "ID").toString();
        String nombreCurso = Proceso.datoFilaColumna(c.tabla1, filaSeleccionada, "curso").toString();
        String idDocente = Proceso.datoFilaColumna(c.tabla1, filaSeleccionada, "profesor").toString();
        String fecha = Proceso.datoFilaColumna(c.tabla1, filaSeleccionada, "fecha").toString();
        c.txtIDCurso.setText(idCurso);
        c.txtNombreCurso.setText(nombreCurso);
        c.comboDocente.setSelectedItem(idDocente);
        c.txtFecha.setText(fecha);

    }

    private int ID_ACTUAL() {
        try {
            int idActual = 0;
            for (Object id : new DATA.DataCurso().getConsultar(0)) {
                idActual = Integer.parseInt(id.toString());
            }
            return idActual;
        } catch (NumberFormatException e) {
            System.out.println("ERROR: " + e.getMessage());
            return 0;
        }
    }

    private String getIdActual() {
        int valorActualId = ID_ACTUAL() + 1;
        String nuevaID = String.format("%08d", valorActualId);
        return nuevaID;
    }

    public void limpiar() {
        consultar();
        filaSeleccionada = -1;
        c.txtIDCurso.setText(String.valueOf(getIdActual()));
        c.txtFecha.setText(Proceso.obtenerFechaActual().toString());
        c.txtNombreCurso.setText("");
        rellenarComboIDDocente();
    }

}
