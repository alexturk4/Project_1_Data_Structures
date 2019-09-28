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

public class Main {

    public static void main(String[] args) {
        int list[] = {2,42,1,7,23,3,0};
        printArray(list);
        insertionSort(list);
        selectionSort(list);
    }
    private static void printArray(int[] list) {
        for(int i:list){
            System.out.print(i + " ");
        }
        System.out.println();
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
}