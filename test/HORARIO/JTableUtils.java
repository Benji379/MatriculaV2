package HORARIO;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import javax.swing.table.TableCellRenderer;

public class JTableUtils {

    public static void configureMultiLineCellsWithDynamicHeight(JTable table) {
        // Crear un renderizador personalizado para manejar los saltos de línea en las celdas
        MultiLineTableCellRenderer cellRenderer = new MultiLineTableCellRenderer();

        // Configurar el renderizador personalizado para cada columna
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }

        // Ajustar la altura de las filas para mostrar todo el texto
        adjustRowHeights(table);
    }

    // Renderizador personalizado para manejar los saltos de línea en las celdas
    static class MultiLineTableCellRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Centrar el texto tanto vertical como horizontalmente
            setHorizontalAlignment(SwingConstants.CENTER);
            setVerticalAlignment(SwingConstants.CENTER);

            // Si el valor de la celda es una cadena y contiene saltos de línea, dividirlo y agregar etiquetas HTML
            if (value instanceof String && ((String) value).contains("\n")) {
                String text = (String) value;
                text = "<html><center>" + text.replaceAll("\n", "<br>") + "</center></html>";
                setText(text);
            }

            return cellComponent;
        }
    }

    // Método para ajustar la altura de las filas para mostrar todo el texto
    private static void adjustRowHeights(JTable table) {
        for (int row = 0; row < table.getRowCount(); row++) {
            int maxHeight = 0;
            for (int column = 0; column < table.getColumnCount(); column++) {
                TableCellRenderer cellRenderer = table.getCellRenderer(row, column);
                Component cellComponent = table.prepareRenderer(cellRenderer, row, column);
                maxHeight = Math.max(maxHeight, cellComponent.getPreferredSize().height);
            }
            table.setRowHeight(row, maxHeight);
        }
    }
}
