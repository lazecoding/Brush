package brush.leetcode.search.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lazecoding
 * @date: 2021/5/11 22:02
 * @description:
 */
public class Q39 {
    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 5};
        int target = 8;
        List<List<Integer>> ans = Solution.combinationSum(candidates, target);
        System.out.println(ans);
    }


    /**
     * 给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
     *
     * candidates中的数字可以无限制重复被选取。
     *
     * 说明：
     * 所有数字（包括target）都是正整数。
     * 解集不能包含重复的组合。
     *
     * 示例1：
     * 输入：candidates = [2,3,6,7], target = 7,
     * 所求解集为：
     * [
     *   [7],
     *   [2,2,3]
     * ]
     *
     * 示例2：
     * 输入：candidates = [2,3,5], target = 8,
     * 所求解集为：
     * [
     *  [2,2,2,2],
     *  [2,3,3],
     *  [3,5]
     * ]
     *
     * 提示：
     * 1 <= candidates.length <= 30
     * 1 <= candidates[i] <= 200
     * candidate 中的每个元素都是独一无二的。
     * 1 <= target <= 500
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/combination-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class Solution {

        /**
         * 通过回溯法，我们可以构建出一颗树
         * candidates 中每个元素出现次数不限，树地分支每次分成两个。一个是索引位置不变，一个是索引位置变化（右移一位）
         *
         * @param candidates
         * @param target
         * @return
         */
        public static List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            // 已经组合的列表
            List<Integer> combine = new ArrayList<Integer>();
            dfs(candidates, target, ans, combine, 0);
            return ans;
        }

        public static void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
            if (idx == candidates.length) {
                return;
            }
            if (target == 0) {
                ans.add(new ArrayList<Integer>(combine));
                return;
            }
            // 跳过当前，右移
            dfs(candidates, target, ans, combine, idx + 1);
            // 选择当前数值
            if (target - candidates[idx] >= 0) {
                combine.add(candidates[idx]);
                dfs(candidates, target - candidates[idx], ans, combine, idx);
                combine.remove(combine.size() - 1);
            }
        }
    }
}
