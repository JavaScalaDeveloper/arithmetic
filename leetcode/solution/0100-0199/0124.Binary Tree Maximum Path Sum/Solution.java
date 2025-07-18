package solution._0124;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    private int val = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return val;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        int val1 = root.val + left + right;
        int val2 = root.val + Math.max(0, Math.max(left, right));
        val = Math.max(val, val1);
        return val2;
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