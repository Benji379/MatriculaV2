package MODELO;

import java.io.Serializable;

public class Horario implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public static String RANGO1 = "\n07:30\n-\n09:00\n\n";
    public static String RANGO2 = "\n09:00\n-\n10:30\n\n";
    public static String RECREO = "10:30\n10:45";
    public static String RANGO3 = "\n10:45\n-\n12:15\n\n";
    public static String RANGO4 = "\n12:15\n-\n13:45\n\n";

    private final String ID_Celda;
    private final String IdSeccion;
    private final String dia;
    private final String rangoHorario;
    private final String curso;

    public Horario() {
        this.ID_Celda = null;
        this.IdSeccion = null;
        this.dia = null;
        this.rangoHorario = null;
        this.curso = null;
    }
    
    public Horario(String ID_Celda, String IdSeccion, String dia, String rangoHorario, String curso) {
        this.ID_Celda = ID_Celda;
        this.IdSeccion = IdSeccion;
        this.dia = dia;
        this.rangoHorario = rangoHorario;
        this.curso = curso;
    }

    public String getID_Celda() {
        return ID_Celda;
    }

    public String getIdSeccion() {
        return IdSeccion;
    }

    public String getDia() {
        return dia;
    }

    public String getRangoHorario() {
        return rangoHorario;
    }

    public String getCurso() {
        return curso;
    }

    public class NodoHorario implements Serializable {

        private static final long serialVersionUID = 1L;

        private Horario horario;
        private NodoHorario siguiente;

        public NodoHorario(Horario horario) {
            this.horario = horario;
            this.siguiente = null;
        }

        public Horario getHorario() {
            return horario;
        }

        public void setHorario(Horario horario) {
            this.horario = horario;
        }

        public NodoHorario getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(NodoHorario siguiente) {
            this.siguiente = siguiente;
        }
    }

    public class ListaEnlazadaHorario implements Serializable {

        private static final long serialVersionUID = 1L;

        private NodoHorario cabeza;

        public void añadirHorario(Horario horario) {
            NodoHorario nuevoNodo = new NodoHorario(horario);
            if (cabeza == null) {
                cabeza = nuevoNodo;
            } else {
                NodoHorario actual = cabeza;
                while (actual.getSiguiente() != null) {
                    actual = actual.getSiguiente();
                }
                actual.setSiguiente(nuevoNodo);
            }
        }

        public void actualizarHorario(Horario horario) {
            NodoHorario actual = cabeza;
            while (actual != null) {
                if (actual.getHorario().getID_Celda().equals(horario.getID_Celda())) {
                    actual.setHorario(horario);
                    return;
                }
                actual = actual.getSiguiente();
            }
        }

        public void borrarHorario(String ID_Celda) {
            if (cabeza == null) {
                return;
            }
            if (cabeza.getHorario().getID_Celda().equals(ID_Celda)) {
                cabeza = cabeza.getSiguiente();
                return;
            }
            NodoHorario actual = cabeza;
            while (actual.getSiguiente() != null) {
                if (actual.getSiguiente().getHorario().getID_Celda().equals(ID_Celda)) {
                    actual.setSiguiente(actual.getSiguiente().getSiguiente());
                    return;
                }
                actual = actual.getSiguiente();
            }
        }

        public NodoHorario getCabeza() {
            return cabeza;
        }

        public boolean existeHorario(String ID_Celda) {
            NodoHorario actual = cabeza;
            while (actual != null) {
                if (actual.getHorario().getID_Celda().equals(ID_Celda)) {
                    return true;
                }
                actual = actual.getSiguiente();
            }
            return false;
        }
    }
}
