package com.github.HammerDough.linkedlist;

import org.junit.Test;

public class TestDoublyLinkedListSentinel {
    @Test//测试头插法
    public void test1(){
        DoublyLinkedListSentinel list = new DoublyLinkedListSentinel();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);

        for (Integer i : list) {
            System.out.println(i);
        }
    }

    @Test//测试尾插法
    public void test2(){
        DoublyLinkedListSentinel list = new DoublyLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        for (Integer i : list) {
            System.out.println(i);
        }
    }

    @Test//测试按索引插入
    public void test3(){
        DoublyLinkedListSentinel list = new DoublyLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.insert(2,6);
        list.insert(5,9);
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    @Test//测试删除头和删除尾
    public void test4(){
        DoublyLinkedListSentinel list = new DoublyLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.removeLast();
        list.removeFirst();
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    @Test//测试按索引删除
    public void test5(){
        DoublyLinkedListSentinel list = new DoublyLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        int removed = list.remove(2);
        System.out.println("被删除元素为"+removed);

        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
