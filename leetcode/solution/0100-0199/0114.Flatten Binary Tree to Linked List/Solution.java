package solution._0114;
public class Solution {
    public void flatten(TreeNode root) {
        if (root==null) return;
        TreeNode right = root.right;
        flatten(right);
        flatten(root.left);
        root.right = root.left;
        root.left = null;
        TreeNode cache = root;
        while (cache.right!=null) cache = cache.right;
        cache.right = right;
    }
     class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}