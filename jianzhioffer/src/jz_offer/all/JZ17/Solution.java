package jz_offer.all.JZ17;

public class Solution {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;
        return dfs(root1, root2);
    }

    public boolean dfs(TreeNode root1, TreeNode root2) {
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag = false;
        if (root1.val == root2.val) {
            flag = judge(root1, root2);
        }
        if (flag)
            return true;
        if (root1.left != null) {
            flag1 = dfs(root1.left, root2);
        }
        if (root1.right != null) {
            flag2 = dfs(root1.right, root2);
        }
        return flag1 || flag2;
    }

    public boolean judge(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return false;
        if (root2 == null)
            return true;
        if (root1.val == root2.val) {
            boolean flag1 = true;
            boolean flag2 = true;
            if (root1.left != null || root2.left != null)
                flag1 = judge(root1.left, root2.left);
            if (root1.right != null || root2.right != null)
                flag2 = judge(root1.right, root2.right);
            return flag1 && flag2;
        } else {
            return false;
        }
    }
}
