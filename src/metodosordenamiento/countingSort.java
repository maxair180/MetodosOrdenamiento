/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodosordenamiento;

import java.util.Arrays;

/**
 *
 * @author chris
 */

public class countingSort {
    
    public static int[] countingSort(int[] arr) {
        if (arr.length == 0) return arr;        //si el arreglo esta vacio lo retorna sin hacer nada

        //encontrar el valor maximo y minimo del arreglo "streams"
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;      //calcula el rango de valores del arreglo
        
        int[] count = new int[range];           //almacena la frecuencia de cada numero en el rango
        int[] output = new int[arr.length];     //arreglo ordenado
        
        //llenar el arreglo
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }
        
        //acumular valores en count[]
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        
        //construye el arreglo ordenado
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }
        
        return output;
    }
}