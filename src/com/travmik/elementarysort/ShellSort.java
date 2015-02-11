/*
 * Canadian Tire Corporation, Ltd. Do not reproduce without permission in writing.
 * Copyright (c) 2015 Canadian Tire Corporation, Ltd. All rights reserved.
 */

package com.travmik.elementarysort;

public class ShellSort extends AbstractSort<Integer> {
    public ShellSort(final Integer[] array) {
        super(array);
    }

    @Override
    public void sort() {
        int N = array.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1; // 1, 4, 13, 40, 121, 364
        }

        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(array[j], array[j - h]); j -= h) {
                    exch(array, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}
