package brush.leetcode.sort;

/**
 * @className: Q4
 * @package: brush.leetcode.sort
 * @description:
 * @datetime: 2020/10/16   20:55
 * @author: lazecoding
 */
public class Q4 {
    public static void main(String[] args) {
        int[] num1 = new int[3];
        int[] num2 = new int[4];
        double ans = new Solution().findMedianSortedArrays(num1, num2);
        System.out.println(ans);
    }

    /**
     * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
     *
     * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     *
     * 你可以假设 nums1 和 nums2 不会同时为空。
     *
     * 示例 2:
     *
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     *
     * 则中位数是 (2 + 3)/2 = 2.5
     *
     */
    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            double ans = 0L;
            int length = nums1.length + nums2.length;
            //相当于求第K的数字


            return ans;
        }
    }
}
