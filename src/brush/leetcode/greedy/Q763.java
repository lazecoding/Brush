package brush.leetcode.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lazecoding
 * @date: 2020/12/1 21:14
 * @description:
 */
public class Q763 {
    public static void main(String[] args) {
        String s = "sdsaadsdgfjhgkjfortioyiot";
        List<Integer> list = Solution.partitionLabels(s);
        System.out.println(list.toString());
    }

    /**
     * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
     * <p>
     * 示例：
     * 输入：S = "ababcbacadefegdehijhklij"
     * 输出：[9,7,8]
     * 解释：
     * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
     * 每个字母最多出现在一个片段中。
     * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
     *  
     * <p>
     * 提示：
     * S的长度在[1, 500]之间。
     * S只包含小写字母 'a' 到 'z' 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/partition-labels
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class Solution {
        public static List<Integer> partitionLabels(String s) {
            int[] last = new int[26];
            // 先得出每个字母最后的位置
            for (int i = 0; i < s.length(); i++) {
                last[s.charAt(i) - 'a'] = i;
            }
            List<Integer> partition = new ArrayList<Integer>();
            int start = 0, end = 0;
            for (int i = 0; i < s.length(); i++) {
                end = Math.max(end, last[s.charAt(i) - 'a']);
                // 如果当前这个字母得到的 就是 当前字母串的 end 说明可以切出去了
                if (i == end) {
                    partition.add(end - start + 1);
                    start = end + 1;
                }
            }
            return partition;
        }
    }
}
