// Anesh Turk Project #1
// Data Structures and Algorithms CS 3345
// Fall 2019 - Due 9/29/19

/*
    The purpose of this project is to compare the efficiency of the following 6 sorting algorithms:
        1. Insertion Sort
        2. Selection Sort
        3. Quick Sort
        4. Merge Sort
        5. Heap Sort
        6. Radix Sort

    On arrays which already exist in the following states:
        1. InOrder (ascending)
        2. ReverseOrder (descending)
        3. AlmostOrder (80% sorted 20% unsorted)
        4. Random

    We will be keeping track of the number of comparisons, element movements, and the running time and will then compare
        the results between them
 */
package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int list[] = createArray();
        printArray(list);
        insertionSort(list);
        System.out.println();

        int list2[] = createArray();
        printArray(list2);
        selectionSort(list2);
        System.out.println();

        int list3[] = createArray();
        printArray(list3);
        quickSort(list3);
        System.out.println();

        int list4[] = createArray();
        printArray(list4);
        heapSort(list4);
    }


    private static void printArray(int[] list) {
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static int[] createArray() {
        Random rand = new Random();
        int[] list = new int[20];
        // Generate random integers in range 0 to 999
        for (int i = 0; i < 20; i++) {
            list[i] = rand.nextInt(1000);
        }
        return list;
    }

    private static void insertionSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int currentElement = list[i];
            int k;

            for (k = i - 1; k >= 0 && list[k] > currentElement; k--) {
                list[k + 1] = list[k];
            }
            // Insert the current element into list[k + 1]
            list[k + 1] = currentElement;
        }
        printArray(list);
    }

    private static void selectionSort(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            // Find the minimum in the list[i..list.length-1]
            int currentMin = list[i];
            int currentMinIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (currentMin > list[j]) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }

            // Swap list[i] with list[currentMinIndex] if necessary
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
        printArray(list);
    }

    public static void quickSort(int[] list) {
        quickSort(list, 0, list.length - 1);
        printArray(list);
    }

    private static void quickSort(int[] list, int first, int last) {
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }

    /**
     * Partition the array list[first..last]
     */
    private static int partition(int[] list, int first, int last) {
        int pivot = list[first]; // Choose the first element as the pivot
        int low = first + 1; // Index for forward search
        int high = last; // Index for backward search

        while (high > low) {
            // Search forward from left
            while (low <= high && list[low] <= pivot)
                low++;

            // Search backward from right
            while (low <= high && list[high] > pivot)
                high--;

            // Swap two elements in the list
            if (high > low) {
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        while (high > first && list[high] >= pivot)
            high--;

        // Swap pivot with list[high]
        if (pivot > list[high]) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        } else {
            return first;
        }
    }

    private static void heapSort(int arr[])
    {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
        printArray(arr);
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    private static void heapify(int arr[], int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2*i + 1; // left = 2*i + 1
        int r = 2*i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }



}


