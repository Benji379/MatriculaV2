package CONTROLADOR;

import DATA.DataLogin;
import MODELO.Proceso;
import VISTA.frmLogin;
import VISTA.frmPrincipal;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class ControladorLogin {

    frmLogin login;

    public ControladorLogin(frmLogin login) {
        this.login = login;
    }

    public void initDiseño() {
        try {
            login.setLocationRelativeTo(null);
//            login.setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/icono.png")));
            login.setBackground(new Color(0, 0, 0, 0));
            Proceso.transparentarTxtField(login.txtUsuario, login.txtContraseña);
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void ingresar() {
        try {
            String usuario = login.txtUsuario.getText();
            String contraseña = login.txtContraseña.getText();
            if (usuario.equalsIgnoreCase(DataLogin.leerUsuario()) && contraseña.equalsIgnoreCase(DataLogin.leerPassword())) {
                frmPrincipal abrir = new frmPrincipal();
                abrir.setVisible(true);
                login.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void txtKeyReleased(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ingresar();
        }
    }

    int LayoutX;
    int LayoutY;

    public void BarraTituloMousePressed(MouseEvent evt) {

        if (evt.getButton() == MouseEvent.BUTTON1) {
            LayoutX = evt.getX();
            LayoutY = evt.getY();
        }
    }

    public void BarraTituloMouseDragged(MouseEvent evt) {
        login.setLocation(evt.getXOnScreen() - LayoutX, evt.getYOnScreen() - LayoutY);
    }

}
