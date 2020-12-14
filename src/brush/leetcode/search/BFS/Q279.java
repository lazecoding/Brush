package brush.leetcode.search.BFS;

/**
 * @author: lazecoding
 * @date: 2020/12/14 21:19
 * @description:
 */
public class Q279 {
    public static void main(String[] args) {
        int n = 5;
        int ans = Solution.numSquares(n);
        System.out.println(ans);
    }

    /**
     * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
     *
     * 示例 1:
     * 输入: n = 12
     * 输出: 3
     * 解释: 12 = 4 + 4 + 4.
     *
     * 示例 2:
     * 输入: n = 13
     * 输出: 2
     * 解释: 13 = 4 + 9.
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/perfect-squares
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class Solution {
        public static int numSquares(int n) {
            // 默认初始化值都为0
            int[] dp = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                // 最坏的情况就是每次+1
                dp[i] = i;
                for (int j = 1; i - j * j >= 0; j++) {
                    //i 表示当前数字，j*j 表示平方数
                    // dp[i - j * j] + 1 是获取数量。 j的平方根作为有个数量，当前值就要-j的平方根，得到之前计算的数量，而且需要加上 j这个数量
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
            return dp[n];
        }
    }
}
