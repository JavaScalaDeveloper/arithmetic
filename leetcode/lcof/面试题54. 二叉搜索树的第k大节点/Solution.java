/**
 * Definition for a binary tree node.
 * private static class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
package lcof.面试题54.二叉搜索树的第k大节点;

public class Solution {
    private int t;
    private int res;
    public int kthLargest(TreeNode root, int k) {
        t = k;
        traverse(root);
        return res;
    }

    private void traverse(TreeNode node) {
        if (node != null) {
            traverse(node.right);
            --t;
            if (t == 0) {
                res = node.val;
                return;
            }
            traverse(node.left);
        }
    }
   private static class TreeNode {
        int val;
        private TreeNode left;
        private TreeNode right;

    }
}