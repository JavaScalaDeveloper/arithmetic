package solution._0606;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
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
   private static class TreeNode {
        int val;
        private TreeNode left;
        private TreeNode right;

    }
}
