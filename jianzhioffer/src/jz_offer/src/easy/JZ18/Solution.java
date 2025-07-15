package jz_offer.src.easy.JZ18;

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

    }

    public void Mirror(TreeNode root) {
        if (root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }
}
