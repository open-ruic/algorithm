package me.arui.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 * https://leetcode.com/problems/pascals-triangle/
 */
public class PascalsTriangle118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < (i + 1); j++) {
                if (i == 0) {
                    row.add(1);
                    continue;
                }

                List<Integer> lastRow = result.get(i - 1);
                int num1 = j - 1 < 0 ? 0 : lastRow.get(j - 1);
                int num2 = j > lastRow.size() - 1 ? 0 : lastRow.get(j);
                int num = num1 + num2;
                row.add(num);
            }
            result.add(row);
        }
        return result;
    }

    public static void test(int numRows) {
        PascalsTriangle118 test = new PascalsTriangle118();
        List<List<Integer>> result = test.generate(numRows);
        System.out.println("执行结果：" + numRows);
        for (List<Integer> row : result) {
            for (Integer num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        test(5);
        test(6);
    }
}
