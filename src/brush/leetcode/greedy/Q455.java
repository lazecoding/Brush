package brush.leetcode.greedy;

import java.util.Arrays;

/**
 * @className: Q455
 * @package: brush.leetcode.greedy
 * @description:
 * @datetime: 2020/10/20   22:23
 * @author: lazecoding
 */
public class Q455 {
    public static void main(String[] args) {
        int[] g = new int[]{2, 2, 3};
        int[] s = new int[]{1, 1};
        int ans = Solution.findContentChildren(g, s);
        System.out.println(ans);

    }

    /**
     * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
     * <p>
     * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
     * <p>
     *  
     * 示例 1:
     * <p>
     * 输入: g = [1,2,3], s = [1,1]
     * 输出: 1
     * 解释:
     * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
     * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
     * 所以你应该输出1。
     * 示例 2:
     * <p>
     * 输入: g = [1,2], s = [1,2,3]
     * 输出: 2
     * 解释:
     * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
     * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
     * 所以你应该输出2.
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= g.length <= 3 * 104
     * 0 <= s.length <= 3 * 104
     * 1 <= g[i], s[j] <= 231 - 1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/assign-cookies
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class Solution {
        /**
         * 证明：假设在某次选择中，贪心策略选择给当前满足度最小的孩子分配第 m 个饼干，第 m 个饼干为可以满足该孩子的最小饼干。
         * 假设存在一种最优策略，可以给该孩子分配第 n 个饼干，并且 m < n。我们可以发现，经过这一轮分配，
         * 贪心策略分配后剩下的饼干一定有一个比最优策略来得大。因此在后续的分配中，贪心策略一定能满足更多的孩子。
         * 也就是说不存在比贪心策略更优的策略，即贪心策略就是最优策略。
         *
         * @param g
         * @param s
         * @return
         */
        public static int findContentChildren(int[] g, int[] s) {
            if (g == null || s == null) {
                return 0;
            }
            Arrays.sort(g);
            Arrays.sort(s);
            int gi = 0, si = 0;
            while (gi < g.length && si < s.length) {
                if (g[gi] <= s[si]) {
                    gi++;
                }
                si++;
            }
            return gi;
        }
    }
}
