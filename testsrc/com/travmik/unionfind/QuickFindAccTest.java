package com.travmik.unionfind;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class QuickFindAccTest {
    @Test
    public void acceptanceTest() throws Exception {
        int[] ref = {1, 1, 1, 8, 8, 1, 1, 1, 8, 8};
        QuickFindUF quickFind = new QuickFindUF(10);
        quickFind.union(4, 3);
        quickFind.union(3, 8);
        quickFind.union(6, 5);
        quickFind.union(9, 4);
        quickFind.union(2, 1);
        quickFind.union(8, 9);
        quickFind.union(5, 0);
        quickFind.union(7, 2);
        quickFind.union(6, 1);


        assertTrue(String.format("QuickFind array '%s' should be same as '%s'", Arrays.toString(quickFind.getArray
                ()), Arrays.toString(ref)), Arrays.equals(quickFind.getArray(), ref));
    }
}
