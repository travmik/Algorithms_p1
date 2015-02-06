package com.travmik.assignment.percolation;

import org.junit.Test;

public class PercolationStatsTest {
    private final int N = 3;
    private int refSize = N * N + 2;

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhitNegativeN() {
        new PercolationStats(-1, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhitNegativeT() {
        new PercolationStats(10, -1);
    }
}
