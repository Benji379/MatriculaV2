package MODELO;

import java.util.Arrays;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MetodosOrdenamiento {

    // Método de ordenamiento por inserción
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    // Método de ordenamiento por selección
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    // Método de ordenamiento burbuja
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Método de ordenamiento shell
    public static void shellSort(int[] array) {
        int n = array.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                int temp = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
    }

    public static void ordenarPorColumna(JTable table, int numeroColumna, boolean ascendente) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        Object[][] rowData = new Object[model.getRowCount()][model.getColumnCount()];
        for (int i = 0; i < model.getRowCount(); i++) {
            for (int j = 0; j < model.getColumnCount(); j++) {
                rowData[i][j] = model.getValueAt(i, j);
            }
        }

        Arrays.sort(rowData, (Object[] o1, Object[] o2) -> {
            Comparable<Object> c1 = (Comparable<Object>) o1[numeroColumna];
            Comparable<Object> c2 = (Comparable<Object>) o2[numeroColumna];
            return c1.compareTo(c2);
        });

        if (!ascendente) {
            for (int i = 0; i < rowData.length / 2; i++) {
                Object[] temp = rowData[i];
                rowData[i] = rowData[rowData.length - i - 1];
                rowData[rowData.length - i - 1] = temp;
            }
        }

        model.setRowCount(0);

        for (Object[] row : rowData) {
            model.addRow(row);
        }
    }
    
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6};
        System.out.println("Array original: " + Arrays.toString(array));

        insertionSort(array.clone());
        System.out.println("Ordenado por inserción: " + Arrays.toString(array));

        selectionSort(array.clone());
        System.out.println("Ordenado por selección: " + Arrays.toString(array));

        bubbleSort(array.clone());
        System.out.println("Ordenado por burbuja: " + Arrays.toString(array));

        shellSort(array.clone());
        System.out.println("Ordenado por shell: " + Arrays.toString(array));
    }
}
