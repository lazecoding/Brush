package brush.leetcode.binarysearch;

/**
 * @author: lazecoding
 * @date: 2020/12/3 23:18
 * @description:
 */
public class Q153 {
    public static void main(String[] args) {

    }

    /**
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
     * 请找出其中最小的元素。
     * <p>
     * <p>
     * 示例 1：
     * 输入：nums = [3,4,5,1,2]
     * 输出：1
     * <p>
     * 示例 2：
     * 输入：nums = [4,5,6,7,0,1,2]
     * 输出：0
     * <p>
     * 示例 3：
     * 输入：nums = [1]
     * 输出：1
     *  
     * <p>
     * 提示：
     * 1 <= nums.length <= 5000
     * -5000 <= nums[i] <= 5000
     * nums 中的所有整数都是 唯一 的
     * nums 原来是一个升序排序的数组，但在预先未知的某个点上进行了旋转
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class Solution {
        /**
         * emmm   这旋转和我理解我不一样，这是分成两段位置交换
         * 其实这样就变成了递增，递减，递增的数组
         *
         * 如果是单调递增的，那就正常判断。如果不是单调递增的，这个也有特点，右侧的一节肯定小于左侧一节的任意一个值，很好判断
         **
         * @param nums
         * @return
         */
        public int findMin(int[] nums) {
            int l = 0, h = nums.length - 1;
            while (l < h) {
                int m = l + (h - l) / 2;
                if (nums[m] <= nums[h]) {
                    h = m;
                } else {
                    l = m + 1;
                }
            }
            return nums[l];
        }
    }
}
