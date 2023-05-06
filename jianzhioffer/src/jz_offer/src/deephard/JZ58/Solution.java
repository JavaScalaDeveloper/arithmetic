package jz_offer.src.deephard.JZ58;

public class Solution {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        return solve(pRoot.left, pRoot.right);
    }

    private boolean solve(TreeNode node1, TreeNode node2) {
        //这些都是递归终止条件，必须写
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (node1.val != node2.val) return false;
        return solve(node1.left, node2.right) && solve(node1.right, node2.left);
    }
}
