package com.abhishekpa.sort;

import com.abhishekpa.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class CountingSort {
    public static int[] sort(int[] array) {
        if (array.length == 0) return array;
        int max = ArrayUtils.max(array);
        return countingSort(array, max);
    }

    private static int[] countingSort(int[] array, int max) {
        if (max < 0) throw new RuntimeException("Counting sort does not work with negative numbers");
        int[] count = new int[max+1];
        for (int i = 0; i < count.length; i++) count[i] = 0;
        for (int value : array) count[value]++;
        for (int i = 1; i < count.length; i++) count[i] += count[i-1];
        int[] sortedArray = new int[array.length];
        for (int value : array) {
            sortedArray[count[value]-1] = value;
            count[value]--;
        }
        return sortedArray;
    }

    public static void main(String[] args) {
        List<int[]> listOfArray = new ArrayList<>();
        listOfArray.add(new int[]{});
        listOfArray.add(new int[]{1});
        listOfArray.add(new int[]{1, 0});
        listOfArray.add(new int[]{0, 1, 2});
        listOfArray.add(new int[]{2, 1, 0});
        listOfArray.add(new int[]{9, 0, 1, 4, 7, 1, 3, 5});

        for (int[] values : listOfArray) {
            ArrayUtils.print(sort(values));
        }
    }
}
