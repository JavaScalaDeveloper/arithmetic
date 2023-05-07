package solution._0606;
import java.util.*;

public class Solution {
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        if (t.right != null) {
            return t.val + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
        }
        if (t.left != null) {
            return t.val + "(" + tree2str(t.left) + ")";
        }
        return t.val + "";
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
