package com.travmik.stackNqueue;

public class QueueOfStrings {

    public QueueOfStrings() {
    }

    public void enqueue(final String item) {
    }

    public String dequeue() {
        return "";
    }

    public boolean isEmpty() {
        return false;
    }

    public int size() {
        return 0;
    }

    private class Node {
        private String item;
        private Node next;
    }
}
