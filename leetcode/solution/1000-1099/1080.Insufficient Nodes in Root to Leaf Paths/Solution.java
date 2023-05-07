package solution._1080;
import java.util.*;

public class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root == null) {
            return null;
        }
        limit -= root.val;
        if (root.left == null && root.right == null) {
            return limit > 0 ? null : root;
        }
        root.left = sufficientSubset(root.left, limit);
        root.right = sufficientSubset(root.right, limit);
        return root.left == null && root.right == null ? null : root;
    }
    private class ListNode {
        int val;
        private ListNode next;
    }

    private class TreeNode {
        int val;
        private TreeNode left;
        private TreeNode right;
    }
}
