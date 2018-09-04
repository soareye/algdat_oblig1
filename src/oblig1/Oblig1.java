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

    // Count the amount of swaps the "maks"-method would have to do on a given list:
    public static int ombyttinger(int[] list) {

        int swapCount = 0;

        for (int i = 0; i < list.length-1; i++) {

            if (list[i] > list[i+1]) {
                swapCount++;
            }
        }

        return swapCount;
    }


    // Find the number of unique values in a sorted list:
    public static int antallUlikeSortert(int[] list) {

        handleUnsorted(list);

        if (list.length == 0) {
            return 0;
        }

        int uniqueCount = 1;

        for (int i = 1; i < list.length; i++) {

            // Because the list is sorted, we only need to check
            // whether the current value is greater than the previous one.
            if (list[i] > list[i-1]) {
                uniqueCount++;
            }
        }

        return uniqueCount;
    }

    public static void handleUnsorted(int[] list) {
        if (!sortedAsc(list)) {
            throw new IllegalStateException("Unsorted list!");
        }
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

    public static int antallUlikeUsortert(int[] list) {

        if (list.length == 0) {
            return 0;
        }

        // The first value is always unique, so we can start at 1.
        int uniqueCount = 1;
        for (int i = 1; i < list.length; i++) {

            boolean unique = true;
            // Check if the value at index 'i' hasn't already occurred:
            for (int j = 0; j < i; j++) {

                if (list[i] == list[j]) {
                    unique = false;
                }
            }

            if (unique) uniqueCount++;
        }

        return uniqueCount;
    }

    // Sort a list in ascending order with odds on the left and evens on the right:
    public static void delsortering(int[] list) {

        for (int i = 0; i < list.length-1; i++) {

            // This method will make sure the first 'i' odd numbers are sorted.
            // Because of this we can end the loop at 'i'.
            moveMinOdd(list, list.length-1, i);

            // This method will make sure the last 'i' even numbers are sorted.
            // Because of this we can end the loop at 'list.length-i'.
            moveMaxEven(list, 0, list.length-i);
        }
    }

    // Move the smallest, odd number down in a list:
    public static void moveMinOdd(int[] list, int from, int to) {

        for (int i = from; i > to; i--) {
            int currentNumber = list[i];
            int nextNumber = list[i-1];

            if (!even(currentNumber)) {

                if (currentNumber < nextNumber || even(nextNumber)) {
                    swap(list, i, i - 1);
                }
            }
        }
    }

    // Move the largest, even number up in a list:
    public static void moveMaxEven(int[] list, int from, int to) {

        // The '-1' is there because the method uses the value 'i+1'.
        for (int i = from; i < to-1; i++) {
            int currentNumber = list[i];
            int nextNumber = list[i+1];

            if (even(currentNumber)) {

                if (currentNumber > nextNumber || !even(nextNumber)) {
                    swap(list, i, i + 1);
                }
            }
        }
    }

    public static boolean even(int n) {
        return n%2 == 0;
    }
}
