package brush.leetcode.search.Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: lazecoding
 * @date: 2021/4/14 21:33
 * @description:
 */
public class Q46 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List ans = Solution.permute(nums);
        System.out.println(ans.toString());

    }

    /**
     * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
     *
     * 示例:
     * 输入: [1,2,3]
     *
     * 输出:
     * [
     *   [1,2,3],
     *   [1,3,2],
     *   [2,1,3],
     *   [2,3,1],
     *   [3,1,2],
     *   [3,2,1]
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/permutations
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class Solution {
        /**
         * 从左往右每一个位置都依此尝试填入一个数，看能不能填完这 n 个空格
         * @param nums
         * @return
         */
        public static List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();

            List<Integer> output = new ArrayList<Integer>();
            for (int num : nums) {
                output.add(num);
            }

            int n = nums.length;
            backtrack(n, output, res, 0);
            return res;
        }

        public static void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
            // 所有数都填完了
            if (first == n) {
                res.add(new ArrayList<Integer>(output));
            }
            for (int i = first; i < n; i++) {
                // 动态维护数组
                Collections.swap(output, first, i);
                // 继续递归填下一个数
                backtrack(n, output, res, first + 1);
                // 撤销操作
                Collections.swap(output, first, i);
            }
        }
    }
}



