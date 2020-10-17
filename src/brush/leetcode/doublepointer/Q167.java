package brush.leetcode.doublepointer;

import java.util.Arrays;

/**
 * @className: Q167
 * @package: brush.leetcode.doublepointer
 * @description:
 * @datetime: 2020/10/16   21:08
 * @author: lazecoding
 */
public class Q167 {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 4, 5, 7, 8, 9};
        int[] ans;
        ans = Solution.twoSum(arr, 9);
        System.out.println(Arrays.toString(ans));
    }

    /**
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
     * <p>
     * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
     * <p>
     * 说明:
     * <p>
     * 返回的下标值（index1 和 index2）不是从零开始的。
     * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
     * 示例:
     * <p>
     * 输入: numbers = [2, 7, 11, 15], target = 9
     * 输出: [1,2]
     * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class Solution {
        /**
         * 使用双指针，一个指针指向值较小的元素，一个指针指向值较大的元素。指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。
         * <p>
         * 如果两个指针指向元素的和 sum == target，那么得到要求的结果；
         * 如果 sum > target，移动较大的元素，使 sum 变小一些；
         * 如果 sum < target，移动较小的元素，使 sum 变大一些。
         * 数组中的元素最多遍历一次，时间复杂度为 O(N)。只使用了两个额外变量，空间复杂度为 O(1)。
         *
         * @param numbers
         * @param target
         * @return
         */
        public static int[] twoSum(int[] numbers, int target) {
            if (numbers == null) {
                return null;
            }
            int i = 0, j = numbers.length - 1;
            while (i < j) {
                int sum = numbers[i] + numbers[j];
                if (sum == target) {
                    return new int[]{i + 1, j + 1};
                } else if (sum < target) {
                    i++;
                } else {
                    j--;
                }
            }
            return null;
        }
    }

}
