package brush.leetcode.search.Backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: lazecoding
 * @date: 2021/5/9 16:48
 * @description:
 */
public class Q77 {

    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        List<List<Integer>> res =Solution.combine(n, k);
        System.out.println(res);
    }

    /**
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     *
     * 示例:
     * 输入:n = 4, k = 2
     * 输出:
     * [
     *   [2,4],
     *   [3,4],
     *   [2,3],
     *   [1,2],
     *   [1,3],
     *   [1,4],
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/combinations
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class Solution {
        /**
         * 例如输入：n = 4, k = 2，我们可以发现如下递归结构：
         *
         * 如果组合里有 1 ，那么需要在 [2, 3, 4] 里再找 11 个数；
         * 如果组合里有 2 ，那么需要在 [3, 4] 里再找 11数。注意：这里不能再考虑 11，因为包含 11 的组合，在第 1 种情况中已经包含。
         * 依次类推
         *
         * 作者：liweiwei1419
         * 链接：https://leetcode-cn.com/problems/combinations/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-ma-/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         * @return
         */
        public static List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            if (k <= 0 || n < k) {
                return res;
            }
            Deque<Integer> path = new ArrayDeque<>();
            dfs(n, k, 1, path, res);
            return res;
        }

        private static void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
            // 递归终止条件是：path 的长度等于 k
            if (path.size() == k) {
                res.add(new ArrayList<>(path));
                return;
            }
            // 遍历可能的搜索起点
            for (int i = begin; i <= n; i++) {
                // 向路径变量里添加一个数
                path.addLast(i);
                System.out.println("递归之前 => " + path);
                // 下一轮搜索，设置的搜索起点要加 1，因为组合数理不允许出现重复的元素
                dfs(n, k, i + 1, path, res);
                // 重点：深度优先遍历有回头的过程，因此递归之前做了什么，递归之后需要做相同操作的逆向操作
                path.removeLast();
                System.out.println("递归之后 => " + path);
            }
        }

    }
}
