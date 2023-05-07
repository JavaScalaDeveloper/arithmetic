/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
package lcof._06;
import java.util.*;

public class Solution {
    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[]{};
        // 计算链表长度n
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            ++n;
            cur = cur.next;
        }
        int[] res = new int[n];
        cur = head;
        while (cur != null) {
            res[--n] = cur.val;
            cur = cur.next;
        }
        return res;
    }
    private class ListNode {
        int val;
        private ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}