package brush.leetcode.sort;

import java.awt.image.Kernel;
import java.util.*;

/**
 * @className: Q347
 * @package: brush.leetcode.sort
 * @description:
 * @datetime: 2020/10/20   21:01
 * @author: lazecoding
 */
public class Q347 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3, 6, 6};
        int k = 3;
        int[] list = Solution.topKFrequent(nums, k);
        System.out.println(Arrays.toString(list));
    }

    /**
     * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
     * <p>
     * 示例 1:
     * 输入: nums = [1,1,1,2,2,3], k = 2
     * 输出: [1,2]
     * <p>
     * 示例 2:
     * 输入: nums = [1], k = 1
     * 输出: [1]
     *  
     * <p>
     * 提示：
     * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
     * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
     * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
     * 你可以按任意顺序返回答案。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class Solution {
        public static int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> frequencyForNum = new HashMap<>();
            for (int num : nums) {
                frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0) + 1);
            }
            // 数组内索引即数字出现频率，这样相当于排序了
            List<Integer>[] buckets = new ArrayList[nums.length + 1];
            for (int key : frequencyForNum.keySet()) {
                int frequency = frequencyForNum.get(key);
                if (buckets[frequency] == null) {
                    buckets[frequency] = new ArrayList<>();
                }
                buckets[frequency].add(key);
            }
            List<Integer> topK = new ArrayList<>();
            for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) {
                if (buckets[i] == null) {
                    continue;
                }
                if (buckets[i].size() <= (k - topK.size())) {
                    topK.addAll(buckets[i]);
                } else {
                    topK.addAll(buckets[i].subList(0, k - topK.size()));
                }
            }
            // list 转 数组
            int[] topNums = topK.stream().mapToInt(Integer::valueOf).toArray();
            return topNums;
        }
    }
}
