package jz_offer.all.JZ14;

import java.util.Stack;

public class Solution {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode node = null;
        if (head == null)
            return null;
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        if (k > stack.size())
            return null;
        for (int i = 1; i <= k; i++) {
            node = stack.pop();
        }
        return node;
    }
}
