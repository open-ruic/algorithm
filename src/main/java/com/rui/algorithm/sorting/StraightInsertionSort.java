package com.rui.algorithm.sorting;

/**
 * 直接插入排序算法
 *
 * 运作如下：
 * 将一个记录插入一个有序的队列，从而得到一个新的有序，记录数增加1的新的队列
 *
 */
public class StraightInsertionSort {

    private int initialCapacity = 10;

    private int[] data;

    private int size = 0;

    public StraightInsertionSort() {
        data = new int[initialCapacity];
    }

    public StraightInsertionSort(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        data = new int[initialCapacity];
    }

    public void insert(int number) {
        if(size == initialCapacity) {
            throw new IndexOutOfBoundsException();
        }
        if(size == 0) {
            data[0] = number;
        } else {
            int tmp = number;
            for(int i = 0; i < size; i++) {
                if(data[i] > tmp) {
                    int old = data[i];
                    data[i] = tmp;
                    tmp = old;
                }
                if(i == size-1) {
                    data[i+1] =  tmp;
                }
            }
        }
        size++;
    }

    public String toString() {
        StringBuffer str = new StringBuffer();
        for(int i = 0; i < size; i++) {
            str.append(data[i]);
            str.append("-");
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StraightInsertionSort sorting = new StraightInsertionSort();
        sorting.insert(1);
        sorting.insert(2);
        sorting.insert(5);
        sorting.insert(4);
        sorting.insert(3);
        System.out.println(sorting.size);
        System.out.println(sorting.toString());
    }

}
