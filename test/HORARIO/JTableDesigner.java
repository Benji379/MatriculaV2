package HORARIO;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class JTableDesigner {

    public static void designTable(JTable table, Color selectionColor, Color cellBackgroundColor) {
        // Restablecer los valores por defecto
        table.setSelectionBackground(selectionColor);
        table.setBackground(cellBackgroundColor);
        table.setFont(new Font(table.getFont().getName(), Font.PLAIN, table.getFont().getSize()));

        // Establecer el renderizador para las celdas
        table.setDefaultRenderer(Object.class, new CustomTableCellRenderer());

        // Establecer el renderizador para el encabezado de la tabla
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setFont(new Font(table.getFont().getName(), Font.BOLD, table.getFont().getSize() + 2));

        // Establecer el espacio entre las celdas
        table.setRowHeight(table.getRowHeight() + 2);

        // Establecer el separador de celdas
        table.setGridColor(Color.BLACK);
        table.setShowGrid(true);
        table.setShowVerticalLines(true);
        table.setShowHorizontalLines(true);

        // Permitir la selección de celdas individuales
        table.setCellSelectionEnabled(true);
    }

    // Renderizador personalizado para las celdas
    static class CustomTableCellRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            ((JLabel) component).setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.BLACK)); // Rubrayado en las celdas
            return component;
        }
    }
}
