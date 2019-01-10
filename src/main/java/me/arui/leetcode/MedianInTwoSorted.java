package me.arui.leetcode;

public class MedianInTwoSorted {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        }
        if (nums1.length == 0 && nums2.length != 0) {
            return calculation(nums2);
        }
        if (nums1.length != 0 && nums2.length == 0) {
            return calculation(nums1);
        }
        return find(nums1, 0, nums1.length, nums2);
    }

    private double calculation(int[] nums) {
        if (nums.length == 1) return nums[0];
        boolean hasTwoMed = nums.length % 2 == 0;
        int medianIndex = (nums.length - 1) / 2;
        int median = nums[medianIndex];
        int median2 = nums[medianIndex + 1];
        return hasTwoMed ? (median + median2) / (double) 2 : median;
    }

    private double find(int[] nums1, int start1, int end1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int medianIndex = (total - 1) / 2;
        int i = (start1 + end1 - 1) / 2;
        int j = medianIndex - i > 0 ? medianIndex - i : 0;
        boolean hasTwoMed = total % 2 == 0;
        int median = 0;
        int median2 = 0;
        System.out.println("i ===" + i);
        System.out.println("j ===" + j);

        if (nums1[i] <= nums2[j]) {
            if ((j + 1 > nums2.length - 1) || nums1[i] <= nums2[j + 1]) {
                median = nums1[i];
                return median;
            } else {
                return find(nums1, start1, i - 1, nums2);
            }
        } else {
            if ((i + 1 > nums1.length - 1) || nums2[j] < nums1[i + 1]) {
                median = nums1[2];
                return median;
            } else {
                return find(nums1, i + 1, end1, nums2);
            }
        }

//        if(nums1[i] >= nums2[j]) {
//            if((j+1 > nums2.length-1) || nums1[i] < nums2[j+1]) {
//                median = nums1[i];
//                if(hasTwoMed) {
//                    int nums2Max = j+1 > nums2.length - 1? nums2[j] : nums2[j+1];
//                    median2 = i+1 <= nums1.length - 1 && nums1[i+1] > nums2Max ? nums1[i+1] :nums2Max;
//                }
//                return hasTwoMed ? (median+median2)/(double)2: median;
//            } else {
//                return find(nums1, start1, i-1, nums2);
//            }
//        } else {
//            if((i+1 > nums1.length-1) || i == nums2.length -1 || nums2[j] < nums1[i+1]) {
//                median = nums2[j];
//                if(hasTwoMed) {
//                    int nums1Max = i+1 > nums1.length - 1? nums1[i] : nums1[i+1];
//                    median2 = j+1 <= nums2.length - 1 && nums2[j+1] > nums1Max ? nums2[j+1] :nums1Max;
//                }
//                return hasTwoMed ? (median + median2)/(double)2: median;
//            } else {
//                return find(nums1, i+1, end1, nums2);
//            }
//        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2}; // 4, 1
        int[] nums2 = {3, 4}; // 11, 4
//        1, 2, 2, 3, 4, 4, 5, 8, 11, 12, 15, 16, 17, 18, 19  // 15 , 7,  8
//        int[] nums1 = {1, 100, 102}; 1
//        int[] nums2 = {2};  0    2
        MedianInTwoSorted medianInTwoSorted = new MedianInTwoSorted();
        System.out.println(medianInTwoSorted.findMedianSortedArrays(nums1, nums2));
    }

}