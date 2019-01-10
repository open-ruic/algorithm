package me.arui.leetcode;

public class MergeSortedArray88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) return;
        int i = m > 0 ? m - 1 : 0;
        int j = n - 1;
        int no = nums1.length - 1;
        while (no >= 0 && j >= 0 && i >=0) {
            if(nums1[i] > nums2[j]) {
                nums1[no] = nums1[i];
                i--;
            } else {
                nums1[no] = nums2[j];
                j--;
            }
            no--;
        }
        if(i < 0 && j >= 0) {
            while (j >= 0) {
                nums1[j] = nums2[j];
                j--;
            }
        }
    }

    public static void test(MergeSortedArray88 test, int[] nums1, int m, int[] nums2, int n) {
        test.merge(nums1, m, nums2, n);
        for(int num : nums1) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MergeSortedArray88 test = new MergeSortedArray88();
        test(test, new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
        test(test, new int[]{0}, 0, new int[]{1}, 1);
        test(test, new int[]{1}, 1, new int[]{0}, 0);
        test(test, new int[]{2, 0}, 1, new int[]{1}, 1);
    }

}
