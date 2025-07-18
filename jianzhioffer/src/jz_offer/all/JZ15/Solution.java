package jz_offer.all.JZ15;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    private static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode after = null;
        while (head != null) {
            after = head.next;
            head.next = pre;
            pre = head;
            head = after;
        }
        return pre;
    }
}
