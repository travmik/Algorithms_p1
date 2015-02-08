package com.travmik.assignment.percolation;

import com.travmik.utils.StdRandom;
import com.travmik.utils.StdStats;

public class PercolationStats {
    private double factor = 1.96;
    private final int number;
    private double[] results;

    public PercolationStats(final int N, final int T) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException(
                    String.format("Number of sites(N) '%s' and time(T) '%s' should be greater then 0", N, T));
        }
        number = N;
        results = new double[T];
        for (int i = 0; i < T; i++) {
            makeExperiment(i);
        }
    }

    private void makeExperiment(final int iteration) {
        Percolation perc = new Percolation(number);
        int n = 0;
        while (!perc.percolates()) {
            int row;
            int column;
            do {
                row = StdRandom.uniform(1, number + 1);
                column = StdRandom.uniform(1, number + 1);
            } while (perc.isOpen(row, column));
            perc.open(row, column);
            n++;
        }
        results[iteration] = (double) n / (number * number);
    }

    public double mean() {
        return StdStats.mean(results);
    }

    public double stddev() {
        return StdStats.stddev(results);
    }

    public double confidenceLo() {
        return mean() - (factor*stddev()/Math.sqrt(results.length));
    }

    public double confidenceHi() {
        return mean() + (factor*stddev()/Math.sqrt(results.length));
    }

    public static void main(String[] args) {
        PercolationStats p;
        int N, T;
        N = Integer.parseInt(args[0]);
        T = Integer.parseInt(args[1]);
        p = new PercolationStats(N, T);
        System.out.println("mean                    = " + p.mean());
        System.out.println("stddev                  = " + p.stddev());
        System.out.println("95% confidence interval = " + p.confidenceLo() + ", " + p.confidenceHi());
    }
}
