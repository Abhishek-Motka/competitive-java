package com.abhishekpa.ds.stack;

public class TwoStack
{
    int top1, top2;
    int [] stack;

    public TwoStack(int capacity) {
        stack = new int[capacity];
        top1 = -1;
        top2 = capacity;
    }

    public void push1(int data) {
        if (top1 < top2 - 1) {
            top1++;
            stack[top1] = data;
        } else {
            System.out.println("Stack overflow");
        }
    }

    public void push2(int data) {
        if (top1 < top2 - 1) {
            top2--;
            stack[top2] = data;
        } else {
            System.out.println("Stack overflow");
        }
    }

    public int pop1() {
        if (top1 >= 0) {
            return stack[top1--];
        } else {
            System.out.println("Stack underflow");
            return Integer.MIN_VALUE;
        }
    }

    public int pop2() {
        if (top2 < stack.length) {
            return stack[top2++];
        } else {
            System.out.println("Stack underflow");
            return Integer.MIN_VALUE;
        }
    }

    public int peek1() {
        if (isEmpty1()) return Integer.MIN_VALUE;
        return stack[top1];
    }

    public int peek2() {
        if (isEmpty2()) return Integer.MIN_VALUE;
        return stack[top2];
    }

    public boolean isEmpty1() {
        return top1 < 0;
    }

    public boolean isEmpty2() {
        return top2 >= stack.length;
    }

    public static void main(String[] args)
    {
        TwoStack stack = new TwoStack(5);
        stack.push1(1);
        stack.push1(2);
        stack.push2(3);
        System.out.println(stack.peek1());
        System.out.println(stack.peek2());
        System.out.println(stack.pop2());
        System.out.println(stack.pop1());
        System.out.println(stack.pop1());
        System.out.println(stack.isEmpty1());
        System.out.println(stack.isEmpty2());
    }
}
