/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
package solution._1298;
import java.util.*;

public class Solution {
    public int getDecimalValue(ListNode head) {
        int sum = 0;
        StringBuilder sb = new StringBuilder("0");
        while (head != null) {
            sum += head.val;
            if (sum != 0) {
                sb.append(head.val);
            }
            head = head.next;
        }
        return Integer.valueOf(sb.toString(), 2);
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}