package brush.leetcode.search.Backtracking;

import java.util.ArrayList;
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
        public static List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();




            return null;
        }
    }
}
