package brush.leetcode.search.Backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: lazecoding
 * @date: 2020/12/24 21:19
 * @description:
 */
public class Q93 {
    public static void main(String[] args) {
        String s = "25525511135";
        List<String> list = new Solution().restoreIpAddresses(s);
        System.out.println(list.toString());
    }

    /**
     * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
     * <p>
     * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
     * <p>
     * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
     * <p>
     *  
     * <p>
     * 示例 1：
     * 输入：s = "25525511135"
     * 输出：["255.255.11.135","255.255.111.35"]
     * <p>
     * 示例 2：
     * 输入：s = "0000"
     * 输出：["0.0.0.0"]
     * <p>
     * 示例 3：
     * 输入：s = "1111"
     * 输出：["1.1.1.1"]
     * <p>
     * 示例 4：
     * 输入：s = "010010"
     * 输出：["0.10.0.10","0.100.1.0"]
     * <p>
     * 示例 5：
     * 输入：s = "101023"
     * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
     *  
     * <p>
     * 提示：
     * 0 <= s.length <= 3000
     * s 仅由数字组成
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class Solution {
        List<String> res = new LinkedList<>();

        /**
         * 选择：每次选择，我们都可以选择1位或2位或3位作为一个整数。在哪里选择？在剩余未使用的字符串中选择。但是如果当前位是0，那只有1种选择就是单独选这个0作为一个整数。
         * 路径：根据选择目前所得到的整数。
         * 约束条件：每次选择，如果遇到0开头，那么只能是0单独作为一个整数；不管选择多少位，得到的整数必须在[0,255][0,255]内。
         * 结束条件：当已经得到了4个整数并且所有字符都被用过一次，说明得到了一个有效IP地址，加入答案；当已经得到了4个整数但是没有用完字符串，不是有效IP地址，结束；
         *    当用完了所有字符串但是还没得到4个整数，不是有效IP地址，结束。
         *
         *
         * @param s
         * @return
         */
        public List<String> restoreIpAddresses(String s) {
            int[] segments = new int[4];
            backtrack(s, 0, 0, segments);
            return res;
        }

        public void backtrack(String s, int start, int segmentNum, int[] segments) {
            // 到达结束条件
            if (segmentNum == 4) {
                if (start == s.length()) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < 3; i++) {
                        sb.append(segments[i]).append(".");
                    }
                    sb.append(segments[3]);
                    res.add(sb.toString());
                }
                return;
            }

            // 提前回溯
            if (start == s.length()) {
                return;
            }

            // 约束条件，0开头，特别处理
            if (s.charAt(start) == '0') {
                segments[segmentNum] = 0;
                backtrack(s, start + 1, segmentNum + 1, segments);
            }

            int temp = 0;
            for (int end = start; end < s.length(); end++) {
                // 做选择
                temp = temp * 10 + (s.charAt(end) - '0');
                if (temp > 0 && temp <= 255) {
                    segments[segmentNum] = temp;
                    backtrack(s, end + 1, segmentNum + 1, segments);
                } else {
                    // 这个break极为重要，没有的话会产生错误答案
                    //当出现前导0的情况的时候， 按照代码顺序将进入递归，当返回到这个位置时，继续往下执行，temp的值恰好是0，
                    // 没有break将继续加上下一位的值，就会出现把“010”当做“10”处理这样的情况，而这是错误的。
                    break;
                }
            }
        }
    }
}
