package MODELO;

import java.io.Serializable;
import java.sql.Date;

public class Matricula implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private final String idMatricula;
    private final String alumno;
    private final String seccion;
    private final String pagado;
    private final Date fecha;

    public Matricula() {
        this.idMatricula = null;
        this.alumno = null;
        this.seccion = null;
        this.pagado = null;
        this.fecha = null;
    }

    public Matricula(String idMatricula, String alumno, String seccion, String pagado, Date fecha) {
        this.idMatricula = idMatricula;
        this.alumno = alumno;
        this.seccion = seccion;
        this.pagado = pagado;
        this.fecha = fecha;
    }

    public String getIdMatricula() {
        return idMatricula;
    }

    public String getAlumno() {
        return alumno;
    }

    public String getSeccion() {
        return seccion;
    }

    public String getPagado() {
        return pagado;
    }

    public Date getFecha() {
        return fecha;
    }

    public class NodoMatricula implements Serializable {

        private static final long serialVersionUID = 1L;

        private Matricula matricula;
        private NodoMatricula siguiente;

        public NodoMatricula(Matricula matricula) {
            this.matricula = matricula;
            this.siguiente = null;
        }

        public Matricula getMatricula() {
            return matricula;
        }

        public void setMatricula(Matricula matricula) {
            this.matricula = matricula;
        }

        public NodoMatricula getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(NodoMatricula siguiente) {
            this.siguiente = siguiente;
        }
    }

    public class ListaEnlazadaMatricula implements Serializable {

        private static final long serialVersionUID = 1L;

        private NodoMatricula cabeza;

        public void añadirMatricula(Matricula matricula) {
            NodoMatricula nuevoNodo = new NodoMatricula(matricula);
            if (cabeza == null) {
                cabeza = nuevoNodo;
            } else {
                NodoMatricula actual = cabeza;
                while (actual.getSiguiente() != null) {
                    actual = actual.getSiguiente();
                }
                actual.setSiguiente(nuevoNodo);
            }
        }

        public NodoMatricula getCabeza() {
            return cabeza;
        }

        public boolean existeMatricula(String idMatricula) {
            NodoMatricula actual = cabeza;
            while (actual != null) {
                if (actual.getMatricula().getIdMatricula().equals(idMatricula)) {
                    return true;
                }
                actual = actual.getSiguiente();
            }
            return false;
        }

        public void borrarMatricula(String idMatricula) {
            if (cabeza == null) {
                return;
            }
            if (cabeza.getMatricula().getIdMatricula().equals(idMatricula)) {
                cabeza = cabeza.getSiguiente();
                return;
            }
            NodoMatricula actual = cabeza;
            while (actual.getSiguiente() != null) {
                if (actual.getSiguiente().getMatricula().getIdMatricula().equals(idMatricula)) {
                    actual.setSiguiente(actual.getSiguiente().getSiguiente());
                    return;
                }
                actual = actual.getSiguiente();
            }
        }

        public void actualizarMatricula(Matricula matricula) {
            NodoMatricula actual = cabeza;
            while (actual != null) {
                if (actual.getMatricula().getIdMatricula().equals(matricula.getIdMatricula())) {
                    actual.setMatricula(matricula);
                    return;
                }
                actual = actual.getSiguiente();
            }
        }
    }
}
