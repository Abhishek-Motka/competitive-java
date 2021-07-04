package com.abhishekpa.divideconquer;

import com.abhishekpa.sort.InsertionSort;
import com.abhishekpa.utils.ArrayUtils;

import java.util.Random;

public class NthSmallestNumber {

    private static Random random = new Random();

    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int lastSwapped = start - 1;
        for (int i = start; i <= end; i++) {
            if (array[i] <= pivot) {
                lastSwapped++;
                ArrayUtils.swap(array, i, lastSwapped);
            }
        }
        return lastSwapped;
    }

    private static int randomPartition(int[] array, int start, int end) {
        int pivot = start + random.nextInt(end - start);
        ArrayUtils.swap(array, pivot, end);
        return partition(array, start, end);
    }

    public static int nthSmallest(int[] array, int i) {
        if (i < 1 || i > array.length) throw new IllegalArgumentException("Can't find given minimum value");
        i--;
        int start = 0, end = array.length - 1;
        int pivot = randomPartition(array, start, end);
        while (pivot != i) {
            if (pivot < i) start = pivot + 1;
            else end = pivot - 1;
            if (start == end) return array[start];
            pivot = randomPartition(array, start, end);
        }
        return array[pivot];
    }

    public static void main(String[] args) {
        int[] array = new int[] {4, 1, 3, 2, 6, 4, 5, 7, 10, 1, 2, 1, 0, -19, -5};
        ArrayUtils.print(InsertionSort.sort(array));
        System.out.println(nthSmallest(array, 1));
        System.out.println(nthSmallest(array, 2));
        System.out.println(nthSmallest(array, 3));
        System.out.println(nthSmallest(array, 4));
        System.out.println(nthSmallest(array, 5));
        System.out.println(nthSmallest(array, 6));
        System.out.println(nthSmallest(array, 7));
        System.out.println(nthSmallest(array, 8));
        System.out.println(nthSmallest(array, 9));
        System.out.println(nthSmallest(array, 10));
        System.out.println(nthSmallest(array, 11));
        System.out.println(nthSmallest(array, 12));
        System.out.println(nthSmallest(array, 13));
        System.out.println(nthSmallest(array, 14));
        System.out.println(nthSmallest(array, 15));
    }
}
