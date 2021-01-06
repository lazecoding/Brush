package brush.leetcode.search.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: lazecoding
 * @date: 2021/1/6 22:00
 * @description:
 */
public class Q17 {
    public static void main(String[] args) {
        String digits = "23";
        List<String> ans = Solution.letterCombinations(digits);
        System.out.println(ans.toString());
    }

    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     *
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     *
     * 有图！！！！！！
     *
     * 示例:
     *
     * 输入："23"
     * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     * 说明:
     * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class Solution {
        /**
         * 首先使用哈希表存储每个数字对应的所有可能的字母，然后进行回溯操作。
         *
         * 回溯过程中维护一个字符串，表示已有的字母排列（如果未遍历完电话号码的所有数字，则已有的字母排列是不完整的）。
         * 该字符串初始为空。每次取电话号码的一位数字，从哈希表中获得该数字对应的所有可能的字母，并将其中的一个字母插入到已有的字母排列后面，
         * 然后继续处理电话号码的后一位数字，直到处理完电话号码中的所有数字，即得到一个完整的字母排列。然后进行回退操作，遍历其余的字母排列。
         *
         * @param digits
         * @return
         */
        public static List<String> letterCombinations(String digits) {
            int length = digits.length();
            List<String> combinations = new ArrayList<String>();
            if (length == 0) {
                return combinations;
            }
            Map<Character, String> keyMap = new HashMap<>(8);
            keyMap.put('2', "abc");
            keyMap.put('3', "def");
            keyMap.put('4', "ghi");
            keyMap.put('5', "jkl");
            keyMap.put('6', "mno");
            keyMap.put('7', "pqrs");
            keyMap.put('8', "tuv");
            keyMap.put('9', "wxyz");
            backtrack(combinations, keyMap, digits, 0, new StringBuffer());
            return combinations;
        }

        public static void backtrack(List<String> combinations, Map<Character, String> keyMap, String digits, int index, StringBuffer combination) {
            if (index == digits.length()) {
                combinations.add(combination.toString());
            } else {
                char digit = digits.charAt(index);
                String letters = keyMap.get(digit);
                int lettersCount = letters.length();
                for (int i = 0; i < lettersCount; i++) {
                    combination.append(letters.charAt(i));
                    backtrack(combinations, keyMap, digits, index + 1, combination);
                    combination.deleteCharAt(index);
                }
            }
        }

    }
}
