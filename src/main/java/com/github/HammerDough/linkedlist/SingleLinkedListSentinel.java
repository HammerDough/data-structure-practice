package com.github.HammerDough.linkedlist;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 单向链表（带有哨兵）
 */
public class SingleLinkedListSentinel implements Iterable<Integer>{

    private Node head = new Node(0,null);

    /**
     * 节点类
     */
    private static class Node{
        int value;
        Node next;

        public Node(int value,Node next){
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 头插法
     * @param value 插入值
     */
    public void addFirst(int value){
        head.next = new Node(value,head.next);
    }

    /**
     * 得到尾节点
     * @return 尾节点
     */
    public Node findLast(){
        Node p = head;
        while(p.next!=null){
            p = p.next;
        }
        return p;
    }

    /**
     * 尾插法
     * @param value 插入值
     */
    public void addLast(int value){
        Node tail = findLast();
        tail.next = new Node(value,null);
    }

    /**
     * 向索引位置插入
     * @param index 插入点索引
     * @param value 插入值
     */
    public void insert(int index,int value){
        Node prev = findNode(index-1);
        if(prev==null){
            throw new IllegalArgumentException(String.format("index [%d] 不合法%n",index));
        }
        prev.next = new Node(value,prev.next);
    }

    /**
     * 删除首元素
     */
    public void removeFirst(){
        if(head.next==null){
            throw new IllegalArgumentException(String.format("index [0] 不合法%n"));
        }
        Node removed = head.next;
        head.next = removed.next;
    }

    /**
     * 删除索引处元素
     * @param index 索引
     */
    public void remove(int index){
        Node prev = findNode(index-1);
        if(prev==null){
            throw new IllegalArgumentException(String.format("index [%d] 不合法%n",index));
        }
        Node removed = prev.next;
        if(removed==null){
            throw new IllegalArgumentException(String.format("index [%d] 不合法%n",index));
        }
        prev.next = removed.next;
    }

    /**
     * 根据索引来查找节点
     * @param index 查找的索引
     * @return 索引对应的节点
     */
    public Node findNode(int index){
        int i = -1;
        for(Node p = head; p.next!=null; p=p.next,i++){
            if(i==index){
                return p;
            }
        }

        return null;
    }

    /**
     * 根据索引得到节点的值
     * @param index 索引
     * @return 索引处节点的值
     */
    public int get(int index){
        Node node = findNode(index);
        if(node==null){
            throw new IllegalArgumentException(String.format("index [%d] 不合法%n",index));
        }
        return node.value;
    }

    /**
     * 遍历方式1
     * @param consumer 函数式接口实现类对象，消耗的数据类型为Integer
     */
    public void loop1(Consumer<Integer> consumer){
        Node p =head.next;
        while(p!=null){
            consumer.accept(p.value);
            p = p.next;
        }
    }

    /**
     * 遍历方式2
     * @param consumer 函数式接口实现类对象，消耗的数据类型为Integer
     */
    public void loop2(Consumer<Integer> consumer){
        for(Node p=head.next;p!=null;p=p.next){
            consumer.accept(p.value);
        }
    }

    /**
     * 实现迭代器接口
     * @return 迭代器
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p =head.next;
            @Override
            public boolean hasNext() {
                return p!=null;
            }

            @Override
            public Integer next() {
                Integer value=p.value;
                p=p.next;
                return value;
            }
        };
    }


}

