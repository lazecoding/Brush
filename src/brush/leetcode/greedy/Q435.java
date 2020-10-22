package brush.leetcode.greedy;

import java.util.Arrays;

/**
 * @className: Q435
 * @package: brush.leetcode.greedy
 * @description:
 * @datetime: 2020/10/22   23:26
 * @author: lazecoding
 */
public class Q435 {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int ans = Solution.eraseOverlapIntervals(intervals);
        System.out.println(ans);
    }

    /**
     * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
     * <p>
     * 注意:
     * 可以认为区间的终点总是大于它的起点。
     * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
     * <p>
     * 示例 1:
     * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
     * 输出: 1
     * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
     * <p>
     * 示例 2:
     * 输入: [ [1,2], [1,2], [1,2] ]
     * 输出: 2
     * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
     * <p>
     * 示例 3:
     * 输入: [ [1,2], [2,3] ]
     * 输出: 0
     * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class Solution {
        public static int eraseOverlapIntervals(int[][] intervals) {
            int res=0;
            Arrays.sort(intervals,(arr1,arr2)->(arr1[0]-arr2[0]));
            for (int i = 0; i < intervals.length-1; i++) {
                if (intervals[i][1]>intervals[i+1][0]){
                    res++;
                    intervals[i+1][1] = Math.min(intervals[i][1],intervals[i+1][1]);
                }
            }
            return res;
        }
    }
}
