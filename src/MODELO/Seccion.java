package MODELO;

import java.io.Serializable;
import java.sql.Date;

public class Seccion implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String idSeccion;
    private final String tutor;
    private final String grado;
    private final String aula;
    private final String division;
    private final Date fecha;

    public Seccion() {
        this.idSeccion = null;
        this.tutor = null;
        this.grado = null;
        this.aula = null;
        this.division = null;
        this.fecha = null;
    }

    public Seccion(String idSeccion, String tutor, String grado, String aula, String division, Date fecha) {
        this.idSeccion = idSeccion;
        this.tutor = tutor;
        this.grado = grado;
        this.aula = aula;
        this.division = division;
        this.fecha = fecha;
    }

    public String getIdSeccion() {
        return idSeccion;
    }

    public String getTutor() {
        return tutor;
    }

    public String getGrado() {
        return grado;
    }

    public String getAula() {
        return aula;
    }

    public String getDivision() {
        return division;
    }

    public Date getFecha() {
        return fecha;
    }

    public class NodoSeccion implements Serializable {

        private static final long serialVersionUID = 1L;

        private Seccion seccion;
        private NodoSeccion siguiente;

        public NodoSeccion(Seccion seccion) {
            this.seccion = seccion;
            this.siguiente = null;
        }

        public Seccion getSeccion() {
            return seccion;
        }

        public void setSeccion(Seccion seccion) {
            this.seccion = seccion;
        }

        public NodoSeccion getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(NodoSeccion siguiente) {
            this.siguiente = siguiente;
        }
    }

    public class ListaEnlazadaSeccion implements Serializable {

        private static final long serialVersionUID = 1L;
        
        private NodoSeccion cabeza;

        // Método para añadir una nueva sección
        public void añadirSeccion(Seccion seccion) {
            NodoSeccion nuevoNodo = new NodoSeccion(seccion);
            if (cabeza == null) {
                cabeza = nuevoNodo;
            } else {
                NodoSeccion actual = cabeza;
                while (actual.getSiguiente() != null) {
                    actual = actual.getSiguiente();
                }
                actual.setSiguiente(nuevoNodo);
            }
        }

        // Método para actualizar una sección existente
        public void actualizarSeccion(Seccion seccion) {
            NodoSeccion actual = cabeza;
            while (actual != null) {
                if (actual.getSeccion().getIdSeccion().equals(seccion.getIdSeccion())) {
                    actual.setSeccion(seccion);
                    return;
                }
                actual = actual.getSiguiente();
            }
        }

        // Método para borrar una sección por su ID
        public void borrarSeccion(String idSeccion) {
            if (cabeza == null) {
                return;
            }
            if (cabeza.getSeccion().getIdSeccion().equals(idSeccion)) {
                cabeza = cabeza.getSiguiente();
                return;
            }
            NodoSeccion actual = cabeza;
            while (actual.getSiguiente() != null) {
                if (actual.getSiguiente().getSeccion().getIdSeccion().equals(idSeccion)) {
                    actual.setSiguiente(actual.getSiguiente().getSiguiente());
                    return;
                }
                actual = actual.getSiguiente();
            }
        }

        // Método para obtener la cabeza de la lista de secciones
        public NodoSeccion getCabeza() {
            return cabeza;
        }

        // Método para verificar si una sección existe por su ID
        public boolean existeSeccion(String idSeccion) {
            NodoSeccion actual = cabeza;
            while (actual != null) {
                if (actual.getSeccion().getIdSeccion().equals(idSeccion)) {
                    return true;
                }
                actual = actual.getSiguiente();
            }
            return false;
        }
    }
}
