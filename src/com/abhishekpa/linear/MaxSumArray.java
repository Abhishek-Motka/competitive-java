package com.abhishekpa.linear;

import com.abhishekpa.utils.ArrayUtils;

public class MaxSumArray {
    public static int[] maxSumArray(int[] values, int start, int end) {
        int i = 0, low = 0, high = 0, max = 0, currSum = 0, currLow = 0;
        while (i <= end) {
            currSum += values[i];
            if (currSum > max) {
                max = currSum;
                low = currLow;
                high = i;
            } else if (currSum < 0) {
                currSum = 0;
                currLow = i + 1;
            }
            i++;
        }
        return new int[] {low, high, max};
    }

    public static void main(String[] args) {
        int[] values = new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        ArrayUtils.print(maxSumArray(values, 0, values.length-1));
    }
}
