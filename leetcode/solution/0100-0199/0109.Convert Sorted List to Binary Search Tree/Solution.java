package solution._0109;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return new TreeNode(head.val,null,null);
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast!=null && fast.next!=null){
            prev = slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        TreeNode root = new TreeNode(Objects.requireNonNull(prev).next.val,null,null);
        prev.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
    private static class ListNode {
        int val;
        private ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    @AllArgsConstructor
    private static class TreeNode {
        int val;
        private TreeNode left;
        private TreeNode right;

    }
}
