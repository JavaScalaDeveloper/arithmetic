package solution._0450;
import java.util.*;

public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode newRoot = root.right;
            TreeNode parent = null;
            while (newRoot.left != null) {
                parent = newRoot;
                newRoot = newRoot.left;
            }
            if (parent != null) {
                parent.left = newRoot.right;
                newRoot.right = root.right;
            }
            newRoot.left = root.left;
            return newRoot;
        }
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
