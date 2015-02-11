/*
 * Canadian Tire Corporation, Ltd. Do not reproduce without permission in writing.
 * Copyright (c) 2015 Canadian Tire Corporation, Ltd. All rights reserved.
 */

package com.travmik.elementarysort;

public class InsertionSort extends AbstractSort<Integer> {
    public InsertionSort(final Integer[] array) {
        super(array);
    }

    @Override
    public void sort() {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(array[j], array[j - 1])) {
                    exch(array, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }
}
