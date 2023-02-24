# Data Structures and Algorithms

## Lab 1: Sorting Algorithms

### 1.1 Bubble Sort

Bubble sort is a simple sorting algorithm. 
This sorting algorithm is comparison-based algorithm in which each 
pair of adjacent elements is compared and the elements are swapped 
if they are not in order. 
This algorithm is not suitable for large data sets as its average 
and worst case complexity are of Ο(n^2) where n is the number of 
items.

<p align="center">
<img src="https://upload.wikimedia.org/wikipedia/commons/c/c8/Bubble-sort-example-300px.gif">
</p>

````java
public class BubbleSort {
    public static int[] bubbleSort(int[] arr) {
        int i, j, temp;
        int n = arr.length;
        boolean swapped;

        for (i = 0; i < n-1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return arr;
    }
}
````

### 1.2 Selection Sort

The algorithm repeatedly selects the smallest (or largest) element
from the unsorted portion of the list and swaps it with the first 
element of the unsorted portion.

Selection Sort iterates through ``n - 1`` elements and, 
at each iteration ``i``, selects the minimum value and index putting it
at that index ``i``.

<p align="center">
<img src="https://upload.wikimedia.org/wikipedia/commons/9/94/Selection-Sort-Animation.gif">
</p>

````java
public class SelectionSort {
    public static int[] selectionSort(int[] arr) {
        int i, j, temp;
        int min, minPos;
        
        for (i = 0; i < n-1; i++) {
            min = arr[i];
            minPos = i;
            for (j = i + 1; j < n; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minPos = j;
                }
            }
            
            temp = arr[i];
            arr[i] = min;
            arr[minPos] = temp;
        }
    }
}
````

### 1.3 Insertion Sort

Insertion sort is a simple sorting algorithm that works similar 
to the way you sort playing cards in your hands. The array is 
virtually split into a sorted and an unsorted part. Values from 
the unsorted part are picked and placed at the correct position 
in the sorted part.

Insertion Sort assumes that the first element of the array is the
initial sorted array.
Then iterate the elements from ```1:n-1```. 
At each iteration, compare element at step ``i`` with the elements 
in the sorted array (``j = 0 : i-1``) and swap until necessary.

<p align="center">
<img src="https://upload.wikimedia.org/wikipedia/commons/9/9c/Insertion-sort-example.gif">
</p>

````java
public class InsertionSort {
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
````

### 1.4 Merge Sort
Merge sort is a sorting algorithm that works by dividing an array into smaller subarrays, sorting each subarray, and then merging the sorted subarrays back together to form the final sorted array.

<p align="center">
<img src="https://upload.wikimedia.org/wikipedia/commons/c/cc/Merge-sort-example-300px.gif">
</p>

````java
public class MergeSort {
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
````

### 1.5 Quick Sort

Select a random pivot and swap it with the last index.

````java
public class QuickSort {
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
}
````