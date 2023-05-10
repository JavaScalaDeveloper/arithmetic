package jz_offer.all.JZ62;

import java.util.Stack;

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

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k < 0)
            return null;
        TreeNode cur = pRoot;
        Stack<TreeNode> stack = new Stack<>();
        //while内为中序遍历
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (--k == 0)
                    return cur;
                cur = cur.right;
            }
        }
        return null;
    }
}
