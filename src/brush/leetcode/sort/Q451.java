package brush.leetcode.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @className: Q451
 * @package: brush.leetcode.sort
 * @description:
 * @datetime: 2020/10/20   21:45
 * @author: lazecoding
 */
public class Q451 {
    public static void main(String[] args) {
        String s = "asdqwewAASDfda";
        String str = Solution.frequencySort(s);
        System.out.println(str);
    }

    /**
     * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
     * <p>
     * 示例 1:
     * 输入:
     * "tree"
     * <p>
     * 输出:
     * "eert"
     * <p>
     * 解释:
     * 'e'出现两次，'r'和't'都只出现一次。
     * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
     * <p>
     * 示例 3:
     * 输入:
     * "Aabb"
     * <p>
     * 输出:
     * "bbAa"
     * <p>
     * 解释:
     * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
     * 注意'A'和'a'被认为是两种不同的字符。
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sort-characters-by-frequency
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class Solution {
        public static String frequencySort(String s) {
            Map<Character, Integer> frequencyForNum = new HashMap<>();
            for (char c : s.toCharArray()) {
                frequencyForNum.put(c, frequencyForNum.getOrDefault(c, 0) + 1);

            }
            List<Character>[] bucket = new ArrayList[s.length() + 1];
            for (char c : frequencyForNum.keySet()) {
                int frequency = frequencyForNum.get(c);
                if (bucket[frequency] == null) {
                    bucket[frequency] = new ArrayList<>();
                }
                bucket[frequency].add(c);
            }
            StringBuilder str = new StringBuilder();
            for (int i = bucket.length - 1; i >= 0; i--) {
                if (bucket[i] == null) {
                    continue;
                }
                for (char c : bucket[i]) {
                    for (int j = 0; j < i; j++) {
                        str.append(c);
                    }
                }
            }
            return str.toString();
        }
    }
}
