package com.abhishekpa.sort;

import com.abhishekpa.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort {
    public static int[] sort(int[] values) {
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length - i - 1; j++) {
                if (values[j] > values[j+1]) {
                    ArrayUtils.swap(values, j, j+1);
                }
            }
        }
        return values;
    }

    public static void main(String[] args) {
        List<int[]> listOfArray = new ArrayList<>();
        listOfArray.add(new int[]{});
        listOfArray.add(new int[]{1});
        listOfArray.add(new int[]{1, -1});
        listOfArray.add(new int[]{0, 1, -1});
        listOfArray.add(new int[]{-8, 0, 1, -4, -8, 1, 5, 3, -9});

        for (int[] values : listOfArray) {
            ArrayUtils.print(sort(values));
        }
    }
}
