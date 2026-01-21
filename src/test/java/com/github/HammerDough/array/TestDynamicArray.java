package com.github.HammerDough.array;

import org.junit.Test;

import java.util.Iterator;
import java.util.stream.IntStream;

public class TestDynamicArray {
    @Test//测试添加元素
    public void test1(){
        DynamicArray dy = new DynamicArray();
        dy.addLast(1);
        dy.addLast(2);
        dy.addLast(3);
        dy.addLast(4);

        dy.add(2,5);

        for(int i=0;i<5;i++){
            System.out.println(dy.get(i));
        }
    }
    @Test//测试foreach遍历
    public void test2(){
        DynamicArray dy = new DynamicArray();
        dy.addLast(1);
        dy.addLast(2);
        dy.addLast(3);
        dy.addLast(4);

        dy.foreach(System.out::println);
    }

    @Test//测试更改元素
    public void test3(){
        DynamicArray dy = new DynamicArray();
        dy.addLast(1);
        dy.addLast(2);
        dy.addLast(3);
        dy.addLast(4);
        dy.foreach(System.out::println);
        dy.set(2,6);
        dy.foreach(System.out::println);
    }

    @Test//测试迭代器遍历
    public void test4(){
        DynamicArray dy = new DynamicArray();
        dy.addLast(1);
        dy.addLast(2);
        dy.addLast(3);
        dy.addLast(4);

        //增强for循环底层就是迭代器
        for (Integer element : dy) {
            System.out.println(element);
        }

        //会自动转换为下面的代码
        Iterator<Integer> it = dy.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    @Test//测试stream流获取
    public void test5(){
        DynamicArray dy = new DynamicArray();
        dy.addLast(1);
        dy.addLast(2);
        dy.addLast(3);
        dy.addLast(4);

        IntStream stream = dy.stream();
        stream.forEach(System.out::println);
    }

    @Test//测试删除元素
    public void test6(){
        DynamicArray dy = new DynamicArray();
        dy.addLast(1);
        dy.addLast(2);
        dy.addLast(3);
        dy.addLast(4);

        int  removed = dy.remove(2);
        System.out.println(removed);
        dy.foreach(System.out::println);
    }

    @Test//测试扩容机制
    public void test7(){
        DynamicArray dy = new DynamicArray();
        for(int i=0;i<9;i++){
            dy.addLast(i+1);
        }
        dy.foreach(System.out::println);
    }
}
