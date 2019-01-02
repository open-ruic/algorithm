package me.arui.leetcode;

import java.util.*;


/**
 * 954.
 */
public class MinIncrementForUnique {

    public int minIncrementForUnique(Integer[] arr) {
        Arrays.sort(arr);
        int count = 0;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] <= arr[i-1]) {
                count += (arr[i-1] - arr[i] + 1);
                arr[i] = arr[i-1] + 1;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> lists = new ArrayList<>();
        for(int i =0; i < 39998 ;i++) {
            lists.add(random.nextInt(40000));
        }
//        Integer[] arr = lists.toArray(new Integer[0]);
//        1 1 2 2 3 7
        Integer[] arr = {3,2,1,2,1,7};
        MinIncrementForUnique minIncrementForUnique = new MinIncrementForUnique();
        Date beginDate = new Date();
        System.out.println(minIncrementForUnique.minIncrementForUnique(arr));
        Date endDate = new Date();
        System.out.println("Time : "  + (endDate.getTime() - beginDate.getTime()));
    }
}
