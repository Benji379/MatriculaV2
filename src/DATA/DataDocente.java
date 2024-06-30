package DATA;

import MODELO.Docente;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JTable;

public class DataDocente {

    private static final String URL_GUARDADO = "data/docente.bin";
    private Docente.ListaEnlazadaDocente listaDocentes;

    public DataDocente() {
        listaDocentes = new Docente().new ListaEnlazadaDocente();
        cargarDocentesDesdeArchivo();
    }

    public void registrar(Docente docente) {
        listaDocentes.añadirDocente(docente);
        guardarEnArchivo();
    }

    public void actualizar(Docente docente) {
        listaDocentes.actualizarDocente(docente);
        guardarEnArchivo();
    }

    public void borrar(String codigoDocente) {
        listaDocentes.borrarDocente(codigoDocente);
        guardarEnArchivo();
    }

    public void consultar(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0); // Limpia el modelo para nuevos datos

        int i = 0;
        Docente.NodoDocente actual = listaDocentes.getCabeza();
        while (actual != null) {
            Docente docente = actual.getDocente();
            i++;
            modelo.addRow(new Object[]{
                i,
                docente.getCodigo(),
                docente.getDni(),
                docente.getNombre(),
                docente.getApellido(),
                docente.getCorreo(),
                docente.getEstado(),
                docente.getFecha()
            });
            actual = actual.getSiguiente();
        }
    }

    private void guardarEnArchivo() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(URL_GUARDADO))) {
            out.writeObject(listaDocentes);
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public ArrayList<Object> getConsultar(int columna) {
        ArrayList<Object> resultado = new ArrayList<>();
        Docente.NodoDocente actual = listaDocentes.getCabeza();
        while (actual != null) {
            Docente docente = actual.getDocente();
            switch (columna) {
                case 0:
                    resultado.add(docente.getCodigo());
                    break;
                case 1:
                    resultado.add(docente.getDni());
                    break;
                case 2:
                    resultado.add(docente.getNombre());
                    break;
                case 3:
                    resultado.add(docente.getApellido());
                    break;
                case 4:
                    resultado.add(docente.getCorreo());
                    break;
                case 5:
                    resultado.add(docente.getEstado());
                    break;
                case 6:
                    resultado.add(docente.getFecha());
                    break;
            }
            actual = actual.getSiguiente();
        }
        return resultado;
    }

    public boolean existeDocente(String codigo) {
        return listaDocentes.existeDocente(codigo);
    }

    @SuppressWarnings("unchecked")
    private void cargarDocentesDesdeArchivo() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(URL_GUARDADO))) {
            listaDocentes = (Docente.ListaEnlazadaDocente) in.readObject();
        } catch (FileNotFoundException e) {
            listaDocentes = new Docente().new ListaEnlazadaDocente(); // Si no se encuentra el archivo, inicializamos una nueva lista
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
            listaDocentes = new Docente().new ListaEnlazadaDocente(); // En caso de otro error, también inicializamos una nueva lista
        }
    }
}
