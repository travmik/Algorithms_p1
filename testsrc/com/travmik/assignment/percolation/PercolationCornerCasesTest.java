package com.travmik.assignment.percolation;

import org.junit.Test;

public class PercolationCornerCasesTest {
    private final int N = 10;

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhileInstantiateWithNegativeNumber() {
        new Percolation(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhileOpenWithLowerFirstArg() {
        Percolation perc = new Percolation(N);
        perc.open(0, 9);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhileOpenWithHeigherFirstArg() {
        Percolation perc = new Percolation(N);
        perc.open(11, 9);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhileOpenWithLowerSecondArg() {
        Percolation perc = new Percolation(N);
        perc.open(9, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhileOpenWithHeigherSecondArg() {
        Percolation perc = new Percolation(N);
        perc.open(9, 11);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhileIsOpenWithLowerFirstArg() {
        Percolation perc = new Percolation(N);
        perc.isOpen(0, 9);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhileIsOpenWithHeigherFirstArg() {
        Percolation perc = new Percolation(N);
        perc.isOpen(11, 9);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhileIsOpenWithLowerSecondArg() {
        Percolation perc = new Percolation(N);
        perc.isOpen(9, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhileIsOpenWithHeigherSecondArg() {
        Percolation perc = new Percolation(N);
        perc.isOpen(9, 11);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhileIsFullWithLowerFirstArg() {
        Percolation perc = new Percolation(N);
        perc.isFull(0, 9);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhileIsFullWithHeigherFirstArg() {
        Percolation perc = new Percolation(N);
        perc.isFull(11, 9);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhileIsFullWithLowerSecondArg() {
        Percolation perc = new Percolation(N);
        perc.isFull(9, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhileIsFullWithHeigherSecondArg() {
        Percolation perc = new Percolation(N);
        perc.isFull(9, 11);
    }
}
