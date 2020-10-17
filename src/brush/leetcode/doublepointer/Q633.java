package brush.leetcode.doublepointer;

/**
 * @className: Q633
 * @package: brush.leetcode.doublepointer
 * @description:
 * @datetime: 2020/10/17   11:08
 * @author: lazecoding
 */
public class Q633 {
    public static void main(String[] args) {
        //本题和 Q167很类似
        boolean ans = Q633.Solution.judgeSquareSum(9);
        System.out.println(ans);
    }

    /**
     * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
     * <p>
     *  提示：
     * 0 <= c <= 2^31 - 1
     * <p>
     * 示例 1：
     * <p>
     * 输入：c = 5
     * 输出：true
     * 解释：1 * 1 + 2 * 2 = 5
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sum-of-square-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class Solution {
        public static boolean judgeSquareSum(int target) {
            if (target < 0) {
                return false;
            }
            int i = 0, j = (int) Math.sqrt(target);
            while (i <= j) {
                int powSum = i * i + j * j;
                if (powSum == target) {
                    return true;
                } else if (powSum > target) {
                    j--;
                } else {
                    i++;
                }
            }
            return false;
        }
    }
}
