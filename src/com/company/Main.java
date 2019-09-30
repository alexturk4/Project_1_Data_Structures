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
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        /*int list[] = createArray();
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
        System.out.println();

        int list5[] = createArray();
        printArray(list5);
        mergeSort(list4);*/
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("Please enter an array size:");
            int size = Integer.parseInt(in.nextLine());
            int []numberList = createArray(size); // this will create an array of random numbers

            System.out.println();
            System.out.println("Please select an array type to sort:");
            System.out.println("1. Random");
            System.out.println("2. Ascending");
            System.out.println("3. Descending");
            System.out.println("4. 80% Sorted (20% Unsorted)");

            int arrayType = Integer.parseInt(in.nextLine());
            printArray(numberList);
            // random array
            if (arrayType == 1){
                printArray(numberList);
            }
            // ascending array
            else if (arrayType == 2) {
                numberList = insertionSort(numberList);
                printArray(numberList);
            }
            // descending array
            else if (arrayType == 3) {
                numberList = descendingInsertionSort(numberList);
                printArray(numberList);
            }
            // 80% sorted array
            else if (arrayType == 4) {
                numberList = partialInsertionSort(numberList,.8);
                printArray(numberList);
            }

            System.out.println("Please select a sorting algorithm");
            System.out.println("1. Insertion Sort");
            System.out.println("2. Selection Sort");
            System.out.println("3. Quick Sort");
            System.out.println("4. Merge Sort");
            System.out.println("5. Heap Sort");
            System.out.println("6. Radix Sort");

            performSort(Integer.parseInt(in.nextLine()), numberList);


        }
    }

    private static void performSort(int sortType, int[] numberList){
        // insertion sort
        if (sortType == 1){

        }
        // selection sort
        else if (sortType == 2){

        }
        // quick sort
        else if (sortType == 3){

        }
        // merge sort
        else if (sortType == 4){

        }
        // heap sort
        else if (sortType == 5){

        }
        // radix sort
        else if (sortType == 6){
            numberList = radixSort(numberList, numberList.length);
        }
        printArray(numberList);
    }


    private static void printArray(int[] list) {
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static int[] createArray(int size) {
        Random rand = new Random();
        int[] list = new int[size];
        // Generate random integers in range 0 to 999
        for (int i = 0; i < size; i++) {
            list[i] = rand.nextInt(1000);
        }
        return list;
    }

    private static int[] insertionSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int currentElement = list[i];
            int k;

            for (k = i - 1; k >= 0 && list[k] > currentElement; k--) {
                list[k + 1] = list[k];
            }
            // Insert the current element into list[k + 1]
            list[k + 1] = currentElement;
        }
        //printArray(list);
        return list;
    }

    // this performs insertion sort but in descending order
    private static int[]  descendingInsertionSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int currentElement = list[i];
            int k;

            for (k = i - 1; k >= 0 && list[k] < currentElement; k--) {
                list[k + 1] = list[k];
            }
            // Insert the current element into list[k + 1]
            list[k + 1] = currentElement;
        }
        return list;
    }

    // this will sort x-proportion of the array and then leave the rest unsorted
    // where x is a decimal value from 0 to 1
    private static int[]  partialInsertionSort(int[] list, double x) {
        for (int i = 1; i < java.lang.Math.floor(list.length * x); i++) {
            int currentElement = list[i];
            int k;

            for (k = i - 1; k >= 0 && list[k] > currentElement; k--) {
                list[k + 1] = list[k];
            }
            // Insert the current element into list[k + 1]
            list[k + 1] = currentElement;
        }
        return list;
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

    /** The method for sorting the numbers */
    public static void mergeSort(int[] list) {
        if (list.length > 1) {
            // Merge sort the first half
            int[] firstHalf = new int[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf);

            // Merge sort the second half
            int secondHalfLength = list.length - list.length / 2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(list, list.length / 2,
                    secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);

            // Merge firstHalf with secondHalf into list
            merge(firstHalf, secondHalf, list);
        }
        printArray(list);
    }

    /** Merge two sorted lists */
    public static void merge(int[] list1, int[] list2, int[] temp) {
        int current1 = 0; // Current index in list1
        int current2 = 0; // Current index in list2
        int current3 = 0; // Current index in temp

        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1] < list2[current2])
                temp[current3++] = list1[current1++];
            else
                temp[current3++] = list2[current2++];
        }

        while (current1 < list1.length)
            temp[current3++] = list1[current1++];

        while (current2 < list2.length)
            temp[current3++] = list2[current2++];
    }

    // A utility function to get maximum value in arr[]
    static int getMax(int []arr, int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int []arr, int n, int exp)
    {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[ (arr[i]/exp)%10 ]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--)
        {
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    // The main function to that sorts arr[] of size n using
    // Radix Sort
    private static int[] radixSort(int []arr, int n)
    {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);

        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(arr, n, exp);

        return arr;
    }

}


