package me.arui.leetcode.one;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. Pascal's Triangle II
 * https://leetcode.com/problems/pascals-triangle-ii/
 */
public class PascalsTriangleTwo119 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = null;
        List<Integer> lastRow = null;

        int i = 0;
        while (i < rowIndex + 1) {
            row = new ArrayList<>();
            for (int j = 0; j < (i + 1); j++) {
                if (i == 0) {
                    row.add(1);
                    continue;
                }
                int num1 = j - 1 < 0 ? 0 : lastRow.get(j - 1);
                int num2 = j > lastRow.size() - 1 ? 0 : lastRow.get(j);
                int num = num1 + num2;
                row.add(num);
            }
            lastRow = row;
            i++;
        }
        return row;
    }

    public static void test(int numRows) {
        PascalsTriangleTwo119 test = new PascalsTriangleTwo119();
        List<Integer> result = test.getRow(numRows);
        System.out.println("执行结果：" + numRows);
        for (Integer num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        test(3);
        test(5);
        test(6);
    }
}
