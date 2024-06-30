package CONTROLADOR;

import DATA.DataAlumno;
import VISTA.panelBuscarAlumno;
import javax.swing.table.DefaultTableModel;

public class ControladorBuscarAlumno {

    panelBuscarAlumno b;

    DataAlumno data;

    public ControladorBuscarAlumno(panelBuscarAlumno b) {
        this.b = b;
        data = new DataAlumno();
    }

    public void initDiseno() {
        consultar();
    }

    public void consultar() {
        data.consultar(b.tablaAlumno);
        rellenarComboBox();
    }

    private void rellenarComboBox() {
        b.comboDniEstudiante.removeAllItems();
        b.comboDniEstudiante.addItem("TODOS");
        for (Object daEs : new DATA.DataAlumno().getConsultar(1)) {
            b.comboDniEstudiante.addItem(daEs);
        }
    }

    public void tablaAlumnoMouseClicked() {

    }

    public void selectComboDniEstudiante() {
        int indexCombo = b.comboDniEstudiante.getSelectedIndex();
        if (indexCombo != 0) {
            DefaultTableModel modelo = (DefaultTableModel) b.tablaAlumno.getModel();
            modelo.setRowCount(0);
            String dniEstudiante = (String) b.comboDniEstudiante.getSelectedItem();

            int i = 0;
            for (Object dt : new DATA.DataAlumno().getConsultar(1)) {
                if (dniEstudiante.equalsIgnoreCase(dt.toString())) {
                    String codEstudiante = new DATA.DataAlumno().getConsultar(0).get(i).toString();
                    String dniEstudiant = new DATA.DataAlumno().getConsultar(1).get(i).toString();
                    String nombre = new DATA.DataAlumno().getConsultar(2).get(i).toString();
                    String apellido = new DATA.DataAlumno().getConsultar(3).get(i).toString();
                    String dniApoderado = new DATA.DataAlumno().getConsultar(4).get(i).toString();
                    modelo.addRow(new Object[]{
                        codEstudiante,
                        dniEstudiant,
                        nombre,
                        apellido,
                        dniApoderado
                    });
                }
                i++;
            }
            b.tablaAlumno.setModel(modelo);
        }else{
            data.consultar(b.tablaAlumno);
        }

    }

}
