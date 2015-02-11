package com.travmik.elementarysort;

import java.util.Arrays;

public class SelectionSort extends AbstractSort<Integer> {
    public SelectionSort(final Integer[] array) {
        super(array);
    }

    @Override
    public void sort() {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (less(array[j], array[minIndex])) {
                    minIndex = j;
                }
            }
            exch(array, i, minIndex);
        }
    }
}
