/**
 * Definition for singly-linked list.
 * private static class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 package src.main.java._0208;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public ListNode detectCycle(ListNode head) {
         ListNode fast = head, slow = head;
         while (fast != null && fast.next != null) {
             fast = fast.next.next;
             slow = slow.next;
             if (fast == slow) break;
         }
         if (fast == null || fast.next == null) return null;
         ListNode p = head;
         while (p != slow) {
             p = p.next;
             slow = slow.next;
         }
         return p;
    }
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}