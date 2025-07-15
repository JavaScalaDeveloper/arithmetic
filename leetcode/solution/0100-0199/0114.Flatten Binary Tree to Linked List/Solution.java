package solution._0114;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public void flatten(TreeNode root) {
        if (root==null) return;
        TreeNode right = root.right;
        flatten(right);
        flatten(root.left);
        root.right = root.left;
        root.left = null;
        TreeNode cache = root;
        while (cache.right!=null) cache = cache.right;
        cache.right = right;
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