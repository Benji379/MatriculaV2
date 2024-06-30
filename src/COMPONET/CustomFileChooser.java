package COMPONET;

import jnafilechooser.api.JnaFileChooser;

public class CustomFileChooser {

    public static String chooseExcelFile(String defaultName, String extension) {
        JnaFileChooser fileChooser = new JnaFileChooser();
        fileChooser.addFilter("Archivos de Excel", extension);
        fileChooser.setMultiSelectionEnabled(false); // Cambia a true si deseas habilitar la selecci�n m�ltiple
        fileChooser.setMode(JnaFileChooser.Mode.Files); // Cambia el modo seg�n tus necesidades

        // Establece el nombre de archivo por defecto
        if (defaultName != null && !defaultName.isEmpty()) {
            fileChooser.setDefaultFileName(defaultName + "." + extension);
        }

        if (fileChooser.showOpenDialog(null)) {
            String selectedFilePath = fileChooser.getSelectedFile().getAbsolutePath();
//            System.out.println("Archivo seleccionado: " + selectedFilePath);
            return selectedFilePath;
        } else {
//            System.out.println("Selecci�n de archivo cancelada.");
            return null;
        }
    }

    public static void main(String[] args) {
        String defaultFileName = "archivo_excel";
        String fileExtension = "xlsx"; // Cambia la extensi�n si es necesario

        String selectedFilePath = CustomFileChooser.chooseExcelFile(defaultFileName, fileExtension);
        System.out.println(selectedFilePath);
    }
}
