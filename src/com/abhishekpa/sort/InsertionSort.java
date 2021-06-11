package com.abhishekpa.sort;

import com.abhishekpa.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort {
    public static int[] sort(int... input) {
        for (int i = 1; i < input.length; i++) {
            int j = i;
            int currValue = input[i];
            while (j > 0 && input[j-1] > currValue) {
                input[j] = input[j-1];
                j--;
            }
            input[j] = currValue;
        }
        return input;
    }

    public static int[] reverseSort(int... values) {
        for (int i = 1; i < values.length; i++) {
            int currValue = values[i];
            int j = i;
            while(j > 0 && values[j-1] <= currValue) {
                values[j] = values[j-1];
                j--;
            }
            values[j] = currValue;
        }
        return values;
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
