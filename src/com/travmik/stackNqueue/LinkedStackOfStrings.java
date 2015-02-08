package com.travmik.stackNqueue;

public class LinkedStackOfStrings {
    private Node firstNode;

    public LinkedStackOfStrings() {
    }

    public void push(final String item) {
        Node oldFirst = firstNode;
        firstNode = new Node();
        firstNode.item = item;
        firstNode.next = oldFirst;
    }

    public String pop() {
        String out = firstNode.item;
        firstNode = firstNode.next;
        return out;
    }

    public boolean isEmpty() {
        return firstNode == null;
    }

    public int size() {
        return 0;
    }

    private class Node {
        private String item;
        private Node next;
    }
}
