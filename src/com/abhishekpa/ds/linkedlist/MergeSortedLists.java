package com.abhishekpa.ds.linkedlist;

import java.util.Objects;

public class MergeSortedLists
{
    public static <T extends Comparable> SimpleLinkedList<T> mergeLists(SimpleLinkedList<T> list1, SimpleLinkedList<T> list2) {
        Node<T> dummyNode = new Node<>(null);
        Node<T> curr = dummyNode;
        Node<T> curr1 = list1.getHead();
        Node<T> curr2 = list2.getHead();
        while (true) {
            if (Objects.isNull(curr1)) {
                curr.setNext(curr2);
                break;
            }

            if (Objects.isNull(curr2)) {
                curr.setNext(curr1);
                break;
            }

            if (curr1.getData().compareTo(curr2.getData()) > 0) {
                curr.setNext(curr2);
                curr2 = curr2.getNext();
            } else {
                curr.setNext(curr1);
                curr1 = curr1.getNext();
            }
            curr = curr.getNext();
        }
        return new SimpleLinkedList<T>(dummyNode.getNext());
    }

    public static <T extends Comparable<T>> Node<T> recursiveMerge(Node<T> first, Node<T> second) {
        if (Objects.isNull(first)) return second;
        if (Objects.isNull(second)) return first;

        if (first.getData().compareTo(second.getData()) > 0) {
            second.setNext(recursiveMerge(first, second.getNext()));
            return second;
        } else {
            first.setNext(recursiveMerge(first.getNext(), second));
            return first;
        }
    }

    public static void main(String[] args)
    {
        SimpleLinkedList<Integer> list1 = new SimpleLinkedList<>();
        list1.append(1);
        list1.append(3);
        list1.append(5);
        SimpleLinkedList<Integer> list2 = new SimpleLinkedList<>();
        list2.append(2);
        list2.append(4);
        list2.append(6);
        SimpleLinkedList<Integer> mergedList = mergeLists(list1, list2);
        mergedList.printList();
        SimpleLinkedList<Integer> list3 = new SimpleLinkedList<>();
        list3.append(1);
        list3.append(3);
        list3.append(5);
        SimpleLinkedList<Integer> list4 = new SimpleLinkedList<>();
        list4.append(2);
        list4.append(4);
        list4.append(6);
        SimpleLinkedList<Integer> mergedList2 = new SimpleLinkedList<>(recursiveMerge(list3.getHead(), list4.getHead()));
        mergedList2.printList();
    }
}
