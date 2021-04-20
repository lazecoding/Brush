package brush.algorithms.softt;

import java.util.Arrays;

/**
 * @author: lazecoding
 * @date: 2021/4/20 21:45
 * @description:
 */
public class ShellT {
    public static void soft(Comparable[] a) {
        int length = a.length;
        int h = (a.length / 3) + 1;

        while (h >= 1) {
            for (int i = h; i < length; i++) {
                for (int j = i; (j >= h) && (a[j].compareTo(a[j - h]) < 0); j -= h) {
                    Object temp = a[j];
                    a[j] = a[j - h];
                    a[j - h] = (Comparable) temp;
                }
            }
            h --;

        }
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{1, 5, 2, 3, 4};
        soft(a);
        System.out.println(Arrays.toString(a));
    }
}
