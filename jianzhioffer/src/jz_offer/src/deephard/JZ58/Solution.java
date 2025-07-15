package jz_offer.src.deephard.JZ58;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0, new TreeNode(1, new TreeNode(2, null, null), null),
                new TreeNode(1, null, new TreeNode(2, null, null)));
        boolean result = new Solution().isSymmetrical(treeNode);
        System.out.println(result);
    }

    @Data
    @AllArgsConstructor
    @Builder
    private static class TreeNode {
        private int val = 0;
        private TreeNode left = null;
        private TreeNode right = null;

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
