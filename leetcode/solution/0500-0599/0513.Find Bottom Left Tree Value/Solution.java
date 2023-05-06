/**
 * Definition for a binary tree node.
 * class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
package solution._05;
public class Solution {
    int max = -1;
    int value = 0;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return value;
    }

    private void dfs(TreeNode root, int d) {
        if (root == null) {
            return;
        }
        d++;
        if (max < d) {
            max = d;
            value = root.val;
        }
        dfs(root.left, d);
        dfs(root.right, d);
    }
}