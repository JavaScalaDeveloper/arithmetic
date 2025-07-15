package solution._1022;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int s) {
        if (root == null) {
            return 0;
        }
        s = s << 1 | root.val;
        if (root.left == null && root.right == null) {
            return s;
        }
        return dfs(root.left, s) + dfs(root.right, s);
    }
    private static class ListNode {
        int val;
        private ListNode next;
    }

   private static class TreeNode {
        int val;
        private TreeNode left;
        private TreeNode right;
    }

}
