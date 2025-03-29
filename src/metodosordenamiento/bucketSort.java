/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodosordenamiento;

import java.util.ArrayList;         //maneja listas
import java.util.Arrays;            //para usar arreglos
import java.util.Collections;       //para ordenar listas dentro de los buckets
import java.util.List;              //maneja listas genericas

/**
 *
 * @author chris
 */

public class bucketSort {
    
    public static int[] bucketSort(int[] arr) {
        if (arr.length == 0) return arr;        // si el arreglo esta vacio, lo retorna sin hacer nada
        
        int max = Arrays.stream(arr).max().getAsInt();  //encuentra el valor maximo del arreglo
        int min = Arrays.stream(arr).min().getAsInt();  //encuentra el valor minimo del arreglo
        int bucketCount = 10;   //definir 10 cubetas para distribuir los elementos
        List<List<Integer>> buckets = new ArrayList<>(bucketCount); //crea una lista de las cubetas
        
        //inicializar cada cubeta como una nueva ArrayList(integer)
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }
        
        //calcular el indice de la cubeta, para que cada numero se distribuya uniformemente
        for (int num : arr) {
            int bucketIndex = (int) ((double) (num - min) / (max - min + 1) * bucketCount);
            buckets.get(bucketIndex).add(num);
        }
        
        //ordena cada cubeta individualmente  "Collections"
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }
        
        int index = 0;
        int[] result = new int[arr.length];     //nuedvo arreglo para almacenar elementos ordenados

        //concatena los elementos de las cubetas ordenados en el arreglo final
        for (List<Integer> bucket : buckets) {
            for (int num : bucket) {
                result[index++] = num;
            }
        }
        
        return result;
    }
}