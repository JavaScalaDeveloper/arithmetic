/**
 * Definition for a binary tree node.
 * private static class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
package solution._0437;

import java.util.LinkedList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        int res = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res += solution(node, sum);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return res;
    }

    private int solution(TreeNode root, int sum) {
        if (root == null) return 0;
        int res = sum == root.val ? 1 : 0;
        return solution(root.left, sum - root.val) + solution(root.right, sum - root.val) + res;
    }

   private static class TreeNode {
        int val;
        private TreeNode left;
        private TreeNode right;

    }

}