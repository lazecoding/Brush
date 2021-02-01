package brush.algorithms4.a_base.binarysearch;

/**
 * @author: lazecoding
 * @date: 2021/2/1 22:58
 * @description: 二分查询
 */
public class BinarySearch {
    public static int binary1(int[] arr, int data) {
        int min = 0;
        int max = arr.length - 1;
        int mid;
        while (min <= max) {
            mid = (min + max) / 2;
            if (arr[mid] > data) {
                max = mid - 1;
            } else if (arr[mid] < data) {
                min = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int binary2(int[] arr, int data) {
        int min = 0;
        int max = arr.length - 1;
        int mid;
        while (min <= max) {
            // 防止溢出
            mid = min + (max - min) / 2;
            if (arr[mid] > data) {
                max = mid - 1;
            } else if (arr[mid] < data) {
                min = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int binary3(int[] arr, int data) {
        int min = 0;
        int max = arr.length - 1;
        int mid;
        while (min <= max) {
            // 无符号位运算符的优先级较低，先括起来
            mid =  min + ((max - min) >>> 1);
            if (arr[mid] > data) {
                max = mid - 1;
            } else if (arr[mid] < data) {
                min = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
