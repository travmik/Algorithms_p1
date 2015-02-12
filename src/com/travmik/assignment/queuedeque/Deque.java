package com.travmik.assignment.queuedeque;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node tail;
    private Node head;
    private int size = 0;

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addLast(Item item) {
        if (item == null) {
            throw new NullPointerException("Item should be not null");
        }
        Node node = new Node();
        node.item = item;
        node.next = null;
        node.prev = tail;
        if (size == 0) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
    }

    // add the item to the end
    public void addFirst(Item item) {
        if (item == null) {
            throw new NullPointerException("Item should be not null");
        }
        Node node = new Node();
        node.item = item;
        node.prev = null;
        if (size == 0) {
            tail = node;
            node.next = null;
        } else {
            head.prev = node;
            node.next = head;
        }
        head = node;
        size++;
    }

    // remove and return the item from the front
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Dequeue is empty");
        }
        Item item = tail.item;
        if (size > 1) {
            tail = tail.prev;
            tail.next = null;
        } else {
            head = null;
            tail = null;
        }
        size--;
        return item;
    }

    // remove and return the item from the end
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Dequeue is empty");
        }
        Item item = head.item;
        if (size > 1) {
            head = head.next;
            head.prev = null;
        } else {
            head = null;
            tail = null;
        }
        size--;
        return item;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = head;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException("Remove now is not supported");
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("There is no elements.");
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }
}
