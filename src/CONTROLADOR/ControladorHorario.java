package CONTROLADOR;

import DATA.DataHorario;
import DATA.DataSeccion;
import MODELO.Horario;
import MODELO.JTableUtils;
import MODELO.Proceso;
import MODELO.Seccion;
import VISTA.frmPrincipal;
import VISTA.moduloCursos;
import VISTA.moduloHorario;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import jnafilechooser.api.JnaFileChooser;

public class ControladorHorario {

    moduloHorario h;
    DataHorario data;

    public ControladorHorario(moduloHorario h) {
        this.h = h;
        data = new DataHorario();
    }

    public void initDiseño() {
        limpiar();
    }

    public void limpiar() {
        consultar();
    }

    public void consultar() {
        rellenarHorario();
        rellenarCombos();
    }

    public void registrar() {

        String idSeccion = (String) h.comboSeccion.getSelectedItem();
        String dia = String.valueOf(h.comboDia.getSelectedIndex());
        String rango = String.valueOf(h.comboRangoHorario.getSelectedIndex());
        String curso = (String) h.comboCurso.getSelectedItem();
        String ID_celda = generarCodigoCelda(idSeccion, dia, rango, curso);
        Horario horario = new Horario(ID_celda, idSeccion, dia, rango, curso);
        data.registrar(horario);
        rellenarHorario();
    }

    public void modificar() {

    }

    public void eliminar() {

    }

    public String textoCelda(String nombreCurso, String docente) {
        return "\n" + nombreCurso + "\n" + "(" + docente + ")" + "\n\n";
    }

    String td = "vacio";

    private void rellenarHorario() {

        String HORARIO[][] = {
            {td, td, td, td, td},
            {td, td, td, td, td},
            {td, td, td, td, td},
            {td, td, td, td, td}
        };

        String comboSelecciona = (String) h.comboSeccion.getSelectedItem();
        for (int i = 0; i < 20; i++) {
            for (Object codHorario : new DATA.DataHorario().getConsultar(0)) {
                String codSeccion = metodoExtractor(codHorario.toString(), 1);
                if (codSeccion.equals(comboSelecciona)) {
                    int dia = Integer.parseInt(metodoExtractor(codHorario.toString(), 2));
                    int rango = Integer.parseInt(metodoExtractor(codHorario.toString(), 3));
                    String NombreCurso = metodoExtractor(codHorario.toString(), 4).toUpperCase();;
                    HORARIO[rango][dia] = "<html><b>" + NombreCurso + "</b></html>";
                }
            }
        }

//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 5; j++) {
//                HORARIO[i][j] = "Benji";
//            }
//        }
        DefaultTableModel modelo = (DefaultTableModel) h.tablaHorario.getModel();
        modelo.setRowCount(0);
        modelo.addRow(new Object[]{Horario.RANGO1, HORARIO[0][0], HORARIO[0][1], HORARIO[0][2], HORARIO[0][3], HORARIO[0][4]});
        modelo.addRow(new Object[]{Horario.RANGO2, HORARIO[1][0], HORARIO[1][1], HORARIO[1][2], HORARIO[1][3], HORARIO[1][4]});
//        modelo.addRow(new Object[]{Horario.RECREO, "B", "R", "E", "A", "K"});
        modelo.addRow(new Object[]{Horario.RECREO, "RECREO", "RECREO", "RECREO", "RECREO", "RECREO"});
        modelo.addRow(new Object[]{Horario.RANGO3, HORARIO[2][0], HORARIO[2][1], HORARIO[2][2], HORARIO[2][3], HORARIO[2][4]});
        modelo.addRow(new Object[]{Horario.RANGO4, HORARIO[3][0], HORARIO[3][1], HORARIO[3][2], HORARIO[3][3], HORARIO[3][4]});

        h.tablaHorario.setModel(modelo);

        JTableUtils.configureMultiLineCellsWithDynamicHeight(h.tablaHorario);
    }

    public String getCurso(String idSeccion, int n) {
        for (int i = 0; i < new DATA.DataCurso().getConsultar(0).size(); i++) {
            String idSec = new DATA.DataCurso().getConsultar(0).get(i).toString();
            if (idSec.equalsIgnoreCase(idSeccion)) {
                String grad = new DATA.DataCurso().getConsultar(n).get(i).toString();
                return grad;
            }
        }
        return null;
    }

    public String getNomProfe(String idProfe) {
        for (int i = 0; i < new DATA.DataDocente().getConsultar(0).size(); i++) {
            String idSec = new DATA.DataDocente().getConsultar(0).get(i).toString();
            if (idSec.equalsIgnoreCase(idProfe)) {
                String nom = new DATA.DataDocente().getConsultar(2).get(i).toString();
                String apell = new DATA.DataDocente().getConsultar(3).get(i).toString();
                return nom + " " + apell;
            }
        }
        return null;
    }

    private String generarCodigoCelda(String idSeccion, String dia, String rangoHora, String codigoCurso) {
        return idSeccion + "|" + dia + "|" + rangoHora + "|" + codigoCurso;
    }

    public static String metodoExtractor(String cadena, int indice) {
        // Dividir la cadena en partes usando el símbolo "|" como separador
        indice = indice - 1;
        String[] partes = cadena.split("\\|");

        // Verificar si el índice está dentro del rango de las partes
        if (indice >= 0 && indice < partes.length) {
            // Retornar la parte correspondiente al índice ingresado
            return partes[indice];
        } else {
            // Si el índice está fuera del rango, retornar null
            return null;
        }
    }

    public void rellenarCombos() {
        h.comboSeccion.removeAllItems();
        for (Object apod : new DATA.DataSeccion().getConsultar(0)) {
            h.comboSeccion.addItem(apod);
        }
        h.comboCurso.removeAllItems();
        for (Object apod : new DATA.DataCurso().getConsultar(1)) {
            h.comboCurso.addItem(apod);
        }
    }

    public void setGradoNivel(String idSeccion) {
//        c.txtSeccion.setText(idSeccion);
        for (int i = 0; i < new DATA.DataSeccion().getConsultar(0).size(); i++) {
            String idSec = new DATA.DataSeccion().getConsultar(0).get(i).toString();
            if (idSec.equalsIgnoreCase(idSeccion)) {
                String grad = new DATA.DataSeccion().getConsultar(2).get(i).toString();
                String div = new DATA.DataSeccion().getConsultar(4).get(i).toString();
                h.txtTituloHorario.setText("Horario " + grad + " " + div);
            }
        }
    }

    public void selectCombo() {
        String seleccionado = (String) h.comboSeccion.getSelectedItem();
        setGradoNivel(seleccionado);
        rellenarHorario();
        String docentee = docenteXSeccion();
        h.txtDocente.setText("Docente: " + docentee);
        System.out.println(docentee);
    }

    private String docenteXSeccion() {
        String nombreDocente = "";
        String codSeccionn = (String) h.comboSeccion.getSelectedItem();
        ArrayList<Seccion> listaSeccion = new DataSeccion().secciones();
        for (Seccion sec : listaSeccion) {
            String idSeccion = sec.getIdSeccion();
            if (codSeccionn.equalsIgnoreCase(idSeccion)) {
                nombreDocente = sec.getTutor();
                break;
            }
        }
        return nombreDocente;
    }

    public void selectCelda() {
        h.tablaHorario.setFocusable(true);
        int dia = h.comboDia.getSelectedIndex();
        int rango = h.comboRangoHorario.getSelectedIndex();
        if (rango < 2) {
            h.tablaHorario.setRowSelectionInterval(rango, rango);
            h.tablaHorario.setColumnSelectionInterval(dia + 1, dia + 1);
            h.tablaHorario.requestFocusInWindow();
        } else {
            h.tablaHorario.setRowSelectionInterval(rango + 1, rango + 1);
            h.tablaHorario.setColumnSelectionInterval(dia + 1, dia + 1);
            h.tablaHorario.requestFocusInWindow();
        }
    }

    public void btnCursos() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            Proceso.mostrarVentanEmergente(new moduloCursos());
        });
    }

    public static void main(String[] args) {
        String palabra = "perro|gato|elefante|loro";
        int indice = 4;

        String segundo = metodoExtractor(palabra, indice);
        System.out.println(segundo);
    }

    private final String defaultFileName = "HORARIO";

    public void imageAvatar1MouseClicked(java.awt.event.ActionEvent evt) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            java.awt.Window parentWindow = javax.swing.SwingUtilities.windowForComponent(h.panelHorario);
            if (parentWindow != null) {
                JnaFileChooser jnaCh = new JnaFileChooser();
                jnaCh.setDefaultFileName(defaultFileName); // Establecer el nombre por defecto en el campo de texto
                boolean save = jnaCh.showOpenDialog(parentWindow);
                if (save) {
                    String fileName = jnaCh.getSelectedFile().getName();
                    if (fileName.isEmpty() || fileName.equals(defaultFileName)) {
                        fileName = defaultFileName;
                    }
                    Proceso.capturePanel(h.panelHorario, jnaCh.getSelectedFile().getParentFile(), fileName);
                }
            }
        });
    }
}
