// Erik Snilsberg s325872

package oblig1;

import java.util.NoSuchElementException;

public class Oblig1 {

    // Oppgave 1
    // Move the largest number to the end of an array and return said number:
    public static int maks(int[] list) {

        if (list.length < 1)
            throw new NoSuchElementException("No largest element in empty list!");

        else if (list.length == 1)
            return list[0];

        for (int i = 0; i < list.length-1; i++) {

            // If the current number is larger than the next, move it to the right:
            if (list[i] > list[i+1]) {
                swap(list, i, i+1);
            }
        }

        // The largest number will have been moved all the way to the end of the list
        // which is what we will return.
        return list[list.length-1];
    }

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    // Oppgave 1 questions:
    // The largest amount of swaps occurs when the largest number is in the first spot.
    // The lowest amount of swaps happens when the list is sorted in ascending order.
    // The largest amount of swaps is n-1, the lowest is 0. The average is (n-1)/2.

    // Count the amount of swaps the "maks"-method would have to do on a given list:
    public static int ombyttinger(int[] list) {

        if (list.length < 1)
            throw new NoSuchElementException("No largest element in empty list!");

        else if (list.length == 1)
            return 0;

        int swapCount = 0;
        int max = list[0];

        for (int i = 0; i < list.length-1; i++) {

            // If the current max is greater than the next number,
            // we would have moved it to the right and can increase
            // the swap counter, if not, it means the next number is
            // our new max value:
            if (max > list[i+1]) {
                swapCount++;
            } else {
                max = list[i+1];
            }
        }

        return swapCount;
    }

    // Oppgave 2
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

    // Check if a list of integers is sorted in ascending order:
    public static boolean sortedAsc(int[] list) {

        boolean sorted = true;

        for (int i = 1; i < list.length; i++) {
            if (list[i] < list[i - 1]) {
                sorted = false;
            }
        }

        return sorted;
    }

    // Oppgave 3
    // Find the number of unique values in an unsorted list:
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

    // Oppgave 4
    // Sort a list in ascending order with odds on the left and evens on the right:
    public static void delsortering(int[] list) {

        if (list.length <= 1) return;

        // Divide the list by placing odd numbers on the left and even numbers on the
        // right and store the index of the first even number in a variable:
        int evenOddPivot = partEvenOdd(list);

        // If the list is all even or all odd, sort the whole list.
        // Else, sort the odd and even parts separately:
        if (evenOddPivot == list.length-1 || evenOddPivot == 0) {
            quickSort(list, 0, list.length-1);
        } else {
            quickSort(list, evenOddPivot, list.length - 1);
            quickSort(list, 0, evenOddPivot - 1);
        }
    }

    // Divide the list by placing odd numbers on the left and even numbers on the
    // right and return the index of the first even number:
    public static int partEvenOdd(int[] list) {
        int left = 0;
        int right = list.length-1;

        while (left < right) {
            // Search the list from the left until you find an even value:
            while (!even(list[left]) && left < right) {
                left++;
            }
            // Search the list from the right until you find an odd value:
            while (even(list[right]) && right > left) {
                right--;
            }

            // When you have found an even value on the left and an odd on
            // the right, swap them:
            if (even(list[left]) && !even(list[right]) && right > left) {
                swap(list, left, right);
            }
        }

        // Ensure that the 'right' index is pointing to an even value, if there are any:
        if (!even(list[right]) && right < list.length - 1)
            right++;

        return right;
    }

    // Sort a list recursively by placing a value where it belongs and calling the
    // method again on the sub-lists to the right and to the left of said value:
    public static void quickSort(int[] list, int left, int right) {

        if (left < right) {

            // Choose the value in the middle as the value to sort:
            int pivot = (left+right)/2;

            // Sort the value and store the index of where it was placed in a variable.
            int newPivot = partition(list, pivot, left, right);

            // Sort the part of the list to the right and the left, respectively, of the sorted value:
            quickSort(list, newPivot + 1, right);
            quickSort(list, left, newPivot - 1);
        }
    }

    // Sort an element by moving all larger elements to the right and all smaller elements to the left:
    public static int partition(int[] list, int pivot, int left, int right) {

        // Move the value we're sorting out of the way:
        swap(list, pivot, right);
        pivot = right;
        right = right - 1;

        while (left < right) {

            // Search the list from the left until we find a value greater than the pivot:
            while (list[left] < list[pivot] && left < right) {
                left++;
            }

            // Search the list from the right until we find a value smaller than the pivot:
            while (list[right] > list[pivot] && right > left) {
                right--;
            }

            // Once we have found these, swap them:
            swap(list, left, right);
        }

        // Ensure that the pivot is placed in the right spot, that the
        // index we're swapping with is larger than the pivot:
        if (list[right] < list[pivot] && right < list.length - 1) right++;
        swap(list, right, pivot);
        pivot = right;

        return pivot;
    }

    public static boolean even(int n) {
        return n%2 == 0;
    }

    // Oppgave 5
    // Move all elements in a list, 1 step forward:
    public static void rotasjon(char[] list) {
        for (int i = 0; i < list.length-1; i++) {
            swap(list, list.length-1-i, list.length-1-(i+1));
        }
    }

    public static void swap(char[] array, int a, int b) {
        char temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    // Oppgave 6
    // Move all elements in a list forward or backwards k times:
    public static void rotasjon(char[] list, int k) {

        if (list.length < 1) return;

        // Moving around a circle a million times will look no
        // different than moving around it once. Because we are
        // treating the list as a circular object, we can use
        // modulo to find the number of steps we need to move
        // the elements:
        int iters = Math.abs(k) % list.length;

        // Whether k is negative or positive, move the elements
        // backwards or forwards depending on which final position
        // is closer:
        if (k < 0) {
            if (iters <= list.length/2) {
                rotateBackward(list, iters);
            } else {
                rotateForward(list, list.length - iters);
            }
        } else {
            if (iters <= list.length/2) {
                rotateForward(list, iters);
            } else {
                rotateBackward(list, list.length - iters);
            }
        }
    }

    // Move the elements in a list 'iters' number of steps backwards
    // by cutting and pasting the list in the right places:
    public static void rotateBackward(char[] list, int iters) {

        // Create a copy of the list we're rotating:
        char tmp[] = new char[list.length];
        System.arraycopy(list, 0, tmp, 0, list.length);
        for (int i = 0; i < list.length; i++) {
            tmp[i] = list[i];
        }

        // Paste the last part of the list 'iters' number of steps backwards:
        for (int i = iters; i < list.length; i++) {
            list[i - iters] = tmp[i];
        }

        // Paste the first 'iters' number of elements from the copy of the list
        // to the end of the original list:
        for (int i = 0; i < iters; i++) {
            list[i + list.length - iters] = tmp[i];
        }
    }

    // Move the elements in a list 'iters' number of steps forwards:
    public static void rotateForward(char[] list, int iters) {

        // Create a copy of the list we're rotating:
        char tmp[] = new char[list.length];
        System.arraycopy(list, 0, tmp, 0, list.length);
        for (int i = 0; i < list.length; i++) {
            tmp[i] = list[i];
        }

        // Paste the last 'iters' long elements long part of the list to the start of the list:
        for (int i = list.length - iters; i < list.length; i++) {
            list[i - (list.length - iters)] = tmp[i];
        }

        // Paste all the elements expect for the 'iters' last elements, 'iters' steps forward:
        for (int i = 0; i < list.length - iters; i++) {
            list[i + iters] = tmp[i];
        }
    }

    // Oppgave 7 a
    public static String flett(String a, String b) {
        String flette = "";
        int iterations;

        // Find the larger string and store the length in a variable:
        if (a.length() > b.length()) {
            iterations = a.length();

        } else {
            iterations = b.length();
        }

        // Iterate through the larger string and
        // add characters from both.
        // If the index exceeds the length of one of the strings
        // just add the remaining characters from the larger string:
        for (int i = 0; i < iterations; i++) {

            if (i >= a.length()) {
                flette += b.toCharArray()[i];

            } else if (i >= b.length()) {
                flette += a.toCharArray()[i];

            } else {
                flette += a.toCharArray()[i];
                flette += b.toCharArray()[i];
            }
        }

        return flette;
    }


    // Oppgave 7 b
    public static String flett(String... strings) {

        int i = 0;
        String flette = "";

        // The length of the "flette" before and after
        // each iteration:
        int lastFlette = flette.length() - 1;
        int curFlette = flette.length();

        // While the length of the "flette" still increases:
        while (lastFlette < curFlette) {

            // Add the 'i'-th letter in a string to the "flette"-String:
            for (String curString : strings) {
                if (i < curString.length()) {
                    flette += curString.toCharArray()[i];
                }
            }

            // Move on to the next letter:
            i++;

            // Update the lengths:
            lastFlette = curFlette;
            curFlette = flette.length();
        }

        return flette;
    }

    // Oppgave 8
    // Create a sorted list of indices for a list by creating a sorted copy of that list
    // and using the sorted copy to find the indices of the list in the correct order:
    public static int[] indekssortering(int[] list) {
        int indices[] = new int[list.length];

        int copy[] = copy(list);
        bubbleSort(copy);

        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length; j++) {

                // Store the index 'j' of the unsorted list in a sorted order:
                if (list[j] == copy[i])
                    indices[i] = j;
            }
        }

        return indices;
    }

    // Sort a given list with repeated calls to bubbleMax,
    // which moves the largest value in a list to the end of that list:
    public static void bubbleSort(int[] list) {

        for (int i = 0; i < list.length; i++) {
            bubbleMax(list, list.length-i);
        }
    }

    // Move the largest value in a list to the end of a list by
    // repeatedly swapping the largest value to the right:
    public static void bubbleMax(int[] list, int end) {
        for (int i = 0; i < end - 1; i++) {

            if (list[i] > list[i+1]) {
                swap(list, i, i+1);
            }
        }
    }

    public static int[] copy(int[] list) {
        int copy[] = new int[list.length];

        for (int i = 0; i < list.length; i++)
            copy[i] = list[i];

        return copy;
    }

    // Oppgave 9
    public static int[] tredjeMin(int[] list) {

        if (list.length < 3)
            throw new NoSuchElementException("No third minimum in a list with less than 3 elements!");

        // Get the sorted indices of the first three values:
        int startValues[] = {list[0], list[1], list[2]};
        int sortedIndices[] = indekssortering(startValues);

        int minIndex = sortedIndices[0];
        int secMinIndex = sortedIndices[1];
        int thirdMinIndex = sortedIndices[2];

        for (int i = 3; i < list.length; i++) {

            if (list[i] < list[thirdMinIndex]) {

                if (list[i] < list[secMinIndex]) {

                    if (list[i] < list[minIndex]) {

                        // If the current value is smaller than each current minimums,
                        // store it in min and replace the rest:
                        thirdMinIndex = secMinIndex;
                        secMinIndex = minIndex;
                        minIndex = i;

                    } else {

                        // If the current value is smaller than the third and second min,
                        // store it in second min and replace third min:
                        thirdMinIndex = secMinIndex;
                        secMinIndex = i;
                    }
                } else {
                    // If the current value is only smaller than the third min,
                    // store it in the third min:
                    thirdMinIndex = i;
                }
            }
        }

        return new int[]{minIndex, secMinIndex, thirdMinIndex};
    }

    // Oppgave 10
    // Investigate whether the string b contains each character in a:
    public static boolean inneholdt(String a, String b) {

        // b can't contain a if it's shorter.
        if (b.length() < a.length()) return false;

        char aList[] = a.toCharArray();
        char bList[] = b.toCharArray();

        // Call the charCount-method on the two lists of characters.
        // This creates two matrices which holds the indices of each
        // unique character and the number of times they occur.
        int[][] charCountA = charCount(aList);
        int[][] charCountB = charCount(bList);

        // Loop to find to find out if 'b' has the same amount, or more, of each character as 'a':
        for (int i = 0; i < charCountA.length; i++) {

            boolean bHasCurrentChar = false;
            char currentCharA = aList[charCountA[i][0]];
            int charAmountA = charCountA[i][1];

            for (int j = 0; j < charCountB.length; j++) {

                int currentCharB = bList[charCountB[j][0]];
                int charAmountB = charCountB[j][1];

                // If 'b' has the current character from 'a',
                // then if 'b' has less occurrences of this character,
                // return false, because 'b' can't contain 'a' unless
                // it has all the characters 'a' has or more.
                if (currentCharA == currentCharB) {
                    bHasCurrentChar = true;

                    if (charAmountA > charAmountB) {
                        return false;
                    }

                    // Break, because we already know that 'b' has enough
                    // of the current character from the previous if-clause.
                    break;
                }
            }

            // If 'b' didn't have the character at all, then 'b' can't contain 'a'.
            if (!bHasCurrentChar) return false;
        }

        return true;
    }

    // Find the number of each unique characters and return a
    // matrix with the indices of the unique characters along
    // with the number of occurrences:
    public static int[][] charCount(char[] list) {

        // Create the matrix for storing the index of each unique
        // character and the number of occurrences:
        // The first column holds the index.
        // The second column holds the number of occurrences.
        int charCount[][] = new int[uniqueChars(list)][2];

        // 'k' represents the index of the first column in the "charCount"-matrix.
        int k = 0;

        for (int i = 0; i < list.length-1; i++) {

            // If it's the first time we have encountered a character
            // it's unique and we can store its index, 'i', in the
            // first column of the matrix:
            if (firstEncounter(list, i)) {

                // Store the index of the unique character in the first column:
                charCount[k][0] = i;
                // Initialize the number of occurrences to one:
                charCount[k][1] = 1;

                // Loop for counting the number of occurrences of a character:
                for (int j = i + 1; j < list.length; j++) {

                    // Increase the number of occurrences each time we encounter
                    // the character we're currently investigating:
                    if (list[i] == list[j])
                        charCount[k][1]++;
                }

                k++;
            }
        }

        return charCount;
    }

    // Find the number of unique characters in a list:
    public static int uniqueChars(char[] list) {
        int charCount = 0;
        for (int i = 0; i < list.length - 1; i++) {

            if (firstEncounter(list, i)) {
                charCount++;
            }
        }

        return charCount;
    }

    // Investigate whether a character has been encountered earlier in a list:
    public static boolean firstEncounter(char[] list, int index) {
        for (int j = 0; j < index; j++) {
            if (list[index] == list[j]) return false;
        }

        return true;
    }
}
