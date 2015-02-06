package com.travmik.unionfind;

public class QuickUnionUF extends AbstractUF {

    public QuickUnionUF(final int N) {
        super(N);
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int rootP = root(p);
        int rootQ = root(q);
        if (rootP == rootQ) {
            return;
        }
        id[rootP] = rootQ;
    }

    private int root(int i) {
        while (id[i] != i) {
            i = id[i];
        }
        return i;
    }
}
