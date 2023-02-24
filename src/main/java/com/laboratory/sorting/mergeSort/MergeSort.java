package com.laboratory.sorting.mergeSort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{6, 5, 4, 3, 2, 1};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr) {
        split(arr, arr.length);
    }

    public static void split(int[] arr, int n) {
        if (n < 2)
            return;

        int middle = n / 2;

        int[] L = new int[middle];
        int[] R = new int[n - middle];

        for (int i = 0; i < middle; i++) {
            L[i] = arr[i];
        }

        for (int j = middle; j < n; j++) {
            R[j - middle] = arr[j];
        }

        split(L, L.length);
        split(R, R.length);

        merge(arr, L, R, middle, n-middle);
    }

    public static void merge(int[] a, int[] L, int[] R, int left, int right) {
        System.out.println("[*] MERGE: " + Arrays.toString(L) + " R: " + Arrays.toString(R));
        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            if(L[i] < R[j]) {
                a[k++] = L[i++];
            } else {
                a[k++] = R[j++];
            }
        }

        while (i < left) {
            a[k++] = L[i++];
        }

        while (j < left) {
            a[k++] = R[j++];
        }
        System.out.println(Arrays.toString(a));
    }
}
