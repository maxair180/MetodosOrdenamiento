/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodosordenamiento;

/**
 *
 * @author chris
 */

public class heapSort {
    
    public static void heapSort(int[] arr) {
        int n = arr.length;     //guarda la longitud del arreglo

        //construccion del monticulo (Heapify)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        
        //extrae el maximo de arr[0] y lo coloca al final de arr[i]
        for (int i = n - 1; i > 0; i--) {   
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
        //intercambia arr[0] (raiz del heap) con arr[i] ultimo elemento no ordenado    
 
            heapify(arr, i, 0);
        }
    }
    
    //metodo que asegura que un subarbol con raiz en "i" cumple la propiedad de Max-Heap
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;        //nodo raiz
        int l = 2 * i + 1;      //indice hijo izquierdo
        int r = 2 * i + 2;      //indice hijo derecho
        
        //encontrar el mayor
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }
        
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }
        
        //si hay un hijo mayor que el nodo raiz, se intercambian los valores
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            
            heapify(arr, n, largest);
        }
    }
}