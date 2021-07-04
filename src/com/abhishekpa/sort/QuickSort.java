package com.abhishekpa.sort;

import com.abhishekpa.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuickSort {

    private static Random random = new Random();

    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int lastSwaped = start - 1;
        for (int i = start; i <= end; i++) {
            if (array[i] <= pivot) {
                lastSwaped++;
                ArrayUtils.swap(array, lastSwaped, i);
            }
        }
        return lastSwaped;
    }

    private static int randomPartition(int[] array, int start, int end) {
        int pivot = start + random.nextInt(end - start);
        ArrayUtils.swap(array, pivot, end);
        return partition(array, start, end);
    }

    private static void quickSort(int[] array, int start, int end) {
        if (start >= end) return;
        int pivot = randomPartition(array, start, end);
        quickSort(array, start, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    public static int[] sort(int[] array) {
        quickSort(array, 0, array.length-1);
        return array;
    }

    public static void main(String[] args) {
        List<int[]> listOfArray = new ArrayList<>();
        listOfArray.add(new int[]{});
        listOfArray.add(new int[]{1});
        listOfArray.add(new int[]{1, -1});
        listOfArray.add(new int[]{0, 1, -1});
        listOfArray.add(new int[]{-8, 0, 1, -4, -8, 1, 3, 5});

        for (int[] values : listOfArray) {
            ArrayUtils.print(sort(values));
        }
    }
}
