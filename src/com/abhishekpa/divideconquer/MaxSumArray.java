package com.abhishekpa.divideconquer;

import com.abhishekpa.utils.ArrayUtils;

public class MaxSumArray {
    public static int[] maxSubArray(int[] values, int start, int end) {
        if (start == end) {
            return new int[]{start, end, values[start]};
        }
        int mid = start + (end - start)/2;
        int[] leftHighs = maxSubArray(values, start, mid);
        int[] rightHighs = maxSubArray(values, mid+1, end);
        int[] crossingHighs = maxCrossingSum(values, start, mid, end);
        if (leftHighs[2] >= rightHighs[2] && leftHighs[2] >= crossingHighs[2])
            return leftHighs;
        else if (rightHighs[2] >= leftHighs[2] && rightHighs[2] >= crossingHighs[2])
            return rightHighs;
        else
            return crossingHighs;
    }

    public static int[] maxCrossingSum(int[] values, int start, int mid, int end) {
        int sum = values[mid];
        int leftMaxSum = sum;
        int i = mid-1;
        int leftHigh = mid;
        while(i >= start) {
            sum += values[i];
            if (sum > leftMaxSum) {
                leftMaxSum = sum;
                leftHigh = i;
            }
            i--;
        }
        sum = values[mid+1];
        i = mid + 2;
        int rightMaxSum = sum;
        int rightHigh = mid + 1;
        while(i <= end) {
            sum += values[i];
            if(sum > rightMaxSum) {
                rightMaxSum = sum;
                rightHigh = i;
            }
            i++;
        }
        return new int[] {leftHigh, rightHigh, leftMaxSum + rightMaxSum};
    }

    public static void main(String[] args) {
        int[] values = new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        ArrayUtils.print(maxSubArray(values, 0, values.length-1));
    }
}
