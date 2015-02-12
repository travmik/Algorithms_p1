package com.travmik.assignment.queuedeque;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class RandomizedQueueTest1 {
    private Deque<Integer> deque;

    @Before
    public void setUp() {
        deque = new Deque<Integer>();
    }

    @Test(expected = NullPointerException.class)
    public void testFailOnAddingLastNullElement() {
        deque.addLast(null);
    }

    @Test(expected = NullPointerException.class)
    public void testFailOnAddingFirstNullElement() {
        deque.addFirst(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void testFailOnEmptyDequeForRemoveLast() {
        deque.removeLast();
    }

    @Test(expected = NoSuchElementException.class)
    public void testFailOnEmptyDequeForRemoveFirst() {
        deque.removeFirst();
    }

    @Test
    public void testAddFirst() {
        deque.addFirst(123);
        assertEquals(1, deque.size());
        assertEquals(Integer.valueOf(123), deque.removeFirst());
        assertEquals(0, deque.size());
    }

    @Test
    public void testAddLast() {
        deque.addLast(123);
        assertEquals(1, deque.size());
        assertEquals(Integer.valueOf(123), deque.removeLast());
        assertEquals(0, deque.size());
    }

    @Test
    public void testIterator() {
        deque.addFirst(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addFirst(0);
        Iterator<Integer> iterator = deque.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(0), iterator.next());
        assertEquals(Integer.valueOf(1), iterator.next());
        assertEquals(Integer.valueOf(2), iterator.next());
        assertEquals(Integer.valueOf(3), iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void addFirstAddLast() {
        deque.addFirst(1);
        assertEquals(Integer.valueOf(1), deque.removeLast());
        deque.addFirst(1);
        deque.addFirst(2);
        assertEquals(Integer.valueOf(1), deque.removeLast());
    }

    /** Tests coursera's test10 case. */
    @Test(expected = NoSuchElementException.class)
    public void test10() {
        deque.addFirst(1);
        deque.addLast(2);
        deque.removeFirst();
        deque.removeLast();
        deque.addLast(2);
        deque.removeFirst();
        Iterator<Integer> iterator = deque.iterator();
        System.out.println(deque.isEmpty());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
    }
}
