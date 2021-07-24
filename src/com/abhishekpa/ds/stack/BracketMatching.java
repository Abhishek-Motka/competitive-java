package com.abhishekpa.ds.stack;

public class BracketMatching
{
    public static boolean areBracketsBalanced(String brackets) {
        LinkedStack<Character> stack = new LinkedStack<>();
        for (int i = 0; i < brackets.length(); i++) {
            char currChar = brackets.charAt(i);
            if (currChar == '{' || currChar == '[' || currChar == '(') {
                stack.push(currChar);
            } else {
                if (stack.isEmpty()) return false;
                switch (stack.pop()) {
                    case '{':
                        if (currChar != '}') return false;
                        break;
                    case '[':
                        if (currChar != ']') return false;
                        break;
                    case '(':
                        if (currChar != ')') return false;
                        break;
                    default:
                        return false;
                }
            }
        }
        if (stack.isEmpty()) return true;
        else return false;
    }

    public static void main(String[] args)
    {
        System.out.println(areBracketsBalanced("("));
        System.out.println(areBracketsBalanced("{"));
        System.out.println(areBracketsBalanced("["));
        System.out.println(areBracketsBalanced("}"));
        System.out.println(areBracketsBalanced(")"));
        System.out.println(areBracketsBalanced("]"));
        System.out.println(areBracketsBalanced("{]"));
        System.out.println(areBracketsBalanced("}{"));
        System.out.println(areBracketsBalanced("{}([]{[]()})[[][[[]]]{}([])]"));
    }
}
