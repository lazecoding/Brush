package brush.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: lazecoding
 * @date: 2021/1/5 21:28
 * @description:
 */
public class Q830 {
    public static void main(String[] args) {
        String s = "abcdddeeeeaabbbcd";
         //s = "aaa";
        List<List<Integer>> list = Solution.largeGroupPositions(s);
        System.out.println(list.toString());

    }

    /**
     * 830. 较大分组的位置
     * 在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
     *
     * 例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
     *
     * 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。上例中的 "xxxx" 分组用区间表示为 [3,6] 。
     *
     * 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
     *
     * 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
     *
     *
     *
     * 示例 1：
     * 输入：s = "abbxxxxzzy"
     * 输出：[[3,6]]
     * 解释："xxxx" 是一个起始于 3 且终止于 6 的较大分组。
     *
     * 示例 2：
     * 输入：s = "abc"
     * 输出：[]
     * 解释："a","b" 和 "c" 均不是符合要求的较大分组。
     *
     * 示例 3：
     * 输入：s = "abcdddeeeeaabbbcd"
     * 输出：[[3,5],[6,9],[12,14]]
     * 解释：较大分组为 "ddd", "eeee" 和 "bbb"
     * 示例 4：
     *
     * 输入：s = "aba"
     * 输出：[]
     *
     * 提示：
     *
     * 1 <= s.length <= 1000
     * s 仅含小写英文字母
     */
    static class Solution {
        // 好家伙好家伙，我是废物，这是什么垃圾学学别人。道理是一样的，我自己的代码写的是什么东西。
        public static List<List<Integer>> largeGroupPositions(String s) {
            int length = s.length();
            List<List<Integer>> list = new ArrayList<>();
            if (length < 3) {
                return list;
            }
            List<Integer> range = null;
            int start = 0;
            int end = 0;
            int count = 1;
            while (end < length - 1) {
                end++;
                if (s.charAt(end) == s.charAt(start)) {
                    count++;
                    if (count == 3) {
                        range = new ArrayList<>();
                        range.add(start);
                    }
                    if (end == length - 1 && count >= 3) {
                        range.add(end);
                        list.add(range);
                    }
                } else {
                    if (count >= 3) {
                        range.add(end - 1);
                        list.add(range);
                    }
                    count = 1;
                    start = end;
                }
            }
            return list;
        }

        /**
         * 作者：LeetCode-Solution
         * 链接：https://leetcode-cn.com/problems/positions-of-large-groups/solution/jiao-da-fen-zu-de-wei-zhi-by-leetcode-so-fi3n/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         * @param s
         * @return
         */
        public List<List<Integer>> largeGroupPositions1(String s) {
            List<List<Integer>> ret = new ArrayList<List<Integer>>();
            int n = s.length();
            int num = 1;
            for (int i = 0; i < n; i++) {
                if (i == n - 1 || s.charAt(i) != s.charAt(i + 1)) {
                    if (num >= 3) {
                        ret.add(Arrays.asList(i - num + 1, i));
                    }
                    num = 1;
                } else {
                    num++;
                }
            }
            return ret;
        }


    }
}
