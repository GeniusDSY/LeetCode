package array;

/**
 * @author :DengSiYuan
 * @date :2019/9/21 19:38
 * @desc : 121.买卖股票的最佳时机
 * 【题目】
 *      给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *      如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *      注意你不能在买入股票前卖出股票。
 * 【示例】
 *      输入: [7,1,5,3,6,4]
 *      输出: 5
 *      解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 */
public class BestTimeToBuyAndSellStock {

    /**
     * 【想法】
     *      使我们感兴趣的点是上图中的峰和谷。我们需要找到最小的谷之后的最大的峰。
     *      我们可以维持两个变量——minprice 和 maxprofit，它们分别对应迄今为止所得到的最小的谷值和最大的利润（卖出价格与最低价格之间的最大差值）。
     * 【复杂度分析】
     *      时间复杂度：O(n)O(n)，只需要遍历一次。
     *      空间复杂度：O(1)O(1)，只使用了两个变量。
     * @param prices
     * @return
     * 【复杂度分析】
     *      时间复杂度：O(n)，只需要遍历一次。
     *      空间复杂度：O(1)，只使用了两个变量。
     */
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int price : prices) {
            //循环判断，获取最新获取谷值
            if (price < minprice) {
                minprice = price;
            }
            //判断当前值与谷值作差后是否大于原利润值，替换
            else if (price - minprice > maxprofit) {
                maxprofit = price - minprice;
            }
        }
        return maxprofit;
    }

    /**
     * 【想法】
     *      两层遍历，内层永远从外层+1的位置开始，两两作差进行利润判断
     * @param prices
     * @return
     * 【复杂度分析】
     *      时间复杂度：O(n^2)。循环运行 n(n-1)/2	次。
     *      空间复杂度：O(1)。只使用了两个变量 —— maxprofit 和 profit。
     */
    public int maxProfit1(int prices[]) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit) {
                    maxprofit = profit;
                }
            }
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7, 1, 5, 3, 6, 4};
        BestTimeToBuyAndSellStock sellStock = new BestTimeToBuyAndSellStock();
        long start = System.nanoTime();
        int result = sellStock.maxProfit(arr);
        long end = System.nanoTime();
        System.out.println(result);
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        start = System.nanoTime();
        result = sellStock.maxProfit1(arr);
        end = System.nanoTime();
        System.out.println(result);
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
    }

}
