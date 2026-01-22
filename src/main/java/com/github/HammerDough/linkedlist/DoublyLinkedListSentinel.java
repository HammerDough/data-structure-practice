package com.github.HammerDough.linkedlist;

import java.util.Iterator;

public class DoublyLinkedListSentinel implements Iterable<Integer> {

    static class Node {
        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;

    public DoublyLinkedListSentinel() {
        head = new Node(null, 0, null);
        tail = new Node(null, 0, null);

        head.next = tail;
        tail.prev = head;
    }

    private Node findNode(int index) {
        int i = -1;
        for (Node p = head; p != tail; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null;
    }

    public void insert(int index, int value) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw new IllegalArgumentException(String.format("index [%d] 不合法%n", index));
        }
        Node next = prev.next;
        Node inserted = new Node(prev, value, next);
        prev.next = inserted;
        next.prev = inserted;
    }

    public int remove(int index) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw new IllegalArgumentException(String.format("index [%d] 不合法%n", index));
        }
        Node removed = prev.next;
        if (removed == tail) {
            throw new IllegalArgumentException(String.format("index [%d] 不合法%n", index));
        }
        Node next = removed.next;

        prev.next = next;
        next.prev = prev;

        return removed.value;
    }

    public void addFirst(int value) {
        Node next = head.next;
        Node added = new Node(head, value, next);
        head.next = added;
        next.prev = added;
    }

    public void addLast(int value) {
        Node last = tail.prev;
        Node added = new Node(last, value, tail);
        last.next = added;
        tail.prev = added;
    }

    public int removeFirst() {
        return remove(0);
    }

    public int removeLast() {
        Node removed = tail.prev;
        if (removed == head) {
            throw new IllegalArgumentException(String.format("index [0] 不合法%n"));
        }
        Node prev = removed.prev;
        prev.next = tail;
        tail.prev = prev;
        return removed.value;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;

            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }


}
