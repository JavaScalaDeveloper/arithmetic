package solution._0116;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public void connect(TreeLinkedNode root) {
        if (root == null || root.left == null) return;
        root.left.next = root.right;
        if (root.next == null) root.right.next = null;
        else root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
    }

    private class TreeLinkedNode {
        int val;
        TreeLinkedNode left;
        TreeLinkedNode right;
        TreeLinkedNode next;

        public TreeLinkedNode(int val, TreeLinkedNode left, TreeLinkedNode right, TreeLinkedNode next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }

    private static class ListNode {
        int val;
        private ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

   private static class TreeNode {
        int val;
        private TreeNode left;
        private TreeNode right;

    }
}
