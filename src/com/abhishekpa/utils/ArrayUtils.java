package com.abhishekpa.utils;

public class ArrayUtils {
    public static void print(int[] values) {
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + ", ");
        }
        if (values.length == 0) System.out.print("Empty Array");
        System.out.println();
    }

    public static void print(int[] values, int start, int end) {
        if (values.length == 0) {
            System.out.println("Empty Array");
            return;
        }
        if (start < 0 || end < 0 || start >= values.length || end >= values.length || start > end) {
            throw new IllegalArgumentException("Invalid start and end point provided");
        }
        for (int i = start; i <= end; i++) {
            System.out.print(values[i] + ", ");
        }
        System.out.println();
    }

    public static void swap(int[] values, int i, int j) {
        if (i != j) {
            values[i] += values[j];
            values[j] = values[i] - values[j];
            values[i] -= values[j];
        }
    }
}
