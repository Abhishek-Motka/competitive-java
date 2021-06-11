package com.abhishekpa.sort;

import com.abhishekpa.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort {
    public static int[] sort(int[] values) {
        for (int i = 0; i < values.length - 1; i++) {
            int min = indexOfMinValue(values, i+1);
            swap(values, i, min);
        }
        return values;
    }

    private static int indexOfMinValue(int[] values, int start) {
        int min = start;
        for (int i = min + 1; i < values.length; i++) {
            if (values[i] < values[min]) min = i;
        }
        return min;
    }

    private static void swap(int[] values, int i, int j) {
        if (i != j) {
            values[i] += values[j];
            values[j] = values[i] - values[j];
            values[i] -= values[j];
        }
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
