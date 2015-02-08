package com.travmik.utils;

/**
 *  <i>Standard statistics</i>. This class provides methods for computing
 *  statistics such as min, max, mean, sample standard deviation, and
 *  sample variance.
 *  <p>
 *  For additional documentation, see
 *  <a href="http://introcs.cs.princeton.edu/22library">Section 2.2</a> of
 *  <i>Introduction to Programming in Java: An Interdisciplinary Approach</i>
 *  by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public final class StdStats {

    private StdStats() {
    }

    /**
     * Returns the maximum value in the array a[], -infinity if no such value.
     */
    /**
     * Returns the sample standard deviation in the array a[], NaN if no such value.
     */
    public static double stddev(double[] a) {
        return Math.sqrt(var(a));
    }

    /**
     * Returns the sample variance in the array a[], NaN if no such value.
     */
    public static double var(double[] a) {
        if (a.length == 0) return Double.NaN;
        double avg = mean(a);
        double sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            sum += (a[i] - avg) * (a[i] - avg);
        }
        return sum / (a.length - 1);
    }

    /**
     * Returns the average value in the array a[], NaN if no such value.
     */
    public static double mean(double[] a) {
        if (a.length == 0) return Double.NaN;
        double sum = sum(a);
        return sum / a.length;
    }

    /**
     * Returns the sum of all values in the array a[].
     */
    public static double sum(double[] a) {
        double sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }
}
