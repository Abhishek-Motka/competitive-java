package com.abhishekpa.ds.stack;


public class StockSpan
{
    public static int[] calculateSpan(int... values) {
        int[] spans = new int[values.length];
        LinkedStack<Integer> spanStack = new LinkedStack<>();
        spanStack.push(0);
        spans[0] = 1;
        for (int i = 1; i < values.length; i++) {
            while (!spanStack.isEmpty() && values[spanStack.peek()] <= values[i])
                spanStack.pop();
            spans[i] = spanStack.isEmpty() ? (i+1) : i - spanStack.peek();
            spanStack.push(i);
        }
        return spans;
    }

    public static int[] calculateSpanItr(int... values) {
        int[] ans = new int[values.length];
        ans[0] = 1;
        for (int i = 1; i < values.length; i++) {
            int counter = 1;
            while ((i - counter) >= 0 && values[i] >= values[i - counter])
                counter += ans[i - counter];
            ans[i] = counter;
        }
        return ans;
    }

    public static void main(String[] args)
    {
        for (int val : calculateSpanItr(10, 4, 5, 90, 120, 80)) {
            System.out.println(val);
        }
    }
}
