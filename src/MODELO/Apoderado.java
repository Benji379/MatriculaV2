package MODELO;

import java.io.Serializable;

public class Apoderado implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String dni;
    private final String nombre;
    private final String apellido;
    private final String telefono;

    public Apoderado() {
        this.dni = null;
        this.nombre = null;
        this.apellido = null;
        this.telefono = null;
    }

    public Apoderado(String dni, String nombre, String apellido, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
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

    public String getTelefono() {
        return telefono;
    }

    public class NodoApoderado implements Serializable {

        private static final long serialVersionUID = 1L;

        private Apoderado apoderado;
        private NodoApoderado siguiente;

        public NodoApoderado(Apoderado apoderado) {
            this.apoderado = apoderado;
            this.siguiente = null;
        }

        public Apoderado getApoderado() {
            return apoderado;
        }

        public void setApoderado(Apoderado apoderado) {
            this.apoderado = apoderado;
        }

        public NodoApoderado getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(NodoApoderado siguiente) {
            this.siguiente = siguiente;
        }
    }

    public class ListaEnlazadaApoderado implements Serializable {

        private static final long serialVersionUID = 1L;

        private NodoApoderado cabeza;

        public void añadirApoderado(Apoderado apoderado) {
            NodoApoderado nuevoNodo = new NodoApoderado(apoderado);
            if (cabeza == null) {
                cabeza = nuevoNodo;
            } else {
                NodoApoderado actual = cabeza;
                while (actual.getSiguiente() != null) {
                    actual = actual.getSiguiente();
                }
                actual.setSiguiente(nuevoNodo);
            }
        }

        public void actualizarApoderado(Apoderado apoderado) {
            NodoApoderado actual = cabeza;
            while (actual != null) {
                if (actual.getApoderado().getDni().equals(apoderado.getDni())) {
                    actual.setApoderado(apoderado);
                    return;
                }
                actual = actual.getSiguiente();
            }
        }

        public void borrarApoderado(String dni) {
            if (cabeza == null) {
                return;
            }
            if (cabeza.getApoderado().getDni().equals(dni)) {
                cabeza = cabeza.getSiguiente();
                return;
            }
            NodoApoderado actual = cabeza;
            while (actual.getSiguiente() != null) {
                if (actual.getSiguiente().getApoderado().getDni().equals(dni)) {
                    actual.setSiguiente(actual.getSiguiente().getSiguiente());
                    return;
                }
                actual = actual.getSiguiente();
            }
        }

        public NodoApoderado getCabeza() {
            return cabeza;
        }

        public boolean existeApoderado(String dni) {
            NodoApoderado actual = cabeza;
            while (actual != null) {
                if (actual.getApoderado().getDni().equals(dni)) {
                    return true;
                }
                actual = actual.getSiguiente();
            }
            return false;
        }
    }
}
