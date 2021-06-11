package com.abhishekpa.sort;

import com.abhishekpa.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static int[] sort(int[] values) {
        mergeSort(values, 0, values.length - 1);
        return values;
    }

    public static void mergeSort(int[] values, int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start)/2;
        mergeSort(values, start, mid);
        mergeSort(values, mid+1, end);
        merge(values, start, mid, end);
    }

    public static void merge(int[] values, int start, int mid, int end) {
        int[] aux = new int[end-start+1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (values[i] < values[j]) {
                aux[k++] = values[i++];
            } else {
                aux[k++] = values[j++];
            }
        }
        while (i <= mid) {
            aux[k++] = values[i++];
        }
        while (j <= end) {
            aux[k++] = values[j++];
        }
        for (i = start, k = 0; i <= end; i++) {
            values[i] = aux[k++];
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
