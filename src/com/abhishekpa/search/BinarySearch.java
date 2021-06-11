package com.abhishekpa.search;

public class BinarySearch {
    public static int search(int[] values, int key) {
        return binarySearch(values, key, 0, values.length-1);
    }

    private static int binarySearch(int[] values, int key, int start, int end) {
        if (start > end) return -1;
        int mid = start + (end - start) / 2;
        if (values[mid] == key) {
            return mid;
        } else if (values[mid] < key) {
            return binarySearch(values, key, mid+1, end);
        } else {
            return binarySearch(values, key, start, mid-1);
        }
    }

    public static void main(String[] args) {
        int[] values = new int[]{};
        System.out.println(search(values, 1));
        values = new int[] {1};
        System.out.println(search(values, 1));
        System.out.println(search(values, -1));
        values = new int[] {-1, 0, 1, 2, 5};
        System.out.println(search(values, -1));
        System.out.println(search(values, 5));
        System.out.println(search(values, 2));
        System.out.println(search(values, 1000));
    }
}
