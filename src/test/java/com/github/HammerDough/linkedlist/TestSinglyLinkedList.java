package com.github.HammerDough.linkedlist;

import org.junit.Test;

public class TestSinglyLinkedList {

    @Test//测试头插法addFirst和遍历1、2
    public void test1(){
        SingleLinkedList list = new SingleLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);

        list.loop1(value->{
            System.out.println(value);
        });

        list.loop2(value->{
            System.out.println(value);
        });

    }

    @Test//测试迭代器遍历
    public void test2(){
        SingleLinkedList list = new SingleLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);

        for (Integer value : list) {
            System.out.println(value);
        }
    }

    @Test//测试尾插法addLast
    public void test3(){
        SingleLinkedList list = new SingleLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        for (Integer value : list) {
            System.out.println(value);
        }

    }

    @Test//测试查找方法get
    public void test4(){
        SingleLinkedList list = new SingleLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        int value = list.get(2);
        System.out.println(value);
    }

    @Test//测试插入方法insert
    public void test5(){
        SingleLinkedList list = new SingleLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.insert(2,9);
        for (Integer value : list) {
            System.out.println(value);
        }
    }

    @Test//测试删除首元素removeFirst
    public void test6(){
        SingleLinkedList list = new SingleLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.removeFirst();
        for (Integer value : list) {
            System.out.println(value);
        }
    }

    @Test//测试按照索引删除元素remove
    public void test7(){
        SingleLinkedList list = new SingleLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.remove(2);
//        list.remove(7);//特殊情况1
//        list.remove(4);//特殊情况2
        for (Integer value : list) {
            System.out.println(value);
        }
    }
}
