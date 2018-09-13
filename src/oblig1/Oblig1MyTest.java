package oblig1;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class Oblig1MyTest {

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
        int oddList[] = {9, 7, 5, 3, 1};
        int expectedResult[] = {1, 3, 5, 7, 9};

        Oblig1.delsortering(oddList);

        assertArrayEquals(expectedResult, oddList);
    }

    @org.junit.jupiter.api.Test
    void partEvenOdd() {
        int list[] = {2, 1};
        int expected[] = {1, 2};
        Oblig1.partEvenOdd(list);

        assertArrayEquals(expected, list);
    }

    @org.junit.jupiter.api.Test
    void quickSort() {
        int list[] = {5, 4, 3, 2, 1};
        int expected[] = {1, 2, 3, 4, 5};
        Oblig1.quickSort(list, 0, list.length-1);

        assertArrayEquals(expected, list);
    }

    @org.junit.jupiter.api.Test
    void partition() {
        int list[] = {1, 3, 2};
        int expected[] = {1, 2, 3};
        Oblig1.partition(list, 2, 0, 2);

        assertArrayEquals(expected, list);
    }

    @org.junit.jupiter.api.Test
    void delsorteringEmptyList() {
        int[] emptyList = new int[0];
        int[] expectedResult = {};

        Oblig1.delsortering(emptyList);

        assertArrayEquals(expectedResult, emptyList);
    }

    @org.junit.jupiter.api.Test
    void even() {
        assertTrue(Oblig1.even(2));
        assertFalse(Oblig1.even(1));
    }

    @org.junit.jupiter.api.Test
    void rotasjon() {
        char list[] = {'a', 'b', 'c', 'd'};
        char expectedResult[] = {'d', 'a', 'b', 'c'};

        Oblig1.rotasjon(list);

        assertArrayEquals(expectedResult, list);
    }

    @org.junit.jupiter.api.Test
    void rotasjon1() {
        char listNeg[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        char listNegOdd[] = {'a', 'b', 'c', 'd', 'e'};
        char listPos[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        char listPosOdd[] = {'a', 'b', 'c', 'd', 'e'};

        char expectedNeg[] = {'d', 'e', 'f', 'g', 'a', 'b', 'c'};
        char expectedPos[] = {'e', 'f', 'g', 'a', 'b', 'c', 'd'};
        char expectedNegOdd[] = {'c', 'd', 'e', 'a', 'b'};
        char expectedPosOdd[] = {'d', 'e', 'a', 'b', 'c'};

        Oblig1.rotasjon(listNeg, -3);
        Oblig1.rotasjon(listNegOdd, -2);
        Oblig1.rotasjon(listPos, 3);
        Oblig1.rotasjon(listPosOdd, 2);

        assertArrayEquals(expectedNeg, listNeg);
        assertArrayEquals(expectedNegOdd, listNegOdd);
        assertArrayEquals(expectedPos, listPos);
        assertArrayEquals(expectedPosOdd, listPosOdd);
    }

    @org.junit.jupiter.api.Test
    void flett() {
        String x = "abc";
        String y = "fghij";
        String expected = "afbgchij";
        String actual = Oblig1.flett(x, y);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void flett1() {
        String[] strings = {"abc", "fghij", "klmn"};
        String expected = "afkbglchminj";
        String actual = Oblig1.flett(strings);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void indekssortering() {
        int[] values = {5, 2, 4, 1, 3};
        int[] expected = {3, 1, 4, 2, 0};
        int[] actual = Oblig1.indekssortering(values);

        assertArrayEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void tredjeMin() {
        int[] values = {5, 2, 4, 1, 3};
        int[] expected = {3, 1, 4};
        int[] actual = Oblig1.tredjeMin(values);

        assertArrayEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void inneholdt() {
        String a = "ABBA";
        String b = "RABARBERA";
        String c = "";

        assertTrue(Oblig1.inneholdt(a, b));
        assertTrue(Oblig1.inneholdt(c, a));
        assertFalse(Oblig1.inneholdt(b, a));
    }

    @org.junit.jupiter.api.Test
    void charCount() {
        char list[] = {'a', 'b', 'c', 'd', 'd'};
        int expected[][] = {{0, 1}, {1, 1}, {2, 1}, {3, 2}};
        int actual[][] = Oblig1.charCount(list);

        assertArrayEquals(expected[0], actual[0]);
        assertArrayEquals(expected[1], actual[1]);
        assertArrayEquals(expected[2], actual[2]);
        assertArrayEquals(expected[3], actual[3]);
    }

    @org.junit.jupiter.api.Test
    void uniqueChars() {
        char list[] = {'a', 'b', 'c', 'd', 'd'};
        int expected = 4;

        assertEquals(expected, Oblig1.uniqueChars(list));
    }

    @org.junit.jupiter.api.Test
    void firstEncounter() {
        char list[] = {'a', 'b', 'c', 'd', 'd'};

        assertTrue(Oblig1.firstEncounter(list, 3));
        assertFalse(Oblig1.firstEncounter(list, 4));
    }
}