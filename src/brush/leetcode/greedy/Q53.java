package brush.leetcode.greedy;

/**
 * @author: lazecoding
 * @date: 2020/12/1 20:50
 * @description:
 */
public class Q53 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int ans = Solution.maxSubArray(nums);
        System.out.println(ans);

    }

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * <p>
     * 示例:
     * 输入: [-2,1,-3,4,-1,2,1,-5,4]
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     * <p>
     * 进阶:
     * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class Solution {
        public static int maxSubArray(int[] nums) {
            int pre = 0;
            int maxValue = nums[0];
            for (int i = 0; i < nums.length; i++) {
                // 获取当前较大值
                pre = Math.max(nums[i] + pre, nums[i]);
                // 拿记录的最大值和当前较大值比较
                maxValue = Math.max(maxValue, pre);
            }
            return maxValue;
        }
    }
}
