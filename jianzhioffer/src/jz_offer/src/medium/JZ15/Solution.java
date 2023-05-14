package jz_offer.src.medium.JZ15;

import datastructure.ListNode;
import tools.listnode.ListNodeUtils;

public class Solution {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        Solution solution = new Solution();
        ListNode result = solution.reverseList(listNode);
        System.out.println(ListNodeUtils.getValues(result));
    }

//    private static class ListNode {
//        int val;
//        ListNode next = null;
//
//        public ListNode(int val) {
//            this.val = val;
//        }
//    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode after = null;
        while (head != null) {
            after = head.next;
            head.next = pre;
            pre = head;
            head = after;
            System.out.println("pre=" + ListNodeUtils.getValues(pre));
            System.out.println("head=" + ListNodeUtils.getValues(head));
        }
        return pre;
    }
}
