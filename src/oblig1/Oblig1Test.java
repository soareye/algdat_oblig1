package oblig1;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class Oblig1Test {

    @org.junit.jupiter.api.Test
    void maksRandomList() {
        int[] list = {1, 5, 2, 4, 3};
        int expectedMax = 5;
        int max = Oblig1.maks(list);

        assertEquals(expectedMax, max);
    }

    @org.junit.jupiter.api.Test
    void maksSingleElementList() {
        int[] singleElementList = {1};
        int expectedMax = 1;
        int max = Oblig1.maks(singleElementList);

        assertEquals(expectedMax, max);
    }

    @org.junit.jupiter.api.Test
    void maksEmptyList() {
        int[] emptyList = new int[0];

        assertThrows(NoSuchElementException.class,
                ()->Oblig1.maks(emptyList));
    }

    @org.junit.jupiter.api.Test
    void swap() {
        int[] list = {1, 2};
        int[] expectedList = {2, 1};
        Oblig1.swap(list, 0, 1);

        assertArrayEquals(expectedList, list);
    }

    @org.junit.jupiter.api.Test
    void ombyttinger() {
        int[] list = {5, 4, 3, 2, 1};
        int expectedSwapCount = 4;
        int swapCount = Oblig1.ombyttinger(list);

        assertEquals(expectedSwapCount, swapCount);
    }

    @org.junit.jupiter.api.Test
    void antallUlikeSortert() {
        int[] list = {1, 2, 3};
        int expectedUniqueCount = 3;
        int uniqueCount = Oblig1.antallUlikeSortert(list);

        assertEquals(expectedUniqueCount, uniqueCount);
    }

    @org.junit.jupiter.api.Test
    void antallUlikeSortertEmptyList() {
        int[] emptyList = new int[0];
        int expectedUniqueCount = 0;
        int uniqueCount = Oblig1.antallUlikeSortert(emptyList);

        assertEquals(expectedUniqueCount, uniqueCount);
    }

    @org.junit.jupiter.api.Test
    void handleUnsorted() {
        int[] unsortedList = {1, 3, 2};

        assertThrows(IllegalStateException.class,
                ()->Oblig1.handleUnsorted(unsortedList));
    }

    @org.junit.jupiter.api.Test
    void sortedAsc() {
        int[] sortedList = {1, 2, 3};
        int[] unsortedList = {1, 3, 2};

        assertTrue(Oblig1.sortedAsc(sortedList));
        assertFalse(Oblig1.sortedAsc(unsortedList));
    }

    @org.junit.jupiter.api.Test
     void antallUlikeUsortert() {
        int[] list = {1, 2, 3, 3, 1, 6, 6};
        int expectedUniqueCount = 4;
        int uniqueCount = Oblig1.antallUlikeUsortert(list);

        assertEquals(expectedUniqueCount, uniqueCount);
    }

    @org.junit.jupiter.api.Test
    void delsortering() {
        int[] list = {10, 8, 6, 4, 1, 9, 7, 5, 3, 2};
        int[] expectedResult = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10};

        Oblig1.delsortering(list);

        assertArrayEquals(expectedResult, list);
    }

    @org.junit.jupiter.api.Test
    void delsorteringEven() {
        int[] evenList = {22, 14, 10, 6, 4, 2};
        int[] expectedResult = {2, 4, 6, 10, 14, 22};

        Oblig1.delsortering(evenList);

        assertArrayEquals(expectedResult, evenList);
    }

    @org.junit.jupiter.api.Test
    void delsorteringOdd() {
        int[] oddList = {9, 7, 5, 3, 1};
        int[] expectedResult = {1, 3, 5, 7, 9};

        Oblig1.delsortering(oddList);

        assertArrayEquals(expectedResult, oddList);
    }

    @org.junit.jupiter.api.Test
    void delsorteringEmptyList() {
        int[] emptyList = new int[0];
        int[] expectedResult = {};

        Oblig1.delsortering(emptyList);

        assertArrayEquals(expectedResult, emptyList);
    }

    @org.junit.jupiter.api.Test
    void moveMinOdd() {
        int[] oddList = {5, 4, 3, 2, 1};
        int[] expectedResult = {1, 5, 4, 3, 2};

        Oblig1.moveMinOdd(oddList, oddList.length-1, 0);

        assertArrayEquals(expectedResult, oddList);
    }

    @org.junit.jupiter.api.Test
    void moveMaxEven() {
        int[] evenList = {5, 4, 3, 2, 1};
        int[] expectedResult = {5, 3, 2, 1, 4};

        Oblig1.moveMaxEven(evenList, 0, evenList.length);

        assertArrayEquals(expectedResult, evenList);
    }

    @org.junit.jupiter.api.Test
    void even() {
        assertTrue(Oblig1.even(2));
        assertFalse(Oblig1.even(1));
    }
}