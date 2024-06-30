package DATA;

import java.io.*;

public class DataLogin {

    private static final String URL_DATA_LOGIN = "data/login.bin";

    // Método para guardar el usuario y la contraseña en un archivo binario
    public static void guardarDatos(String usuario, String contraseña) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(URL_DATA_LOGIN))) {
            oos.writeObject(usuario);
            oos.writeObject(contraseña);
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    // Método para leer el usuario del archivo binario
    public static String leerUsuario() {
        String usuario = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(URL_DATA_LOGIN))) {
            usuario = (String) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return usuario;
    }

    // Método para leer la contraseña del archivo binario
    public static String leerPassword() {
        String password = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(URL_DATA_LOGIN))) {
            ois.readObject(); // Leemos el usuario pero no lo usamos
            password = (String) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return password;
    }

    public static void main(String[] args) {
        String usuario = "admin";
        String contraseña = "2024";

        // Guardar los datos en el archivo binario
        guardarDatos(usuario, contraseña);
        System.out.println("Datos guardados correctamente.");

        // Leer los datos del archivo binario
        String usuarioLeido = leerUsuario();
        String contraseñaLeida = leerPassword();
        System.out.println("Usuario leído: " + usuarioLeido);
        System.out.println("Contraseña leída: " + contraseñaLeida);
    }
}
