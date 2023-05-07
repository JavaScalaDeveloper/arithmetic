package solution._0129;
import java.util.*;

public class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root,0);
    }
    private int sumNumbers(TreeNode root, int sum) {
        if (root==null) return 0;
        sum = sum *10 + root.val;
        if (root.left==null && root.right==null) return sum;
        return sumNumbers(root.left,sum)+sumNumbers(root.right,sum);
    }
     class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}