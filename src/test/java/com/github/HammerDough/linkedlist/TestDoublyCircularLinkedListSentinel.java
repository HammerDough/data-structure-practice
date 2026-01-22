package com.github.HammerDough.linkedlist;

import org.junit.Test;

public class TestDoublyCircularLinkedListSentinel {

    @Test//测试头插法
    public void test1(){
        DoublyCircularLinkedListSentinel list = new DoublyCircularLinkedListSentinel();
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
        DoublyCircularLinkedListSentinel list = new DoublyCircularLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        for (Integer i : list) {
            System.out.println(i);
        }
    }

    @Test//测试删除头元素
    public void test3(){
        DoublyCircularLinkedListSentinel list = new DoublyCircularLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    @Test//测试删除尾元素
    public void test4(){
        DoublyCircularLinkedListSentinel list = new DoublyCircularLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.removeLast();
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    @Test//测试根据值删除
    public void test5(){
        DoublyCircularLinkedListSentinel list = new DoublyCircularLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(2);
        list.addLast(4);
        list.addLast(2);

        list.removeByValue(2);
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
