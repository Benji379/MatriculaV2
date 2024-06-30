package DATA;

import MODELO.Alumno;
import MODELO.Alumno.NodoAlumno;
import MODELO.Alumno.ListaEnlazadaAlumno;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JTable;

public class DataAlumno {

    private static final String URL_GUARDADO = "data/alumno.bin";
    private ListaEnlazadaAlumno listaAlumnos;
    
    public DataAlumno() {
        listaAlumnos = new Alumno().new ListaEnlazadaAlumno();
        cargarAlumnosDesdeArchivo();
    }

    public void registrar(Alumno alumno) {
        listaAlumnos.añadirAlumno(alumno);
        guardarEnArchivo();
    }

    public void actualizar(Alumno alumno) {
        listaAlumnos.actualizarAlumno(alumno);
        guardarEnArchivo();
    }

    public void borrar(String codigo) {
        listaAlumnos.borrarAlumno(codigo);
        guardarEnArchivo();
    }

    public void consultar(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0); // Limpia el modelo para nuevos datos

        NodoAlumno actual = listaAlumnos.getCabeza();
        while (actual != null) {
            Alumno alumno = actual.getAlumno();
            modelo.addRow(new Object[]{
                alumno.getCodigo(),
                alumno.getDni(),
                alumno.getNombre(),
                alumno.getApellido(),
                alumno.getApoderado()
            });
            actual = actual.getSiguiente();
        }
    }

    private void guardarEnArchivo() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(URL_GUARDADO))) {
            out.writeObject(listaAlumnos);
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public ArrayList<Object> getConsultar(int columna) {
        ArrayList<Object> resultado = new ArrayList<>();
        NodoAlumno actual = listaAlumnos.getCabeza();
        while (actual != null) {
            Alumno alumno = actual.getAlumno();
            switch (columna) {
                case 0:
                    resultado.add(alumno.getCodigo());
                    break;
                case 1:
                    resultado.add(alumno.getDni());
                    break;
                case 2:
                    resultado.add(alumno.getNombre());
                    break;
                case 3:
                    resultado.add(alumno.getApellido());
                    break;
                case 4:
                    resultado.add(alumno.getApoderado());
                    break;
            }
            actual = actual.getSiguiente();
        }
        return resultado;
    }

    public boolean existeAlumno(String dni) {
        return listaAlumnos.existeAlumno(dni);
    }

    private void cargarAlumnosDesdeArchivo() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(URL_GUARDADO))) {
            listaAlumnos = (ListaEnlazadaAlumno) in.readObject();
        } catch (FileNotFoundException e) {
            listaAlumnos = new Alumno().new ListaEnlazadaAlumno(); // Si no se encuentra el archivo, inicializamos una nueva lista
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
            listaAlumnos = new Alumno().new ListaEnlazadaAlumno(); // En caso de otro error, también inicializamos una nueva lista
        }
    }
}
