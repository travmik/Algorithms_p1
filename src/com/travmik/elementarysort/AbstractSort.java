package com.travmik.elementarysort;

public abstract class AbstractSort<T extends Comparable<T>> {
    protected T[] array;

    public AbstractSort(final T[] array) {
        this.array = array;
    }

    public abstract void sort();

    public boolean less(final T p, final T q) {
        return p.compareTo(q) < 0;
    }

    public void exch(final T[] array, final int indexP, final int indexQ) {
        T tmp = array[indexP];
        array[indexP] = array[indexQ];
        array[indexQ] = tmp;
    }
}
