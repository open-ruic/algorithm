package me.arui.algorithm.sorting;


public class QuickSort {

    private int[] data;

    public QuickSort(int[] data) {
        this.data = data;
    }

    private void swap(int a, int b) {
        int tmp = data[a];
        data[a] = data[b];
        data[b] = tmp;
    }

    public int[] sort(int low, int high) {
        int i = low;
        int j = high;
        int pivot = data[low + (high - low) / 2];

        while (i <= j) {
            while (data[i] < pivot) {
                i++;
            }
            while (data[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }

        // Recursion
        if (low < j)
            sort(low, j);
        if (i < high)
            sort(i, high);
        return data;
    }

    public static void main(String[] args) {
        int a[] = {3, 1, 5, 7, 2, 4, 9, 6};
        QuickSort sorting = new QuickSort(a);
        a = sorting.sort(0, 7);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
