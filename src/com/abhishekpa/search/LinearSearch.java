package com.abhishekpa.search;


public class LinearSearch {
    public static int search(int key, int... values) {
        for (int i = 0; i < values.length; i++) {
            if (values[i] == key) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] values = new int[]{};
        System.out.println(search(1, values));
        values = new int[] {1};
        System.out.println(search(1, values));
        System.out.println(search(-1, values));
        values = new int[] {1, -1, 0, 2, 5};
        System.out.println(search(1, values));
        System.out.println(search(5, values));
        System.out.println(search(2, values));
        System.out.println(search(1000, values));
    }
}
