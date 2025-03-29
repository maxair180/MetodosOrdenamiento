/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodosordenamiento;

/**
 *
 * @author chris
 */

public class insertionSort {
    
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int var1 = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > var1) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = var1;
        }
    }
}