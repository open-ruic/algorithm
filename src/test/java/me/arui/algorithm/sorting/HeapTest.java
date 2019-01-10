package me.arui.algorithm.sorting;

import org.junit.Test;

public class HeapTest {

    @Test
    public void testHeapSort() {
        Integer[] arr = {50, 10, 90, 30, 70, 40, 80, 60, 20};
        HeapSort<Integer> heapSort = new HeapSort<>(arr);
        heapSort.sort();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
