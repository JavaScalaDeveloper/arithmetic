package src.main.java._0410;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t2 == null)
            return true;
        if (t1 == null)
            return false;
        return isSubTree(t1, t2) || checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }

    public boolean isSubTree(TreeNode t1, TreeNode t2){
        if (t2 == null)
            return true;
        if (t1 == null)
            return false;
        if (t1.val != t2.val)
            return false;
        return isSubTree(t1.left,t2.left) && isSubTree(t1.right,t2.right);
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