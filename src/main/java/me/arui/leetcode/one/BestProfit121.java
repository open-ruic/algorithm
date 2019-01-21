package me.arui.leetcode.one;

/**
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestProfit121 {

    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int maxProfit = 0;
        int minPrince = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrince) {
                minPrince = prices[i];
            } else if (prices[i] - minPrince > maxProfit) {
                maxProfit = prices[i] - minPrince;
            }
        }
        return maxProfit;
    }

    public static void test(int[] prices) {
        BestProfit121 test = new BestProfit121();
        int result = test.maxProfit(prices);
        System.out.println("执行结果：" + result);
    }

    public static void main(String[] args) {
        test(new int[]{7, 1, 5, 3, 6, 4});
        test(new int[]{5, 4, 3, 5, 1, 2});
    }

}
