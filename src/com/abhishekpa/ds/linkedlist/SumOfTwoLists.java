package com.abhishekpa.ds.linkedlist;

import java.util.Objects;
import java.util.Stack;

public class SumOfTwoLists
{
    public static SimpleLinkedList<Integer> sum(SimpleLinkedList<Integer> first, SimpleLinkedList<Integer> second)
    {
        Stack<Node<Integer>> stack1 = new Stack<>();
        Stack<Node<Integer>> stack2 = new Stack<>();
        Stack<Node<Integer>> stack3 = new Stack<>();

        Node<Integer> head = first.getHead();
        while(Objects.nonNull(head)) {
            stack1.push(head);
            head = head.getNext();
        }

        head = second.getHead();
        while (Objects.nonNull(head)) {
            stack2.push(head);
            head = head.getNext();
        }

        int carry = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            Node<Integer> firstNode = stack1.pop();
            Node<Integer> secondNode = stack2.pop();

            int sum = carry + firstNode.getData() + secondNode.getData();
            Node<Integer> node = new Node<>(sum % 10);
            stack3.push(node);
            if (sum > 9) {
                carry = 1;
            } else {
                carry = 0;
            }
        }

        while(!stack1.isEmpty()) {
            Node<Integer> firstNode = stack1.pop();
            int sum = carry + firstNode.getData();
            Node<Integer> node = new Node<>(sum % 10);
            stack3.push(node);
            if (sum > 9) {
                carry = 1;
            } else {
                carry = 0;
            }
        }

        while(!stack2.isEmpty()) {
            Node<Integer> secondNode = stack2.pop();
            int sum = carry + secondNode.getData();
            Node<Integer> node = new Node<>(sum % 10);
            stack3.push(node);
            if (sum > 9) {
                carry = 1;
            } else {
                carry = 0;
            }
        }

        if (carry == 1) stack3.push(new Node<>(1));

        if (stack3.isEmpty()) return new SimpleLinkedList<>(new Node<>(0));
        Node<Integer> newList = stack3.pop();
        Node<Integer> newListHead = newList;
        while (!stack3.isEmpty()) {
            newList.setNext(stack3.pop());
            newList = newList.getNext();
        }
        return new SimpleLinkedList<>(newListHead);
    }

    /*
        Another way can be reversing the linked lists
        and adding all numbers one by one with carry
     */

    public static void main(String[] args)
    {
        SimpleLinkedList<Integer> num1 = new SimpleLinkedList<>();
        num1.push(7);
        num1.push(3);
        num1.push(6);
        num1.push(9);
        SimpleLinkedList<Integer> num2 = new SimpleLinkedList<>();
        num2.push(4);
        num2.push(5);
        num2.push(6);
        sum(num1, num2).printList();
    }
}
