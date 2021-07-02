package com.abhishekpa.utils;

public class ArrayUtils {
    public static void print(int[] values) {
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + ", ");
        }
        if (values.length == 0) System.out.print("Empty Array");
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
