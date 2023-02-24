package com.laboratory.sorting.quickSort;

import java.util.Arrays;

import static com.laboratory.sorting.Test.*;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = getAvg();

        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex)
            return;
        int pivotIndex = (lowIndex + highIndex + 1)/2;
        int pivotValue = arr[pivotIndex];

        swap(arr, pivotIndex, highIndex);

        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {
            while (arr[leftPointer] < pivotValue && leftPointer < rightPointer) leftPointer++;
            while (arr[rightPointer] > pivotValue && leftPointer < rightPointer) rightPointer--;

            swap(arr, leftPointer, rightPointer);
        }

        quickSort(arr, lowIndex, leftPointer - 1);
        quickSort(arr, leftPointer, highIndex);

    }

    private static void swap(int[] arr, int leftPointer, int rightPointer) {
        int temp = arr[leftPointer];
        arr[leftPointer] = arr[rightPointer];
        arr[rightPointer] = temp;
    }
}
