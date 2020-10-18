package brush.leetcode.sort;

import javax.sound.midi.Soundbank;
import java.util.PriorityQueue;

/**
 * @className: Q215
 * @package: brush.leetcode.sort
 * @description:
 * @datetime: 2020/10/18   19:51
 * @author: lazecoding
 */
public class Q215 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;
        int ans = Solution.findKthLargest(nums, k);
        System.out.println(ans);
    }

    /**
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     * <p>
     * 示例 1:
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     * <p>
     * 示例 2:
     * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     * 输出: 4
     * <p>
     * 说明: 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class Solution {
        public static int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(); // 小顶堆
            for (int val : nums) {
                queue.add(val);
                if (queue.size() > k) {
                    // 维护堆的大小为 K
                    queue.poll();
                }
            }
            return queue.peek();
        }
    }
}
