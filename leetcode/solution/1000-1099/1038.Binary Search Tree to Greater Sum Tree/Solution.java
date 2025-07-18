/**
 * Definition for a binary tree node.
 * private static class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
package solution._1038;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    private int max = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root == null) return new TreeNode(0);
        int temp = bstToGst(root.right).val;
        root.val += (temp > max ? temp : max);
        max = root.val > max ? root.val : max;
        if (root.left != null) {
            int temp2 = bstToGst(root.left.right).val;
            root.left.val += max > temp2 ? max : temp2;
            max = max > root.left.val ? max : root.left.val;
            bstToGst(root.left.left);
        }
        return root;
    }
    private static class ListNode {
        int val;
        private ListNode next;
    }

   private static class TreeNode {
        int val;
        private TreeNode left;
        private TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
    }
}
