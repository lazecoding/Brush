package brush.leetcode.sort;

import java.util.Arrays;

/**
 * @className: Q75
 * @package: brush.leetcode.sort
 * @description:
 * @datetime: 2020/10/20   21:51
 * @author: lazecoding
 */
public class Q75 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        int[] arr = Solution.sortColors(nums);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     * <p>
     * 注意:
     * 不能使用代码库中的排序函数来解决这道题。
     * <p>
     * 示例:
     * 输入: [2,0,2,1,1,0]
     * 输出: [0,0,1,1,2,2]
     * <p>
     * 进阶：
     * 一个直观的解决方案是使用计数排序的两趟扫描算法。
     * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
     * 你能想出一个仅使用常数空间的一趟扫描算法吗？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sort-colors
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class Solution {
        /**
         * 双指针
         * @param nums
         * @return
         */
        public static int[] sortColors(int[] nums) {
            int p0 = 0, p2 = nums.length - 1;
            for (int i = 0; i <= p2; ++i) {
                //从左向右循环
                //如果遇到 2 和 右侧交换，防止交换了还是2，循环
                while (i <= p2 && nums[i] == 2) {
                    int temp = nums[i];
                    nums[i] = nums[p2];
                    nums[p2] = temp;
                    --p2;
                }
                //遇到0就 和 左侧交换
                if (nums[i] == 0) {
                    int temp = nums[i];
                    nums[i] = nums[p0];
                    nums[p0] = temp;
                    ++p0;
                }
            }
            return nums;
        }
    }
}
