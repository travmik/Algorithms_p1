package com.travmik.assignment.queuedeque;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.travmik.utils.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] array;
    private int size;

    // construct an empty randomized queue
    public RandomizedQueue() {
        array = (Item[]) new Object[1];
        size = 0;

    }

    // is the queue empty?
    public boolean isEmpty() {
        return size() == 0;
    }

    // return the number of items on the queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new NullPointerException("Item should be not null");
        }
        resizeIfTooSmall();
        array[size++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        checkIsNotEmpty();
        final int randomIndex = StdRandom.uniform(size);
        Item item = array[randomIndex];
        size--;
        array[randomIndex] = array[size];
        array[size] = null;
        resizeIfTooBig();

        return item;
    }

    private void resizeIfTooBig() {
        if (size != 0 && size <= array.length / 4) {
            resize(array.length / 2);
        }
    }

    private void resizeIfTooSmall() {
        if (size == array.length) {
            resize(2 * array.length);
        }
    }

    // return (but do not remove) a random item
    public Item sample() {
        checkIsNotEmpty();
        return array[StdRandom.uniform(size)];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator(array);
    }

    private void checkIsNotEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException("There is no elements.");
        }
    }

    private void resize(final int newSize) {
        Item[] newArray = (Item[]) new Object[newSize];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private Item[] randArr;
        private int currentIndex;

        public RandomizedQueueIterator(final Item[] array) {
            if (size > 0) {
                this.randArr = (Item[]) new Object[size];
                randArr[0] = array[0];
                for (int i = 1; i < size; i++) {
                    Item temp = array[i];
                    int randIndex = StdRandom.uniform(i + 1);
                    randArr[i] = randArr[randIndex];
                    randArr[randIndex] = temp;
                }
                this.currentIndex = 0;
            }
        }

        public boolean hasNext() {
            return currentIndex != size;
        }

        public void remove() {
            throw new java.lang.UnsupportedOperationException("Remove now is not supported");
        }

        public Item next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException("There is no elements.");
            }
            return randArr[currentIndex++];
        }
    }
}
