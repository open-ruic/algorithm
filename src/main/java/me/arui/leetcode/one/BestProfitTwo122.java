package me.arui.leetcode.one;

/**
 * 122. Best Time to Buy and Sell Stock II
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BestProfitTwo122 {

    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += (prices[i] - prices[i - 1]);
            }
        }
        return maxProfit;
    }

    public static void test(int[] prices) {
        BestProfitTwo122 test = new BestProfitTwo122();
        int result = test.maxProfit(prices);
        System.out.println("执行结果：" + result);
    }

    public static void main(String[] args) {
        test(new int[]{7, 1, 5, 3, 6, 4});
        test(new int[]{5, 4, 3, 5, 1, 2});
        test(new int[]{1, 2, 3, 4, 5});
    }
}
