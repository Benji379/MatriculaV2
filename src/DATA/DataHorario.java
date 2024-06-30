package DATA;

import MODELO.Horario;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JTable;

public class DataHorario {

    private static final String URL_GUARDADO = "data//horarios.bin";

    private Horario.ListaEnlazadaHorario listaHorarios;

    public DataHorario() {
        listaHorarios = new Horario().new ListaEnlazadaHorario();
        cargarHorariosDesdeArchivo();
    }

    public void registrar(Horario horario) {
        listaHorarios.añadirHorario(horario);
        guardarEnArchivo();
    }

    public void actualizar(Horario horario) {
        listaHorarios.actualizarHorario(horario);
        guardarEnArchivo();
    }

    public void borrar(String ID_Celda) {
        listaHorarios.borrarHorario(ID_Celda);
        guardarEnArchivo();
    }

    public void consultar(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
        Horario.NodoHorario actual = listaHorarios.getCabeza();
        while (actual != null) {
            Horario horario = actual.getHorario();
            modelo.addRow(new Object[]{
                horario.getIdSeccion(),
                horario.getDia(),
                horario.getRangoHorario(),
                horario.getCurso()
            });
            actual = actual.getSiguiente();
        }
    }

    public ArrayList<Object> getConsultar(int columna) {
        ArrayList<Object> resultado = new ArrayList<>();
        Horario.NodoHorario actual = listaHorarios.getCabeza();
        while (actual != null) {
            Horario horario = actual.getHorario();
            switch (columna) {
                case 0:
                    resultado.add(horario.getID_Celda());
                    break;
                case 1:
                    resultado.add(horario.getIdSeccion());
                    break;
                case 2:
                    resultado.add(horario.getDia());
                    break;
                case 3:
                    resultado.add(horario.getRangoHorario());
                    break;
                case 4:
                    resultado.add(horario.getCurso());
                    break;
            }
            actual = actual.getSiguiente();
        }
        return resultado;
    }

    private void guardarEnArchivo() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(URL_GUARDADO))) {
            out.writeObject(listaHorarios);
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void cargarHorariosDesdeArchivo() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(URL_GUARDADO))) {
            Object readObject = in.readObject();
            if (readObject instanceof Horario.ListaEnlazadaHorario) {
                listaHorarios = (Horario.ListaEnlazadaHorario) readObject;
            } else {
                throw new IllegalArgumentException("Tipo de objeto no esperado en el archivo: " + readObject.getClass());
            }
        } catch (FileNotFoundException e) {
            listaHorarios = new Horario().new ListaEnlazadaHorario();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
            listaHorarios = new Horario().new ListaEnlazadaHorario();
        }
    }
}
