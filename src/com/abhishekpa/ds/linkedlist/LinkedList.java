package com.abhishekpa.ds.linkedlist;

public class LinkedList
{
    private Node head;
    private Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insert(int value) {
        if (this.tail == null) {
            this.head = new Node(null, null, value);
            this.tail = this.head;
        } else {
            this.tail.next = new Node(null, this.tail, value);
            this.tail = this.tail.next;
        }
    }

    public void delete(Node n) {
        if (n.prev != null) n.prev.next = n.next;
        else this.head = n.next;
        if (n.next != null) n.next.prev = n.prev;
        else this.tail = n.prev;
    }

    public void print() {
        Node curr = this.head;
        while(curr != null) {
            System.out.print(curr.value);
            System.out.print(", ");
            curr = curr.next;
        }
        System.out.println();
    }

    public Node search(int value) {
        Node curr = this.head;
        while (curr != null) {
            if (curr.value == value) return curr;
            curr = curr.next;
        }
        throw new RuntimeException("Value not found");
    }

    class Node {
        public Node next;
        public Node prev;
        public int value;

        public Node(Node next, Node prev, int value) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.insert(1);
        l.insert(2);
        l.print();
        l.insert(3);
        l.insert(4);
        l.insert(5);
        l.print();
        Node n = l.search(3);
        l.delete(n);
        l.print();
    }
}
