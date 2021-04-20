package brush.algorithms.softt;

import java.util.Arrays;

/**
 * @author: lazecoding
 * @date: 2021/4/19 21:42
 * @description:
 */
public class SelectionT {

    public static void soft(Comparable[] a) {
        int length = a.length;
        for (int i = 0; i < length; i++) {
            int min = i;
            Object temp = new Object();
            for (int j = i; j < length; j++) {
                if (a[j].compareTo(a[min]) < 0) {
                    min = j;
                }
            }
            temp = a[i];
            a[i] = a[min];
            a[min] = (Comparable) temp;
        }

    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{1, 5, 2, 3, 4};
        soft(a);
        System.out.println(Arrays.toString(a));
    }
}
