/**
 * Definition for a binary tree node.
 * class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
package solution._0563;

public class Solution {

    int sum = 0;

    public int findTilt(TreeNode root) {
        traverse(root);
        return sum;
    }

    public int traverse(TreeNode root) {
        if (root == null) return 0;
        int left = traverse(root.left);
        int right = traverse(root.right);
        sum += Math.abs(left - right);
        return left + right + root.val;
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