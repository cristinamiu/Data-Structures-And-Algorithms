package com.lab.sorting.insertionSort;

import java.util.Arrays;

import static com.lab.sorting.Test.*;

public class InsertionSort {
    public static void main(String[] args) {
        System.out.println("[*] Selection Sort:");
        System.out.println(Arrays.toString(insertionSort(getWorst())));
    }

    public static int[] insertionSort(int[] arr) {
        int i, j, temp;
        int n = arr.length;

        for (i = 1; i < n; i++) {
            j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
        return arr;
    }
}
