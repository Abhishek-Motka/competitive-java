package com.abhishekpa.ds.stack;


import java.util.Objects;

public class ReverseString
{
    public static String reverse(String input) {
        LinkedStack<Character> stack = new LinkedStack<>();
        int size = input.length();
        for (int i = 0; i < size; i++) {
            stack.push(input.charAt(i));
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) builder.append(stack.pop());
        return builder.toString();
    }

    public static String reverseWithArray(String input) {
        if (Objects.isNull(input)) return null;
        char[] chars = input.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }

    public static void main(String[] args)
    {
        String[] words = new String[] {"hello", "WorLd", "AbhIsheK", "HahA", "A", "", "aa"};
        for (String word : words) {
            System.out.println(reverse(word));
            System.out.println(reverseWithArray(word));
        }
    }
}
