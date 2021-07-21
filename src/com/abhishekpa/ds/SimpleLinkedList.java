package com.abhishekpa.ds;

import com.abhishekpa.ds.exceptions.InvalidIndexException;

import java.util.Objects;

public class SimpleLinkedList<T>
{
    private Node<T> head;

    public void push(T data) {
        if (Objects.isNull(head)) {
            head = new Node<>(data);
            return;
        }
        Node<T> node = new Node<>(data, head);
        head = node;
        return;
    }

    public void insert(T data, int position) {
        if (position == 0) {
            push(data);
            return;
        }

        int i = 1;
        Node<T> current = head;
        while (i < position && Objects.nonNull(current)) {
            current = current.getNext();
            i++;
        }

        if (Objects.isNull(current)) throw new InvalidIndexException();

        Node<T> node = new Node<>(data, current.next);
        current.setNext(node);
    }

    public void append(T data) {
        if (Objects.isNull(head)) {
            head = new Node<>(data);
            return;
        }

        Node<T> current = head;
        while (Objects.nonNull(current.getNext())) {
            current = current.getNext();
        }
        current.setNext(new Node(data));
    }

    public void printList() {
        Node<T> current = head;
        System.out.print("List: [");
        while (current != null) {
            System.out.print(current.getData().toString()+",");
            current = current.getNext();
        }
        System.out.print("]");
    }

    public static void main(String[] args)
    {
        SimpleLinkedList<Integer> linkedList = new SimpleLinkedList<>();
        linkedList.push(1);
        linkedList.push(2);
        linkedList.push(3);
        linkedList.insert(5, 2);
        linkedList.insert(4, 1);
        linkedList.insert(0, 0);
        linkedList.append(6);
        linkedList.append(7);
        linkedList.printList();
    }

    private class Node<T> {
        private T data;
        private Node next;

        public Node(T data)
        {
            this(data, null);
        }

        public Node(T data, Node next)
        {
            this.data = data;
            this.next = next;
        }

        public T getData()
        {
            return data;
        }

        public Node getNext()
        {
            return next;
        }

        public void setNext(Node next)
        {
            this.next = next;
        }
    }
}
