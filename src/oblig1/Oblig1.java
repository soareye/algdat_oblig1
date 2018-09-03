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
}
