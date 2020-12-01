package brush.leetcode.greedy;

/**
 * @author: lazecoding
 * @date: 2020/12/1 20:11
 * @description:
 */
public class Q665 {
    public static void main(String[] args) {

    }

    /**
     * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
     * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
     * <p>
     * <p>
     * 示例 1:
     * 输入: nums = [4,2,3]
     * 输出: true
     * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
     * <p>
     * 示例 2:
     * 输入: nums = [4,2,1]
     * 输出: false
     * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
     *  
     * 说明：
     * 1 <= n <= 10 ^ 4
     * - 10 ^ 5 <= nums[i] <= 10 ^ 5
     * 通过次数31,143提交次数134,437
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/non-decreasing-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class Solution {
        // 可以是某个值 大了或小了
        public boolean checkPossibility(int[] nums) {
            int sum = 0;
            for (int i = 1; i < nums.length && sum <= 1; i++) {
                if (nums[i - 1] > nums[i]) {
                    sum++;
                    // 判断 i 这个值是不是小了，如果是的，这样就相当于去掉了；   如果判断不通过那就是 i-1大了，不需要动。
                    if (i - 2 >= 0 && nums[i - 2] > nums[i]){
                        nums[i] = nums[i - 1];
                    }
                }
            }
            return sum <= 1;
        }
    }
}
