/**
 * Definition for a binary tree node.
 * private static class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
package solution._0572;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {

        if (t == null) return true;
        if (s == null) return false;

        if (s.val != t.val){
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }
        return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSameTree(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;

        if(root1.val != root2.val) return false;
        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }
   private static class TreeNode {
        int val;
        private TreeNode left;
        private TreeNode right;

    }
}