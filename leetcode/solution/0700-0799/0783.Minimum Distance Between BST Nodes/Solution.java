package solution._0783;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int minDiffInBST(TreeNode root) {
        TreeNode[] pre = new TreeNode[1];
        int[] res = new int[]{Integer.MAX_VALUE};
        dfs(root, pre, res);
        return res[0];
    }

    private void dfs(TreeNode root, TreeNode[] pre, int[] res) {
        if (root == null) {
            return;
        }
        dfs(root.left, pre, res);
        if (pre[0] != null) {
            res[0] = Math.min(res[0], root.val - pre[0].val);
        }
        pre[0] = root;
        dfs(root.right, pre, res);
    }
   private static class TreeNode {
        int val;
        private TreeNode left;
        private TreeNode right;

    }

}
