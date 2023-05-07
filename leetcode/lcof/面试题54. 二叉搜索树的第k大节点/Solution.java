/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
package lcof._054;
import java.util.*;

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