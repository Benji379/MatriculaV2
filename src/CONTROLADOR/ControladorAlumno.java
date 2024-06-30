package CONTROLADOR;

import DATA.DataAlumno;
import MODELO.Alumno;
import MODELO.Proceso;
import VISTA.moduloAlumnoApoderado;
import javax.swing.JOptionPane;

public class ControladorAlumno {

    moduloAlumnoApoderado a;
    DataAlumno data;

    public ControladorAlumno(moduloAlumnoApoderado a) {
        this.a = a;
        data = new DataAlumno();
    }

    public void initDiseño() {
        limpiar();
        Proceso.transparentarTxtField(a.alumno_txtDni, a.alumno_txtNombre, a.alumno_txtApellido);

        a.alumno_comboApoderado.removeAllItems();
        for (Object apod : new DATA.DataApoderado().getConsultar(0)) {
            a.alumno_comboApoderado.addItem(apod);
        }

    }

    public void limpiar() {
        consultar();
        filaSeleccionada = -1;
        a.alumno_txtDni.setText("");
        a.alumno_txtNombre.setText("");
        a.alumno_txtApellido.setText("");
        a.alumno_txtDni.setEditable(true);
    }

    public void consultar() {
        data.consultar(a.tablaAlumno);
    }

    public void eliminar() {
        if (filaSeleccionada >= 0) {
            int msj = JOptionPane.YES_NO_OPTION;
            int confir = JOptionPane.showConfirmDialog(null, "Confirmar eliminacion", "Confirmacion", msj);
            if (confir == 0) {
                String codigo = Proceso.datoFilaColumna(a.tablaAlumno, filaSeleccionada, "codigo").toString();
                data.borrar(codigo);
                limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void registrar() {
        String dni = a.alumno_txtDni.getText();
        String nombre = a.alumno_txtNombre.getText();
        String apellido = a.alumno_txtApellido.getText();
        String apoderado = a.alumno_comboApoderado.getSelectedItem().toString();
        boolean comprobarVacios = Proceso.ComprobarTxtVacio(dni, nombre, apellido, apoderado);
        if (!comprobarVacios) {
            int msj = JOptionPane.YES_NO_OPTION;
            int confir = JOptionPane.showConfirmDialog(null, "Confirmar registro", "Confirmacion", msj);
            if (confir == 0) {
                String codigo = Proceso.generarCodigo('A', dni, apellido, Proceso.obtenerFechaActual());
                Alumno alumno = new Alumno(codigo, dni, nombre, apellido, apoderado);
                data.registrar(alumno);
                limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Campos vacios");
        }
    }

    public void modificar() {
        if (filaSeleccionada >= 0) {

            int msj = JOptionPane.YES_NO_OPTION;
            int confir = JOptionPane.showConfirmDialog(null, "Confirmar modificacion", "Confirmacion", msj);
            if (confir == 0) {
                String codigo = Proceso.datoFilaColumna(a.tablaAlumno, filaSeleccionada, "codigo").toString();
                String dni = a.alumno_txtDni.getText();
                String nombre = a.alumno_txtNombre.getText();
                String apellido = a.alumno_txtApellido.getText();
                String apoderado = a.alumno_comboApoderado.getSelectedItem().toString();
                Alumno alumno = new Alumno(codigo, dni, nombre, apellido, apoderado);
                data.actualizar(alumno);
                limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    int filaSeleccionada = -1;

    public void tablaAlumnoMouseClicked() {
        filaSeleccionada = a.tablaAlumno.getSelectedRow();
        String codigo = Proceso.datoFilaColumna(a.tablaAlumno, filaSeleccionada, "codigo").toString();
        String dni = Proceso.datoFilaColumna(a.tablaAlumno, filaSeleccionada, "dni").toString();
        String nombre = Proceso.datoFilaColumna(a.tablaAlumno, filaSeleccionada, "nombre").toString();
        String apellido = Proceso.datoFilaColumna(a.tablaAlumno, filaSeleccionada, "apellido").toString();
        String apoderado = Proceso.datoFilaColumna(a.tablaAlumno, filaSeleccionada, "apoderado").toString();

        a.alumno_txtDni.setText(dni);
        a.alumno_txtNombre.setText(nombre);
        a.alumno_txtApellido.setText(apellido);
        a.alumno_comboApoderado.setSelectedItem(apoderado);
        a.alumno_txtDni.setEditable(false);
    }
}
