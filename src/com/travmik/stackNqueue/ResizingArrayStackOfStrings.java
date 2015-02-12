package com.travmik.stackNqueue;

public class ResizingArrayStackOfStrings {

    private String[] stack;
    private int index;

    public ResizingArrayStackOfStrings() {
        stack = new String[1];
        index = 0;
    }

    public void push(final String item) {
        if (index == stack.length) {
            resize(2 * stack.length);
        }
        stack[index++] = item;
    }

    public String pop() {
        String item = stack[--index];
        if (index <= stack.length / 4) {
            resize(stack.length/2);
        }
        return item;
    }

    private void resize(final int newSize) {
        String[] newStack = new String[newSize];
        for(int i = 0; i < stack.length; i++){
            newStack[i] = stack[i];
        }
        stack = newStack;
    }

    public boolean isEmpty() {
        return false;
    }

    public int size() {
        return 0;
    }
}
