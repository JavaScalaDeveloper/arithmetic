/**
 * Definition for a binary tree node.
 * private static class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
package solution._0543;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    int ans = 1;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans - 1;
    }

    public int depth(TreeNode node) {
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L + R + 1);
        return Math.max(L, R) + 1;
    }
   private static class TreeNode {
        int val;
        private TreeNode left;
        private TreeNode right;

    }
}