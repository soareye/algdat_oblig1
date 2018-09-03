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
}