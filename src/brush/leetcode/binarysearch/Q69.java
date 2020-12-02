package brush.leetcode.binarysearch;

/**
 * @author: lazecoding
 * @date: 2020/12/2 22:19
 * @description:
 */
public class Q69 {
    public static void main(String[] args) {
        int x =5;
        int ans = Solution.mySqrt(x);
        System.out.println(x);
    }

    /**
     * 实现 int sqrt(int x) 函数。
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     *
     * 示例 1:
     * 输入: 4
     * 输出: 2
     *
     * 示例 2:
     * 输入: 8
     * 输出: 2
     * 说明: 8 的平方根是 2.82842...,
     *      由于返回类型是整数，小数部分将被舍去。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sqrtx
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class Solution {
        // 二分法做这道题很简单，下面的方法是用牛顿迭代法（偷）
        // 其实就是数学
        // 牛顿迭代法是一种可以用来快速求解函数零点的方法。
        //为了叙述方便，我们用 CC 表示待求出平方根的那个整数。显然，CC 的平方根就是函数
        //y = f(x) = x^2 - C
        public static int mySqrt(int x) {
            if (x == 0) {
                return 0;
            }

            double C = x, x0 = x;
            while (true) {
                double xi = 0.5 * (x0 + C / x0);
                if (Math.abs(x0 - xi) < 1e-7) {
                    break;
                }
                x0 = xi;
            }
            return (int) x0; }
    }
}
