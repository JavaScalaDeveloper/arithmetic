/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
package solution._05;
public class Solution {
    public int getMinimumDifference(TreeNode root) {
        Integer res = Integer.MAX_VALUE, prev = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty()) break;
            TreeNode node = stack.pop();
            res = Math.min(res, Math.abs(node.val - prev));
            prev = node.val;
            root = node.right;
        }
        return res;
    }
}