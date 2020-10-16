package brush.leetcode.string;

import java.util.Stack;

/**
 * @className: Q415
 * @package: brush.leetcode.string
 * @description:
 * @datetime: 2020/10/16   21:00
 * @author: lazecoding
 */
public class Q415 {
    public static void main(String[] args) {
        String num1 = "1";
        String num2 = "9";
        String ans = new Solution().addStrings2(num1, num2);
        System.out.println(ans);

    }

    /**
     * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
     */
    static class Solution {
        public String addStrings1(String num1, String num2) {
            int i = num1.length() - 1;
            int j = num2.length() - 1;
            int add = 0;
            int x;
            int y;
            StringBuilder builder = new StringBuilder();
            while (i >= 0 || j >= 0 || add != 0) {
                x = i >= 0 ? num1.charAt(i) - '0' : 0;
                y = j >= 0 ? num2.charAt(j) - '0' : 0;
                builder.append((x + y + add) % 10);
                add = (x + y + add) / 10;
                i--;
                j--;
            }
            return builder.reverse().toString();
        }

        public String addStrings2(String num1, String num2) {
            Stack<Integer> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();
            int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
            while (i >= 0 || j >= 0 || carry != 0) {
                carry += i >= 0 ? num1.charAt(i--) - '0' : 0;
                carry += j >= 0 ? num2.charAt(j--) - '0' : 0;
                stack.push(carry % 10);
                carry = carry / 10;
            }
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            return sb.toString();
        }
    }
}
