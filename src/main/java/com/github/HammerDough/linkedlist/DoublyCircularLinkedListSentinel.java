package com.github.HammerDough.linkedlist;

import java.util.Iterator;

public class DoublyCircularLinkedListSentinel implements Iterable<Integer> {

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

    private Node sentinel = new Node(null, -1, null);

    public DoublyCircularLinkedListSentinel() {
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    /**
     * 头插法
     * @param value 插入值
     */
    public void addFirst(int value){
        Node next = sentinel.next;
        Node added = new Node(sentinel,value,next);
        next.prev = added;
        sentinel.next = added;
    }

    /**
     * 尾插法
     * @param value 插入值
     */
    public void addLast(int value){
        Node prev = sentinel.prev;
        Node added = new Node(prev,value,sentinel);
        prev.next = added;
        sentinel.prev = added;
    }

    /**
     * 删除头元素
     */
    public void removeFirst(){
        Node removed = sentinel.next;
        if(removed == sentinel){
            throw new IllegalArgumentException("非法");
        }
        Node next = removed.next;
        sentinel.next = next;
        next.prev = sentinel;
    }

    /**
     * 根据值删除元素
     * @param value 删除值
     */
    public void removeByValue(int value){
        while(true){
            Node removed = findByValue(value);
            if(removed == null){
                return;
            }
            Node prev = removed.prev;
            Node next = removed.next;
            prev.next = next;
            next.prev = prev;
        }
    }

    /**
     * 根据值查找节点
     * @param value 查找值
     * @return 节点
     */
    private Node findByValue(int value){
        Node p = sentinel.next;
        while(p!=sentinel){
            if(p.value==value){
                return p;
            }
            p=p.next;
        }
        return null;
    }

    /**
     * 删除尾元素
     */
    public void removeLast(){
        Node removed = sentinel.prev;
        if(removed == sentinel){
            throw new IllegalArgumentException("非法");
        }
        Node prev = removed.prev;
        prev.next = sentinel;
        sentinel.prev = prev;
    }



    /**
     * 实现迭代器
     * @return 迭代器
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = sentinel.next;
            @Override
            public boolean hasNext() {
                return p != sentinel;
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
