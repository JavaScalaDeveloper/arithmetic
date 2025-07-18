/**
 * Definition for a binary tree node.
 * private static class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
package solution._0563;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {

    int sum = 0;

    public int findTilt(TreeNode root) {
        traverse(root);
        return sum;
    }

    public int traverse(TreeNode root) {
        if (root == null) return 0;
        int left = traverse(root.left);
        int right = traverse(root.right);
        sum += Math.abs(left - right);
        return left + right + root.val;
    }

   private static class TreeNode {
        int val;
        private TreeNode left;
        private TreeNode right;

    }

}