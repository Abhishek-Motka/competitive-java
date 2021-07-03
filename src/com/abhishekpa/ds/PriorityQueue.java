package com.abhishekpa.ds;

import com.abhishekpa.utils.ArrayUtils;
import com.abhishekpa.utils.HeapUtils;

public class PriorityQueue {
    int[] heap;
    int heapSize;

    public PriorityQueue(int size) {
        this.heap = new int[size];
        this.heapSize = 0;
    }

    public PriorityQueue(int[] array) {
        HeapUtils.toMaxHeap(array);
        this.heap = array;
        this.heapSize = array.length;
    }

    public int max() {
        if (this.heapSize <= 0) {
            throw new RuntimeException("Heap Underflow");
        }
        return this.heap[0];
    }

    public int extractMax() {
        if (this.heapSize <= 0) {
            throw new RuntimeException("Heap Underflow");
        }
        int max = this.heap[0];
        this.heap[0] = this.heap[this.heapSize-1];
        this.heapSize = this.heapSize - 1;
        HeapUtils.maxHeapifyIterative(this.heap, this.heapSize, 0);
        return max;
    }

    public PriorityQueue increaseKey(int key, int node) {
        if (node >= this.heapSize || node < 0) {
            throw new IllegalArgumentException("Referred node does not exist in heap");
        }
        this.heap[node] += key;
        while (node > 0) {
            int parent = HeapUtils.parent(node);
            if (this.heap[parent] < this.heap[node]) {
                ArrayUtils.swap(this.heap, parent, node);
                node = parent;
            } else {
                break;
            }
        }
        return this;
    }

    public PriorityQueue decreaseKey(int key, int node) {
        if (node >= this.heapSize || node < 0) {
            throw new IllegalArgumentException("Referred node does not exist in heap");
        }
        this.heap[node] -= key;
        HeapUtils.maxHeapifyIterative(this.heap, this.heapSize, node);
        return this;
    }

    public PriorityQueue updateKey(int key, int node) {
        if (node >= this.heapSize || node < 0) {
            throw new IllegalArgumentException("Referred node does not exist in heap");
        }
        int oldKey = this.heap[node];
        if (oldKey < key) {
            return this.increaseKey(key - oldKey, node);
        } else if (oldKey > key) {
            return this.decreaseKey(oldKey - key, node);
        }
        return this;
    }

    public boolean isMaxHeap() {
        return HeapUtils.isMaxHeap(this.heap, this.heapSize);
    }

    public PriorityQueue insert(int key) {
        if (this.heapSize >= this.heap.length) {
            throw new RuntimeException("Heap Overflow");
        }
        this.heap[this.heapSize] = key;
        this.heapSize++;
        this.increaseKey(0, this.heapSize-1);
        return this;
    }

    public PriorityQueue delete(int node) {
        if (node < 0 || node >= this.heapSize) {
            throw new IllegalArgumentException("Node does not exist");
        }
        this.heap[node] = this.heap[this.heapSize - 1];
        this.heapSize--;
        HeapUtils.maxHeapifyIterative(this.heap, this.heapSize, node);
        return this;
    }

    public void print() {
        if (this.heapSize == 0) {
            System.out.println("Empty Heap");
        } else {
            ArrayUtils.print(this.heap, 0, this.heapSize - 1);
        }
    }

    public int size() {
        return this.heapSize;
    }

    public static void main(String[] args) {
        PriorityQueue q1 = new PriorityQueue(10);
        q1.insert(1).insert(5).insert(3).insert(4).insert(6).insert(10).insert(1).insert(2);
        q1.print();
        System.out.println(q1.isMaxHeap());
        System.out.println(q1.max());
        q1.delete(0).delete(0).delete(0).delete(0).print();
        q1.delete(0).delete(0).delete(0).delete(0).print();
        System.out.println(q1.isMaxHeap());

        PriorityQueue q2 = new PriorityQueue(new int[] {1, 5, 3, 4, 6, 10, 1, 2});
        q2.print();
        System.out.println(q2.isMaxHeap());
        q2.updateKey(7, 5).print();
        System.out.println(q2.isMaxHeap());
        q2.updateKey(0, 1).print();
        System.out.println(q2.isMaxHeap());
        while (q2.size() > 0) {
            System.out.println(q2.extractMax());
        }
    }
}
