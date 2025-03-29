/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package metodosordenamiento;

import javax.swing.JOptionPane;     //para usar cajas de texto
import java.util.Arrays;      //para usar arreglos y metodos como toString() que convierte arreglos a strings 

//importar todos los metodos de ordenamiento desde sus clases
import static metodosordenamiento.bubbleSort.bubbleSort;
import static metodosordenamiento.bucketSort.bucketSort;
import static metodosordenamiento.countingSort.countingSort;
import static metodosordenamiento.heapSort.heapSort;
import static metodosordenamiento.insertionSort.insertionSort;
import static metodosordenamiento.mergeSort.mergeSort;
import static metodosordenamiento.quickSort.quickSort;
import static metodosordenamiento.radixSort.radixSort;
import static metodosordenamiento.selectionSort.selectionSort;

/**
 *
 * @author chris
 */

public class MetodosOrdenamiento {

    public static void main(String[] args) {
        
// solicitar cantidad de elementos
        String nStr = JOptionPane.showInputDialog("ingrese la cantidad de elementos para ordenar:");
        int n = Integer.parseInt(nStr);     //convertir el string a entero
        int[] arr = new int[n];             //crea arreglo de enteros con la cantidad de elementos dados por el usuario
        
        // solicita los elementos uno por uno
        for (int i = 0; i < n; i++) {
            String elementStr = JOptionPane.showInputDialog("ingrese el elemento " + (i + 1) + " de " + n + ":");
        //convierte el string ingresado a entero y lo almacena en el arreglo    
            arr[i] = Integer.parseInt(elementStr);
        }
        
        // MENU
        String menu = "elija metodo de ordenamiento:\n" +
                     "1. selection sort (seleccion)\n" +
                     "2. bubble sort (burbuja)\n" +
                     "3. insertion sort (insercion)\n" +
                     "4. merge sort (combinacion)\n" +
                     "5. quick sort (rapida)\n" +
                     "6. heap sort (monton)\n" +
                     "7. counting sort (conteo)\n" +
                     "8. radix sort (raiz)\n" +
                     "9. bucket sort (cubeta)";
        
        String opcionStr = JOptionPane.showInputDialog(menu);   //mostrar menu
        int opcion = Integer.parseInt(opcionStr);       //convierte la seleccion a entero
        int[] arrOriginal = arr.clone();            //crea una copia del arreglo original
        
        switch (opcion) {
            case 1:
                selectionSort(arr);
                break;
            case 2:
                bubbleSort(arr);
                break;
            case 3:
                insertionSort(arr);
                break;
            case 4:
                mergeSort(arr, 0, arr.length - 1);
                break;
            case 5:
                quickSort(arr, 0, arr.length - 1);
                break;
            case 6:
                heapSort(arr);
                break;
            case 7:
                arr = countingSort(arr);
                break;
            case 8:
                radixSort(arr);
                break;
            case 9:
                arr = bucketSort(arr);
                break;
            default:
                JOptionPane.showMessageDialog(null, "opcion no valida");
                return;
        }
        
        // resultados
        String resultado = "arreglo original: " + Arrays.toString(arrOriginal) + "\n" +
                           "arreglo ordenado: " + Arrays.toString(arr);
        
        // mostrar resultados
        JOptionPane.showMessageDialog(null, resultado, "resultado del ordenamiento", JOptionPane.INFORMATION_MESSAGE);
    }
}