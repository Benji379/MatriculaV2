package MODELO;

import java.io.Serializable;
import java.sql.Date;

public class Docente implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String codigo;
    private final String dni;
    private final String nombre;
    private final String apellido;
    private final String correo;
    private final String estado;
    private final Date fecha;

    public Docente() {
        this.codigo = null;
        this.dni = null;
        this.nombre = null;
        this.apellido = null;
        this.correo = null;
        this.estado = null;
        this.fecha = null;
    }
    
    public Docente(String codigo, String dni, String nombre, String apellido, String correo, String estado, Date fecha) {
        this.codigo = codigo;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.estado = estado;
        this.fecha = fecha;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getEstado() {
        return estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getCodigo() {
        return codigo;
    }

    public class NodoDocente implements Serializable {

        private static final long serialVersionUID = 1L;

        private Docente docente;
        private NodoDocente siguiente;

        public NodoDocente(Docente docente) {
            this.docente = docente;
            this.siguiente = null;
        }

        public Docente getDocente() {
            return docente;
        }

        public void setDocente(Docente docente) {
            this.docente = docente;
        }

        public NodoDocente getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(NodoDocente siguiente) {
            this.siguiente = siguiente;
        }
    }

    public class ListaEnlazadaDocente implements Serializable {

        private static final long serialVersionUID = 1L;

        private NodoDocente cabeza;

        public void añadirDocente(Docente docente) {
            NodoDocente nuevoNodo = new NodoDocente(docente);
            if (cabeza == null) {
                cabeza = nuevoNodo;
            } else {
                NodoDocente actual = cabeza;
                while (actual.getSiguiente() != null) {
                    actual = actual.getSiguiente();
                }
                actual.setSiguiente(nuevoNodo);
            }
        }

        public void actualizarDocente(Docente docente) {
            NodoDocente actual = cabeza;
            while (actual != null) {
                if (actual.getDocente().getCodigo().equals(docente.getCodigo())) {
                    actual.setDocente(docente);
                    return;
                }
                actual = actual.getSiguiente();
            }
        }

        public void borrarDocente(String codigo) {
            if (cabeza == null) {
                return;
            }
            if (cabeza.getDocente().getCodigo().equals(codigo)) {
                cabeza = cabeza.getSiguiente();
                return;
            }
            NodoDocente actual = cabeza;
            while (actual.getSiguiente() != null) {
                if (actual.getSiguiente().getDocente().getCodigo().equals(codigo)) {
                    actual.setSiguiente(actual.getSiguiente().getSiguiente());
                    return;
                }
                actual = actual.getSiguiente();
            }
        }

        public NodoDocente getCabeza() {
            return cabeza;
        }

        public boolean existeDocente(String codigo) {
            NodoDocente actual = cabeza;
            while (actual != null) {
                if (actual.getDocente().getCodigo().equals(codigo)) {
                    return true;
                }
                actual = actual.getSiguiente();
            }
            return false;
        }
    }
}
