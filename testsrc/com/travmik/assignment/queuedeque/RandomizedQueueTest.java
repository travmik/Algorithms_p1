package com.travmik.assignment.queuedeque;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class RandomizedQueueTest {
    private final static int SIZE = 100;

    @Test
    public void emptyAfterInit() {
        RandomizedQueue<String> queue = new RandomizedQueue<>();

        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test(expected = NullPointerException.class)
    public void shouldEnqueueThrowNullPointer() {
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        queue.enqueue(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldDenqueueThrowNoSuchElement() {
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        queue.dequeue();
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldSampleThrowNoSuchElement() {
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        queue.sample();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldIteratorRemoveThrowUnsupportedOperation() {
        RandomizedQueue<String> deque = new RandomizedQueue<>();
        deque.iterator().remove();
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldIteratorNextEmptyThrowNoSuchElement() {
        RandomizedQueue<String> deque = new RandomizedQueue<>();
        deque.iterator().next();
    }

    @Test
    public void shouldEnqueueAndIncreaseSize() {
        RandomizedQueue<String> queue = new RandomizedQueue<>();

        queue.enqueue("Stas");

        assertEquals(1, queue.size());
        assertFalse(queue.isEmpty());
    }

    @Test
    public void shouldSampleAndLeaveOldSize() {
        RandomizedQueue<String> queue = new RandomizedQueue<String>();

        queue.enqueue("Stas");

        queue.sample();

        assertEquals(1, queue.size());
        assertFalse(queue.isEmpty());
    }

    @Test
    public void shouldFullIterate() {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();

        for (int i = 0; i < SIZE; i++) {
            queue.enqueue(i);
        }

        Iterator<Integer> iter = queue.iterator();

        Integer[] results = new Integer[SIZE];

        for (int i = 0; i < SIZE; i++) {
            assertTrue(iter.hasNext());
            results[i] = iter.next();
        }

        assertFalse(iter.hasNext());
        assertEquals(SIZE, results.length);
    }

    @Test
    public void shouldNotHaveNullInIterator() throws Exception {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};


        for (Integer number : array) {
            queue.enqueue(number);
        }

        for (Integer deckItem : queue) {
            assertNotNull(deckItem);
        }
    }
}
