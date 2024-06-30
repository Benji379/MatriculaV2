package DATA;

import MODELO.Matricula;
import MODELO.Matricula.NodoMatricula;
import MODELO.Matricula.ListaEnlazadaMatricula;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JTable;

public class DataMatricula {

    private static final String URL_GUARDADO = "data//matricula.bin";

    private ListaEnlazadaMatricula listaMatriculas;

    public DataMatricula() {
        listaMatriculas = new Matricula().new ListaEnlazadaMatricula();
        cargarMatriculasDesdeArchivo(); // Método para cargar matrículas al inicio desde el archivo .bin
    }

    public void registrar(Matricula matricula) {
        listaMatriculas.añadirMatricula(matricula);
        guardarEnArchivo();
    }

    public void actualizar(Matricula matricula) {
        listaMatriculas.actualizarMatricula(matricula);
        guardarEnArchivo();
    }

    public void borrar(String idMatricula) {
        listaMatriculas.borrarMatricula(idMatricula);
        guardarEnArchivo();
    }

    public void consultar(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0); // Limpia el modelo para nuevos datos

        int i = 0;
        NodoMatricula actual = listaMatriculas.getCabeza();
        while (actual != null) {
            Matricula matricula = actual.getMatricula();
            i++;
            modelo.addRow(new Object[]{
                i,
                matricula.getIdMatricula(),
                matricula.getAlumno(),
                matricula.getSeccion(),
                matricula.getPagado(),
                matricula.getFecha()
            });
            actual = actual.getSiguiente();
        }
    }

    private void guardarEnArchivo() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(URL_GUARDADO))) {
            out.writeObject(listaMatriculas);
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public ArrayList<Object> getConsultar(int columna) {
        ArrayList<Object> resultado = new ArrayList<>();
        NodoMatricula actual = listaMatriculas.getCabeza();
        while (actual != null) {
            Matricula matricula = actual.getMatricula();
            switch (columna) {
                case 0:
                    resultado.add(matricula.getIdMatricula());
                    break;
                case 1:
                    resultado.add(matricula.getAlumno());
                    break;
                case 2:
                    resultado.add(matricula.getSeccion());
                    break;
                case 3:
                    resultado.add(matricula.getPagado());
                    break;
                case 4:
                    resultado.add(matricula.getFecha());
                    break;
            }
            actual = actual.getSiguiente();
        }
        return resultado;
    }

    public boolean existeMatricula(String idMatricula) {
        return listaMatriculas.existeMatricula(idMatricula);
    }

    @SuppressWarnings("unchecked")
    private void cargarMatriculasDesdeArchivo() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(URL_GUARDADO))) {
            listaMatriculas = (ListaEnlazadaMatricula) in.readObject();
        } catch (FileNotFoundException e) {
            listaMatriculas = new Matricula().new ListaEnlazadaMatricula(); // Si no se encuentra el archivo, inicializamos una nueva lista
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
            listaMatriculas = new Matricula().new ListaEnlazadaMatricula(); // En caso de otro error, también inicializamos una nueva lista
        }
    }

}
