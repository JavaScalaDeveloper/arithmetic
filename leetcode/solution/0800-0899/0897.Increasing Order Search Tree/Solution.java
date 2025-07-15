/**
 * Definition for a binary tree node.
 * private static class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
package solution._0897;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        TreeNode left = increasingBST(root.left);
        TreeNode right = increasingBST(root.right);
        if (left == null) {
            root.right = right;
            return root;
        }
        TreeNode res = left;
        while (left != null && left.right != null) left = left.right;
        left.right = root;
        root.right = right;
        root.left = null;
        return res;
    }
    private static class ListNode {
        int val;
        private ListNode next;
    }

   private static class TreeNode {
        int val;
        private TreeNode left;
        private TreeNode right;
    }
}