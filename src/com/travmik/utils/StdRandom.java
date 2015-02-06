/*
 * Canadian Tire Corporation, Ltd. Do not reproduce without permission in writing.
 * Copyright (c) 2015 Canadian Tire Corporation, Ltd. All rights reserved.
 */

package com.travmik.utils;

import java.util.Random;

/**
 *  <i>Standard random</i>. This class provides methods for generating
 *  random number from various distributions.
 *  <p>
 *  For additional documentation, see <a href="http://introcs.cs.princeton.edu/22library">Section 2.2</a> of
 *  <i>Introduction to Programming in Java: An Interdisciplinary Approach</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public final class StdRandom {
    private static Random random;    // pseudo-random number generator

    // static initializer
    static {
        random = new Random(System.currentTimeMillis());
    }

    // don't instantiate
    private StdRandom() {
    }

    /**
     * Return real number uniformly in [0, 1).
     */
    public static double uniform() {
        return random.nextDouble();
    }

    /**
     * Returns an integer uniformly between 0 (inclusive) and N (exclusive).
     * @throws IllegalArgumentException if <tt>N <= 0</tt>
     */

    public static int uniform(int N) {
        if (N <= 0) throw new IllegalArgumentException("Parameter N must be positive");
        return random.nextInt(N);
    }

    ///////////////////////////////////////////////////////////////////////////
    //  STATIC METHODS BELOW RELY ON JAVA.UTIL.RANDOM ONLY INDIRECTLY VIA
    //  THE STATIC METHODS ABOVE.
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Returns a real number uniformly in [0, 1).
     * @deprecated clearer to use {@link #uniform()}
     */
    public static double random() {
        return uniform();
    }

    /**
     * Returns an integer uniformly in [a, b).
     * @throws IllegalArgumentException if <tt>b <= a</tt>
     * @throws IllegalArgumentException if <tt>b - a >= Integer.MAX_VALUE</tt>
     */
    public static int uniform(int a, int b) {
        if (b <= a) throw new IllegalArgumentException("Invalid range");
        if ((long) b - a >= Integer.MAX_VALUE) throw new IllegalArgumentException("Invalid range");
        return a + uniform(b - a);
    }

}
