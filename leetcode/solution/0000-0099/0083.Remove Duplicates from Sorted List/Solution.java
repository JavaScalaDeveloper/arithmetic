package solution._0083;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;

    }

    private static class ListNode {
        int val;
        private ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    @Data
    @AllArgsConstructor
    @Builder
    private static class TreeNode {
        int val;
        private TreeNode left;
        private TreeNode right;

    }
}