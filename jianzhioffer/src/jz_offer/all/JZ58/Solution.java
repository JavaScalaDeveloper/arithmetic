package jz_offer.all.JZ58;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    @Data
    @AllArgsConstructor
    @Builder
    private static class TreeNode {
        private int val = 0;
        private TreeNode left = null;
        private TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null)
            return true;
        return solve(pRoot.left, pRoot.right);
    }

    private boolean solve(TreeNode node1, TreeNode node2) {
        //这些都是递归终止条件，必须写
        if (node1 == null && node2 == null)
            return true;
        if (node1 == null || node2 == null)
            return false;
        if (node1.val != node2.val)
            return false;
        return solve(node1.left, node2.right) && solve(node1.right, node2.left);
    }
}
