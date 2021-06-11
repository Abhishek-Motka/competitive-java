package com.abhishekpa.sort.problems;

import com.abhishekpa.sort.MergeSort;

public class TwoSum {
    private static boolean findTwoElementsWithSum(int[] values, int sum) {
        MergeSort.sort(values);
        int i = 0;
        int j = values.length-1;
        while (i < j) {
            if (values[i] + values[j] == sum) {
                return true;
            } else if (values[i] + values[j] < sum) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] values = new int[]{4, -1, 0, 2, 3, -5, 8, 6};
        System.out.println(findTwoElementsWithSum(values, 3));
        values = new int[]{4, -1, 0, 2, 3, -5, 8, 6};
        System.out.println(findTwoElementsWithSum(values, -2));
        values = new int[]{4, -1, 0, 2, 3, -5, 8, 6};
        System.out.println(findTwoElementsWithSum(values, 14));
        values = new int[]{4, -1, 0, 2, 3, -5, 8, 6};
        System.out.println(findTwoElementsWithSum(values, -6));
        values = new int[]{4, -1, 0, 2, 3, -5, 8, 6};
        System.out.println(findTwoElementsWithSum(values, 100));
    }
}
