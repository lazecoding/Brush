package brush.leetcode.doublepointer;

import java.util.Arrays;

/**
 * @className: Q88
 * @package: brush.leetcode.doublepointer
 * @description:
 * @datetime: 2020/10/18   17:59
 * @author: lazecoding
 */
public class Q88 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3, 5, 0, 0, 0};
        int[] nums2 = new int[]{-1, 2, 6};
        int[] ans = Solution.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(ans));
    }

    /**
     * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
     * <p>
     * 说明：
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     *  
     * 提示：
     * -10^9 <= nums1[i], nums2[i] <= 10^9
     * nums1.length == m + n
     * nums2.length == n
     * <p>
     * 示例：
     * 输入：
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     * <p>
     * 输出：[1,2,2,3,5,6]
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class Solution {
        public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
            int index1 = m - 1;
            int index2 = n - 1;
            int indexMerge = m + n - 1;
            while (index1 >= 0 || index2 >= 0) {
                if (index1 >= 0 && index2 >= 0) {
                    if (nums1[index1] > nums2[index2]) {
                        nums1[indexMerge] = nums1[index1];
                        index1--;
                        indexMerge--;
                    } else {
                        nums1[indexMerge] = nums2[index2];
                        index2--;
                        indexMerge--;
                    }
                } else if (index1 < 0 && index2 >= 0) {
                    nums1[indexMerge] = nums2[index2];
                    index2--;
                    indexMerge--;
                } else if (index1 >= 0 && index2 < 0) {
                    nums1[indexMerge] = nums1[index1];
                    index1--;
                    indexMerge--;
                }
            }
            return nums1;
        }
    }
}
