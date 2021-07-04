package com.abhishekpa.ds;

import com.abhishekpa.utils.ArrayUtils;

public class Stack {
    int[] values;
    int top;

    public Stack(int size) {
        if (size < 1) throw new IllegalArgumentException("Invalid size for stack");
        this.values = new int[size];
        this.top = -1;
    }

    public boolean isEmpty() {
        return top >= 0;
    }

    public int push(int value) {
        if (this.top == this.values.length - 1) throw new RuntimeException("Stack Overflow");
        this.values[++this.top] = value;
        return value;
    }

    public int pop() {
        if (this.top < 0) throw new RuntimeException("Stack Underflow");
        return this.values[this.top--];
    }

    public int search(int value) {
        for (int i = this.top; i >= 0; i--) {
            if (this.values[i] == value) return i;
        }
        throw new RuntimeException("Value not found");
    }

    public void print() {
        if (this.top <  0) {
            System.out.println("Empty Stack");
            return;
        }
        ArrayUtils.print(this.values, 0, this.top);
    }

    public int size() {
        return this.top + 1;
    }

    public static void main(String[] args) {
        Stack stack = new Stack(10);
        System.out.println(stack.isEmpty());
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.print();
        System.out.println(stack.pop());
        System.out.println(stack.search(2));
        System.out.println(stack.size());
        stack.pop();
        stack.pop();
        System.out.println(stack.size());
    }
}
