package brush.algorithms.softt;

import java.util.Arrays;

/**
 * @author: lazecoding
 * @date: 2021/4/19 22:03
 * @description:
 */
public class InsertionT {

    public static void soft(Comparable[] a) {
        int length = a.length;
        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0; j--) {
                // 这样写很拉稀 会出现很多无意义的比较，第一个已经不满足了 之后没意义比较了
                if (a[j].compareTo(a[j - 1]) < 0) {
                    Object temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = (Comparable) temp;
                }
            }
        }

    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{1, 5, 2, 3, 4};
        soft(a);
        System.out.println(Arrays.toString(a));
    }
}
