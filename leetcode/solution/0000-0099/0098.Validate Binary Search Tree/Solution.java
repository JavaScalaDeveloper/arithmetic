package solution._0098;
import java.util.*;

public class Solution {

    private long current = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (isValidBST(root.left) && current < root.val) {
            current = root.val;
            return isValidBST(root.right);
        }
        return false;
    }
    private class ListNode {
        int val;
        private ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private class TreeNode {
        int val;
        private TreeNode left;
        private TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}