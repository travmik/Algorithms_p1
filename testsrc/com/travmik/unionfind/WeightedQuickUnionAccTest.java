package com.travmik.unionfind;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class WeightedQuickUnionAccTest {
    @Test
    public void acceptanceTest() throws Exception {
        int[] ref = {6, 2, 6, 4, 6, 6, 6, 2, 4, 4};
        MyWeightedQuickUnionUF wQuickUnion = new MyWeightedQuickUnionUF(10);
        wQuickUnion.union(4, 3);
        wQuickUnion.union(3, 8);
        wQuickUnion.union(6, 5);
        wQuickUnion.union(9, 4);
        wQuickUnion.union(2, 1);
        wQuickUnion.union(5, 0);
        wQuickUnion.union(7, 2);
        wQuickUnion.union(6, 1);
        wQuickUnion.union(7, 3);


        assertTrue(String.format("Weighted QuickUnion array '%s' should be same as '%s'",
                Arrays.toString(wQuickUnion.getArray()), Arrays.toString(ref)),
                Arrays.equals(wQuickUnion.getArray(), ref));
    }
}
