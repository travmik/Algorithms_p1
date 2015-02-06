package com.travmik.unionfind;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class QuickUnionAccTest {
    @Test
    public void acceptanceTest() throws Exception {
        int[] ref = {1, 8, 1, 8, 3, 0, 5, 1, 8, 8};
        QuickUnionUF quickUnion = new QuickUnionUF(10);
        quickUnion.union(4, 3);
        quickUnion.union(3, 8);
        quickUnion.union(6, 5);
        quickUnion.union(9, 4);
        quickUnion.union(2, 1);
        quickUnion.union(8, 9);
        quickUnion.union(5, 0);
        quickUnion.union(7, 2);
        quickUnion.union(6, 1);
        quickUnion.union(7, 3);


        assertTrue(String.format("QuickUnion array '%s' should be same as '%s'", Arrays.toString(quickUnion.getArray
                        ()), Arrays.toString(ref)), Arrays.equals(quickUnion.getArray(), ref));
    }

}
