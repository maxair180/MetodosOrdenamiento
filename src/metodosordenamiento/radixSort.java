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

public class radixSort {
    
    public static void radixSort(int[] arr) {
        
        //encuentra el numero mas grande del arreglo
        int max = Arrays.stream(arr).max().getAsInt();
        
        //itera por cada digito, unidad, decena, centena
        for (int exp = 1; max / exp > 0; exp *= 10) {
            //en cada iteracion ordena el arreglo segun el digito actual
            countingSortByDigit(arr, exp);  
        }
    }
    
    private static void countingSortByDigit(int[] arr, int exp) {
        int[] output = new int[arr.length]; //arrreglo para almacenar elementos ordenados
        int[] count = new int[10];          //frecuencia de los digitos

        //extraer el digito segun su posicion
        for (int i = 0; i < arr.length; i++) {
            count[(arr[i] / exp) % 10]++;
        }
        
        //convertir el arreglo count[] en posiciones acumuladas
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        
        //construir el arreglo output[] ordenado
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        
        System.arraycopy(output, 0, arr, 0, arr.length);
    }
}