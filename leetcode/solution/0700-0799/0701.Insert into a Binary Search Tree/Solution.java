/**
 * Definition for a binary tree node.
 * private static class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
package solution._0701;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {

        if(root == null){
            root = new TreeNode(val,null,null);
      }

        if(val < root.val){
            root.left = insertIntoBST(root.left, val);
        }
        else if(val > root.val){
            root.right = insertIntoBST(root.right, val);
        }

        // return the unchanged pointer
        return root;
    }
    @AllArgsConstructor
   private static class TreeNode {
        int val;
        private TreeNode left;
        private TreeNode right;

    }
}
