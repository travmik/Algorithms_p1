package com.travmik.unionfind;

public abstract class AbstractUF {
    protected final int[] id;

    public AbstractUF(final int N){
        this.id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    abstract boolean connected(int p, int q);

    abstract void union(int p, int q);

    public String getFormattedArray() {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < id.length; i++) {
            out.append(id[i] + " ");
        }
        return out.toString().trim();
    }

    public int[] getArray() {
        return id;
    }
}
