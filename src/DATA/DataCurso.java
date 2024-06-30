package DATA;

import MODELO.Curso;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import javax.swing.JTable;

public class DataCurso {

    private static final String URL_GUARDADO = "data//cursos.bin";

    private Curso.ListaEnlazadaCurso listaCursos;

    public DataCurso() {
        listaCursos = new Curso().new ListaEnlazadaCurso();
        cargarCursosDesdeArchivo();
    }

    public void registrar(Curso curso) {
        listaCursos.añadirCurso(curso);
        guardarEnArchivo();
    }

    public void actualizar(Curso curso) {
        listaCursos.actualizarCurso(curso);
        guardarEnArchivo();
    }

    public void borrar(String idCurso) {
        listaCursos.borrarCurso(idCurso);
        guardarEnArchivo();
    }

    public void consultar(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0); // Limpia el modelo para nuevos datos

        Curso.NodoCurso actual = listaCursos.getCabeza();
        while (actual != null) {
            Curso curso = actual.getCurso();
            modelo.addRow(new Object[]{
                curso.getIdCurso(),
                curso.getNombreCurso(),
                curso.getIdDocente(),
                curso.getFecha()
            });
            actual = actual.getSiguiente();
        }
    }

    private void guardarEnArchivo() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(URL_GUARDADO))) {
            out.writeObject(listaCursos);
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public ArrayList<Object> getConsultar(int columna) {
        ArrayList<Object> resultado = new ArrayList<>();
        Curso.NodoCurso actual = listaCursos.getCabeza();
        while (actual != null) {
            Curso curso = actual.getCurso();
            switch (columna) {
                case 0:
                    resultado.add(curso.getIdCurso());
                    break;
                case 1:
                    resultado.add(curso.getNombreCurso());
                    break;
                case 2:
                    resultado.add(curso.getIdDocente());
                    break;
                case 3:
                    resultado.add(curso.getFecha());
                    break;
            }
            actual = actual.getSiguiente();
        }
        return resultado;
    }

    public boolean existeCurso(String idCurso) {
        return listaCursos.existeCurso(idCurso);
    }

    @SuppressWarnings("unchecked")
    private void cargarCursosDesdeArchivo() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(URL_GUARDADO))) {
            listaCursos = (Curso.ListaEnlazadaCurso) in.readObject();
        } catch (FileNotFoundException e) {
            listaCursos = new Curso().new ListaEnlazadaCurso(); // Si no se encuentra el archivo, inicializamos una nueva lista
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
            listaCursos = new Curso().new ListaEnlazadaCurso(); // En caso de otro error, también inicializamos una nueva lista
        }
    }
}
