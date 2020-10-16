package brush.leetcode.linkedlist;

/**
 * @className: Q2
 * @package: brush.leetcode.array
 * @description:
 * @datetime: 2020/10/16   20:49
 * @author: lazecoding
 */
public class Q2 {
    public static void main(String[] args) {

    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        /*public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int x;
            int y;
            int add = 0;
            int result;
            ListNode root = new ListNode(0);
            ListNode current = root;
            while (l1 != null || l2 != null || add != 0){
                x = l1 != null ? l1.val : 0;
                y = l2 != null ? l2.val : 0;
                result = x + y + add;
                current.next = new ListNode(result % 10);
                current = current.next;
                add = result / 10;
                if(l1 != null){
                    l1 = l1.next;
                }
                if(l2 != null){
                    l2 = l2.next;
                }
            }
            if(root.next != null){
                root = root.next;
            }
            return root;
        }*/
    }
}
