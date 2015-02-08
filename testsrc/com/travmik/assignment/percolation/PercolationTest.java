package com.travmik.assignment.percolation;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PercolationTest {
    private final int N = 3;
    private int refSize = N * N + 2;

    @Test
    public void shouldHaveRightSizeAfterInit() {
        Percolation perc = new Percolation(N);

        assertEquals("Wrong size of open array", refSize, perc.open.length);
        assertEquals("Wrong size of union array", refSize, perc.union.count());

    }

    @Test
    public void shouldOpenRightSites() {
        Percolation perc = new Percolation(N);
        perc.open(1, 2);
        perc.open(2, 3);
        perc.open(3, 1);
        boolean[] refGrid = getRefOpenArray();
        refGrid[2] = true;
        refGrid[6] = true;
        refGrid[7] = true;

        assertTrue(getMessageForSiteArrays(refGrid, perc.open), Arrays.equals(refGrid, perc.open));
    }

    @Test
    public void shouldBeOpen() {
        Percolation perc = new Percolation(N);
        perc.open(1, 2);


        assertTrue("Should be open", perc.isOpen(1, 2));
    }

    @Test
    public void shouldBeConnectedAfterOpenWithVirtualTop() {
        Percolation perc = new Percolation(N);
        perc.open(1, 1);
        perc.open(1, 2);
        perc.open(1, 3);
        boolean[] refGrid = getRefOpenArray();
        refGrid[1] = true;
        refGrid[2] = true;
        refGrid[3] = true;

        assertTrue(getMessageForSiteArrays(refGrid, perc.open), Arrays.equals(refGrid, perc.open));
        assertTrue(getMessageForConnectedSites(0, 1), perc.union.connected(0, 1));
        assertTrue(getMessageForConnectedSites(0, 2), perc.union.connected(0, 2));
        assertTrue(getMessageForConnectedSites(0, 3), perc.union.connected(0, 3));
    }

    @Test
    public void shouldBeConnectedAfterOpenWithVirtualBottom() {
        Percolation perc = new Percolation(N);
        perc.open(3, 1);
        perc.open(3, 2);
        perc.open(3, 3);
        boolean[] refGrid = getRefOpenArray();
        refGrid[7] = true;
        refGrid[8] = true;
        refGrid[9] = true;

        assertTrue(getMessageForSiteArrays(refGrid, perc.open), Arrays.equals(refGrid, perc.open));
        assertTrue(getMessageForConnectedSites(10, 7), perc.union.connected(10, 7));
        assertTrue(getMessageForConnectedSites(10, 8), perc.union.connected(10, 8));
        assertTrue(getMessageForConnectedSites(10, 9), perc.union.connected(10, 9));
    }

    @Test
    public void shouldBeConnectedAfterOpenWithRightOne() {
        Percolation perc = new Percolation(N);
        perc.open(2, 2);
        perc.open(2, 1);

        assertTrue(getMessageForConnectedSites(5, 4), perc.union.connected(5, 4));
    }

    @Test
    public void shouldBeConnectedAfterOpenWithLeftOne() {
        Percolation perc = new Percolation(N);
        perc.open(2, 1);
        perc.open(2, 2);

        assertTrue(getMessageForConnectedSites(5, 4), perc.union.connected(5, 4));
    }

    @Test
    public void shouldBeConnectedAfterOpenWithTopOne() {
        Percolation perc = new Percolation(N);
        perc.open(1, 2);
        perc.open(2, 2);

        assertTrue(getMessageForConnectedSites(5, 2), perc.union.connected(5, 2));
    }

    @Test
    public void shouldBeConnectedAfterOpenWithBottomOne() {
        Percolation perc = new Percolation(N);
        perc.open(2, 2);
        perc.open(1, 2);

        assertTrue(getMessageForConnectedSites(5, 2), perc.union.connected(5, 2));
    }

    @Test
    public void shouldBeConnectedAfterOpenWithVirtualTopThroughTwo() {
        Percolation perc = new Percolation(N);
        perc.open(1, 2);
        perc.open(2, 2);
        perc.open(2, 3);

        assertTrue(getMessageForConnectedSites(6, 0), perc.union.connected(6, 0));
    }

    @Test
    public void shouldBeConnectedAfterOpenWithVirtualBottomThroughTwo() {
        Percolation perc = new Percolation(N);
        perc.open(3, 2);
        perc.open(2, 2);
        perc.open(2, 3);

        assertTrue(getMessageForConnectedSites(6, 10), perc.union.connected(6, 10));
    }

    @Test
    public void shouldPercolate() {
        Percolation perc = new Percolation(N);
        perc.open(1, 1);
        perc.open(2, 1);
        perc.open(2, 2);
        perc.open(2, 3);
        perc.open(3, 3);

        assertTrue("Should percolate", perc.percolates());
    }

    @Test
    public void shouldBeFull() {
        Percolation perc = new Percolation(N);
        perc.open(1, 1);
        perc.open(2, 1);
        perc.open(2, 2);
        perc.open(2, 3);
        perc.open(3, 1);
        perc.open(3, 3);

        assertTrue("Should be full", perc.isFull(3, 3));
    }

    @Test
    public void shouldBeNotFull() {
        Percolation perc = new Percolation(N);
        perc.open(1, 1);
        perc.open(2, 1);
        perc.open(2, 2);
        perc.open(2, 3);
        perc.open(3, 1);
        perc.open(3, 3);

        // beckwash
        // assertFalse("Should be not full", perc.isFull(3, 1));
    }

    @Test
    public void shouldNotPercolate() {
        Percolation perc = new Percolation(N);
        perc.open(1, 1);
        perc.open(1, 3);
        perc.open(2, 2);
        perc.open(3, 1);
        perc.open(3, 3);

        assertFalse("Should not percolate", perc.percolates());
    }

    private boolean[] getRefOpenArray() {
        boolean[] out = new boolean[refSize];
        out[0] = true;
        out[out.length - 1] = true;
        return out;
    }


    private String getMessageForSiteArrays(final boolean[] ref, final boolean[] orig) {
        return String.format("Original open array '%s' should be same as '%s'",
                Arrays.toString(orig), Arrays.toString(ref));
    }

    private String getMessageForConnectedSites(final int p, final int q) {
        return String.format("Sites '%s' and '%s' should be connected", p, q);
    }

}
