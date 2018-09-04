package oblig1;

import java.util.NoSuchElementException;

public class Oblig1 {

    // Moves the largest number to the end of an array and returns said number:
    public static int maks(int[] list) {
        if (list.length < 1)
            throw new NoSuchElementException("No largest element in empty list!");

        else if (list.length == 1)
            return list[0];

        for (int i = 0; i < list.length-1; i++) {
            if (list[i] > list[i+1]) {
                swap(list, i, i+1);
            }
        }

        return list[list.length-1];
    }

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    // Task 1 questions:
    // The largest amount of swaps occurs when the largest number is in the first spot.
    // The lowest amount of swaps happens when the list is sorted in ascending order.
    // The largest amount of swaps is n-1, the lowest is 0. The average is (n-1)/2.

    // Counts the amount of swaps the "maks"-method would have to do:
    public static int ombyttinger(int[] list) {
        int swapCount = 0;

        for (int i = 0; i < list.length-1; i++) {
            if (list[i] > list[i+1]) {
                swapCount++;
            }
        }

        return swapCount;
    }


    // Finds the number of unique values in a sorted list.
    public static int antallUlikeSortert(int[] list) {
        if (!sortedAsc(list)) {
            throw new IllegalStateException("Unsorted list!");
        }

        int uniqueCount = 0;

        if (list.length == 0) {
            return uniqueCount;
        }

        uniqueCount++;

        for (int i = 1; i < list.length; i++) {
            if (list[i] > list[i-1]) {
                uniqueCount++;
            }
        }

        return uniqueCount;
    }

    public static boolean sortedAsc(int[] list) {
        boolean sorted = true;

        for (int i = 1; i < list.length; i++) {
            if (list[i] < list[i - 1]) {
                sorted = false;
            }
        }

        return sorted;
    }
}
