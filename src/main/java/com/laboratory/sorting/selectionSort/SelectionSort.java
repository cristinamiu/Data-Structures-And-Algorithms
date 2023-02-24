package com.lab.sorting.selectionSort;

import java.util.Arrays;

import static com.lab.sorting.Test.*;

public class SelectionSort {
    public static void main(String[] args) {
        System.out.println("Best Case:");

        System.out.println("[*] Selection Sort");
        System.out.println("    > Result: " + Arrays.toString(selectionSort(getBest())));

        System.out.println("\nWorst Case:");

        System.out.println("[*] Selection Sort");
        System.out.println("[*] > Result: " + Arrays.toString(selectionSort(getWorst())));

        System.out.println("\nAverage Case:");

        System.out.println("[*] Selection Sort");
        System.out.println("    > Result: " + Arrays.toString(selectionSort(getAvg())));

    }

    private static int[] selectionSort(int[] arr) {
        int i, j, min, minPoz, temp;
        int n = arr.length;

        for (i = 0; i < n - 1; i++) {
            minPoz = i;
            min = arr[i];
            for (j = i + 1; j < n; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minPoz = j;
                }
            }
            if (minPoz != i) {
                temp = arr[i];
                arr[i] = min;
                arr[minPoz] = temp;
            }

        }

        return arr;
    }
}
