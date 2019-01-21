package me.arui.leetcode.nine;

import java.util.*;

/**
 * 970. Powerful Integers
 * https://leetcode.com/problems/powerful-integers/
 */
public class PowerfulIntegers970 {

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        if(bound < 2) return Collections.emptyList();
        if(x == 1 && y == 1) return Arrays.asList(2);
        if(x == 1 || y == 1) return powerfulIntegers(x ==1 ? y : x, bound);

        Set<Integer> arr = new LinkedHashSet<>();
        int i = getMax(x, bound);
        int j = getMax(y, bound);
        for(; i >=0; i--) {
            int tmp = j;
            while(tmp >= 0) {
                int num = (int) (Math.pow(x, i) + Math.pow(y, tmp));
                if(num <= bound) {
                    arr.add(num);
                }
                tmp--;
            }
        }
        List<Integer> result  = new ArrayList<>();
        result.addAll(arr);
        return result;
    }

    List<Integer> powerfulIntegers(int base, int bound) {
        List<Integer> list = new ArrayList<>();
        int tmp = 1;
        while (tmp + 1 <= bound) {
            list.add(tmp+1);
            tmp = tmp * base;
        }
        return list;
    }

    private int getMax(int x, int bound) {
        int n = 0;
        int tmp = 1;
        while (tmp <= bound) {
            tmp = tmp * x;
            n++;
        }
        return n-1 > 100 ? 100 : n-1;
    }

    public static void test(int x, int y, int bound) {
        PowerfulIntegers970 test = new PowerfulIntegers970();
        List<Integer> result = test.powerfulIntegers(x, y, bound);
        System.out.println("执行结果：");
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        test(2, 3, 10);
        test(1, 2, 100);
    }

}
