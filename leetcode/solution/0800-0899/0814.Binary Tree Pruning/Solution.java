package solution._0814;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        return root.val == 0 && root.left == null && root.right == null ? null : root;
    }
   private static class TreeNode {
        int val;
        private TreeNode left;
        private TreeNode right;

    }

}
