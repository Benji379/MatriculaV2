package DATA;

import MODELO.Seccion;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JTable;

public class DataSeccion {

    private static final String URL_GUARDADO = "data//seccion.bin";
    private Seccion.ListaEnlazadaSeccion listaSecciones;

    public DataSeccion() {
        listaSecciones = new Seccion().new ListaEnlazadaSeccion();
        cargarSeccionesDesdeArchivo();
    }

    public void registrar(Seccion seccion) {
        listaSecciones.añadirSeccion(seccion);
        guardarEnArchivo();
    }

    public void actualizar(Seccion seccion) {
        listaSecciones.actualizarSeccion(seccion);
        guardarEnArchivo();
    }

    public void borrar(String idSeccion) {
        listaSecciones.borrarSeccion(idSeccion);
        guardarEnArchivo();
    }

    public ArrayList<Seccion> secciones() {
        ArrayList<Seccion> listaSeccioness = new ArrayList<>();
        Seccion.NodoSeccion actual = listaSecciones.getCabeza();
        while (actual != null) {
            listaSeccioness.add(actual.getSeccion());
            actual = actual.getSiguiente();
        }
        return listaSeccioness;
    }

    public void consultar(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0); // Limpia el modelo para nuevos datos
        int i = 0;
        Seccion.NodoSeccion actual = listaSecciones.getCabeza();
        while (actual != null) {
            Seccion seccion = actual.getSeccion();
            i++;
            modelo.addRow(new Object[]{
                i,
                seccion.getIdSeccion(),
                seccion.getGrado(),
                seccion.getDivision(),
                seccion.getTutor(),
                seccion.getAula(),
                seccion.getFecha()
            });
            actual = actual.getSiguiente();
        }
    }

    private void guardarEnArchivo() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(URL_GUARDADO))) {
            out.writeObject(listaSecciones);
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public ArrayList<Object> getConsultar(int columna) {
        ArrayList<Object> resultado = new ArrayList<>();
        Seccion.NodoSeccion actual = listaSecciones.getCabeza();
        while (actual != null) {
            Seccion seccion = actual.getSeccion();
            switch (columna) {
                case 0:
                    resultado.add(seccion.getIdSeccion());
                    break;
                case 1:
                    resultado.add(seccion.getTutor());
                    break;
                case 2:
                    resultado.add(seccion.getGrado());
                    break;
                case 3:
                    resultado.add(seccion.getAula());
                    break;
                case 4:
                    resultado.add(seccion.getDivision());
                    break;
                case 5:
                    resultado.add(seccion.getFecha());
                    break;
            }
            actual = actual.getSiguiente();
        }
        return resultado;
    }

    public boolean existeSeccion(String idSeccion) {
        return listaSecciones.existeSeccion(idSeccion);
    }

    @SuppressWarnings("unchecked")
    private void cargarSeccionesDesdeArchivo() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(URL_GUARDADO))) {
            listaSecciones = (Seccion.ListaEnlazadaSeccion) in.readObject();
        } catch (FileNotFoundException e) {
            listaSecciones = new Seccion().new ListaEnlazadaSeccion(); // Si no se encuentra el archivo, inicializamos una nueva lista
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
            listaSecciones = new Seccion().new ListaEnlazadaSeccion(); // En caso de otro error, también inicializamos una nueva lista
        }
    }
}
