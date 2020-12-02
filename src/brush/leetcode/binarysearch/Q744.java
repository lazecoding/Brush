package brush.leetcode.binarysearch;

/**
 * @author: lazecoding
 * @date: 2020/12/2 22:32
 * @description:
 */
public class Q744 {
    public static void main(String[] args) {
        char[] letters = new char[]{'c', 'f', 'j'};
        char target = 'j';
        char ans = Solution.nextGreatestLetter(letters, target);
        System.out.println(ans);
    }

    /**
     * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
     * 在比较时，字母是依序循环出现的。举个例子：
     * 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
     *  
     * <p>
     * 示例：
     * 输入:
     * letters = ["c", "f", "j"]
     * target = "a"
     * 输出: "c"
     * <p>
     * 输入:
     * letters = ["c", "f", "j"]
     * target = "c"
     * 输出: "f"
     * <p>
     * 输入:
     * letters = ["c", "f", "j"]
     * target = "d"
     * 输出: "f"
     * <p>
     * 输入:
     * letters = ["c", "f", "j"]
     * target = "g"
     * 输出: "j"
     * <p>
     * 输入:
     * letters = ["c", "f", "j"]
     * target = "j"
     * 输出: "c"
     * <p>
     * 输入:
     * letters = ["c", "f", "j"]
     * target = "k"
     * 输出: "c"
     *  
     * <p>
     * 提示：
     * letters长度范围在[2, 10000]区间内。
     * letters 仅由小写字母组成，最少包含两个不同的字母。
     * 目标字母target 是一个小写字母。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class Solution {
        public static char nextGreatestLetter(char[] letters, char target) {
            int low = 0, high = letters.length;
            while (low < high) {
                int middle = low + (high - low) / 2;
                if (letters[middle] <= target) {
                    low = middle + 1;
                } else {
                    high = middle;
                }
            }
            // 因为是循环出现二点 所以 当目标是最后一个，结果应该是第一个元素
            return letters[high % letters.length];
        }
    }
}
