package jz_offer.src.hard.JZ17;

import datastructure.TreeNode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import tools.listnode.TreeNodeUtils;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeUtils.buildTree();
        TreeNode right = treeNode.right;
        TreeNodeUtils.printTree(treeNode);
        TreeNodeUtils.printTree(right);
        Solution solution = new Solution();
        boolean result = solution.hasSubtree2(treeNode, right);
        System.out.println(result);
    }
    /*方法1 start*/
    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        return dfs(root1, root2);
    }

    public boolean dfs(TreeNode root1, TreeNode root2) {
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag = false;
        if (root1.val == root2.val) flag = judge(root1, root2);
        if (flag) return true;
        if (root1.left != null) flag1 = dfs(root1.left, root2);
        if (root1.right != null) flag2 = dfs(root1.right, root2);
        return flag1 || flag2;
    }

    public boolean judge(TreeNode root1, TreeNode root2) {
        if (root1 == null) return false;
        if (root2 == null) return true;
        if (root1.val == root2.val) {
            boolean flag1 = true;
            boolean flag2 = true;
            if (root1.left != null || root2.left != null) flag1 = judge(root1.left, root2.left);
            if (root1.right != null || root2.right != null) flag2 = judge(root1.right, root2.right);
            return flag1 && flag2;
        } else {
            return false;
        }
    }
    /*方法1 end*/
    public boolean hasSubtree2(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return isSubStructureHelper(A, B) || hasSubtree2(A.left, B) || hasSubtree2(A.right, B);
    }

    private boolean isSubStructureHelper(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return isSubStructureHelper(A.left, B.left) && isSubStructureHelper(A.right, B.right);
    }


}
