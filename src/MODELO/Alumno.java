package MODELO;

import java.io.Serializable;

public class Alumno implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String codigo;
    private final String dni;
    private final String nombre;
    private final String apellido;
    private final String apoderado;

    public Alumno() {
        this.codigo = null;
        this.dni = null;
        this.nombre = null;
        this.apellido = null;
        this.apoderado = null;
    }

    public Alumno(String codigo, String dni, String nombre, String apellido, String apoderado) {
        this.codigo = codigo;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.apoderado = apoderado;
    }

    public String getCodigo() {
        return codigo;
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

    public String getApoderado() {
        return apoderado;
    }

    public class NodoAlumno implements Serializable {

        private static final long serialVersionUID = 1L;

        private Alumno alumno;
        private NodoAlumno siguiente;

        public NodoAlumno(Alumno alumno) {
            this.alumno = alumno;
            this.siguiente = null;
        }

        public Alumno getAlumno() {
            return alumno;
        }

        public void setAlumno(Alumno alumno) {
            this.alumno = alumno;
        }

        public NodoAlumno getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(NodoAlumno siguiente) {
            this.siguiente = siguiente;
        }
    }

    public class ListaEnlazadaAlumno implements Serializable {

        private static final long serialVersionUID = 1L;

        private NodoAlumno cabeza;

        // Método para añadir un nuevo alumno
        public void añadirAlumno(Alumno alumno) {
            NodoAlumno nuevoNodo = new NodoAlumno(alumno);
            if (cabeza == null) {
                cabeza = nuevoNodo;
            } else {
                NodoAlumno actual = cabeza;
                while (actual.getSiguiente() != null) {
                    actual = actual.getSiguiente();
                }
                actual.setSiguiente(nuevoNodo);
            }
        }

        // Método para actualizar un alumno existente
        public void actualizarAlumno(Alumno alumno) {
            NodoAlumno actual = cabeza;
            while (actual != null) {
                if (actual.getAlumno().getCodigo().equals(alumno.getCodigo())) {
                    actual.setAlumno(alumno);
                    return;
                }
                actual = actual.getSiguiente();
            }
        }

        // Método para borrar un alumno por código
        public void borrarAlumno(String codigo) {
            if (cabeza == null) {
                return;
            }
            if (cabeza.getAlumno().getCodigo().equals(codigo)) {
                cabeza = cabeza.getSiguiente();
                return;
            }
            NodoAlumno actual = cabeza;
            while (actual.getSiguiente() != null) {
                if (actual.getSiguiente().getAlumno().getCodigo().equals(codigo)) {
                    actual.setSiguiente(actual.getSiguiente().getSiguiente());
                    return;
                }
                actual = actual.getSiguiente();
            }
        }

        // Método para obtener todos los alumnos
        public NodoAlumno getCabeza() {
            return cabeza;
        }

        // Método para verificar si un alumno existe por DNI
        public boolean existeAlumno(String dni) {
            NodoAlumno actual = cabeza;
            while (actual != null) {
                if (actual.getAlumno().getDni().equals(dni)) {
                    return true;
                }
                actual = actual.getSiguiente();
            }
            return false;
        }
    }

    public static Alumno busquedaBinaria(Alumno[] alumnos, String codigo) {
        int inicio = 0;
        int fin = alumnos.length - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            Alumno alumnoMedio = alumnos[medio];
            int comparacion = alumnoMedio.getCodigo().compareTo(codigo);

            if (comparacion == 0) {
                return alumnoMedio;
            } else if (comparacion < 0) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        return null;  // No se encontró el alumno con el código dado
    }

    // Método de búsqueda lineal por código
    public static Alumno buscarAlumnoPorCodigo(ListaEnlazadaAlumno lista, String codigo) {
        NodoAlumno actual = lista.getCabeza();
        while (actual != null) {
            if (actual.getAlumno().getCodigo().equals(codigo)) {
                return actual.getAlumno();
            }
            actual = actual.getSiguiente();
        }
        return null; // No se encontró el alumno con el código dado
    }
}
