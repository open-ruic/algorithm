package com.rui.algorithm.sorting;

/**
 * 堆排序算法
 *
 * 堆特点：
 * 1. 一维数组描述完全二叉树，父节点索引 i, 对应子节点索引 2i+1, 2i+2
 * 2. 父节点值大于子节点（最小堆相反）
 *
 * 堆排序：
 * 1. 将堆定点数据移动至队列某位
 * 2. 从数组0到length-1重新调整堆
 *
 * @param <T>
 */
public class HeapSort<T extends Comparable> {

    private T[] values;


    public HeapSort(T[] values) {
        this.values = values;
    }

    public void sort() {
        this.buildHeap();

        for (int i = values.length - 1; i > 0; i--) {
            swap(0, i);
            heapAdjust(0, i);
        }
    }

    private void buildHeap() {
        for(int i = values.length / 2; i >= 0; i--) {
            heapAdjust(i, values.length);
        }
    }

    private void heapAdjust(int i, int n) {
        int childIndex;

        while(leftChildIndex(i) < n) {
            T parent = values[i];
            childIndex = leftChildIndex(i);
            if(childIndex != n - 1 && values[childIndex].compareTo(values[childIndex + 1]) > 0) {
                childIndex = childIndex + 1;
            }

            if(parent.compareTo(values[childIndex]) > 0) { //
                swap(i, childIndex);
            } else {
                break;
            }
            i = childIndex;
        }
    }

    private int leftChildIndex(int i) {
        return 2 * i + 1;
    }

    private void swap(int from, int to) {
        T tmp = values[from];
        values[from] = values[to];
        values[to] = tmp;
    }

}