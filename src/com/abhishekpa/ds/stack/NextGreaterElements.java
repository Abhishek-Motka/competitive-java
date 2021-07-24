package com.abhishekpa.ds.stack;

import sun.awt.image.ImageWatched;

public class NextGreaterElements
{
    public static void printNextGreaterElement(int... array) {
        int size = array.length;
        int[] nge = new int[size];
        LinkedStack<Integer> stack = new LinkedStack<>();
        for (int i = size - 1; i >= 0; i--) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.peek() <= array[i])
                    stack.pop();
            }
            nge[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(array[i]);
        }
        for (int i = 0; i < size; i++)
            System.out.println(array[i] + " ---> " + nge[i]);
    }

    public static void main(String[] args)
    {
        printNextGreaterElement(11, 13, 21, 3);
        printNextGreaterElement(13, 7, 6, 12);
    }
}
