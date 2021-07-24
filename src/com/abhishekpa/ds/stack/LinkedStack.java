package com.abhishekpa.ds.stack;

import com.abhishekpa.ds.linkedlist.Node;
import com.abhishekpa.ds.linkedlist.SimpleLinkedList;

import java.util.Objects;

public class LinkedStack<T extends Comparable>
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

    public void reverse() {
        if (!isEmpty()) {
            T data = pop();
            reverse();
            insertAtBottom(data);
        }
    }

    public void insertAtBottom(T data) {
        if (isEmpty()) {
            push(data);
            return;
        }
        T top = pop();
        insertAtBottom(data);
        push(top);
    }

    public void sort() {
        if (!isEmpty()) {
            T temp = pop();
            sort();
            sortedInsert(temp);
        }
    }

    public void sortedInsert(T data) {
        if (isEmpty() || peek().compareTo(data) <= 0)
            push(data);
        else {
            T temp = pop();
            sortedInsert(data);
            push(temp);
        }
    }

    public static void main(String[] args)
    {
        LinkedStack<Integer> stack = new LinkedStack<>();
        stack.push(2);
        stack.push(1);
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>(stack.head);
        list.printList();
        stack.reverse();
        list = new SimpleLinkedList<>(stack.head);
        list.printList();
        System.out.println(stack.size());
        System.out.println("Is Empty: " + stack.isEmpty());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("Is Empty: " + stack.isEmpty());
        stack.push(3);
        stack.push(1);
        stack.push(2);
        stack.push(4);
        stack.sort();
        list = new SimpleLinkedList<>(stack.head);
        list.printList();
    }
}
