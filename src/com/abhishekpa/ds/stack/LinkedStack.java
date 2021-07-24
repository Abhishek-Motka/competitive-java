package com.abhishekpa.ds.stack;

import com.abhishekpa.ds.linkedlist.Node;

import java.util.Objects;

public class LinkedStack<T>
{
    Node<T> head;

    public LinkedStack() {
        this(null);
    }

    public LinkedStack(Node<T> head) {
        this.head = head;
    }

    public void push(T data) {
        if (Objects.isNull(head)) {
            head = new Node<>(data);
            return;
        }

        Node<T> node = new Node<>(data);
        node.setNext(head);
        head = node;
    }

    public T pop() {
        if (Objects.isNull(head)) return null;
        Node<T> node = head;
        head = head.getNext();
        return node.getData();
    }

    public T peek() {
        if (Objects.isNull(head)) return null;
        return head.getData();
    }

    public boolean isEmpty() {
        return Objects.isNull(head);
    }

    public int size() {
        int i = 0;
        Node<T> curr = head;
        while (Objects.nonNull(curr)) {
            i++;
            curr = curr.getNext();
        }
        return i;
    }

    public static void main(String[] args)
    {
        LinkedStack<Integer> stack = new LinkedStack<>();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.size());
        System.out.println("Is Empty: " + stack.isEmpty());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("Is Empty: " + stack.isEmpty());
    }
}
