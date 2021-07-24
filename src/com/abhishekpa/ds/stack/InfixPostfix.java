package com.abhishekpa.ds.stack;

import sun.awt.image.ImageWatched;

import java.util.regex.Matcher;

public class InfixPostfix
{
    private static boolean isOperator(char op) {
        switch (op) {
            case '+':
            case '-':
            case '*':
            case '/':
            case '^':
            case '(':
            case ')':
                return true;
            default:
                return false;
        }
    }

    private static int prec(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            case '(':
                return 4;
            default:
                return -1;
        }
    }

    public static String convertInfixToPostfix(String infix) {
        StringBuilder result = new StringBuilder();
        LinkedStack<Character> stack = new LinkedStack<>();

        for (int i = 0; i < infix.length(); i++) {
            char currChar = infix.charAt(i);
            if (!isOperator(currChar)) {
                result.append(currChar);
            }
            else if (currChar == ')') {
                while(stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && stack.peek() != '(' && prec(stack.peek()) >= prec(currChar)) {
                    result.append(stack.pop());
                }
                stack.push(currChar);
            }
        }

        while (!stack.isEmpty()) result.append(stack.pop());

        return result.toString();
    }

    public static int evaluatePostfix(String postfix) {
        LinkedStack<Integer> stack = new LinkedStack<>();
        for (int i = 0; i < postfix.length(); i++) {
            int currChar = postfix.charAt(i);
            if (Character.isDigit(currChar)) {
                stack.push(currChar - '0');
            } else {
                int a = stack.pop();
                int b = stack.pop();
                switch (currChar) {
                    case '+':
                        stack.push(b+a);
                        break;
                    case '-':
                        stack.push(b-a);
                        break;
                    case '*':
                        stack.push(a*b);
                        break;
                    case '/':
                        stack.push(b/a);
                        break;
                    case '^':
                        stack.push(Math.round((float) Math.pow(b, a)));
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static int evaluateInfix(String infix) {
        String postFix = convertInfixToPostfix(infix);
        return evaluatePostfix(postFix);
    }

    public static void main(String[] args)
    {
        String infix = "1+2*(2^2-1)^(1+2*2)-7";
        System.out.println(convertInfixToPostfix(infix));
        System.out.println(evaluateInfix(infix));
    }
}
