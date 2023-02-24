package com.laboratory.sorting.bubbleSort;

import java.util.Arrays;

import static com.laboratory.sorting.Test.*;

public class BubbleSort {
    public static void main(String[] args) {
        System.out.println("Best Case:");

        System.out.println("[*] Bubble Sort");
        System.out.println("    > Result: " + Arrays.toString(bubbleSort(getBest())));
        System.out.println("[*] Bubble Sort Optimized");
        System.out.println("    > Result: " + Arrays.toString(bubbleSortOptimized(getBest())));

        System.out.println("\nWorst Case:");

        System.out.println("[*] Bubble Sort");
        System.out.println("[*] > Result: " + Arrays.toString(bubbleSort(getWorst())));
        System.out.println("[*] Bubble Sort Optimized");
        System.out.println("[*] > Result: " + Arrays.toString(bubbleSortOptimized(getWorst())));

        System.out.println("\nAverage Case:");

        System.out.println("[*] Bubble Sort");
        System.out.println("    > Result: " + Arrays.toString(bubbleSort(getAvg())));
        System.out.println("[*] Bubble Sort Optimized");
        System.out.println("    > Result: " + Arrays.toString(bubbleSortOptimized(getAvg())));

    }

    public static int[] bubbleSort(int[] arr) {
        int length = arr.length;
        int steps = 0;

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
                steps++;
            }
        }
        System.out.println("    > Steps: " + steps);
        return arr;
    }

    public static int[] bubbleSortOptimized(int[] arr) {
        int steps = 0;
        int n = arr.length;
        boolean swapped;
        int i, j, temp;


        for (i = 0; i < n - 1; i++)
        {
            swapped = false;
            for (j = 0; j < n - i - 1; j++)
            {
                if (arr[j] > arr[j + 1])
                {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
                steps++;
            }

            if (!swapped)
                break;
        }
        System.out.println("    > Steps: " + steps);
        return arr;
    }
}
