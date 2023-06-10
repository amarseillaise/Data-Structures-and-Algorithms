package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{17, -5, 24, 18, 106, 651, -65, 1, 15};
        System.out.printf("Исходный массив: %s\n", Arrays.toString(arr));

        // проходимся от середины массива к его началу, группируя массив в бинарное дерево, где корень узла должен быть больше или равен его веткам
        for (int i = arr.length / 2 - 1; i >= 0; i--){
            heapify(arr, arr.length, i);
        }
        System.out.printf("Перегруппирован в вид бинарного дерева: %s\n", Arrays.toString(arr));

        // Сортируем перегруппированый массив от конца к началу. На каждой итерации: меняем первый и
        // последний элемент массива местами, затем запускаем метод heapify, отсекая последний элемент,
        // так как он гарантировано наибольший.
        for (int i = arr.length - 1; i >= 0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
        System.out.printf("Отсортированый массив: %s\n", Arrays.toString(arr));
    }

    public static void heapify(int[] arr, int n, int i){

        // 2i + 1 | 2i + 2 - способ определения веток узла в текущей итерации
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) largest = left;
        if (right < n && arr[right] > arr[largest]) largest = right;

        // меняем местами если значение корня меньше, чем значение одной из веток
        if (largest != i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest); // запускаем рекурсию на этом участке дерева
        }

    }
}