package jz_offer.src.medium.JZ14;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode node = null;
        if (head == null) return null;
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        if (k > stack.size()) return null;
        for (int i = 1; i <= k; i++) {
            node = stack.pop();
        }
        return node;
    }
}
