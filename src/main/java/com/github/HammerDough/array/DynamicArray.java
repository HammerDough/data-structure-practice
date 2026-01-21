package com.github.HammerDough.array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class DynamicArray implements Iterable<Integer> {

    private int size = 0;
    private int capacity = 8;
    private int[] array = {}; //先给一个空数组，节省资源，在真正添加元素的时候再创建数组


    /**
     * 在末尾添加元素*/
    public void addLast(int element) {
        add(size, element);
    }

    /**
     * 在指定索引处添加元素*/
    public void add(int index, int element) {
        //容量检测
        checkAndGroup();
        //添加元素
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else if (index < size) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        array[index] = element;
        size++;
    }
    /**
     * 扩容机制实现
     */
    private void checkAndGroup() {
        if(size==0){
            array = new int[capacity];
        }else if(size == capacity) {
            capacity += capacity>>1;//扩容为原来的1.5倍
            int[] newArray = new int[capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;//指针指向新数组，旧数组会GC自动释放
        }
    }

    /**
     * 按索引删除元素*/
    public int remove(int index){
        int removed = array[index];
        if (index < size - 1) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
        }
        size--;
        return  removed;
    }

    /**
     * 更改元素
     * Param:index - 索引位置，在[0,size)区间内
     * Return:该索引位置的元素*/
    public int set(int index,int element){
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
        int changed =  array[index];
        array[index] = element;
        return changed;
    }

    /**
     * 查询元素
     * Param:index - 索引位置，在[0,size)区间内
     * Return:该索引位置的元素
     * */
    public int get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    /**
     *遍历方式1
     * Params:consumer-遍历要执行的操作，提供参数：每个元素
     *  */

    public void foreach(Consumer<Integer> consumer) {
        for(int i=0;i<size;i++){
            //提供array[i]
            //返回void
            consumer.accept(array[i]);
        }
    }

    /**
     * 遍历方式2
     * 迭代器遍历*/
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i=0;
            @Override
            public boolean hasNext() {//有没有下一个元素
                return i<size;
            }

            @Override
            public Integer next() {//返回当前元素，再移动到下一个元素
                return array[i++];
            }
        };
    }

    /**
     * stream流获取*/
    public IntStream stream() {
        return IntStream.of(Arrays.copyOfRange(array, 0, size));
    }



}
