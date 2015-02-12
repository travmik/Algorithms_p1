package com.travmik.assignment.queuedeque;

import com.travmik.utils.StdIn;
import com.travmik.utils.StdOut;

public class Subset {
    public static void main(String[] args) {
        int numberToOutput = Integer.parseInt(args[0]);
        RandomizedQueue<String> queue = new RandomizedQueue<>();

        while (!StdIn.isEmpty()) {
            queue.enqueue(StdIn.readString());
        }

        for (int i = 0; i < numberToOutput; i++) {
            StdOut.println(queue.dequeue());
        }
    }
}
