package me.arui.leetcode;


import java.util.Date;

/**
 * leetcode 749. Contain Virus
 * <p>
 * https://leetcode.com/problems/contain-virus/description/
 */
public class ContainVirus {

    public int containVirus(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}};
//        int[] arr = {6, 7, 8, 0, 1, 1, 2, 2, 3};
//        int[] arr = {2,2,2,0,1};
        ContainVirus containVirus = new ContainVirus();
        Date beginDate = new Date();
        System.out.println(containVirus.containVirus(arr));
        Date endDate = new Date();
        System.out.println("Time : " + (endDate.getTime() - beginDate.getTime()));
    }
}
