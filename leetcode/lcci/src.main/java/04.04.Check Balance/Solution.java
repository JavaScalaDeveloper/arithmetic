/**
 * Definition for a binary tree node.
 * private static class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
package src.main.java._0404;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int l = height(root.left), r = height(root.right);
        return Math.abs(l - r) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }
    @Data
    @AllArgsConstructor
    @Builder
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}