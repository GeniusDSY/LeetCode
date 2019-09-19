package array;

/**
 * @author :DengSiYuan
 * @date :2019/9/19 9:36
 * @desc :122.买卖股票的最佳时机II
 * 【题目】
 *      给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *      设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 【注意】
 *      你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 【示例】
 *      输入: [7,1,5,3,6,4]
 *      输出: 7
 *      解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *            随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 */
public class BestTimeToBuyAndSellStockII {

    /**
     * 【想法】
     *      只要后一天大于前一天就可以进行卖出并在第二天再买入，因为根据[7,1,5,6]可以得知：5 - 1 + 6 - 5 = 6 - 1
     *      因此只要后一天 > 前一天，那么就可以添加到所赚金额中
     * @param prices
     * @return
     * 【复杂度分析】
     *      时间复杂度：O(N)
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            profit += prices[i + 1] - prices[i] > 0 ? prices[i + 1] - prices[i] : 0;
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7,1,5,3,6,4};
        BestTimeToBuyAndSellStockII stock = new BestTimeToBuyAndSellStockII();
        long start = System.nanoTime();
        int result = stock.maxProfit(arr);
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        System.out.println(result);
    }
}
