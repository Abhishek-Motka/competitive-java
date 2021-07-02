package com.abhishekpa.sort;

import com.abhishekpa.utils.ArrayUtils;
import com.abhishekpa.utils.HeapUtils;

import java.util.ArrayList;
import java.util.List;

public class HeapSort {
    public static int[] sort(int[] array) {
        HeapUtils.toMaxHeap(array);
        int heapSize = array.length;
        for (int i = array.length-1; i > 0; i--) {
            ArrayUtils.swap(array, i, 0);
            heapSize--;
            HeapUtils.maxHeapifyIterative(array, heapSize, 0);
        }
        return array;
    }

    public static void main(String[] args)
    {
        List<int[]> listOfArray = new ArrayList<>();
        listOfArray.add(new int[]{});
        listOfArray.add(new int[]{1});
        listOfArray.add(new int[]{1, -1});
        listOfArray.add(new int[]{0, 1, -1});
        listOfArray.add(new int[]{-8, 0, 1, -4, -8, 3, 1, 5});

        for (int[] values : listOfArray)
        {
            ArrayUtils.print(sort(values));
        }
    }
}
