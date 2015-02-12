package com.travmik.assignment.queuedeque;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DequeTest {

    @Test
    public void shouldAddFirstChangeSize() {
        Deque<String> deque = new Deque<>();
        deque.addFirst("powel");
        deque.addFirst("Stas");
        // [Stas, powel]

        assertEquals("Should has 2 elements", 2, deque.size());
    }

    @Test
    public void shouldAddFirst() {
        Deque<String> deque = new Deque<>();
        deque.addFirst("powel");
        deque.addFirst("Stas");
        // [Stas, powel]

        Iterator<String> iter = deque.iterator();
        assertTrue("Should has next", iter.hasNext());
        assertEquals("Should be the same", "Stas", iter.next());
        assertTrue("Should has next", iter.hasNext());
        assertEquals("Should be the same", "powel", iter.next());
    }

    @Test
    public void shouldAddLastChangeSize() {
        Deque<String> deque = new Deque<>();
        deque.addLast("Stas");
        deque.addLast("powel");
        // [Stas, powel]

        assertEquals("Should has 2 elements", 2, deque.size());
    }

    @Test
    public void shouldAddLast() {
        Deque<String> deque = new Deque<>();
        deque.addLast("Stas");
        deque.addLast("powel");
        // [Stas, powel]

        Iterator<String> iter = deque.iterator();
        assertTrue("Should has next", iter.hasNext());
        assertEquals("Should be the same", "Stas", iter.next());
        assertTrue("Should has next", iter.hasNext());
        assertEquals("Should be the same", "powel", iter.next());
    }


    @Test
    public void shouldRemoveFirst() {
        Deque<String> deque = new Deque<>();
        deque.addFirst("Stas");
        deque.addFirst("powel");
        deque.addFirst("guliat!");
        // [guliat!, powel, Stas]

        String item = deque.removeFirst();
        assertEquals("Should has 2 elements", 2, deque.size());
        assertEquals("Should be the same", "guliat!", item);
    }

    @Test
    public void shouldRemoveLast() {
        Deque<String> deque = new Deque<>();
        deque.addFirst("Stas");
        deque.addFirst("powel");
        deque.addFirst("guliat!");
        // [guliat!, powel, Stas]

        String item = deque.removeLast();
        assertEquals("Should has 2 elements", 2, deque.size());
        assertEquals("Should be the same", "Stas", item);
    }

    @Test
    public void shouldNotHaveNext() {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.addLast(2);
        deque.removeFirst();
        deque.removeLast();
        deque.addLast(2);
        deque.removeFirst();
        Iterator<Integer> iterator = deque.iterator();
        assertFalse("Should not have next", iterator.hasNext());
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerAddFirst() {
        Deque<String> deque = new Deque<>();
        deque.addFirst(null);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerAddLast() {
        Deque<String> deque = new Deque<>();
        deque.addLast(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldThrowNoSuchElementRemoveFirst() {
        Deque<String> deque = new Deque<>();
        deque.removeFirst();
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldThrowNoSuchElementRemoveLast() {
        Deque<String> deque = new Deque<>();
        deque.removeLast();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldThrowUnsupportedOperationIteratorRemove() {
        Deque<String> deque = new Deque<>();
        deque.iterator().remove();
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldThrowNoSuchElementEmptyIteratorNext() {
        Deque<String> deque = new Deque<>();
        deque.iterator().next();
    }
}