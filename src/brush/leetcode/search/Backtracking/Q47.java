package brush.leetcode.search.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: lazecoding
 * @date: 2021/5/8 22:24
 * @description:
 */
public class Q47 {

    public static void main(String[] args) {

    }

    /**
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     *
     * 示例 1：
     * 输入：nums = [1,1,2]
     *
     * 输出：
     * [[1,1,2],
     *  [1,2,1],
     *  [2,1,1]]
     *
     * 示例 2：
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     *
     * 提示：
     * 1 <= nums.length <= 8
     * -10 <= nums[i] <= 10
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/permutations-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class Solution {
        boolean[] vis;

        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            List<Integer> perm = new ArrayList<Integer>();
            vis = new boolean[nums.length];
            Arrays.sort(nums);
            backtrack(nums, ans, 0, perm);
            return ans;
        }

        public void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
            if (idx == nums.length) {
                ans.add(new ArrayList<Integer>(perm));
                return;
            }
            for (int i = 0; i < nums.length; ++i) {
                // 这个判断条件保证了对于重复数的集合，一定是从左往右逐个填入的。
                // 假设我们有 3 个重复数排完序后相邻，那么我们一定保证每次都是拿从左往右第一个未被填过的数字，
                // 即整个数组的状态其实是保证了 [未填入，未填入，未填入] 到 [填入，未填入，未填入]，
                // 再到 [填入，填入，未填入]，最后到 [填入，填入，填入] 的过程的，因此可以达到去重的目标。
                if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                    continue;
                }
                perm.add(nums[i]);
                vis[i] = true;
                backtrack(nums, ans, idx + 1, perm);
                vis[i] = false;
                perm.remove(idx);
            }
        }
    }

}
