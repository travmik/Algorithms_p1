/*
 * Canadian Tire Corporation, Ltd. Do not reproduce without permission in writing.
 * Copyright (c) 2015 Canadian Tire Corporation, Ltd. All rights reserved.
 */

package com.travmik.unionfind;

public class MyWeightedQuickUnionUF extends AbstractUF {
    private final int[] sz;

    public MyWeightedQuickUnionUF(final int N) {
        super(N);
        this.sz = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i] = 1;
        }
    }

    public boolean connected(final int p, final int q) {
        return root(p) == root(q);
    }

    public void union(final int p, final int q) {
        int rootP = root(p);
        int rootQ = root(q);
        if (rootP == rootQ) {
            return;
        }

        if (sz[rootP] < sz[rootQ]) {
            id[rootP] = rootQ;
            sz[rootQ] += sz[rootP];
        } else {
            id[rootQ] = rootP;
            sz[rootP] += sz[rootQ];
        }
    }

    public int count() {
        return id.length;
    }

    public int[] getArray() {
        return id;
    }

    private int root(int i) {
        while (id[i] != i) {
            i = id[i];
        }
        return i;
    }
}
