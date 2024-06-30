
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.util.Comparator;

public class TableSorter {

    // Método para ordenar las filas de un JTable por inserción
    public static void insertionSort(JTable table, int columnIndex) {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) table.getModel());
        table.setRowSorter(sorter);

        Comparator<Object> comparator = new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return table.getValueAt((Integer) o1, columnIndex).toString()
                        .compareTo(table.getValueAt((Integer) o2, columnIndex).toString());
            }
        };
        sorter.setComparator(columnIndex, comparator);
        sorter.sort();
    }

    // Método para ordenar las filas de un JTable por selección
    public static void selectionSort(JTable table, int columnIndex) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rows = model.getRowCount();
        for (int i = 0; i < rows - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < rows; j++) {
                if (((Comparable<Object>) model.getValueAt(j, columnIndex)).compareTo(model.getValueAt(minIndex, columnIndex)) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                for (int k = 0; k < model.getColumnCount(); k++) {
                    Object temp = model.getValueAt(i, k);
                    model.setValueAt(model.getValueAt(minIndex, k), i, k);
                    model.setValueAt(temp, minIndex, k);
                }
            }
        }
    }

    // Método para ordenar las filas de un JTable por burbuja
    public static void bubbleSort(JTable table, int columnIndex) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rows = model.getRowCount();
        if (columnIndex < model.getColumnCount()) { // Verificar que el índice de columna sea válido
            for (int i = 0; i < rows - 1; i++) {
                for (int j = 0; j < rows - i - 1; j++) {
                    if (((Comparable<Object>) model.getValueAt(j, columnIndex)).compareTo(model.getValueAt(j + 1, columnIndex)) > 0) {
                        for (int k = 0; k < model.getColumnCount(); k++) {
                            Object temp = model.getValueAt(j, k);
                            model.setValueAt(model.getValueAt(j + 1, k), j, k);
                            model.setValueAt(temp, j + 1, k);
                        }
                    }
                }
            }
        } else {
            System.out.println("Índice de columna inválido");
        }
    }

    // Método para ordenar las filas de un JTable por shell
    public static void shellSort(JTable table, int columnIndex) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rows = model.getRowCount();
        if (columnIndex < model.getColumnCount()) { // Verificar que el índice de columna sea válido
            for (int gap = rows / 2; gap > 0; gap /= 2) {
                for (int i = gap; i < rows; i++) {
                    for (int j = i - gap; j >= 0; j -= gap) {
                        if (((Comparable<Object>) model.getValueAt(j, columnIndex)).compareTo(model.getValueAt(j + gap, columnIndex)) > 0) {
                            for (int k = 0; k < model.getColumnCount(); k++) {
                                Object temp = model.getValueAt(j, k);
                                model.setValueAt(model.getValueAt(j + gap, k), j, k);
                                model.setValueAt(temp, j + gap, k);
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        } else {
            System.out.println("Índice de columna inválido");
        }
    }

    public static void main(String[] args) {
        // Crear cuatro JTables diferentes
        JTable table1 = createTable();
        JTable table2 = createTable();
        JTable table3 = createTable();
        JTable table4 = createTable();

        // Ordenar cada tabla utilizando un método de ordenamiento diferente
        TableSorter.insertionSort(table1, 0); // Ordenar por primera columna usando inserción
        TableSorter.selectionSort(table2, 1); // Ordenar por segunda columna usando selección
        TableSorter.bubbleSort(table3, 2);    // Ordenar por tercera columna usando burbuja
        TableSorter.shellSort(table4, 3);     // Ordenar por cuarta columna usando shell

        // Mostrar las tablas ordenadas en una ventana
        JFrame frame = new JFrame("Ejemplo de Ordenamiento de JTables");
        frame.setLayout(new GridLayout(2, 2));
        frame.add(new JScrollPane(table1));
        frame.add(new JScrollPane(table2));
        frame.add(new JScrollPane(table3));
        frame.add(new JScrollPane(table4));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Método para crear una JTable de ejemplo
    public static JTable createTable() {
        DefaultTableModel model = new DefaultTableModel(
                new Object[][]{{3, "Alice", 25}, {1, "Bob", 30}, {2, "John", 20}},
                new String[]{"ID", "Name", "Age"});
        return new JTable(model);
    }

}
