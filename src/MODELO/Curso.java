package MODELO;

import java.io.Serializable;
import java.sql.Date;

public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String idCurso;
    private final String nombreCurso;
    private final String idDocente;
    private final Date fecha;

    public Curso() {
        this.idCurso = null;
        this.nombreCurso = null;
        this.idDocente = null;
        this.fecha = null;
    }
    
    public Curso(String idCurso, String nombreCurso, String idDocente, Date fecha) {
        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
        this.idDocente = idDocente;
        this.fecha = fecha;
    }

    public String getIdCurso() {
        return idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public String getIdDocente() {
        return idDocente;
    }

    public Date getFecha() {
        return fecha;
    }

    public class NodoCurso implements Serializable {

        private static final long serialVersionUID = 1L;

        private Curso curso;
        private NodoCurso siguiente;

        public NodoCurso(Curso curso) {
            this.curso = curso;
            this.siguiente = null;
        }

        public Curso getCurso() {
            return curso;
        }

        public void setCurso(Curso curso) {
            this.curso = curso;
        }

        public NodoCurso getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(NodoCurso siguiente) {
            this.siguiente = siguiente;
        }
    }

    public class ListaEnlazadaCurso implements Serializable {

        private static final long serialVersionUID = 1L;
        
        private NodoCurso cabeza;

        // Método para añadir un nuevo curso
        public void añadirCurso(Curso curso) {
            NodoCurso nuevoNodo = new NodoCurso(curso);
            if (cabeza == null) {
                cabeza = nuevoNodo;
            } else {
                NodoCurso actual = cabeza;
                while (actual.getSiguiente() != null) {
                    actual = actual.getSiguiente();
                }
                actual.setSiguiente(nuevoNodo);
            }
        }

        // Método para actualizar un curso existente
        public void actualizarCurso(Curso curso) {
            NodoCurso actual = cabeza;
            while (actual != null) {
                if (actual.getCurso().getIdCurso().equals(curso.getIdCurso())) {
                    actual.setCurso(curso);
                    return;
                }
                actual = actual.getSiguiente();
            }
        }

        // Método para borrar un curso por su ID
        public void borrarCurso(String idCurso) {
            if (cabeza == null) {
                return;
            }
            if (cabeza.getCurso().getIdCurso().equals(idCurso)) {
                cabeza = cabeza.getSiguiente();
                return;
            }
            NodoCurso actual = cabeza;
            while (actual.getSiguiente() != null) {
                if (actual.getSiguiente().getCurso().getIdCurso().equals(idCurso)) {
                    actual.setSiguiente(actual.getSiguiente().getSiguiente());
                    return;
                }
                actual = actual.getSiguiente();
            }
        }

        // Método para obtener la cabeza de la lista de cursos
        public NodoCurso getCabeza() {
            return cabeza;
        }

        // Método para verificar si un curso existe por su ID
        public boolean existeCurso(String idCurso) {
            NodoCurso actual = cabeza;
            while (actual != null) {
                if (actual.getCurso().getIdCurso().equals(idCurso)) {
                    return true;
                }
                actual = actual.getSiguiente();
            }
            return false;
        }
    }
}
