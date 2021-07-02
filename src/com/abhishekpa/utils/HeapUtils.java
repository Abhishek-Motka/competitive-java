package com.abhishekpa.utils;

public class HeapUtils {

    public static int left(int i) {
        return (i << 1) + 1;
    }

    public static int right(int i) {
        return (i + 1) << 1;
    }

    public static int parent(int i) {
        return (i - 1) >> 1;
    }

    public static boolean isMaxHeap(int[] values, int heapSize) {
        if (heapSize > values.length) throw new RuntimeException("Heap Size can not be greater than array length");
        for (int i = 0; i < values.length/2; i++) {
            int l = left(i);
            int r = right(i);
            if (l < values.length && values[i] < values[l]) return false;
            if (r < values.length && values[i] < values[r]) return false;
        }
        return true;
    }

    public static boolean isMinHeap(int[] values, int heapSize) {
        if (heapSize > values.length) throw new RuntimeException("Heap Size can not be greater than array length");
        for (int i = 0; i < values.length/2; i++) {
            int l = left(i);
            int r = right(i);
            if (l < values.length && values[i] > values[l]) return false;
            if (r < values.length && values[i] > values[r]) return false;
        }
        return true;
    }

    public static void maxHeapifyRecursive(int[] values, int heapSize, int node) {
        if (heapSize > values.length) throw new RuntimeException("Heap Size can not be greater than array length");
        int left = left(node);
        int right = right(node);
        int largest = node;
        if (left < heapSize && values[left] > values[largest]) largest = left;
        if (right < heapSize && values[right] > values[largest]) largest = right;
        if (largest != node) {
            ArrayUtils.swap(values, largest, node);
            maxHeapifyRecursive(values, heapSize, largest);
        }
    }

    public static void maxHeapifyIterative(int[] values, int heapSize, int node) {
        int i = node;
        while(i < heapSize) {
            int left = left(i);
            int right = right(i);
            int largest = i;
            if (left < heapSize && values[left] > values[largest]) largest = left;
            if (right < heapSize && values[right] > values[largest]) largest = right;
            if (largest != i) {
                ArrayUtils.swap(values, largest, i);
                i = largest;
            } else {
                break;
            }
        }
    }

    public static void minHeapifyRecursive(int[] values, int heapSize, int node) {
        if (heapSize > values.length) throw new RuntimeException("Heap Size can not be greater than array length");
        int left = left(node);
        int right = right(node);
        int smallest = node;
        if (left < heapSize && values[left] < values[smallest]) smallest = left;
        if (right < heapSize && values[right] < values[smallest]) smallest = right;
        if (smallest != node) {
            ArrayUtils.swap(values, smallest, node);
            minHeapifyRecursive(values, heapSize, smallest);
        }
    }

    public static void minHeapifyIterative(int[] values, int heapSize, int node) {
        int i = node;
        while(i < heapSize) {
            int left = left(i);
            int right = right(i);
            int smallest = i;
            if (left < heapSize && values[left] < values[smallest]) smallest = left;
            if (right < heapSize && values[right] < values[smallest]) smallest = right;
            if (smallest != i) {
                ArrayUtils.swap(values, smallest, i);
                i = smallest;
            } else {
                break;
            }
        }
    }

    public static void toMaxHeap(int[] array) {
        int heapSize = array.length;
        for (int i = array.length/2; i >= 0; i--) {
            maxHeapifyIterative(array, heapSize, i);
        }
    }

    public static void toMinHeap(int[] array) {
        int heapSize = array.length;
        for (int i = array.length/2; i>= 0; i--) {
            minHeapifyIterative(array, heapSize, i);
        }
    }

    public static void main(String[] args) {
        System.out.println(left(5));
        System.out.println(right(5));
        System.out.println(parent(11));
        System.out.println(parent(12));
        System.out.println(isMaxHeap(new int[] {23, 17, 14, 6, 13, 10, 1, 5, 7, 12}, 10));
        int[] array = new int[] {27, 17, 3, 16, 13, 10, 1, 5, 7, 12, 4, 8, 9, 0};
        maxHeapifyIterative(array, array.length, 2);
        ArrayUtils.print(array);
        array = new int[] {1, 4, 3, 7, 4, 5, 10, 9, 7, 8, 6, 20, 30, 25, 22, 10, 19, 15, 13, 16, 17};
        toMaxHeap(array);
        System.out.println(isMaxHeap(array, array.length));
        array = new int[] {1, 4, 3, 7, 4, 5, 10, 9, 7, 8, 6, 20, 30, 25, 22, 10, 19, 15, 13, 16, 17};
        toMinHeap(array);
        System.out.println(isMinHeap(array, array.length));
    }
}
