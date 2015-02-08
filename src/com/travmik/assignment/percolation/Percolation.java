package com.travmik.assignment.percolation;

import com.travmik.unionfind.WeightedQuickUnionUF;

public class Percolation {
    private final int numSites;
    //to meet the coursera's contract
    protected final boolean[] open;
    protected WeightedQuickUnionUF union;

    /**
     * Create N-by-N grid, with all sites blocked
     * @param N - number of sites
     */
    public Percolation(final int N) {
        if (N <= 0) {
            throw new IllegalArgumentException(String.format("Number of sites '%s' should be greater then 0", N));
        }
        numSites = N;
        // added two virual sites
        // (1 - numSites) - real sites indexes for first side
        // numSites*numSites - count of sites in grid
        // 0, numSites*numSites + 1 - virtual sites
        union = new WeightedQuickUnionUF(numSites * numSites + 2);
        open = new boolean[numSites * numSites + 2];
        open[0] = true;
        open[open.length - 1] = true;
    }

    public void open(final int row, final int column) {
        validateRange(row);
        validateRange(column);
        int realIndex = getRealIndex(row, column);
        open[realIndex] = true;
        //check if there is left neighbour
        if (realIndex % numSites != 1) {
            unionIfOpen((realIndex - 1), realIndex);
        }
        //check if there is top neighbour
        if ((double) realIndex / numSites > 1) {
            unionIfOpen((realIndex - numSites), realIndex);
        } else {
            union.union(0, realIndex);
        }
        //check if there is right neighbour
        if (realIndex % numSites != 0) {
            //union (realIndex - 1) and realIndex
            unionIfOpen((realIndex + 1), realIndex);
        }

        //check if there is bottom neighbour
        if ((double) realIndex / numSites <= numSites - 1) {
            unionIfOpen((realIndex + numSites), realIndex);
        } else {
            union.union(numSites * numSites + 1, realIndex);
        }
    }

    public boolean isOpen(final int row, final int column) {
        validateRange(row);
        validateRange(column);
        return open[getRealIndex(row, column)];
    }

    public boolean isFull(final int row, final int column) {
        validateRange(column);
        validateRange(row);
        if (!isOpen(row, column)) {
            return false;
        }
        return  union.connected(0, getRealIndex(row, column));
    }

    public boolean percolates() {
        return union.connected(0, numSites * numSites + 1);
    }

    private void unionIfOpen(final int neighborIndex, final int selfIndex) {
        if (open[neighborIndex]) {
            union.union(neighborIndex, selfIndex);
        }
    }

    private int getRealIndex(final int row, final int column) {
        return numSites * (row - 1) + column;
    }

    private void validateRange(final int arg) {
        if (arg < 1 || arg > numSites) {
            throw new IndexOutOfBoundsException(String.format("Input parameter '%s' should be in '[%s, %s]'",
                    arg, 1, numSites));
        }
    }
}