package DATA;

import MODELO.Apoderado;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DataApoderado {

    private static final String URL_GUARDADO = "data/apoderado.bin";
    private Apoderado.ListaEnlazadaApoderado listaApoderados;

    public DataApoderado() {
        listaApoderados = new Apoderado().new ListaEnlazadaApoderado();
        cargarApoderadosDesdeArchivo();
    }

    public void registrar(Apoderado apoderado) {
        listaApoderados.añadirApoderado(apoderado);
        guardarEnArchivo();
    }

    public void actualizar(Apoderado apoderado) {
        listaApoderados.actualizarApoderado(apoderado);
        guardarEnArchivo();
    }

    public void borrar(String dniApoderado) {
        listaApoderados.borrarApoderado(dniApoderado);
        guardarEnArchivo();
    }

    public void consultar(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0); // Limpia el modelo para nuevos datos

        Apoderado.NodoApoderado actual = listaApoderados.getCabeza();
        while (actual != null) {
            Apoderado apoderado = actual.getApoderado();
            modelo.addRow(new Object[]{
                apoderado.getDni(),
                apoderado.getNombre(),
                apoderado.getApellido(),
                apoderado.getTelefono()
            });
            actual = actual.getSiguiente();
        }
    }

    private void guardarEnArchivo() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(URL_GUARDADO))) {
            out.writeObject(listaApoderados);
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public ArrayList<Object> getConsultar(int columna) {
        ArrayList<Object> resultado = new ArrayList<>();
        Apoderado.NodoApoderado actual = listaApoderados.getCabeza();
        while (actual != null) {
            Apoderado apoderado = actual.getApoderado();
            switch (columna) {
                case 0:
                    resultado.add(apoderado.getDni());
                    break;
                case 1:
                    resultado.add(apoderado.getNombre());
                    break;
                case 2:
                    resultado.add(apoderado.getApellido());
                    break;
                case 3:
                    resultado.add(apoderado.getTelefono());
                    break;
            }
            actual = actual.getSiguiente();
        }
        return resultado;
    }

    public boolean existeApoderado(String dni) {
        return listaApoderados.existeApoderado(dni);
    }

    @SuppressWarnings("unchecked")
    private void cargarApoderadosDesdeArchivo() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(URL_GUARDADO))) {
            listaApoderados = (Apoderado.ListaEnlazadaApoderado) in.readObject();
        } catch (FileNotFoundException e) {
            listaApoderados = new Apoderado().new ListaEnlazadaApoderado(); // Si no se encuentra el archivo, inicializamos una nueva lista
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
            listaApoderados = new Apoderado().new ListaEnlazadaApoderado(); // En caso de otro error, también inicializamos una nueva lista
        }
    }
}
