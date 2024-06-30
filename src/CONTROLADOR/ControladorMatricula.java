package CONTROLADOR;

import DATA.DataMatricula;
import MODELO.Matricula;
import MODELO.Proceso;
import VISTA.moduloMatricula;
import VISTA.panelBuscarAlumno;
import java.sql.Date;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class ControladorMatricula {

    moduloMatricula m;
    DataMatricula data;

    public ControladorMatricula(moduloMatricula m) {
        this.m = m;
        data = new DataMatricula();
    }

    public void initDiseño() {
        limpiar();
    }

    public void limpiar() {
        consultar();
        filaSeleccionada = -1;
        m.txtMatricula.setText("MATRICULA #" + getIdActual());
        m.comboAlumno.setEnabled(true);
        m.comboPagado.setSelectedIndex(0);
        m.tablaMatricula.clearSelection();
    }

    private int ID_ACTUAL() {
        try {
            int idActual = 0;
            for (Object id : new DATA.DataMatricula().getConsultar(0)) {
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

    public void consultar() {
//        dao.consultar(m.tablaMatricula);
//        dao.rellenarCombo(m.comboAlumno, "alumnos", "codigo");
//        dao.rellenarCombo(m.comboSeccion, "secciones", "idSeccion");
        m.comboAlumno.removeAllItems();
        for (Object apod : new DATA.DataAlumno().getConsultar(0)) {
            m.comboAlumno.addItem(apod);
        }
        m.comboSeccion.removeAllItems();
        for (Object apod : new DATA.DataSeccion().getConsultar(0)) {
            m.comboSeccion.addItem(apod);
        }

        data.consultar(m.tablaMatricula);
    }

    public void setAlumno(String codigoAlumno) {
        String nombreAlumno;
        String apellidoAlumno;
        for (int i = 0; i < new DATA.DataAlumno().getConsultar(0).size(); i++) {
            String codAlu = new DATA.DataAlumno().getConsultar(0).get(i).toString();
            if (codAlu.equalsIgnoreCase(codigoAlumno)) {
                nombreAlumno = new DATA.DataAlumno().getConsultar(2).get(i).toString();
                apellidoAlumno = new DATA.DataAlumno().getConsultar(3).get(i).toString();
                String dniApoderado = new DATA.DataAlumno().getConsultar(4).get(i).toString();
                m.txtAlumno.setText(nombreAlumno + " " + apellidoAlumno);
                for (int j = 0; j < new DATA.DataApoderado().getConsultar(0).size(); j++) {
                    String dniApod = new DATA.DataApoderado().getConsultar(0).get(j).toString();
                    if (dniApod.equalsIgnoreCase(dniApoderado)) {
                        String nombreApo = new DATA.DataApoderado().getConsultar(1).get(j).toString();
                        String apellidoApo = new DATA.DataApoderado().getConsultar(2).get(j).toString();
                        m.txtApoderado.setText(nombreApo + " " + apellidoApo);
                    }
                }
            }
        }
    }

    public void setGradoNivel(String idSeccion) {
        m.txtSeccion.setText(idSeccion);
        for (int i = 0; i < new DATA.DataSeccion().getConsultar(0).size(); i++) {
            String idSec = new DATA.DataSeccion().getConsultar(0).get(i).toString();
            if (idSec.equalsIgnoreCase(idSeccion)) {
                String grad = new DATA.DataSeccion().getConsultar(2).get(i).toString();
                String div = new DATA.DataSeccion().getConsultar(4).get(i).toString();
                m.txtGrado.setText(grad);
                m.txtDivision.setText(div);
            }
        }
    }

    public void modificar() {
        if (filaSeleccionada >= 0) {
            int msj = JOptionPane.YES_NO_OPTION;
            int confi = JOptionPane.showConfirmDialog(null, "Confirmar modificacion", "Confirmacion", msj);
            if (confi == 0) {
                String dniAlumno = m.comboAlumno.getSelectedItem().toString();
                String idMatricula = Proceso.datoFilaColumna(m.tablaMatricula, filaSeleccionada, "idMatricula").toString();
                String idSeccion = m.comboSeccion.getSelectedItem().toString();
                String pagado = m.comboPagado.getSelectedItem().toString();
                Date fecha = Proceso.obtenerFechaActual();
                Matricula matricula = new Matricula(idMatricula, dniAlumno, idSeccion, pagado, fecha);
                data.registrar(matricula);
                limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void borrar() {
        if (filaSeleccionada >= 0) {
            int msj = JOptionPane.YES_NO_OPTION;
            int confi = JOptionPane.showConfirmDialog(null, "Confirmar eliminacion", "Confirmacion", msj);
            if (confi == 0) {
                String idMatricula = Proceso.datoFilaColumna(m.tablaMatricula, filaSeleccionada, "idMatricula").toString();
                data.borrar(idMatricula);
                limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void tablaMatriculaMouseClicked() {
        filaSeleccionada = m.tablaMatricula.getSelectedRow();
        String idMatricula = Proceso.datoFilaColumna(m.tablaMatricula, filaSeleccionada, "idMatricula").toString();
        String codigAlumno = Proceso.datoFilaColumna(m.tablaMatricula, filaSeleccionada, "alumno").toString();
        String seccion = Proceso.datoFilaColumna(m.tablaMatricula, filaSeleccionada, "seccion").toString();
        String pagado = Proceso.datoFilaColumna(m.tablaMatricula, filaSeleccionada, "pagado").toString();
        m.txtMatricula.setText("MATRICULA #" + idMatricula);
        m.comboAlumno.setSelectedItem(codigAlumno);
        m.comboSeccion.setSelectedItem(seccion);
        m.comboPagado.setSelectedItem(pagado);

        try {
            setAlumno(codigAlumno);
            setGradoNivel(seccion);
        } catch (Exception e) {
        }
//        m.comboAlumno.setEnabled(false);
    }

    public void registrar() {

        try {
            String dniAlumno = m.comboAlumno.getSelectedItem().toString();
            String idMatricula = getIdActual();
            String idSeccion = m.comboSeccion.getSelectedItem().toString();
            String pagado = m.comboPagado.getSelectedItem().toString();
            Date fecha = Proceso.obtenerFechaActual();
            Matricula matricula = new Matricula(idMatricula, dniAlumno, idSeccion, pagado, fecha);
            data.registrar(matricula);
            limpiar();
        } catch (NullPointerException e) {

        }

    }

    int filaSeleccionada = -1;

    public void btnBuscarAlumno() {
        JDialog dialog = new JDialog();
//        new panelBuscarAlumno()
        panelBuscarAlumno pba = new panelBuscarAlumno();
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setSize(455, 485);
        dialog.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        dialog.setModal(true); // Hacer que el diálogo sea modal (bloquear otras interacciones)
        dialog.setContentPane(pba); // Establecer el JPanel recibido como contenido del JDialog
        dialog.setTitle("Alumnos");
        dialog.setVisible(true); // Mostrar el JDialog
//        System.out.println(pba.getCodigo());
        m.comboAlumno.setSelectedItem(pba.getCodigo());
    }

}
