/**
 * Definition for a binary tree node.
 * private static class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
package lcof.面试题55;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode tree) {
        if (tree == null) {
            return 0;
        }
        return 1 + Math.max(height(tree.left), height(tree.right));
    }
   private static class TreeNode {
        int val;
        private TreeNode left;
        private TreeNode right;

    }
}