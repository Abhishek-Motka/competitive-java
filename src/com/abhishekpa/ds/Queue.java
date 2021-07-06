package com.abhishekpa.ds;

import com.abhishekpa.utils.ArrayUtils;

public class Queue {
    int[] array;
    int head;
    int tail;

    public Queue(int size) {
        this.array = new int[size];
    }

    public int enqueue(int value) {
        this.array[this.tail] = value;
        this.tail = (this.tail + 1) % array.length;
        return value;
    }

    public int dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue underflow");
        int val = this.array[this.head++];
        this.head %= array.length;
        return val;
    }

    public void print() {
        System.out.print("Queue: ");
        int i = this.head;
        while(i != this.tail) {
            System.out.print(this.array[i]);
            System.out.print(", ");
            i = (i + 1) % array.length;
        }
        System.out.println();
    }

    public int search(int value) {
        int i = this.head;
        while(i != this.tail) {
            if (array[i] == value) return i;
            i = (i+1) % array.length;
        }
        throw new RuntimeException("Value not found");
    }

    private boolean isFull() {
        return ((this.tail + 1) % array.length) == this.head;
    }

    private boolean isEmpty() {
        return this.head == this.tail;
    }

    public static void main(String[] args) {
        Queue q = new Queue(10);
        q.print();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.print();
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        q.print();
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        q.print();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(7);
        q.enqueue(8);
        q.enqueue(9);
        q.print();
        q.enqueue(10);
    }
}
