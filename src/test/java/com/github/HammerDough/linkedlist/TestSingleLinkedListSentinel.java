package com.github.HammerDough.linkedlist;

import org.junit.Test;

public class TestSingleLinkedListSentinel {

    @Test//测试头插法+遍历
    public void Test1(){
        SingleLinkedListSentinel list = new SingleLinkedListSentinel();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);

        for (Integer i : list) {
            System.out.println(i);
        }
        list.loop1(value->{
            System.out.println(value);
        });
        list.loop2(value->{
            System.out.println(value);
        });
    }

    @Test//测试尾插法
    public void Test2(){
        SingleLinkedListSentinel list = new SingleLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        for (Integer i : list) {
            System.out.println(i);
        }
    }

    @Test//测试删除头元素
    public void Test3(){
        SingleLinkedListSentinel list = new SingleLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.removeFirst();
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    @Test//测试通过索引删除元素
    public void Test4(){
        SingleLinkedListSentinel list = new SingleLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.remove(2);
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    @Test//测试获取元素
    public void Test5(){
        SingleLinkedListSentinel list = new SingleLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        int i = list.get(2);
        System.out.println(i);
    }
}
