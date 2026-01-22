package com.github.HammerDough.linkedlist;

import java.util.Iterator;

/**
 * 双向链表（带哨兵）
 */
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

    /**
     * 按索引查找节点
     * @param index 索引
     * @return 节点
     */
    private Node findNode(int index) {
        int i = -1;
        for (Node p = head; p != tail; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null;
    }

    /**
     * 按索引插入
     * @param index 索引
     * @param value 插入值
     */
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

    /**
     * 按索引删除
     * @param index 索引
     * @return 删除的值
     */
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

    /**
     * 头插法
     * @param value 插入值
     */
    public void addFirst(int value) {
        Node next = head.next;
        Node added = new Node(head, value, next);
        head.next = added;
        next.prev = added;
    }

    /**
     * 尾插法
     * @param value 插入值
     */
    public void addLast(int value) {
        Node last = tail.prev;
        Node added = new Node(last, value, tail);
        last.next = added;
        tail.prev = added;
    }

    /**
     * 删除头
     * @return 删除的值
     */
    public int removeFirst() {
        return remove(0);
    }

    /**
     * 删除尾
     * @return 删除的值
     */
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

    /**
     * 迭代器实现
     * @return 迭代器
     */
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
