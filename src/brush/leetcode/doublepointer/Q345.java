package brush.leetcode.doublepointer;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @className: Q345
 * @package: brush.leetcode.doublepointer
 * @description:
 * @datetime: 2020/10/17   22:53
 * @author: lazecoding
 */
public class Q345 {
    public static void main(String[] args) {
        String str = "leetcode";
        String ans = Solution.reverseVowels(str);
        System.out.println(ans);
    }

    /**
     * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
     * <p>
     * 提示：元音字母不包含字母 "y" 。
     * <p>
     * 示例 1：
     * 输入："hello"
     * 输出："holle"
     * <p>
     * 示例 2：
     * 输入："leetcode"
     * 输出："leotcede"
     *  
     * <p>
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class Solution {
        private final static HashSet<Character> vowels = new HashSet<>(
                Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        public static String reverseVowels(String s) {
            if (s == null) {
                return null;
            }
            int i = 0, j = s.length() - 1;
            char[] result = new char[s.length()];
            while (i <= j) {
                char ci = s.charAt(i);
                char cj = s.charAt(j);
                if (!vowels.contains(ci)) {
                    result[i++] = ci;
                } else if (!vowels.contains(cj)) {
                    result[j--] = cj;
                } else {
                    result[i++] = cj;
                    result[j--] = ci;
                }
            }
            return new String(result);
        }
    }
}
