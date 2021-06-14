package com.abhishekpa.divideconquer;


public class NumberOfInversion {

    public static int inversions(int[] values, int start, int end) {
        if (start >= end) return 0;

        int mid = start + (end - start)/2;
        int invLeft = inversions(values, start, mid);
        int invRight = inversions(values, mid+1, end);
        return countInversions(values, start, mid, end) + invLeft + invRight;
    }

    public static int countInversions(int[] values, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = 0;
        int inv = 0;
        int[] aux = new int[end-start+1];
        while (i <= mid && j <= end) {
            if (values[i] > values[j]) {
                aux[k++] = values[j++];
                // all remaining elements in left array are greater than curr element in right array, resulting in inversions
                inv += mid - i + 1;
            } else {
                aux[k++] = values[i++];
            }
        }
        while (i <= mid) {
            aux[k++] = values[i++];
        }
        while(j <= end) {
            aux[k++] = values[j++];
        }
        for (i = start, k = 0; k < aux.length; k++) {
            values[i++] = aux[k];
        }
        return inv;
    }

    public static void main(String[] args) {
        int[] values = new int[] {2, 4, 1, 3, 5};
        System.out.println(inversions(values, 0, values.length-1));
    }
}
