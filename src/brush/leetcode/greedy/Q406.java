package brush.leetcode.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @className: Q406
 * @package: brush.leetcode.greedy
 * @description:
 * @datetime: 2020/11/4   21:34
 * @author: lazecoding
 */
public class Q406 {
    public static void main(String[] args) {
        int[][] people = new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};

        people =  Solution.reconstructQueue(people);
        System.out.println(Arrays.deepToString(people));

    }

    /**
     * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。
     * 编写一个算法来重建这个队列。
     * <p>
     * 注意：
     * 总人数少于1100人。
     * <p>
     * 示例
     * 输入:
     * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
     * 输出:
     * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class Solution {
        /**
         * 将最高的人按照 k 值升序排序，然后将它们放置到输出队列中与 k 值相等的索引位置上。
         * 按降序取下一个高度，同样按 k 值对该身高的人升序排序，然后逐个插入到输出队列中与 k 值相等的索引位置上。
         * 直到完成为止。
         *
         * 作者：LeetCode
         * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height/solution/gen-ju-shen-gao-zhong-jian-dui-lie-by-leetcode/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         *
         * @param people
         * @return
         */
        public static int[][] reconstructQueue(int[][] people) {
            if (people == null || people.length == 0 || people[0].length == 0) {
                return new int[0][0];
            }
            // H 逆序排序  K正序排序
            Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
            System.out.println(Arrays.deepToString(people));

            //创建LIST  把元素放在所有K上,会把之前这个位置的往后面挤开，而且这个被即开的肯定比当前元素大
            List<int[]> list = new ArrayList<>();
            for (int[] p : people) {
                list.add(p[1], p);
            }
            return list.toArray(new int[list.size()][]);
        }
    }
}
