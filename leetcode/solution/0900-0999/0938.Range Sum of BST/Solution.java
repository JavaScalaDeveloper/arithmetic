/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
package solution._0938;
import java.util.*;

public class Solution {
    private int res = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return res;
        }
        
        if (root.val < L) {
            rangeSumBST(root.right, L, R);
        } else if (root.val > R) {
            rangeSumBST(root.left, L, R);
        } else {
            res += root.val;
            rangeSumBST(root.left, L, R);
            rangeSumBST(root.right, L, R);
        }
        return res;
        
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}