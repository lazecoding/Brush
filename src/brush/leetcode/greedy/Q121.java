package brush.leetcode.greedy;

/**
 * @author: lazecoding
 * @date: 2020/11/29 21:58
 * @description:
 */
public class Q121 {
    public static void main(String[] args) {
        int[] prices = new int[]{2, 4, 1};
        int res = Solution.maxProfit(prices);
        System.out.println(res);

    }

    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
     * <p>
     * 注意：你不能在买入股票前卖出股票。
     * <p>
     * 示例 1:
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     * <p>
     * 示例 2:
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     */
    static class Solution {
        /**
         * 该方法一次遍历即可，要注意价格变化是曲线，并不能单纯maxValue - minValue
         * 需要每次计算一下最大的价值
         * @param prices
         * @return
         */
        public static int maxProfit(int[] prices) {
            int minValue = Integer.MAX_VALUE;
            int maxValue = 0;
            int maxProfit = 0;
            if (prices != null && prices.length > 1) {
                for (int i = 0; i < prices.length; i++) {
                    if (prices[i] < minValue) {
                        minValue = prices[i];
                        maxValue = 0;
                    }
                    if (prices[i] > maxValue) {
                        maxValue = prices[i];
                    }
                    if ((maxValue - minValue) > maxProfit)
                        maxProfit = maxValue - minValue;
                }
                return maxProfit;
            } else {
                return 0;
            }
        }
    }
}
