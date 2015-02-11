package com.travmik.elementarysort;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SortingAlgorithmsTest {
    private Integer[] original = new Integer[]{7, 10, 5, 3, 8, 4, 2, 9, 6};
    private Integer[] reference = {2, 3, 4, 5, 6, 7, 8, 9, 10};


    @Test
    public void shouldSelectionSort() {
        SelectionSort instance = new SelectionSort(original);
        instance.sort();
        assertTrue(getMessageForArrays(reference, original), Arrays.equals(reference, original));
    }

    @Test
    public void shouldInsertionSort() {
        InsertionSort instance = new InsertionSort(original);
        instance.sort();
        assertTrue(getMessageForArrays(reference, original), Arrays.equals(reference, original));
    }

    @Test
    public void shouldShellSort() {
        ShellSort instance = new ShellSort(original);
        instance.sort();
        assertTrue(getMessageForArrays(reference, original), Arrays.equals(reference, original));
    }

    private String getMessageForArrays(final Integer[] ref, final Integer[] orig) {
        return String.format("Original array '%s' should be same as reference '%s'",
                Arrays.toString(orig), Arrays.toString(ref));
    }

}