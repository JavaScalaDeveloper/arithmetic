package jz_offer.src.medium.JZ14;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6,
                new ListNode(7, null)))))));
        Solution solution = new Solution();
        ListNode result1 = solution.findKthToTail2(listNode, 3);
        ListNode result2 = solution.findKthToTail2(listNode, 3);
        System.out.println(result1.toString());
        System.out.println(result2.toString());
    }

    public ListNode findKthToTail2(ListNode head, int k) {
        ListNode listNode = new ListNode(head.val, head.next);
        for (int i = 0; i < k; i++) {
            head = head.next;
        }
        while (head.next != null) {
            listNode = listNode.next;
            head = head.next;
        }
        return listNode;
    }

    @Data
    @AllArgsConstructor
    private static class ListNode {
        int val;
        ListNode next = null;
    }

    public ListNode findKthToTail(ListNode head, int k) {
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
