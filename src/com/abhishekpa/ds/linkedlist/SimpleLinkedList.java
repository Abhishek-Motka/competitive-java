package com.abhishekpa.ds.linkedlist;

import com.abhishekpa.ds.exceptions.InvalidIndexException;

import javax.security.auth.login.CredentialNotFoundException;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<T extends Comparable>
{
    private Node<T> head;

    public SimpleLinkedList () {
        head = null;
    }

    public SimpleLinkedList(Node<T> head) {
        this.head = head;
    }

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

        Node<T> node = new Node<>(data, current.getNext());
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

    public void delete(int position) {
        if (Objects.isNull(head)) throw new InvalidIndexException();
        if (position == 0) {
            head = head.getNext();
            return;
        }
        Node<T> current = head;
        int i = 1;
        while (i != position && Objects.nonNull(current)) {
            i++;
            current = current.getNext();
        }

        if (Objects.isNull(current) || Objects.isNull(current.getNext())) throw new InvalidIndexException();
        current.setNext(current.getNext().getNext());
    }

    public void printList() {
        Node<T> current = head;
        System.out.print("List: [");
        while (current != null) {
            System.out.print(current.getData().toString()+",");
            current = current.getNext();
        }
        System.out.println("]");
    }

    public int size() {
        Node<T> current = head;
        int i = 0;
        while (Objects.nonNull(current)) {
            current = current.getNext();
            i++;
        }
        return i;
    }

    public void swapNodes(T data1, T data2) {
        if (data1.equals(data2)) return;

        Node<T> prev1 = null, curr1 = head;
        while (Objects.nonNull(curr1) && !curr1.getData().equals(data1)) {
            prev1 = curr1;
            curr1 = curr1.getNext();
        }

        Node<T> prev2 = null, curr2 = head;
        while (Objects.nonNull(curr2) && !curr2.getData().equals(data2)) {
            prev2 = curr2;
            curr2 = curr2.getNext();
        }

        if (Objects.isNull(curr1) || Objects.isNull(curr2)) throw new NoSuchElementException();

        if (Objects.isNull(prev1)) {
            head = curr2;
        } else {
            prev1.setNext(curr2);
        }

        if (Objects.isNull(prev2)) {
            head = curr1;
        } else {
            prev2.setNext(curr1);
        }

        Node<T> temp = curr1.getNext();
        curr1.setNext(curr2.getNext());
        curr2.setNext(temp);
    }

    public void reverse() {
        Node<T> prev = null;
        Node<T> curr = head;
        Node<T> next = null;

        while(Objects.nonNull(curr)) {
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void reverse(int k) {
        head = reverseKNodes(head, k);
    }

    public Node<T> reverseKNodes(Node<T> node, int k) {
        if (Objects.isNull(node)) return node;
        Node<T> curr = node;
        Node<T> prev = null;
        Node<T> next = null;

        int count = 0;
        while (count < k && Objects.nonNull(curr)) {
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
            count++;
        }

        if (Objects.nonNull(next)) {
            node.setNext(reverseKNodes(next, k));
        }

        return prev;
    }

    public void reverseRecursive() {
        if (Objects.isNull(head)) return;
        recursiveReverseUtil(head, null);
    }

    public void recursiveReverseUtil(Node<T> curr, Node<T> prev) {
        if (Objects.isNull(curr.getNext())) {
            head = curr;
            curr.setNext(prev);
            return;
        }

        Node<T> next = curr.getNext();
        curr.setNext(prev);
        recursiveReverseUtil(next, curr);
    }

    public Node<T> getHead() {
        return head;
    }

    public void sort() {
        head = mergeSort(head);
    }

    private Node<T> mergeSort(Node<T> node) {
        if (Objects.isNull(node) || Objects.isNull(node.getNext())) return node;

        Node<T> middle = getMiddle(node);
        Node<T> nextOfMiddle = middle.getNext();
        middle.setNext(null);

        Node<T> left = mergeSort(node);
        Node<T> right = mergeSort(nextOfMiddle);

        return MergeSortedLists.recursiveMerge(left, right);
    }

    private Node<T> getMiddle(Node<T> node) {
        if (Objects.isNull(node)) return node;

        Node<T> slow = node;
        Node<T> fast = node;

        while(Objects.nonNull(fast.getNext()) && Objects.nonNull(fast.getNext().getNext())) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return slow;
    }

    public void rotate(int n) {
        if (Objects.isNull(head) || Objects.isNull(head.getNext())) return;
        Node<T> curr = head;
        while (Objects.nonNull(curr.getNext())) curr = curr.getNext();
        curr.setNext(head);
        curr = head;
        for (int i = 1; i < n; i++) curr = curr.getNext();
        head = curr.getNext();
        curr.setNext(null);
    }

    public static void main(String[] args)
    {
        SimpleLinkedList<Integer> linkedList = new SimpleLinkedList<>();
        linkedList.push(3);
        linkedList.push(2);
        linkedList.push(1);
        linkedList.insert(5, 2);
        linkedList.insert(4, 1);
        linkedList.insert(0, 0);
        linkedList.append(6);
        linkedList.append(7);
        linkedList.printList();
        linkedList.delete(0);
        linkedList.delete(6);
        linkedList.delete(3);
        linkedList.printList();
        linkedList.swapNodes(3, 6);
        linkedList.swapNodes(4, 2);
        linkedList.swapNodes(2, 1);
        linkedList.printList();
        linkedList.reverse();
        linkedList.printList();
        linkedList.reverseRecursive();
        linkedList.printList();
        linkedList.sort();
        linkedList.printList();
        linkedList.reverse(3);
        linkedList.printList();
        linkedList.rotate(2);
        linkedList.printList();
        System.out.println("Size: " + linkedList.size());
    }
}
